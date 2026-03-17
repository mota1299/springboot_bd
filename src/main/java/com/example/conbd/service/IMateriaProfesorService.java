package com.example.conbd.service;

import com.example.conbd.model.response.MateriaProfesorResponse;
import com.example.conbd.model.response.ProfesorResponse;

import java.util.List;

public interface IMateriaProfesorService {

    List<MateriaProfesorResponse> obtenerMateriaProfesor();

    ProfesorResponse obtenerMateriasPorProfesor(Integer id);

}
