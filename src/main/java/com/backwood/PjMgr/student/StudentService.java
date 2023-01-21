package com.backwood.PjMgr.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> GetStudents(){
        return studentRepository.findAll();
    }

    public void AddNewStudent(Student student) {

       Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
       if(studentByEmail.isPresent()){
           throw new IllegalStateException("Email taken");
       }
       studentRepository.save(student);
    }

    public void RemoveStudent(Long id) {

      boolean exists =  studentRepository.existsById(id);
      if(!exists){
          throw new IllegalStateException("Student id "+id+" does not exist");
      }
      studentRepository.deleteById(id);
    }
    @Transactional
    public void UpdateStudent(Long id, String name, String email) {

       Student student =studentRepository.findById(id).orElseThrow(()->new IllegalStateException("Student id "+id+" does not exist"));
       if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
       }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional =studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
