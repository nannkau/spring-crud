package vn.amit.springcrud.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.model.request.AddClassRoomRequest;
import vn.amit.springcrud.model.request.UpdateClassRoomRequest;
import vn.amit.springcrud.repository.ClassRoomRepository;
import vn.amit.springcrud.service.ClassRoomService;
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> getAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom add(AddClassRoomRequest classRoom) {
        ClassRoom entity= new ClassRoom();
        entity.setName(entity.getName());
        return classRoomRepository.save(entity);
    }

    @Override
    public ClassRoom update(UpdateClassRoomRequest classRoom) {
        ClassRoom classRoom2= classRoomRepository.findById(classRoom.getId()).get();
        classRoom2.setName(classRoom2.getName());
        return classRoomRepository.save(classRoom2);
    }

    @Override
    public void delete(Integer id) {
        classRoomRepository.deleteById(id);
        
    }

    @Override
    public ClassRoom findByName(String name) {
        return classRoomRepository.findByName(name);
    }

    @Override
    public List<Student> findStudentByClass(Integer id) {
        return classRoomRepository.findStudent(id);
    }

    @Override
    @Transactional
    public Double getTotalPoint(Integer id) {
        return classRoomRepository.getScoreTotal(id);
    }

    @Override
    public ClassRoom findById(Integer id) {
        return classRoomRepository.findById(id).get();
    }
    
}
