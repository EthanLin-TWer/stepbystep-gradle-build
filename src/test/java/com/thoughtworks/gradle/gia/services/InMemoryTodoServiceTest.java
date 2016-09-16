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
        int id = service.add(new TodoItem().id(2).name("setup intellij").completed(true));

        assertThat(id, is(2));
    }

    @Test
    public void should_get_item_with_id_1_when_call_findById_method() throws Exception {
        int id = service.add(new TodoItem().id(1).name("setup gradle").completed(false));

        Optional<TodoItem> setupGradle = service.findById(id);

        assertThat(setupGradle.isPresent(), is(true));
        assertThat(setupGradle.get().getId(), is(1));
        assertThat(setupGradle.get().getName(), is("setup gradle"));
        assertThat(setupGradle.get().isCompleted(), is(false));
    }

    @Test
    public void should_update_item_details_when_call_update_method() throws Exception {
        TodoItem originTodo = new TodoItem().id(1).name("setup gradle").completed(false);
        int id = service.add(originTodo);
        assertThat(service.findById(id).get().getId(), is(1));

        TodoItem updatedTodo = new TodoItem().id(1).name("setup gradle").completed(true);
        service.update(updatedTodo);

        assertThat(service.findById(id).get().getId(), is(1));
        assertThat(service.findById(id).get().getName(), is("setup gradle"));
        assertThat(service.findById(id).get().isCompleted(), is(true));
    }
}