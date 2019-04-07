package io.team21.calendarservice.controllers;

import io.team21.calendarservice.entities.Calendar;
import io.team21.calendarservice.exceptions.RecordNotFoundException;
import io.team21.calendarservice.repositories.CalendarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CalendarController {
    private final CalendarRepository repository;

    CalendarController(CalendarRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Calendar> getCalendars() {
        return repository.findAll();
    }

    @GetMapping("/calendar/{id}")
    public ResponseEntity<Optional> getCalendarById(@PathVariable Integer id) {
        Optional calendar = repository.findById(id);

        if (!calendar.isPresent()) {
            throw new RecordNotFoundException("No calendar with id " + id);
        }
        return new ResponseEntity<>(calendar, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Calendar> createCalendar(@Valid @RequestBody Calendar calendar) {
        repository.save(calendar);
        return new ResponseEntity<>(calendar, HttpStatus.OK);
    }

    @DeleteMapping("/calendar/{id}")
    public ResponseEntity<String> deleteCalendar(@PathVariable Integer id) {
        Optional optionalCalendar = repository.findById(id);

        if (!optionalCalendar.isPresent()) {
            throw new RecordNotFoundException("No calendar with id " + id);
        }
        repository.deleteById(id);
        return new ResponseEntity<>("Calendar deleted.", HttpStatus.OK);
    }
}
