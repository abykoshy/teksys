package com.ak;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    public void testTicketObject() throws Exception
    {
        Ticket ticket = new Ticket("1","2016-04-28T11:19:34-10:00", "incident", "A Catastrophe in Korea (North)", 24, new String[]{"Ohio",
                "Pennsylvania",
                "American Samoa",
                "Northern Mariana Islands"});
        assertThat(ticket.getTags()).contains("American Samoa");
    }

}