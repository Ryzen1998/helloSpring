package com.backwood.PjMgr.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final  StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> GetStudents(){
     return  studentService.GetStudents();
    }
    @PostMapping("addstudent")
    public void AddNewStudent(@RequestBody Student student){
        studentService.AddNewStudent(student);
    }
    @DeleteMapping(path = "removestudent/{studentId}")
    public void RemoveStudent(@PathVariable("studentId") Long id){
        studentService.RemoveStudent(id);
    }
    @PutMapping("updatestudent/{studentId}")
    public void UpdateStudent(@PathVariable("studentId") Long id,@RequestParam(required = false) String name,@RequestParam(required = false) String email){
        studentService.UpdateStudent(id,name,email);
    }
}
