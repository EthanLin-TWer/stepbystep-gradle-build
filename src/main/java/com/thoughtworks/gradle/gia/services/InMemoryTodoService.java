package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTodoService implements TodoService{
    private List<TodoItem> todoList = new ArrayList<>();

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
        this.todoList.add(todo);
        return todo.getId();
    }

    @Override
    public void delete(TodoItem todoItem) {

    }

    @Override
    public void update(TodoItem todoItem) {

    }
}
