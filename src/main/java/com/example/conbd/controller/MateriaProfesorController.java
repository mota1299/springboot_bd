package com.example.conbd.controller;

import com.example.conbd.model.response.MateriaProfesorResponse;
import com.example.conbd.model.response.ProfesorResponse;
import com.example.conbd.service.IMateriaProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class MateriaProfesorController {

    @Autowired
    private IMateriaProfesorService iMateriaProfesorService;

    @GetMapping("/teachers")
    public ResponseEntity<List<MateriaProfesorResponse>> getAllSubjectsTeachears() {
        List<MateriaProfesorResponse> subjects = iMateriaProfesorService.obtenerMateriaProfesor();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/byTeacher")
    public ResponseEntity<ProfesorResponse> getSubjectsByTeacher(@RequestParam("id") Integer id) {
        ProfesorResponse subjects = iMateriaProfesorService.obtenerMateriasPorProfesor(id);
        return ResponseEntity.ok(subjects);
    }

}
