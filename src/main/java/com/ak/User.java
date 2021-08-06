package com.ak;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

@Jacksonized @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Value
public class User extends SearchEntity{

    @JsonProperty("_id")
    String  id;
    String name;
    @JsonProperty("created_at")
    Date createdAt;
    boolean verified;

    public User(String id, String name, String dateAsString, boolean verified){
        this.id = id;
        this.name = name;
        this.createdAt = SearchServiceUtils.getDate(dateAsString);
        this.verified = verified;
    }

    @SneakyThrows
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
