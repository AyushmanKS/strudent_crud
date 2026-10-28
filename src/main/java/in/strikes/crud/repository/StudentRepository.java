package in.strikes.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.strikes.crud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    default Student saveStudent(Student studentReq) {
        Student savedStudent = save(studentReq);
        return savedStudent;
    }
}
