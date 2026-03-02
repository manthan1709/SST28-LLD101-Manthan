package com.example.tickets;

/**
 * Service layer that creates tickets.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 *
 * TODO (student):
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop
 * mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // scattered validation (incomplete on purpose)

        IncidentTicket t = new IncidentTicket.Builder().setId(id).setReporterEmail(reporterEmail).setTitle(title)
                .build();
        return t;
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        // BAD: mutating ticket after it has been "created"
        return t.toBuilder().setPriority("CRITICAL").addTags("ESCALATED").build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // scattered validation
        if (assigneeEmail != null && !assigneeEmail.contains("@")) {
            throw new IllegalArgumentException("assigneeEmail invalid");
        }
        return t.toBuilder().setAssigneeEmail(assigneeEmail).build();
    }
}
