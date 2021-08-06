package com.ak;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketSearchTest {

    @Test
    public void testSearchTickets() throws Exception, SearchServiceException {
        Ticket[] tickets = new Ticket[]{
                new Ticket("1", "","incident","subject1", 10, null),
                new Ticket("2", "","incident","subject2", 10, null),
                new Ticket("3", "","request","subject3", 10, null),
        };

        TicketSearch ticketSearch = new TicketSearch(tickets);
        Ticket[] searchResult = ticketSearch.searchTickets("@.type == 'incident'");
        assertThat(searchResult).isNotEmpty();
        assertThat(searchResult).hasSize(2);
    }
}