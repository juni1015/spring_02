package com.icia.ex2.controller;

import com.icia.ex2.dto.StudentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {return "index";}

    // 호출요청 메소드
    @GetMapping("/hello1")
    public String hello1() {return "hello1";}

    @GetMapping("/hello2")
    public String hello2() {return "hello2";}

    @GetMapping("/hello-param1")
    public String helloParam1(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println("name = " + name + ", age = " + age);
//        int age1 = Integer.parseInt(request.getParameter("age"));
        return "index";
    }

    // form 데이터 (get, post 
    @GetMapping("/form-param1")
    public String formParam1(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        System.out.println("p1 = " + p1 + ", p2 = " + p2);
        return "index";
    }

    @PostMapping("/form-param2")
    public String formParam2(@RequestParam String p3, @RequestParam String p4) {
        // 화면에서 보내는 파라미터의 이름과 받아주는 변수명이 일치하면 ("p3")을 생략할 수 있음
        System.out.println("p3 = " + p3 + ", p4 = " + p4);
        return "index";
    }

    // 데이터를 화면으로 가져갈 때
    @GetMapping("/hello3")
    public String hello3(Model model) {
        String s1 = "안녕하세요";
        // model : 화면의 데이터를 가져갈 때 사용
        // model.addAttribute("담아갈 이름(파라미터의 역할)", 담아갈 값)
        model.addAttribute("m1", s1);
        return "hello3";
    }

    // 객체를 화면으로 가져갈 때
    @GetMapping("/hello4")
    public String hello4(Model model) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("학생1");
        studentDTO.setStudentNumber("12341234");
        model.addAttribute("student", studentDTO);
        return "hello4";
    }
    
    // hello5 요청을 처리하는 메서드
    // 실행내용 : StudentDTO 객체를 담는 ArayList를 선언하고 학생 2명의 정보를 리스트에 저장 후 리스트를 모델에 담자
    @GetMapping("/hello5")
    public String hello5(Model model) {
        ArrayList<StudentDTO> studentDTOList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
//            StudentDTO studentDTO = newStudent(i);
            studentDTOList.add(newStudent(i));
        }
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(1L);
//        studentDTO.setStudentName("학생1");
//        studentDTO.setStudentNumber("111111");
//        list.add(studentDTO);
//
//        studentDTO = new StudentDTO();
//        studentDTO.setId(2L);
//        studentDTO.setStudentName("학생2");
//        studentDTO.setStudentNumber("222222");
//        list.add(studentDTO);

        model.addAttribute("studentList", studentDTOList);
        return "hello5";
    }

    private StudentDTO newStudent(int i) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId((long) i);
        studentDTO.setStudentName("학생" + i);
        studentDTO.setStudentNumber("1111110" + i);
        return studentDTO;
    }
}
//변경사항