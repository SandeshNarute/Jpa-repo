package com.SMSIt.RestFullWeb1proj.Service;

import java.util.List;

import com.SMSIt.RestFullWeb1proj.Entities.Student;

public interface StudentServiceI {
public Student getStudentsbyId(int sid );
public List<Student> getAllStudents();
public String addStudent(Student stu);  

//public Student updateStudent(Student st);
public Student deleteStudentInfo(int sid);
public Student updateStudent(int sid, Student student);
}
