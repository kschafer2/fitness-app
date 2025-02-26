package com.protonmail.kschay.fitness_app.controller;

import com.protonmail.kschay.fitness_app.domain.IdentifiedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public abstract class CrudController<T extends IdentifiedEntity<ID>, ID> {

    protected final CrudRepository<T, ID> repository;

    public CrudController(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<T> get(@PathVariable ID id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<T>> getAll() {
        return ResponseEntity.ofNullable(repository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<T> save(@RequestBody T entity) {
        T savedEntity = repository.save(entity);
        ID id = savedEntity.getId();
        return ResponseEntity.created(URI.create(String.format("/get/%s", id)))
                .body(savedEntity);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Iterable<T>> saveAll(@RequestBody Iterable<T> entities) {
        Iterable<T> savedEntities = repository.saveAll(entities);
        return ResponseEntity.created(URI.create("/getAll")).body(savedEntities);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Iterable<T>> delete(@PathVariable ID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Iterable<T>> deleteAll(@RequestBody Iterable<ID> ids) {
        repository.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }
}
