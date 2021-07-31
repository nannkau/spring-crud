package vn.amit.springcrud.service;

import java.util.Optional;

import vn.amit.springcrud.entity.Point;
import vn.amit.springcrud.entity.Student;



public interface StudentService {
    Optional<Student> getDetail(Integer id);
    Point getPoint(Integer id);
    Student save(Student student);
    Optional<Student> update(Student student);
    Optional<Student> findByName(String name);
    Optional<Student> findById(Integer id);
    void deleteById(Integer id);
}
