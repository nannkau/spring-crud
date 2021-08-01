package vn.amit.springcrud.entity;

public class Point {
    private Integer id;
    private String subject;
    private Double point;

    public Point() {
    }
    

    public Point(Integer id, String subject, Double point) {
        this.id = id;
        this.subject = subject;
        this.point = point;       
    }

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
}
