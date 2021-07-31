package vn.amit.springcrud.service;

import java.util.List;
import java.util.Optional;

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Student;



public interface ClassRoomService {
    List<ClassRoom> getAll();
    ClassRoom add(ClassRoom classRoom);
    ClassRoom update(ClassRoom classRoom);
    void delete(Integer id);
    Optional<ClassRoom> findByName(String name);
    List<Student> findStudentByClass(Integer id);
    Double getTotalPoint(Integer id);
    Optional<ClassRoom> findById(Integer id);
}
