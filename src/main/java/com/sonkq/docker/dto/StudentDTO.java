package com.sonkq.docker.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String studentCode;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
