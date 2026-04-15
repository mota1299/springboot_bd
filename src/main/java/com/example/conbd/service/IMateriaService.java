package com.example.conbd.service;

import com.example.conbd.model.response.MateriaResponse;
import com.example.conbd.model.request.MateriaRequest;

import java.util.List;

public interface IMateriaService {

    List<MateriaResponse> obtenerMaterias();

    MateriaResponse guardarMateria(MateriaRequest request);


}
