package com.ak;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonifyTest {

    @Test
    public void readTicketsJsonFromFile() throws Exception, JsonifyException {
        Ticket[] tickets = Jsonify.getTickets("tickets.json");
        assertThat(tickets).isNotEmpty();
    }

    @Test
    public void readUsersJsonFromFile() throws Exception, JsonifyException {
        User[] users = Jsonify.getUsers("users.json");
        assertThat(users).isNotEmpty();
    }

}