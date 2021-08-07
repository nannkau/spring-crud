package vn.amit.springcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "score_id")
    private Integer id;
    private String subject;
    private Double scoreValue;
    @ManyToOne()
    @JoinColumn(name = "student_id",referencedColumnName = "student_id")
    private Student student;
}
