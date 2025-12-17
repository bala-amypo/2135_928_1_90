package com.example.demo.service;
import java.util.List;
import.util.Optional;
impoirt com.example.demo.entity.Studententity;
public interface StudentService {
    Studententity saveData(Studententity st);
    Studententity insertStudententity(Studententity newStudent);
    List<Studententity> getAllStudententity();
    Optional<Studententity>getOneStudent(Long id);
    void deleteStudent(Long id);
    student insertStudententiy(Student st);}
    
}