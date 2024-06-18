package com.SMSIt.RestFullWeb1proj.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SMSIt.RestFullWeb1proj.Entities.Student;
@Repository
public interface  StudentDao extends JpaRepository<Student, Integer> { 

}
