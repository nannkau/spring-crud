package vn.amit.springcrud.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequest {
    private Integer id;
    private String fullName;
    private String studentCode;
}
