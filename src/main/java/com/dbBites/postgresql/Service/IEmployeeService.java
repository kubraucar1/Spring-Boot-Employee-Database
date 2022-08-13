package com.dbBites.postgresql.Service;

import com.dbBites.postgresql.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IEmployeeService  {

    Employee repetitiveRecording(Employee employee);
    Employee add2(Employee employee);
    Optional<Employee> findById(Long id);

    String infomessage(String message,String user);




   }





