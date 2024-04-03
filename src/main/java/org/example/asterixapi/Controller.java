package org.example.asterixapi;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/")
@RequiredArgsConstructor


public class Controller {

    private final CharacterRepo repo;

    @PostMapping(path = "/characters")
    public void saveNewCharacter(@RequestBody Character character) {
        repo.save(character);
    }

    @GetMapping("/character")
    public List<Character> getAllCharacters() {
        return repo.findAll();
    }
}
