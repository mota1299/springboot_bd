package com.example.conbd.service;

import com.example.conbd.model.request.ProfesorRequest;
import com.example.conbd.model.response.ProfesorResponse;

public interface IProfesorService {

    ProfesorResponse guardarProfesor(ProfesorRequest request);

    ProfesorResponse actualizarProfesor(Integer id, ProfesorRequest request);

    void eliminarProfesor(Integer id);

}
