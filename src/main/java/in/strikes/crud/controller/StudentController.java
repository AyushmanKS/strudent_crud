package in.strikes.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.strikes.crud.entity.Student;
import in.strikes.crud.service.StudentService;

@RestController 
@RequestMapping("/api/students")
public class StudentController {

    @Autowired 
    private StudentService studentService;
    
    @PostMapping("/create") 
    public ResponseEntity<Student> createStudent(@RequestBody  Student student) {
        System.out.println("2. StudentController.createStudent() -> request received for " + student.getName());
        Student createdStudent = studentService.createStudent(student);
        System.out.println("7. StudentController.createStudent() -> sending response, student id " + createdStudent.getId());
        return ResponseEntity.status(201).body(createdStudent);
    }

    @GetMapping("/get/{id}") 
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        System.out.println("StudentController.getAllStudents() -> request received");
        List<Student> students = studentService.getAllStudents();
        System.out.println("StudentController.getAllStudents() -> sending " + students.size() + " students");
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        System.out.println("StudentController.updateStudent() -> request received for id " + id);
        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent == null) {
            System.out.println("StudentController.updateStudent() -> student not found, sending 404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        System.out.println("StudentController.updateStudent() -> sending updated student");
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        System.out.println("StudentController.deleteStudent() -> request received for id " + id);
        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {
            System.out.println("StudentController.deleteStudent() -> student not found, sending 404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        System.out.println("StudentController.deleteStudent() -> sending response");
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted");
    }
}
