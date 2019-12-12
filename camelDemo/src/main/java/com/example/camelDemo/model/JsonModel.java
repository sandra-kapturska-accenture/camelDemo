package com.example.camelDemo.model;

public class JsonModel {
    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JsonModel{" +
            "id=" + id +
            ", description='" + description + '\'' +
            '}';
    }
}
