package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<TodoItem> findAll();
    Optional<TodoItem> findById(int id);
    TodoItem add(TodoItem todo);
    void delete(TodoItem todoItem);
    TodoItem update(TodoItem todoItem);
}
