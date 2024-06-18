package com.SMSIt.RestFullWeb1proj.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SMSIt.RestFullWeb1proj.Dao.StudentDao;
import com.SMSIt.RestFullWeb1proj.Entities.Student;
import com.SMSIt.RestFullWeb1proj.Exception.StudentNotFoundException;

@Service
public class StudentServiceImp implements StudentServiceI {
	@Autowired
	private StudentDao studentDao;

	@Override
	public String addStudent(Student stu) {
		Student save = studentDao.save(stu);
		return "Successfully";
	}

	@Override
	public Student getStudentsbyId(int sid) {
		
		 Optional<Student> student = studentDao.findById(sid);
		 if (student.isPresent()) {
	            return student.get();
	        } else {
	            // Handle the case where the student is not found
	            // For simplicity, returning null or you can throw a custom exception
	            System.out.println("Student with ID " + sid + " not found");
	        }
		 throw new StudentNotFoundException("Student with ID " + sid + " not found");
		
		
	    }
		 
	
	

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();

	}
//
//	@Override
//	public Student updateStudent(Student st) {
//		Student save = studentDao.save(st);
//		return save;
//	}
	
	 public Student updateStudent(int sid, Student student) {
	        Student existingStudent = getStudentById(sid);
	        existingStudent.setSfname(student.getSfname());
	        existingStudent.setSlname(student.getSlname());
	        existingStudent.setSaddress(student.getSaddress());
	        existingStudent.setShobby(student.getShobby());
	        return studentDao.save(existingStudent);
	    }

	private Student getStudentById(int sid) {
	// TODO Auto-generated method stub
	return null;
}

	@Override
	public Student deleteStudentInfo(int sid) {
		Optional<Student> studentOpt = studentDao.findById(sid);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            studentDao.deleteById(sid);
            return student;
        } else {
            throw new StudentNotFoundException("Student with ID " + sid + " not found");
        }
    }


	}


