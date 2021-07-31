package vn.amit.springcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.service.ClassRoomService;
@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Override
    public List<ClassRoom> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClassRoom add(ClassRoom classRoom) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClassRoom update(ClassRoom classRoom) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public List<Student> findStudentByClass(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double getTotalPoint(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<ClassRoom> findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<ClassRoom> findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
