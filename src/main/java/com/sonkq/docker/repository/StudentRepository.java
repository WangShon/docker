package com.sonkq.docker.repository;

import com.sonkq.docker.dto.StudentDTO;
import com.sonkq.docker.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student AS s WHERE s.studentCode = :code")
    Student getStudentByCode(@Param("code") String studentCode);

    @Query("SELECT s FROM Student AS s WHERE s.id = :id")
    Student getStudentById(@Param("id") Long id);
}
