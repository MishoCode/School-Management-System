package example.school.dto;

import example.school.model.Student;
import lombok.Data;

import java.util.Date;

@Data
public class PlainStudentDto {
    private Long id;
    private String name;
    private Date date;

    public static PlainStudentDto from(Student student) {
        PlainStudentDto plainStudentDto = new PlainStudentDto();
        plainStudentDto.setId(student.getId());
        plainStudentDto.setName(student.getName());
        plainStudentDto.setDate(student.getDate());
        return plainStudentDto;
    }
}
