package in.strikes.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.strikes.crud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    default Student saveStudent(Student studentReq) {
        System.out.println("4. StudentRepository.saveStudent() -> saving student to database");
        Student savedStudent = save(studentReq);
        System.out.println("5. StudentRepository.saveStudent() -> student saved with id " + savedStudent.getId());
        return savedStudent;
    }
}
