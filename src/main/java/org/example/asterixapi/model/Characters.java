package org.example.asterixapi.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document("characters")
public record Characters(int id, String name, int age, String profession) {


}
