package ru.tsc.reactordemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tsc.reactordemo.model.Guest;
import ru.tsc.reactordemo.repository.ReactiveGuestRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReactiveGuestServiceImpl implements ReactiveGuestService {

    private final ReactiveGuestRepository guestRepository;

    @Override
    public Mono<Guest> saveOrUpdate(Optional<Guest> optionalGuest) {
        Guest guest = optionalGuest.orElseThrow(NoSuchElementException::new);
        log.info("Creating guest : {}", guest);
        return guestRepository.save(guest);
    }

    @Override
    public Mono<Void> delete(Optional<Long> optionalId) {
        Long id = optionalId.orElseThrow(NoSuchElementException::new);
        log.info("Deleting guest by id : {}", id);
        return guestRepository.deleteById(id);
    }

    @Override
    public Mono<Guest> getById(Optional<Long> optionalId) {
        Long id = optionalId.orElseThrow(NoSuchElementException::new);
        log.info("Getting guest by id : {}", id);
        return guestRepository.findById(id);
    }

    @Override
    public Flux<Guest> getAll() {
        log.info("Getting all guests");
        return guestRepository.findAll();
    }
}
