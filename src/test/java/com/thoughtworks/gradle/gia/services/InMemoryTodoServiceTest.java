package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;
import com.thoughtworks.gradle.gia.exceptions.UpdatingItemNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @Nested
    class AfterSomeDataPopulated {
        @BeforeEach
        void prePopulateWithTwoTodoItems() {
            service.add(new TodoItem().id(1).setName("setup gradle").setCompleted(false));
            service.add(new TodoItem().id(2).setName("setup intellij").setCompleted(true));
        }

        @Test
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        void should_set_item_with_id_1_when_call_findById_method_with_id_1() throws Exception {
            Optional<TodoItem> todoItem = service.findById(1);

            assertEquals(todoItem.isPresent(), true);
            assertAll(() -> assertEquals(todoItem.get().getId(), 1),
                    () -> assertEquals(todoItem.get().getName(), "setup gradle"),
                    () -> assertEquals(todoItem.get().isCompleted(), false));
        }

        @Test
        void should_update_item_details_when_call_update_method_with_id_1() throws Exception {
            TodoItem updatedTodo = service.update(new TodoItem().id(1).setName("setup maven").setCompleted(true));

            assertAll(() -> assertEquals(updatedTodo.getId(), 1),
                    () -> assertEquals(updatedTodo.getName(), "setup maven"),
                    () -> assertEquals(updatedTodo.isCompleted(), true));
        }

        @Test
        void should_throw_exception_when_trying_to_update_an_unexisting_item() {
            assertThrows(UpdatingItemNotExistException.class, () -> service.update(new TodoItem().id(3)));
        }
    }
}