package ru.tsc.reactordemo.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tsc.reactordemo.model.Guest;

import java.util.Optional;

public interface ReactiveGuestService {

    Mono<Guest> saveOrUpdate(Optional<Guest> optionalGuest);

    void delete(Optional<Long> optionalId);

    Mono<Guest> getById(Optional<Long> optionalId);

    Flux<Guest> getAll();
}
