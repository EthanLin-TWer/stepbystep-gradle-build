package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InMemoryTodoServiceTest {

    private InMemoryTodoService service;

    @Before
    public void setUp() throws Exception {
        service = new InMemoryTodoService();
    }

    @Test
    public void should_add_one_item_when_call_add_method() throws Exception {
        long id = service.add(new TodoItem().id(1).name("setup gradle").completed(false));

        assertThat(id, is(1L));
    }

    @Test
    public void should_add_another_item_when_call_add_method() throws Exception {
        
    }
}