package de.richargh.sandbox.quarkus.domain;

import java.util.Optional;

public interface MutableCharacters extends Characters {

    void put(Character character);

}
