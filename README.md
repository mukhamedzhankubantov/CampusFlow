# CampusFlow 🏛️

## Product 🎓
We build CampusFlow LMC. People track course registration.

## Core item
CourseRegistration

## Status table
| From | To | Allowed? |
| --- | --- | --- |
| DRAFT | SUBMITTED | Yes |
| SUBMITTED | APPROVED | Yes |
| DRAFT | APPROVED | No |
| APPROVED | DRAFT | No |

## Forbidden — why
* DRAFT -> APPROVED: A student cannot be approved without advisor review and submission.
* APPROVED -> DRAFT: An approved registration cannot be reverted to draft without dropping the course.

