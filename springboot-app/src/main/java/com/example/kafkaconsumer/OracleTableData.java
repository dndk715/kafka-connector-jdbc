package com.example.kafkaconsumer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OracleTableData {
    @JsonProperty("ID")
    private String id;
    
    @JsonProperty("NAME")
    private String name;
    
    @JsonProperty("DESCRIPTION")
    private String description;
    
    @JsonProperty("CREATED_AT")
    private String createdAt;
    
    // Default constructor
    public OracleTableData() {}
    
    // Constructor with all fields
    public OracleTableData(String id, String name, String description, String createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "OracleTableData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
} 