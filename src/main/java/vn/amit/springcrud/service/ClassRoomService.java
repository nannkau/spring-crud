package vn.amit.springcrud.service;

import java.util.List;

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.model.request.AddClassRoomRequest;
import vn.amit.springcrud.model.request.UpdateClassRoomRequest;



public interface ClassRoomService {
    List<ClassRoom> getAll();
    ClassRoom add(AddClassRoomRequest classRoom);
    ClassRoom update(UpdateClassRoomRequest classRoom);
    void delete(Integer id);
    ClassRoom findByName(String name);
    List<Student> findStudentByClass(Integer id);
    Double getTotalPoint(Integer id);
    ClassRoom findById(Integer id);
}
