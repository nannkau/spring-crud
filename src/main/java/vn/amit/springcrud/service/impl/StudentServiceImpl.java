package vn.amit.springcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.amit.springcrud.data.StudentData;
import vn.amit.springcrud.entity.Point;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{

    @Override
    public Optional<Student> getDetail(Integer id) {
        Optional<Student> student=StudentData.students.stream().filter(s->id==s.getId()).findFirst();
        return student;
    }

    @Override
    public List<Point> getPoint(Integer id) {
        Optional<Student> student=StudentData.students.stream().filter(s->id==s.getId()).findFirst();
        return student.get().getPoints();
    }

    

    @Override
    public Optional<Student> update(Student student) {
        StudentData.students.stream().filter(s->student.getId()==s.getId()).forEach(s->s=student);
        Optional<Student> optional=StudentData.students.stream().filter(s->student.getId()==s.getId()).findFirst();
        return optional;
    }

    @Override
    public Optional<Student> findByName(String name) {
        Optional<Student> student=StudentData.students.stream().filter(s->name.equals(s.getFullName())).findFirst();
        return student;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        Optional<Student> student=StudentData.students.stream().filter(s->id==s.getId()).findFirst();
        return student;
    }

    @Override
    public Student save(Student student) {
        StudentData.students.add(student);
        Optional<Student> optional=StudentData.students.stream().filter(s->student.getId()==s.getId()).findFirst();
        return optional.get();
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Student> student=StudentData.students.stream().filter(s->id==s.getId()).findFirst();
        StudentData.students.remove(student.get());
    }

    
    
}
