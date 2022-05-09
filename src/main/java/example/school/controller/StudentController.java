package example.school.controller;

import example.school.dto.StudentDto;
import example.school.dto.SubjectDto;
import example.school.model.Student;
import example.school.repository.StudentRepository;
import example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<List<StudentDto>> getStudents() {
        List<Student> students = studentService.getStudents();
        List<StudentDto> studentDtoList = students.stream().map(StudentDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(studentDtoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.addStudent(Student.from(studentDto));
        return new ResponseEntity<>(StudentDto.from(student), HttpStatus.OK);
    }

    @PostMapping("/{studentId}/subjects/{subjectId}")
    public ResponseEntity<StudentDto> addSubjectToStudent(@PathVariable Long studentId, @PathVariable Long subjectId) {
        Student student = studentService.addSubjectToStudent(studentId, subjectId);
        return new ResponseEntity<>(StudentDto.from(student), HttpStatus.OK);
    }
}
