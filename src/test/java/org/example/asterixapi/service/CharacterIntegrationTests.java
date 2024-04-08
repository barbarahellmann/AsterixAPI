package org.example.asterixapi.service;

import org.example.asterixapi.repo.CharacterRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CharacterIntegrationTests {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private CharacterRepo repo;

    @Test
    void getAllCharacters_ShouldReturnEmptyList_WhenCalledInitially() throws Exception {
        //GIVEN
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("asterix/characters"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void createNewCharacter_shouldReturnCharacter_WhenCalledWithValidData() throws Exception {
       //GIVEN
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.post("/asterix/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                   "generateID" : "5",
                                    "name" : "Peter",
                                    "age" : 6,
                                    "profession" : "Clown"
                                }
                                """))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                                 "name" : "Peter",
                                    "age" : 6,
                                    "profession" : "Clown"
                        }
                       """))
                .andExpect(MockMvcResultMatchers.jsonPath("$.generatedID").exists());
    }

    @Test
    void getCharacterById_shouldReturnCharacter1_WhenCalledWithId1() throws Exception {
        //GIVEN
        Character testCharacter = new Character("4", "TestCharacter", 12, "Coach");
       repo.save(testCharacter);
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("/asterix/characters/4")
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""

                        {
                            "id" : "4",
                            "name" : "Peter",
                            "age" : 12,
                            "profession" : "coach"
                        }
                        """)));

    }
}
