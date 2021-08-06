package com.ak;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.io.IOException;

public class Jsonify {
    /**
     * Reads a list of Tickets from a file as an array of Ticket
     * @param fileName The json file to read from
     * @return Ticket[]
     * @throws JsonifyException if any exception occurs
     */
    public static Ticket[] getTickets(String fileName) throws JsonifyException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(Jsonify.class.getClassLoader().getResourceAsStream(fileName), Ticket[].class);
        } catch (IOException e) {
            throw new JsonifyException(e);
        }
    }

    /**
     * Reads a list of Users from a file as an array of Users
     * @param fileName The json file to read from
     * @return User[]
     * @throws JsonifyException if any exception occurs
     */
    public static User[] getUsers(String fileName) throws JsonifyException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(Jsonify.class.getClassLoader().getResourceAsStream(fileName), User[].class);
        } catch (IOException e) {
            throw new JsonifyException(e);
        }
    }


    /**
     * Convert object array to json
     * @param objects list
     * @return Json string
     * @throws JsonifyException if an exception occurs
     */
    public static String asJson(Object[] objects) throws JsonifyException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            return objectMapper.writeValueAsString(objects);
        } catch (JsonProcessingException e) {
            throw new JsonifyException(e);
        }
    }


}
