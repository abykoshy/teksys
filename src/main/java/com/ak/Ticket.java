package com.ak;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Data
@AllArgsConstructor
@Jacksonized @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket extends SearchEntity{
    @JsonProperty("_id")
    String id;

    @JsonProperty("created_at")
    Date createdAt;
    String type;
    String subject;
    @JsonProperty("assignee_id")
    int assigneeId;
    String[] tags;

    public Ticket(String id, String createdAt, String type, String subject, int assigneeId, String[] tags) {
        this.id = id;
        this.createdAt = SearchServiceUtils.getDate(createdAt);
        this.type = type;
        this.subject = subject;
        this.assigneeId = assigneeId;
        this.tags = tags;

    }
}
