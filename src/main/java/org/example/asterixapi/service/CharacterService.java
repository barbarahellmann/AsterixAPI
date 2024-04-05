package org.example.asterixapi.service;

import lombok.RequiredArgsConstructor;
import org.example.asterixapi.model.Characters;
import org.example.asterixapi.repo.CharacterRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepo repo;

    public void createNewCharacter(Characters character) {
        repo.save(character);
    }

    public List<Characters> getAllCharacters() {
        return repo.findAll();
    }

    public void deleteCharacter(String id) {
        repo.deleteById(id);

    }


}
