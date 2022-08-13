package com.dbBites.postgresql.Employee;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name ="id",nullable = false)
    private long id;


    @Column(name ="name")
    @NotNull
    @Size( min = 2, max = 30, message = "The lenght of name must be greater than 2")
    private String name;


    @Size( min = 2, max = 30, message = "The lenght of surname must be greater than 2")
    @Column(name ="surname")
    @NotNull
    private String surname;



    @Column(name ="position")
    private String position;



    public Employee(){

    }

    public Employee(long id,String name,String surname,String position){
        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
        this.setPosition(position);
    }

    public Employee(String name,String surname,String position){

        this.setName(name);
        this.setSurname(surname);
        this.setPosition(position);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString(){
        return "Emoloyee[id =" + id + ",name" + name+ ", surname=" + surname + ", position=" + position + "]";
    }





}

