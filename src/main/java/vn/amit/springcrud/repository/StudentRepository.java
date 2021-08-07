package vn.amit.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.amit.springcrud.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByFullName(String name);
}
