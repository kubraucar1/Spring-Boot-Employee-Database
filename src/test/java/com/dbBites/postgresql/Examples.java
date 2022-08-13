package com.dbBites.postgresql;

import com.dbBites.postgresql.TestExamples.Calculator;
import com.dbBites.postgresql.repository.IEmployeeRepository;
import com.dbBites.postgresql.repository.restApi.EmployeeControler;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


public class Examples {


    Calculator calculator= new Calculator();

    @Test
    public void testCalculator(){
        // GİVEN
        int num1=12;
        int num2=13;

        //WHEN
        int total= calculator.sum(num1,num2);

        //THEN
        Assert.assertEquals(25,total);


    }




}
