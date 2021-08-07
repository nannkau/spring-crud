package vn.amit.springcrud.service;

import java.util.List;

import vn.amit.springcrud.entity.Scores;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.model.request.AddStudentRequest;
import vn.amit.springcrud.model.request.UpdateStudentRequest;



public interface StudentService {
    Student getDetail(Integer id);
    List<Scores> getPoint(Integer id);
    Student save(AddStudentRequest student);
    Student update(UpdateStudentRequest student);
    Student findByName(String name);
    Student findById(Integer id);
    void deleteById(Integer id);
}
