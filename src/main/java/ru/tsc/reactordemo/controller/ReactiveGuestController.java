package ru.tsc.reactordemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tsc.reactordemo.model.Guest;
import ru.tsc.reactordemo.service.ReactiveGuestService;

import java.util.Optional;

@RestController
@RequestMapping("/reactive-demo/v1/guests")
@RequiredArgsConstructor
@Log4j2
public class ReactiveGuestController {

    private final ReactiveGuestService guestService;

    @PostMapping
    public Mono<Guest> saveGuest(@RequestBody Optional<Guest> guest) {
        return guestService.saveOrUpdate(guest);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteGuestById(@PathVariable("id") Optional<Long> id) {
        return guestService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<Guest> getGuestById(@PathVariable("id") Optional<Long> id) {
        return guestService.getById(id);
    }

    @GetMapping
    public Flux<Guest> getAllGuests() {
        return guestService.getAll();
    }
}
