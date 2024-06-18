package com.SMSIt.RestFullWeb1proj.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SMSIt.RestFullWeb1proj.Entities.Student;
import com.SMSIt.RestFullWeb1proj.Exception.StudentNotFoundException;
import com.SMSIt.RestFullWeb1proj.Service.StudentServiceImp;

@RestController
public class StudentController {
	
	
@Autowired
private StudentServiceImp studentServiceimp;
@PostMapping("/AddStudentInformation")
public ResponseEntity<String> addStudent(@RequestBody Student stu){
	String student = studentServiceimp.addStudent(stu);
	return new ResponseEntity<String>(student,HttpStatus.CREATED);
	
}


//@GetMapping("/getStudentDataById/{sid}")
//public ResponseEntity<Student>   getDatabyId(@PathVariable Integer sid) {
//	 Student databyId = studentServiceimp.getDatabyId(sid);
//	return new ResponseEntity<Student>(databyId,HttpStatus.OK);
//
//}
@GetMapping("/getstudentDataById/{id}")
public ResponseEntity<Student> getStudentsbyId(@PathVariable("id") int sid){
	try { 
	Student studentsbyId = studentServiceimp.getStudentsbyId(sid);
	return new ResponseEntity<Student>(studentsbyId,HttpStatus.OK);
	
}catch(Exception b) {
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
	
}

//@GetMapping("/getAllStudentData")
//public ResponseEntity<List<Student>> getAllStudet(List<Student> stus) {
//	List<Student> allStudet = studentServiceimp.getAllStudet(stus);
//	return new ResponseEntity<List<Student>>(allStudet, HttpStatus.OK);
//	
//}


@GetMapping("/getAllStudentData")
public ResponseEntity<List<Student>> getAllStudents() {
    try {
        List<Student> allStudents = studentServiceimp.getAllStudents();
        if (allStudents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
//@PutMapping("/updateStudentInfo")
//public ResponseEntity<Student> updateStudent(Student st) {
//	Student updateStudent = studentServiceimp.updateStudent(st);
//	return new ResponseEntity<Student>( updateStudent,HttpStatus.OK);

//}
@PutMapping("/updateStudent/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable("id") int sid, @RequestBody Student student) {
    try {
        Student updatedStudent = studentServiceimp.updateStudent(sid, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    } catch (StudentNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
@DeleteMapping("/DeleteStudentDataById/{sid}")
public ResponseEntity<Student>   deleteStudentInfoId(@PathVariable Integer sid) {
	   Student deleteStudentInfo = studentServiceimp.deleteStudentInfo(sid);
	return new ResponseEntity<Student>(deleteStudentInfo,HttpStatus.OK);

}


}
