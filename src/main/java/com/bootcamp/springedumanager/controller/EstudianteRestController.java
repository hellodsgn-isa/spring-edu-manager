package com.bootcamp.springedumanager.controller;

import com.bootcamp.springedumanager.model.Estudiante;
import com.bootcamp.springedumanager.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteService estudianteService;

    // GET - Listar todos los estudiantes (JSON)
    @GetMapping
    public ResponseEntity<List<Estudiante>> listar() {
        return ResponseEntity.ok(estudianteService.listarTodos());
    }

    // GET - Obtener un estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtener(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerPorId(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }

    // POST - Crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
        Estudiante nuevo = estudianteService.guardar(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // PUT - Actualizar un estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id, @RequestBody Estudiante datos) {
        Estudiante existente = estudianteService.obtenerPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        return ResponseEntity.ok(estudianteService.guardar(existente));
    }

    // DELETE - Eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Estudiante existente = estudianteService.obtenerPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}