package org.example.asterixapi.service;


import org.example.asterixapi.repo.CharacterRepo;
import org.example.asterixapi.model.Character;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharacterServiceTest {
private final CharacterRepo mockRepo = mock(CharacterRepo.class);
    @Test
    void test_getAllCharacters() {
        // GIVEN
        CharacterService serviceTest = new CharacterService(mockRepo);
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
        CharacterService serviceTest = new CharacterService(mockRepo);
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



}

