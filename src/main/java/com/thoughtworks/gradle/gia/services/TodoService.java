package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;

import java.util.List;

public interface TodoService {
    List<TodoItem> findAll();
    TodoItem findById(String id);
    long add(TodoItem todo);
    void delete(TodoItem todoItem);
    void update(TodoItem todoItem);
}
