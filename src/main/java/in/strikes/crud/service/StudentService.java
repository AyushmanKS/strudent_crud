package in.strikes.crud.service;

import in.strikes.crud.entity.Student;
import in.strikes.crud.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        System.out.println("StudentService constructor -> StudentRepository injected");
        this.studentRepository = studentRepository;
    }
    
   public Student createStudent(Student studentReq) {
        System.out.println("3. StudentService.createStudent() -> calling repository");
        Student studentResp = studentRepository.saveStudent(studentReq);
        System.out.println("6. StudentService.createStudent() -> returning saved student to controller");
        return studentResp;
    }

    public Student getStudent(Long id) {
        System.out.println("StudentService.getStudent() -> finding student with id " + id);
        Optional<Student> studentResp = studentRepository.findById(id);

        if (studentResp.isPresent()) {
            System.out.println("StudentService.getStudent() -> student found");
            return studentResp.get();
        }

        System.out.println("StudentService.getStudent() -> no student with id " + id);
        return null;
    }

    public List<Student> getAllStudents() {
        System.out.println("StudentService.getAllStudents() -> fetching all students");
        List<Student> students = studentRepository.findAll();
        System.out.println("StudentService.getAllStudents() -> found " + students.size() + " students");
        return students;
    }

    public Student updateStudent(Long id, Student studentReq) {
        System.out.println("StudentService.updateStudent() -> finding student with id " + id);
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isEmpty()) {
            System.out.println("StudentService.updateStudent() -> no student with id " + id);
            return null;
        }

        Student student = existingStudent.get();
        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        student.setRollNo(studentReq.getRollNo());
        student.setSubject(studentReq.getSubject());

        System.out.println("StudentService.updateStudent() -> saving updated student");
        Student studentResp = studentRepository.save(student);
        System.out.println("StudentService.updateStudent() -> student updated");
        return studentResp;
    }

    public boolean deleteStudent(Long id) {
        System.out.println("StudentService.deleteStudent() -> checking student with id " + id);

        if (!studentRepository.existsById(id)) {
            System.out.println("StudentService.deleteStudent() -> no student with id " + id);
            return false;
        }

        studentRepository.deleteById(id);
        System.out.println("StudentService.deleteStudent() -> student deleted");
        return true;
    }
}
