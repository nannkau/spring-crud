package vn.amit.springcrud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer id;
    private String fullName;
    private String studentCode;
    @OneToMany(mappedBy = "student")
    private List<Scores> scores;
    @ManyToOne()
    @JoinColumn(name = "class_room_id",referencedColumnName = "class_room_id")
    private ClassRoom classRoom; 
    
}
