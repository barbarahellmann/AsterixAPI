package org.example.asterixapi.controller;


import lombok.RequiredArgsConstructor;
import org.example.asterixapi.dto.CharacterWOId;
import org.example.asterixapi.model.Character;
import org.example.asterixapi.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor

public class CharacterController {

    private final CharacterService service;

    @PostMapping
    public void saveNewCharacter(@RequestBody CharacterWOId character) {
        service.createNewCharacter(character);
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return service.getAllCharacters();
    }


//    @PutMapping("/{id}/age")
//    public void updateAge(@PathVariable String id, @RequestBody int age) {
//        if(repo.existsById(id)){
//            repo.deleteById(id);
//            repo.save(character -> repo.save(new Character(id, , age ))
//        };
//
//    }


    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        service.deleteCharacter(id);

    }
}
