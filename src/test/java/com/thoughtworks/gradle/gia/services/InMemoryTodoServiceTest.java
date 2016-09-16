package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InMemoryTodoServiceTest {

    private InMemoryTodoService service;

    @Before
    public void setUp() throws Exception {
        service = new InMemoryTodoService();
    }

    @Test
    public void should_add_another_item_when_call_add_method() throws Exception {
        TodoItem added = service.add(new TodoItem().id(2).setName("setup intellij").setCompleted(true));

        assertThat(added.getId(), is(2));
    }

    @Test
    public void should_get_item_with_id_1_when_call_findById_method() throws Exception {
        TodoItem added = service.add(new TodoItem().id(1).setName("setup gradle").setCompleted(false));

        Optional<TodoItem> setupGradle = service.findById(added.getId());

        assertThat(setupGradle.isPresent(), is(true));
        assertThat(setupGradle.get().getId(), is(1));
        assertThat(setupGradle.get().getName(), is("setup gradle"));
        assertThat(setupGradle.get().isCompleted(), is(false));
    }

    @Test
    public void should_update_item_details_when_call_update_method() throws Exception {
        TodoItem originTodo = service.add(new TodoItem().id(1).setName("setup gradle").setCompleted(false));
        assertThat(service.findById(originTodo.getId()).get().getId(), is(1));

        service.update(new TodoItem().id(1).setName("setup gradle").setCompleted(true));

        assertThat(service.findById(1).get().getId(), is(1));
        assertThat(service.findById(1).get().getName(), is("setup gradle"));
        assertThat(service.findById(1).get().isCompleted(), is(true));
    }
}