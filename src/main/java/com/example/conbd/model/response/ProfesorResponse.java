package com.example.conbd.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ProfesorResponse {

    private String nombreProfesor;
    private String email;
    private List<MateriaResponse> materias;

}
