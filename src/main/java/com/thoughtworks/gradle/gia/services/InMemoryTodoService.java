package com.thoughtworks.gradle.gia.services;

import com.thoughtworks.gradle.gia.domain.TodoItem;
import com.thoughtworks.gradle.gia.exceptions.UpdatingItemNotExistException;

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
    public TodoItem add(TodoItem todo) {
        this.todoList.add(todo);
        return todo;
    }

    @Override
    public void delete(TodoItem todoItem) {

    }

    @Override
    public TodoItem update(TodoItem todoItem) throws UpdatingItemNotExistException {
        Optional<TodoItem> itemWithSameId = this.todoList.stream().filter(todo -> todo.getId() == todoItem.getId()).findFirst();
        if (itemWithSameId.isPresent()) {
            return itemWithSameId.get().setName(todoItem.getName()).setCompleted(todoItem.isCompleted());
        }
        throw new UpdatingItemNotExistException();
    }
}
