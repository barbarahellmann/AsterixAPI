package org.example.asterixapi.service;


import org.example.asterixapi.dto.CharacterWOId;
import org.example.asterixapi.repo.CharacterRepo;
import org.example.asterixapi.model.Character;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharacterServiceTest {
private final CharacterRepo mockRepo = mock(CharacterRepo.class);
private final IdService mockIdService = mock(IdService.class);

    @Test
    void test_getAllCharacters() {
        // GIVEN
        CharacterService serviceTest = new CharacterService(mockRepo, mockIdService);
        Character testCharacter = new Character(
                "testId",
                "testname",
                12,
                "professiontest");
        when(mockRepo.findAll()).thenReturn(List.of(testCharacter));

        List<Character> expected = List.of(testCharacter);
        // WHEN
        List<Character> actual = serviceTest.getAllCharacters();
        // THEN
        assertEquals(expected, actual);
        verify(mockRepo).findAll();
    }

    @Test
    void test_getCharacterById() {
        // GIVEN
        CharacterService serviceTest = new CharacterService(mockRepo, mockIdService);
        Character testCharacter = new Character(
                "testId",
                "testname",
                12,
                "professiontest");
        when(mockRepo.findById("1")).thenReturn(Optional.of(testCharacter));

        Optional<Character> expected = Optional.of(testCharacter);

        // WHEN
        Optional<Character> actual = serviceTest.getCharacterById("1");

        // THEN
        assertEquals(expected, actual);
        verify(mockRepo).findById("1");
    }

    @Test
    void test_updateCharacter(){
        //GIVEN
        CharacterService serviceTest = new CharacterService(mockRepo, mockIdService);
        Character testCharacter = new Character(
                "test",
                "moin",
                14,
                "schueler"
        );

        //WHEN
        serviceTest.updateCharacter(testCharacter);

        //THEN
        verify(mockRepo).save(testCharacter);
    }

    @Test
    void deleteCharacter() {
        //GIVEN
        CharacterService serviceTest = new CharacterService(mockRepo, mockIdService);

        //WHEN
        serviceTest.deleteCharacter("string2");

        //THEN
        verify(mockRepo).deleteById("string2");
    }

    @Test
    void test_createNewCharacter() {

        //GIVEN
        CharacterService serviceTest = new CharacterService(mockRepo, mockIdService);
        Character testCharacter = new Character(
                "kugelfisch",
                "kugel",
                99,
                "fisch"
        );
        CharacterWOId kugelfisch = new CharacterWOId(
                "kugel",
                99,
                "fisch"
        );

        when(mockIdService.generateID()).thenReturn("kugelfisch");
        //WHEN
        serviceTest.createNewCharacter(kugelfisch);

        //THEN
        verify(mockRepo).save(testCharacter);
    }
}


