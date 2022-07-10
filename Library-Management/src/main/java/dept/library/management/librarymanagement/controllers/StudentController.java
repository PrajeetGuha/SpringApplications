package dept.library.management.librarymanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dept.library.management.librarymanagement.entities.Student;
import dept.library.management.librarymanagement.objects.StatusCode;
import dept.library.management.librarymanagement.repositories.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    StudentRepository studentRepository;
    
    @PutMapping("/register")
    StatusCode register(@RequestBody Student student) {
        if (studentRepository.findByEmail(student.getEmail()) == null) {
            studentRepository.save(student);
            return new StatusCode(200, "Student registered successfully");
        }
        else{
            System.out.println("Student already exists");
            return new StatusCode(400, "Student already exists");
        }
    }

    @PostMapping("/login")
    StatusCode login(@RequestBody Student login_creStudent) {
        Student student = studentRepository.findByEmail(login_creStudent.getEmail());
        if (student != null) {
            if (student.getPassword().equals(student.getPassword())) {
                return new StatusCode(200, "Login successful");
            }
            else{
                return new StatusCode(400, "Invalid password");
            }
        }
        else{
            return new StatusCode(400, "Invalid email");
        }
    }

    @PostMapping("/fetch")
    Student fetch(@RequestBody Student student) {
        Student student_fetch = studentRepository.findByEmail(student.getEmail());
        return student_fetch;
    }

}
