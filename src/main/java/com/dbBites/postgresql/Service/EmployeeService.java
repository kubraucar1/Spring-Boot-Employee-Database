package com.dbBites.postgresql.Service;

import com.dbBites.postgresql.Employee.Employee;
import com.dbBites.postgresql.exceptions.EmployeeAlreadyExistException;
import com.dbBites.postgresql.exceptions.stringLengthTooSmallException;
import com.dbBites.postgresql.repository.IEmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class EmployeeService implements  IEmployeeService {

    private final  IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee repetitiveRecording(Employee employee) {

        //employee bilgiler null mı değil mi
        Optional<Employee> employees = employeeRepository.employeeAlreadyExist(employee.getName(), employee.getSurname(), employee.getPosition());
        if (employees.isPresent())
            throw new EmployeeAlreadyExistException();
        else
            return (Employee) employeeRepository.save(employee);

    }



    @Override

    public Employee add2(Employee employee) {

        if (employee.getName()=="Kubra") {
            throw new stringLengthTooSmallException();

        }
        else {
            return (Employee) this.employeeRepository.save(employee);

        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public String infomessage(String message, String user) {
        return "Welcome our team "+ user + "we are so happy to see you amoung us!" ;
    }

}



