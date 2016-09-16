package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTodoService implements TodoService{
    private List<TodoItem> todoList = new ArrayList<>();

    @Override
    public List<TodoItem> findAll() {
        return null;
    }

    @Override
    public Optional<TodoItem> findById(int id) {
        return todoList.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    @Override
    public int add(TodoItem todo) {
        this.todoList.add(todo);
        return todo.getId();
    }

    @Override
    public void delete(TodoItem todoItem) {

    }

    @Override
    public void update(TodoItem todoItem) {
        if (this.todoList.stream().anyMatch(todo -> todo.getId() == todoItem.getId())) {
            this.todoList.stream().filter(todo -> todo.getId() == todoItem.getId()).findFirst()
                    .get().name(todoItem.getName()).completed(todoItem.isCompleted());
        }
    }
}
