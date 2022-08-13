package com.dbBites.postgresql.repository.restApi;

import com.dbBites.postgresql.Employee.Employee;

import com.dbBites.postgresql.Service.EmployeeService;
import com.dbBites.postgresql.Service.IEmployeeService;
import com.dbBites.postgresql.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@Controller
@Repository
public class EmployeeControler {
    @Autowired
    private final IEmployeeRepository employeeRepository;
    private  final IEmployeeService  employeeService;
    private final EmployeeService employeeManager;


    public EmployeeControler(IEmployeeRepository employeeRepository, IEmployeeService employeeService, EmployeeService employeeManager) {

        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
        this.employeeManager = employeeManager;
    }


    @GetMapping("/findAll")
    public String deneme(){
        return "deneme";
    }

    @GetMapping("/getall")
    public List<Employee> get(){
        return  employeeRepository.findAll();
    }

    @PostMapping("/add")
    Employee add(@RequestBody Employee employee){
         return this.employeeRepository.save(employee);}

    @PostMapping("/delete")
    public void delete(@RequestBody Employee employee){
        this.employeeRepository.delete(employee);}

    @GetMapping("/id/{id}")
    public Optional<Employee> getById(@PathVariable Long id){
       return   this.employeeService.findById(id);
    }


    @GetMapping("/getNameSurname/{name}/{surname}")
    public List<Employee> getns(@PathVariable String name, @PathVariable String surname){
        return (List<Employee>) employeeRepository.findAllActiveUsersNative(name,surname);
    }




    @PostMapping("/record")
    ResponseEntity<?>record1(@RequestBody Employee employee){
        employee=employeeService.repetitiveRecording(employee);
        return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);

    }


    @PostMapping("/record2")
    Employee record2(@RequestBody Employee employee){
        employee=employeeService.repetitiveRecording(employee);
        return employee;

    }

    @PostMapping("/size")
    Employee size(@RequestBody Employee employee) {

        return this.employeeService.add2(employee);
    }
    @GetMapping("/info")
    public String info(String message,String user){
        return  employeeService.infomessage(message,"Kubra ");
    }
}


