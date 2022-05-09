package example.school.dto;

import example.school.model.Subject;
import lombok.Data;

@Data
public class PlainSubjectDto {
    private Long id;
    private String name;

    public static PlainSubjectDto from(Subject subject) {
        PlainSubjectDto plainSubjectDto = new PlainSubjectDto();
        plainSubjectDto.setId(subject.getId());
        plainSubjectDto.setName(subject.getName());
        return plainSubjectDto;
    }
}
