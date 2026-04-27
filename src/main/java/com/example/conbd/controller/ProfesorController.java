package com.example.conbd.controller;

import com.example.conbd.model.request.ProfesorRequest;
import com.example.conbd.model.response.ProfesorResponse;
import com.example.conbd.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class ProfesorController {

    @Autowired
    private IProfesorService iProfesorService;

    @PostMapping
    public ResponseEntity<ProfesorResponse> saveTeacher(@RequestBody ProfesorRequest request) {
        ProfesorResponse teacher = iProfesorService.guardarProfesor(request);
        return ResponseEntity.ok(teacher);
    }

    @PutMapping
    public ResponseEntity<ProfesorResponse> updateTeacher(@RequestParam("id") Integer id, @RequestBody ProfesorRequest request) {
        ProfesorResponse teacher = iProfesorService.actualizarProfesor(id, request);
        return ResponseEntity.ok(teacher);
    }

    @PatchMapping
    public ResponseEntity<ProfesorResponse> patchTeacher(@RequestParam("id") Integer id, @RequestBody ProfesorRequest request) {
        ProfesorResponse teacher = iProfesorService.actualizarParcialProfesor(id, request);
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTeacher(@RequestParam("id") Integer id) {
        iProfesorService.eliminarProfesor(id);
        return ResponseEntity.noContent().build();
    }
}
