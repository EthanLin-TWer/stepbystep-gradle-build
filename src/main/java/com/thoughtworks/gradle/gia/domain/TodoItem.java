package com.thoughtworks.gradle.gia.domain;

public class TodoItem implements Comparable<TodoItem> {
    private long id;
    private String name;
    private boolean completed;

    public long getId() {
        return id;
    }

    public TodoItem id(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TodoItem name(String name) {
        this.name = name;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TodoItem completed(boolean completed) {
        this.completed = completed;
        return this;
    }

    @Override
    public int compareTo(TodoItem item) {
        return 0;
    }


}
