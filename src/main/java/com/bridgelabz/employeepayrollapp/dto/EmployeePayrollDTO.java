package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name Invalid")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to br male or female ")
    public String gender;

    @JsonFormat (pattern="dd MMM yyyy")
    @NotNull (message = " StartDate should not be empty")
    @PastOrPresent (message = "StartDate should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message = "Note can not be empty")
    public String note;

    @NotBlank(message = "profile pic can not be empty")
    public String profilePic;
    @NotNull (message = "department should not be empty")
    public List<String> department;

}