package com.dbBites.postgresql.repository;

import com.dbBites.postgresql.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

//optional kullanımı sorgularla
   //querye parametre geçme seklinde güncellenicek
   @Query(
           value = "SELECT * FROM employee u WHERE u.name = 'Onur' and u.surname ='Ozkan'",
           nativeQuery = true)
   Collection<Employee> findAllActiveUsersNative(String name,String surname);

   @Query(value = "select * from employee u WHERE u.name=?1 and u.surname=?2 and u.position=?3",nativeQuery = true)
   Optional<Employee> employeeAlreadyExist(String name, String surname, String position);


   List<Employee> findAll();



}