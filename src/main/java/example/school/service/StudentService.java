package example.school.service;

import example.school.exceptions.StudentNotFoundException;
import example.school.exceptions.SubjectIsAlreadyEnrolledException;
import example.school.model.Student;
import example.school.model.Subject;
import example.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectService subjectService;

    @Autowired
    public StudentService(StudentRepository studentRepository, SubjectService subjectService) {
        this.studentRepository = studentRepository;
        this.subjectService = subjectService;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("This student cannot be found."));
    }

    @Transactional
    public Student addSubjectToStudent(Long studentId, Long subjectId) {
        Student student = getStudent(studentId);
        Subject subject = subjectService.getSubject(subjectId);
        if (student.getSubjects().contains(subject)) {
            throw new SubjectIsAlreadyEnrolledException("This subject is already enrolled");
        }

        student.addSubject(subject);
        subject.enrollStudent(student);
        return student;
    }
}
