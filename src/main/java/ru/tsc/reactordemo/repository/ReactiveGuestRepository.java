package ru.tsc.reactordemo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.tsc.reactordemo.model.Guest;

@Repository
public interface ReactiveGuestRepository extends ReactiveCrudRepository<Guest, Long> {
}
