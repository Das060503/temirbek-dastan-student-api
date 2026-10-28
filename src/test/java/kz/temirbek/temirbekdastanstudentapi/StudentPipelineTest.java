package kz.temirbek.temirbekdastanstudentapi;

import kz.temirbek.temirbekdastanstudentapi.model.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentPipelineTest {

    @Test
    void shouldReturnCorrectStudentName() {
        Student student = new Student();
        student.setFirstName("Dastan");

        // Intentional failure for Jenkins demonstration
        assertEquals("Temirbek", student.getFirstName());
    }
}
