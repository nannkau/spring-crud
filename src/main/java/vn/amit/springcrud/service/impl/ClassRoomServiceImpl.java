package vn.amit.springcrud.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import vn.amit.springcrud.data.ClassRoomData;
import vn.amit.springcrud.data.StudentData;
import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Point;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.service.ClassRoomService;
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
   
    @Override
    public List<ClassRoom> getAll() {
       
        return ClassRoomData.classRooms;
    }

    @Override
    public ClassRoom add(ClassRoom classRoom) {
        ClassRoomData.classRooms.add(classRoom);
        return classRoom;
    }

    @Override
    public ClassRoom update(ClassRoom classRoom) {
        ClassRoomData.classRooms.stream().filter(c->classRoom.getId()==c.getId())
        .forEach(c->c=classRoom);
        return classRoom;
    }

    @Override
    public void delete(Integer id) {
        Optional<ClassRoom> classRoom=ClassRoomData.classRooms.stream().filter(c->id==c.getId()).findFirst();
        if(classRoom.isPresent()){
            ClassRoomData.classRooms.remove(classRoom.get());
        }
        
    }


    @Override
    public List<Student> findStudentByClass(Integer id) {
        List<Student> students=StudentData.students.stream()
        .filter(c->id==c.getClassRoom().getId()).collect(Collectors.toList());
        
        return students;
    }

    @Override
    public Double getTotalPoint(Integer id) {
        Double point=(double) 0;
        for(Student student:StudentData.students){
            if(student.getClassRoom().getId()==id)
            {
                for (Point p : student.getPoints()) {
                    point=point+p.getPoint();
                }
            }
        }
        return point;
    }

    @Override
    public Optional<ClassRoom> findByName(String name) {
        Optional<ClassRoom> classRoom=ClassRoomData.classRooms.stream().filter(c->name.equals(c.getName())).findFirst();
        return classRoom;
    }

    @Override
    public Optional<ClassRoom> findById(Integer id) {
        Optional<ClassRoom> classRoom=ClassRoomData.classRooms.stream().filter(c->id==c.getId()).findFirst();
        return classRoom;
    }
    
}
