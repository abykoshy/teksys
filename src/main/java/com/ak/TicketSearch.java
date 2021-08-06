package com.ak;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import net.minidev.json.JSONArray;

public class TicketSearch extends Search {

    private Ticket[] allTickets;

    public TicketSearch(Ticket[] allTickets) {
        this.allTickets = allTickets;
    }

    /**
     * Search for users based on the criteria in jsonpath format
     *
     * @param criteria criteria as jsonpath
     * @return list of tickets
     * @throws SearchServiceException
     */
    public Ticket[] searchTickets(String criteria) throws SearchServiceException {
        // Initial thought using Java 8 stream filter, but that would require check based on teh attributes
        // An easier way would be to use jsonpath library which already handles the search syntax
        Configuration conf = Configuration.defaultConfiguration()
                .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);

        JSONArray filteredUsers = JsonPath.using(conf).parse(Jsonify.asJson(allTickets)).read("$[?(" + criteria + ")]");
        return asTickets(filteredUsers.toJSONString());
    }

    /**
     * Converts Json object to tickets
     * @param jsonString
     * @return Ticket objects
     * @throws JsonifyException if an exception occurs
     */
    private Ticket[] asTickets(String jsonString) throws JsonifyException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, Ticket[].class);
        } catch (JsonProcessingException e) {
            throw new JsonifyException(e);
        }
    }
}
