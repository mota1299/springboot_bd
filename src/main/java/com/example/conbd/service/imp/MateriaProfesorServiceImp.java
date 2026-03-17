package com.example.conbd.service.imp;

import com.example.conbd.entity.Subject;
import com.example.conbd.entity.Teacher;
import com.example.conbd.model.response.MateriaProfesorResponse;
import com.example.conbd.model.response.MateriaResponse;
import com.example.conbd.model.response.ProfesorResponse;
import com.example.conbd.repository.ISubjectRepository;
import com.example.conbd.repository.ITeacherRepository;
import com.example.conbd.service.IMateriaProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaProfesorServiceImp implements IMateriaProfesorService {

   @Autowired
   private ISubjectRepository iSubjectRepository;

    @Autowired
    private ITeacherRepository iTeacherRepository;

    @Override
    public List<MateriaProfesorResponse> obtenerMateriaProfesor() {
        List<MateriaProfesorResponse> response = new ArrayList<>();
        List<Subject> subjects = iSubjectRepository.findAll();
        for(Subject s: subjects ){
            MateriaProfesorResponse r = new MateriaProfesorResponse();
            r.setNombreMateria(s.getName());
            r.setNombreProfesor(s.getTeacher().getName());
            response.add(r);
        }
        return response;
    }

    @Override
    public ProfesorResponse obtenerMateriasPorProfesor(Integer id) {
        ProfesorResponse response = new ProfesorResponse();
        Teacher teacher = iTeacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher no encontrado"));
        List<Subject> subjects = iSubjectRepository.findByTeacher(teacher);
        List<MateriaResponse> materiaResponses = new ArrayList<>();
        for(Subject s: subjects){
            response.setNombreProfesor(s.getTeacher().getName());
            response.setEmail(s.getTeacher().getEmail());
            MateriaResponse m = new MateriaResponse();
            m.setNombreMateria(s.getName());
            m.setHoras(s.getHours());
            materiaResponses.add(m);
        }
        response.setMaterias(materiaResponses);
        return response;
    }
}
