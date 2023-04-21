package com.icia.ex2.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class StudentDTO {
    private Long id;
    private String studentName;
    private String studentNumber;
}