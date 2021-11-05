package de.richargh.sandbox.quarkus.domain;

import java.util.Optional;

public interface Characters {

    Optional<Character> findById(CharacterId id);

}
