package com.example.conbd.service.imp;

import com.example.conbd.entity.Subject;
import com.example.conbd.entity.Teacher;
import com.example.conbd.model.request.MateriaRequest;
import com.example.conbd.model.response.MateriaResponse;
import com.example.conbd.repository.ISubjectRepository;
import com.example.conbd.repository.ITeacherRepository;
import com.example.conbd.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaServiceImp implements IMateriaService {

    @Autowired
    private ISubjectRepository iSubjectRepository;

    @Autowired
    private ITeacherRepository iTeacherRepository;

    @Override
    public List<MateriaResponse> obtenerMaterias() {
        List<MateriaResponse> response = new ArrayList<>();
        List<Subject> subjects = iSubjectRepository.findAll();
        for(Subject subject : subjects){
            MateriaResponse m = new MateriaResponse();
            m.setNombreMateria(subject.getName());
            m.setHoras(subject.getHours());
            response.add(m);
        }
        return response;
    }

    @Override
    public MateriaResponse guardarMateria(MateriaRequest request) {
        Teacher teacher = iTeacherRepository
                .findById(request.getIdProfesor())
                .orElseThrow(() -> new RuntimeException("Teacher no encontrado"));

        Subject subject = new Subject();
        subject.setName(request.getNombreMateria());
        subject.setHours(request.getHoras());
        subject.setTeacher(teacher);
        subject.setCreatorUser("system");
        subject.setCreationDate(LocalDateTime.now());

        Subject subjectSaved = iSubjectRepository.save(subject);

        MateriaResponse response = new MateriaResponse();
        response.setNombreMateria(subjectSaved.getName());
        response.setHoras(subjectSaved.getHours());
        return response;
    }




}
