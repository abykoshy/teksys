package com.ak;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SearchService {
    User[] allUsers;
    Ticket[] allTickets;

    @Autowired
    Environment env;

    public void initializeFromFile() throws SearchServiceException {
        if (allUsers == null || allTickets == null) {
            allUsers = Jsonify.getUsers(env!=null?env.getProperty("usersjsonfile"):System.getProperty("usersjsonfile"));
            allTickets = Jsonify.getTickets(env!=null?env.getProperty("ticketsjsonfile"):System.getProperty("ticketsjsonfile"));
        }
    }

    /**
     * The main service used to search from the shell
     * @param entity "user" or "ticket"
     * @param mainCriteria criteria as jsonpath expression
     * @return
     * @throws SearchServiceException
     */
    public SearchEntity[] search(String entity, String mainCriteria) throws SearchServiceException {
        if (StringUtils.isNotBlank(entity) && StringUtils.isNotBlank(mainCriteria)) {
            if (entity.equalsIgnoreCase("user")) {
                UserSearch userSearch = new UserSearch(allUsers);
                User[] users = userSearch.searchUsers(mainCriteria);
                return users;
            } else if (entity.equalsIgnoreCase("ticket")) {
                TicketSearch ticketSearch = new TicketSearch(allTickets);
                Ticket[] tickets = ticketSearch.searchTickets(mainCriteria);
                return tickets;
            }
        }
        return null;
    }
}
