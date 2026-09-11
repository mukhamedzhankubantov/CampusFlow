package com.campusflow.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.campusflow.domain.CourseRegistrationStatus.*;
import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationPolicyTest {

    private CourseRegistrationPolicy policy;

    @BeforeEach
    void setUp() {
        policy = new CourseRegistrationPolicy();
    }

    @Test
    void shouldAllowDraftToSubmitted() {
        assertTrue(policy.canTransition(DRAFT, SUBMITTED));
        assertDoesNotThrow(() -> policy.validateTransition(DRAFT, SUBMITTED));
    }

    @Test
    void shouldAllowSubmittedToApproved() {
        assertTrue(policy.canTransition(SUBMITTED, APPROVED));
        assertDoesNotThrow(() -> policy.validateTransition(SUBMITTED, APPROVED));
    }

    @Test
    void shouldForbidDraftToApproved() {
        assertFalse(policy.canTransition(DRAFT, APPROVED));
        assertThrows(IllegalStateException.class, () -> policy.validateTransition(DRAFT, APPROVED));
    }

    @Test
    void shouldForbidApprovedToDraft() {
        assertFalse(policy.canTransition(APPROVED, DRAFT));
        assertThrows(IllegalStateException.class, () -> policy.validateTransition(APPROVED, DRAFT));
    }

    @Test
    void shouldReturnFalseForNullValues() {
        assertFalse(policy.canTransition(null, SUBMITTED));
        assertFalse(policy.canTransition(DRAFT, null));
    }
}