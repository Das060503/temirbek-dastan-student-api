
package kz.temirbek.temirbekdastanstudentapi.service;

import kz.temirbek.temirbekdastanstudentapi.model.Student;
import kz.temirbek.temirbekdastanstudentapi.repository.StudentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE - Add a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ - Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ - Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with ID: " + id
                ));
    }

    // UPDATE - Modify student information
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);

        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setGroupCode(updatedStudent.getGroupCode());

        return studentRepository.save(existingStudent);
    }

    // DELETE - Remove student
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
