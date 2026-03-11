package com.example.conbd.controller;

import com.example.conbd.model.response.MateriaResponse;
import com.example.conbd.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class MateriaController {

    @Autowired
    private IMateriaService iMateriaService;

    @GetMapping("/hours")
    public ResponseEntity<List<MateriaResponse>> getAllSubjects() {
        List<MateriaResponse> subjects = iMateriaService.obtenerMaterias();
        return ResponseEntity.ok(subjects);
    }
}
