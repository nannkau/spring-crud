package vn.amit.springcrud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_room_id")
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "classRoom")
    private List<Student> students;
}
