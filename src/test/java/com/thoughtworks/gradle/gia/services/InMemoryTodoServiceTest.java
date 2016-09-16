package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryTodoServiceTest {
    private InMemoryTodoService service;

    @BeforeEach
    public void setUp() throws Exception {
        service = new InMemoryTodoService();
    }

    @Test
    public void should_add_another_item_when_call_add_method() throws Exception {
        TodoItem added = service.add(new TodoItem().id(2).setName("setup intellij").setCompleted(true));

        assertEquals(added.getId(), 2);
    }

    @Test
    public void should_get_item_with_id_1_when_call_findById_method() throws Exception {
        TodoItem added = service.add(new TodoItem().id(1).setName("setup gradle").setCompleted(false));

        Optional<TodoItem> setupGradle = service.findById(added.getId());

        assertEquals(setupGradle.isPresent(), true);
        assertEquals(setupGradle.get().getId(), 1);
        assertEquals(setupGradle.get().getName(), "setup gradle");
        assertEquals(setupGradle.get().isCompleted(), false);
    }

    @Test
    public void should_update_item_details_when_call_update_method() throws Exception {
        TodoItem originTodo = service.add(new TodoItem().id(1).setName("setup gradle").setCompleted(false));
        assertEquals(service.findById(originTodo.getId()).get().getId(), 1);

        TodoItem updatedTodo = service.update(new TodoItem().id(1).setName("setup gradle").setCompleted(true));

        assertEquals(updatedTodo.getId(), 1);
        assertEquals(updatedTodo.getName(), "setup gradle");
        assertEquals(updatedTodo.isCompleted(), true);
    }

    @Test
    public void should_throw_exception_when_updating_unexisting_item() throws Exception {

    }
}