package com.ak;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import net.minidev.json.JSONArray;

public class UserSearch {
    private final User[] allUsers;

    public UserSearch(User[] allUsers) {
        this.allUsers = allUsers;
    }

    /**
     * Search for users based on the criteria in jsonpath format
     *
     * @param criteria as jsonpath expression
     * @return list of users
     * @throws SearchServiceException
     */
    public User[] searchUsers(String criteria) throws SearchServiceException {
        // Initial thought using Java 8 stream filter, but that would require check based on teh attributes
        /*
        List<User> filteredUsers = Arrays.asList(users).stream()
                .filter(user -> criteria.equals(user.getName()))
                .collect(Collectors.toList());
        */
        // An easier way would be to use jsonpath library which already handles the search syntax
        Configuration conf = Configuration.defaultConfiguration()
                .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);

        JSONArray filteredUsers = JsonPath.using(conf).parse(Jsonify.asJson(allUsers)).read("$[?(" + criteria + ")]");
        return asUsers(filteredUsers.toJSONString());
    }



    /**
     * Converts Json to user objects
     * @param jsonString list of users as json
     * @return User objects
     * @throws JsonifyException if any exception occurs
     */
    private User[] asUsers(String jsonString) throws JsonifyException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, User[].class);
        } catch (JsonProcessingException e) {
            throw new JsonifyException(e);
        }
    }
}
