package com.campusflow.domain;
import java.util.Objects;
public class CourseRegistration {
    private final CourseRegistrationId id;
    private final String studentId;
    private final String courseId;
    private CourseRegistrationStatus status;

    private final CourseRegistrationPolicy policy = new CourseRegistrationPolicy();
    public CourseRegistration(CourseRegistrationId id, String studentId, String courseId){
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.studentId = Objects.requireNonNull(studentId,"studentId cannot be null");
        this.courseId = Objects.requireNonNull(courseId, "courseId cannot be null");
        this.status = CourseRegistrationStatus.DRAFT;
    }

    public void submit(){
        policy.validateTransition(this.status, CourseRegistrationStatus.SUBMITTED);
        this.status = CourseRegistrationStatus.SUBMITTED;
    }
    public void approve(){
        policy.validateTransition(this.status, CourseRegistrationStatus.APPROVED);
        this.status = CourseRegistrationStatus.APPROVED;
    }
    public void reject(){
        policy.validateTransition(this.status, CourseRegistrationStatus.REJECTED);
        this.status = CourseRegistrationStatus.REJECTED;
    }
    public CourseRegistrationId getId(){
        return id;
    }
    public String getStudentId(){
        return studentId;
    }
    public String getCourseId(){
        return courseId;
    }
    public CourseRegistrationStatus getStatus(){
        return status;
    }
}
