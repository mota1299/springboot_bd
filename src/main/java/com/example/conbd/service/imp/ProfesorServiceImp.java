package com.example.conbd.service.imp;

import com.example.conbd.entity.Teacher;
import com.example.conbd.model.request.ProfesorRequest;
import com.example.conbd.model.response.ProfesorResponse;
import com.example.conbd.repository.ITeacherRepository;
import com.example.conbd.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ProfesorServiceImp implements IProfesorService {

    @Autowired
    private ITeacherRepository iTeacherRepository;

    @Override
    public ProfesorResponse guardarProfesor(ProfesorRequest request) {
        Teacher teacher = new Teacher();
        teacher.setName(request.getNombreProfesor());
        teacher.setEmail(request.getEmail());
        teacher.setCreationUser("system");
        teacher.setCreationDate(LocalDateTime.now());

        Teacher teacherSaved = iTeacherRepository.save(teacher);

        ProfesorResponse response = new ProfesorResponse();
        response.setNombreProfesor(teacherSaved.getName());
        response.setEmail(teacherSaved.getEmail());
        response.setMaterias(new ArrayList<>());
        return response;
    }

    @Override
    public ProfesorResponse actualizarProfesor(Integer id, ProfesorRequest request) {
        Teacher teacher = iTeacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher no encontrado"));

        teacher.setName(request.getNombreProfesor());
        teacher.setEmail(request.getEmail());
        teacher.setModificationUser("system");
        teacher.setModificationDate(LocalDateTime.now());

        Teacher teacherSaved = iTeacherRepository.save(teacher);

        ProfesorResponse response = new ProfesorResponse();
        response.setNombreProfesor(teacherSaved.getName());
        response.setEmail(teacherSaved.getEmail());
        response.setMaterias(new ArrayList<>());
        return response;
    }

    @Override
    public ProfesorResponse actualizarParcialProfesor(Integer id, ProfesorRequest request) {
        Teacher teacher = iTeacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher no encontrado"));

        if (request.getNombreProfesor() != null) {
            teacher.setName(request.getNombreProfesor());
        }

        if (request.getEmail() != null) {
            teacher.setEmail(request.getEmail());
        }

        teacher.setModificationUser("system");
        teacher.setModificationDate(LocalDateTime.now());

        Teacher teacherSaved = iTeacherRepository.save(teacher);

        ProfesorResponse response = new ProfesorResponse();
        response.setNombreProfesor(teacherSaved.getName());
        response.setEmail(teacherSaved.getEmail());
        response.setMaterias(new ArrayList<>());
        return response;
    }

    @Override
    public void eliminarProfesor(Integer id) {
        Teacher teacher = iTeacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher no encontrado"));
        iTeacherRepository.delete(teacher);
    }
}
