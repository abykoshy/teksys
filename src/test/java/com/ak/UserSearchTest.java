package com.ak;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSearchTest {
    private User[] users = new User[]{new User("1","name1", "", true),
            new User(null,"name2", "", false),
            new User("3","name1", "", false)};

    @Test
    public void testSearch() throws SearchServiceException {
        UserSearch userSearch = new UserSearch(users);
        User[] searchResult = userSearch.searchUsers("@.name == 'name1'");
        assertThat(searchResult).isNotEmpty();
        assertThat(searchResult).hasSize(2);
    }

    @Test
    public void testSearchNull() throws SearchServiceException {
        UserSearch userSearch = new UserSearch(users);
        User[] searchResult = userSearch.searchUsers("@._id == null");
        assertThat(searchResult).isNotEmpty();
        assertThat(searchResult).hasSize(1);
    }
}