package com.dbBites.postgresql;


import com.dbBites.postgresql.Employee.Employee;
import com.dbBites.postgresql.Service.IEmployeeService;
import com.dbBites.postgresql.repository.IEmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class EmployeeTest {

    MockMvc mockMvc;
    private IEmployeeService  employeeService;
    private IEmployeeRepository employeeRepository;


    @BeforeEach
    public void setUp(){
      employeeService = Mockito.mock(IEmployeeService.class);
      employeeRepository = Mockito.mock(IEmployeeRepository.class);

    }
    @AfterEach
    void tearDown() throws Exception{
    }


    @Test
    public void repetitiveRecordingTest_createEmployeeSuccessfull(){

        Employee employee1 = new Employee(222l,"test","test","intern");
        Mockito.when(employeeRepository.employeeAlreadyExist("test","test","intern")).thenReturn(Optional.empty());

        Employee resultEmployee = employeeService.repetitiveRecording(employee1);

        assertEquals(employee1.getName(),resultEmployee.getName());


    }


    @Test
    public void testEmployeeAdd(){
        Employee employee1 =  new Employee(100L,"Test","test","test");

        assertEquals("test",employeeService.repetitiveRecording(employee1));


    }

    @Test
    public void namesurnamecontroll() throws Exception {



        mockMvc.perform(MockMvcRequestBuilders.get("/employee/getNameSurname/{Kubra}/{Ucar}"))
                .andExpect(status().isOk());



    }

    @Test
    public void findUserByid(){
        //Employee employee = getEmployee();
        Employee employee1 = new Employee(1,"Kubra","Ucar","intern");

        Assertions.assertEquals(1,employeeService.findById(employee1.getId()));

    }














    @Test
    public void testEmployees_name() throws Exception {

        Employee employee = getEmployee();
        String name = "Kubra";
        assertEquals(name, employee.getName());


    }

    @Test
    public void doNotacceptsameuser(){
        Employee employee1 = new Employee(12,"Kubra","Ucar","intern");
        Employee employee2 = new Employee(12,"Kubra","Ucar","intern");

        Employee e1 =employeeService.repetitiveRecording(employee1);
        Employee e2 = employeeService.repetitiveRecording(employee2);

        assertEquals(e1,e2);

    }



    @Test
    public void findUserbyPosition(){
        Employee employee = new Employee(1,"Maddison","Ucar","intern");
        String name = "Maddison";
        assertEquals(name,employee.getName());
    }



    private Employee getEmployee() {
        Employee employee = new Employee();

        employee.setId(1);
        employee.setName("Kubra");
        employee.setPosition("engineer");
        return employee;
    }

}


