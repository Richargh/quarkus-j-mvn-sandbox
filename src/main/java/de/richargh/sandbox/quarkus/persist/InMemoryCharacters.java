package de.richargh.sandbox.quarkus.persist;

import de.richargh.sandbox.quarkus.domain.Character;
import de.richargh.sandbox.quarkus.domain.CharacterId;
import de.richargh.sandbox.quarkus.domain.MutableCharacters;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryCharacters implements MutableCharacters {

    private final Map<CharacterId, Character> allCharacters;

    public InMemoryCharacters(Character... characters) {
        this.allCharacters = Stream.of(characters)
                .collect(Collectors.toMap(Character::id, Function.identity()));
    }

    public Optional<Character> findById(CharacterId id){
        return Optional.ofNullable(allCharacters.get(id));
    }

    @Override
    public void put(Character character) {
        allCharacters.put(character.id(), character);
    }
}
