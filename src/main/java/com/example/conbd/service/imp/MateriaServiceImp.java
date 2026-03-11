package com.example.conbd.service.imp;

import com.example.conbd.entity.Subject;
import com.example.conbd.model.response.MateriaResponse;
import com.example.conbd.repository.ISubjectRepository;
import com.example.conbd.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaServiceImp implements IMateriaService {

    @Autowired
    private ISubjectRepository iSubjectRepository;

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





}
