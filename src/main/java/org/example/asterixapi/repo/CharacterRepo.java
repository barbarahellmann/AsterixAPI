package org.example.asterixapi.repo;

import org.example.asterixapi.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {

}
