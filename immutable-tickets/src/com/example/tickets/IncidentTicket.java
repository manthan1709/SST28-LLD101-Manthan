package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - mutable fields
 * - multiple constructors
 * - public setters
 * - tags list can be modified from outside
 * - validation is scattered elsewhere
 *
 * TODO (student): refactor to immutable + Builder.
 */
public class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final String priority;
    private final List<String> tags;
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;
    private final String source;

    IncidentTicket(Builder builder) {
        this.id = builder.id;
        this.reporterEmail = builder.reporterEmail;
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        this.tags = builder.tags;
        this.assigneeEmail = builder.assigneeEmail;
        this.customerVisible = builder.customerVisible;
        this.slaMinutes = builder.slaMinutes;
        this.source = builder.source;
    }

    public String getId() {
        return id;
    }

    public Builder toBuilder() {
        return new Builder()
                .setId(this.id)
                .setReporterEmail(this.reporterEmail)
                .setTitle(this.title)
                .setDescription(this.description)
                .setPriority(this.priority)
                .setTags(this.tags)
                .setAssigneeEmail(this.assigneeEmail)
                .setCustomerVisible(this.customerVisible)
                .setSlaMinutes(this.slaMinutes)
                .setSource(this.source);
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public List<String> getTags() {
        List<String> deepCopy = new ArrayList<String>();
        for (String s : this.tags) {
            deepCopy.add(s);
        }
        return deepCopy;
    } // BROKEN: leaks internal list

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public boolean isCustomerVisible() {
        return customerVisible;
    }

    public Integer getSlaMinutes() {
        return slaMinutes;
    }

    public String getSource() {
        return source;
    }

    static class Builder {
        String id;
        String reporterEmail;
        String title;
        String description;
        String priority;
        List<String> tags;
        String assigneeEmail;
        boolean customerVisible;
        Integer slaMinutes;
        String source;

        public Builder() {
        }

        public Builder setId(String id) {
            if (id == null || id.trim().isEmpty())
                throw new IllegalArgumentException("id required");
            this.id = id;
            return this;
        }

        public Builder setReporterEmail(String reporterEmail) {
            if (reporterEmail == null || !reporterEmail.contains("@"))
                throw new IllegalArgumentException("email invalid");
            this.reporterEmail = reporterEmail;
            return this;
        }

        public Builder setTitle(String title) {
            if (title == null || title.trim().isEmpty())
                throw new IllegalArgumentException("title required");
            this.title = title;
            return this;
        }

        public Builder addTags(String s) {
            List<String> deepCopyTags = new ArrayList<String>();
            for (String a : tags) {
                deepCopyTags.add(a);
            }
            deepCopyTags.add(s);
            this.tags = deepCopyTags;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPriority(String priority) {
            this.priority = priority;
            return this;
        }

        public Builder setTags(List<String> tags) {
            List<String> deepCopyTags = new ArrayList<String>();
            for (String s : tags) {
                deepCopyTags.add(s);
            }
            this.tags = deepCopyTags;
            return this;
        }

        public Builder setAssigneeEmail(String assigneeEmail) {
            this.assigneeEmail = assigneeEmail;
            return this;
        }

        public Builder setCustomerVisible(boolean customerVisible) {
            this.customerVisible = customerVisible;
            return this;
        }

        public Builder setSlaMinutes(Integer slaMinutes) {
            this.slaMinutes = slaMinutes;
            return this;
        }

        public Builder setSource(String source) {
            this.source = source;
            return this;
        }

        public IncidentTicket build() {
            Validation.requireTicketId(this.id);
            Validation.requireMaxLen(this.id, 20, "title");
            Validation.requireEmail(this.reporterEmail, "reporterEmail");
            Validation.requireNonBlank(this.title, "title");
            Validation.requireMaxLen(this.title, 80, "title");
            if (assigneeEmail != null) {
                Validation.requireEmail(assigneeEmail, "assigneeEmail");
            }
            if (slaMinutes != null) {
                Validation.requireRange(slaMinutes, 5, 7200, "slaMinutes");
            }
            if (priority != null) {
                Validation.requireOneOf(priority, "priority", "LOW", "HIGH", "MEDIUM", "CRITICAL");
            }
            if (tags == null) {
                List<String> new_tags = new ArrayList<String>();
                this.tags = new_tags;
            }
            return new IncidentTicket(this);
        }

    }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }
}