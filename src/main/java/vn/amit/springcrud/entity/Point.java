package vn.amit.springcrud.entity;

public class Point {
    private Integer id;
    private String subject;
    private Double point;
    private Student student;
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getPoint() {
        return this.point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
