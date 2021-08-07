package vn.amit.springcrud.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.amit.springcrud.entity.Scores;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.model.request.AddStudentRequest;
import vn.amit.springcrud.model.request.UpdateStudentRequest;
import vn.amit.springcrud.repository.ScoresRepository;
import vn.amit.springcrud.repository.StudentRepository;
import vn.amit.springcrud.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ScoresRepository scoresRepository;
    @Override
    public Student getDetail(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Scores> getPoint(Integer id) {
        return scoresRepository.findByStudent_Id(id);
    }

   

    @Override
    public Student findByName(String name) {
        return studentRepository.findByFullName(name);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
        
    }

    @Override
    public Student save(AddStudentRequest student) {
        return studentRepository.save(new ModelMapper().map(student, Student.class));
    }

    @Override
    public Student update(UpdateStudentRequest student) {
        Student entity= studentRepository.findById(student.getId()).get();
        if(entity!=null){
            entity.setFullName(student.getFullName());
            entity.setStudentCode(student.getStudentCode());
        }
        return studentRepository.save(entity);
    }

    
    
}
