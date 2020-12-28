package ru.tsc.reactordemo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tsc.reactordemo.model.Guest;
import ru.tsc.reactordemo.service.ReactiveGuestService;

import java.util.Optional;

@RestController
@RequestMapping("/reactive-demo/v1/guests")
@Log4j2
public class ReactiveGuestController {

    private final ReactiveGuestService guestService;

    @Autowired
    public ReactiveGuestController(ReactiveGuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<Mono<Guest>> saveGuest(@RequestBody Optional<Guest> guest) {
        guestService.saveOrUpdate(guest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Mono<Guest>> updateGuest(@RequestBody Optional<Guest> optionalGuest) {
        Mono<Guest> guest = guestService.saveOrUpdate(optionalGuest);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Guest>> deleteGuestById(@PathVariable("id") Optional<Long> id) {
        guestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Guest>> getGuestById(@PathVariable("id") Optional<Long> id) {
        Mono<Guest> guest = guestService.getById(id);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Flux<Guest>> getAllGuests() {
        Flux<Guest> guests = guestService.getAll();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }
}
