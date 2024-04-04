package org.example.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CharacterRepo extends MongoRepository<Characters, String> {

}
