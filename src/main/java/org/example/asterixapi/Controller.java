package org.example.asterixapi;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor


public class Controller {

    private final CharacterRepo repo;

    @PostMapping
    public void saveNewCharacter(@RequestBody Characters character) {
        repo.save(character);
    }

    @GetMapping
    public List<Characters> getAllCharacters() {
        return repo.findAll();
    }
}
