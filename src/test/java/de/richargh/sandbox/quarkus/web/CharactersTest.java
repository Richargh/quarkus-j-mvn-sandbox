package de.richargh.sandbox.quarkus.web;

import de.richargh.sandbox.quarkus.domain.Character;
import de.richargh.sandbox.quarkus.domain.CharacterId;
import de.richargh.sandbox.quarkus.domain.MutableCharacters;
import de.richargh.sandbox.quarkus.persist.InMemoryCharacters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CharactersTest {

    @Test
    @DisplayName("Initial Characters should be empty")
    public void isEmpty(){
        // given
        MutableCharacters testee = new InMemoryCharacters();

        // when
        Optional<Character> result = testee.findById(new CharacterId("1"));

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("should find item if it's in the inventory")
    public void findExistingItem(){
        // given
        Character character = new Character(new CharacterId("1"));
        MutableCharacters testee = new InMemoryCharacters(character);

        // when
        Optional<Character> result = testee.findById(character.id());

        // then
        assertThat(result).contains(character);
    }

}
