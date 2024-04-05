package org.example.asterixapi.service;

import lombok.RequiredArgsConstructor;
import org.example.asterixapi.dto.CharacterWOId;
import org.example.asterixapi.model.Character;
import org.example.asterixapi.repo.CharacterRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepo repo;

    public void createNewCharacter(CharacterWOId character) {
        Character newCharacter = new Character(
                UUID.randomUUID().toString(),
                character.name(),
                character.age(),
                character.profession());
        repo.save(newCharacter);
    }

    public List<Character> getAllCharacters() {
        return repo.findAll();
    }

    public Optional<Character> getCharacterById(String id) {
        return repo.findById(id);
    }

    public void deleteCharacter(String id) {
        repo.deleteById(id);

    }


}
