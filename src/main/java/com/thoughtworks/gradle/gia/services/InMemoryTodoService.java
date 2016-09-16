package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;

import java.util.List;

public class InMemoryTodoService implements TodoService{
    @Override
    public List<TodoItem> findAll() {
        return null;
    }

    @Override
    public TodoItem findById(String id) {
        return null;
    }

    @Override
    public long add(TodoItem todo) {
        return 1;
    }

    @Override
    public void delete(TodoItem todoItem) {

    }

    @Override
    public void update(TodoItem todoItem) {

    }
}
