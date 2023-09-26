package com.sonkq.docker.service;

import com.sonkq.docker.constant.ConstantValue;
import com.sonkq.docker.dto.StudentDTO;
import com.sonkq.docker.mapper.StudentMapper;
import com.sonkq.docker.model.Student;
import com.sonkq.docker.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public String addStudent(Student student) {
        Student existStudent = studentRepository.getStudentByCode(student.getStudentCode());
        String result = "";
        if (existStudent == null) {
            Student s = new Student();
            s.setStudentCode(student.getStudentCode());
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setPhoneNumber(student.getPhoneNumber());
            s.setEmail(student.getEmail());

            studentRepository.save(s);

            result = ConstantValue.SUCCESSFULLY;
        } else {
            result = ConstantValue.STUDENT_IS_EXIST;
        }
        return result;
    }

    public String updateStudent(Long id, StudentDTO s) {
        Student student = studentRepository.getStudentById(id);
        String result = "";
        if (student != null) {
            student.setFirstName(s.getFirstName());
            student.setLastName(s.getLastName());
            student.setPhoneNumber(s.getPhoneNumber());
            student.setEmail(s.getEmail());

            studentRepository.save(student);

            result = ConstantValue.SUCCESSFULLY;
        } else {
            result = ConstantValue.STUDENT_NOT_FOUND;

        }
        return result;
    }

}
