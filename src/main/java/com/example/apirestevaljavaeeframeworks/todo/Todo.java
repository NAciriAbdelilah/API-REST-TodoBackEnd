package com.example.apirestevaljavaeeframeworks.todo;

import jakarta.persistence.*;

@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    @Column(name="description")
    String description;
    @Column(name="statut")
    int statut;

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

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Todo() {
    }

    public Todo(String description, int statut) {
        this.description = description;
        this.statut = statut;
    }

    public Todo(int id, String description, int statut) {
        this.id = id;
        this.description = description;
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
