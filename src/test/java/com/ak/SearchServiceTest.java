package com.ak;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchServiceTest {

    SearchService searchService = new SearchService();

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("usersjsonfile","users.json");
        System.setProperty("ticketsjsonfile","tickets.json");
    }

    @Test
    public void testInitialize() throws SearchServiceException {
        searchService.initializeFromFile();
        assertThat(searchService.allTickets).isNotEmpty();
    }

    @Test
    public void testSearchUser() throws SearchServiceException {
        searchService.initializeFromFile();
        SearchEntity[] users = searchService.search("user", "@.name=='Ingrid Wagner'");
        assertThat(users).isInstanceOf(User[].class);
        assertThat(users).isNotEmpty();
    }

    @Test
    public void testSearchTickets() throws SearchServiceException {
        searchService.initializeFromFile();
        SearchEntity[] tickets = searchService.search("ticket", "@.type=='incident'");
        assertThat(tickets).isInstanceOf(Ticket[].class);
        assertThat(tickets).isNotEmpty();
    }
}