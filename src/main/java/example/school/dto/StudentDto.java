package example.school.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import example.school.model.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentDto {
    private Long id;
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;
    private List<PlainSubjectDto> plainSubjectsDto = new ArrayList<>();

    public static StudentDto from(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setDate(student.getDate());
        studentDto.setPlainSubjectsDto(
            student.getSubjects().stream()
                .map(PlainSubjectDto::from)
                .collect(Collectors.toList()));
        return studentDto;
    }
}
