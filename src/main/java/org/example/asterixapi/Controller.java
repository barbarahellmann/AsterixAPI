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


//    @PutMapping("/{id}/age")
//    public void updateAge(@PathVariable String id, @RequestBody int age) {
//        if(repo.existsById(id)){
//            repo.deleteById(id);
//            repo.save(character -> repo.save(new Characters(id, , age ))
//        };
//
//    }


    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id) {
        repo.deleteById(id);

    }
}
