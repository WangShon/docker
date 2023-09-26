package com.sonkq.docker.mapper;

import com.sonkq.docker.dto.StudentDTO;
import com.sonkq.docker.model.Student;
import org.modelmapper.ModelMapper;

public class StudentMapper {
    ModelMapper modelMapper = new ModelMapper();
    public StudentDTO convertToDto(Student student) {
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    public Student convertToEntity(StudentDTO studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        return student;
    }
}
