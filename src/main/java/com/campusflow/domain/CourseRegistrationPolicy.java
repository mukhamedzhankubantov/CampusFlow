package com.campusflow.domain;

import static com.campusflow.domain.CourseRegistrationStatus.*;

public class CourseRegistrationPolicy {

    public boolean canTransition(CourseRegistrationStatus from, CourseRegistrationStatus to) {
        if (from == null || to == null) {
            return false;
        }

        if (from == to) {
            return true;
        }

        return switch (from) {
            case DRAFT -> to == SUBMITTED;
            case SUBMITTED -> to == APPROVED || to == REJECTED;
            case APPROVED -> false;
            case REJECTED -> to == DRAFT;
        };
    }

    public void validateTransition(CourseRegistrationStatus from, CourseRegistrationStatus to) {
        if (!canTransition(from, to)) {
            throw new IllegalStateException(
                    String.format("Invalid status transition from %s to %s", from, to)
            );
        }
    }
}