package com.campusflow.domain;

import java.util.Objects;
import java.util.UUID;

public record CourseRegistrationId(UUID value){

    public CourseRegistrationId{
        Objects.requireNonNull(value, "ID cannot be null");
    }
    public static CourseRegistrationId generate(){
        return new CourseRegistrationId(UUID.randomUUID());
    }
}