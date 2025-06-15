package com.student.validation.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

	@NotBlank(message = "name must not be null")
	private String name;

	@Size(min = 2, max =  20, message = "surName should be greaterthan 2 and  lessthan 20")
	private String surName;


	@Min(value = 18, message = "Age must be atleast 18")
	@Max(value = 60, message = "Age must be atmost 60")
	private Integer age;

	@Email(message = "Invliad Email")
	private String email;


	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid PhoneNumber")
	private String phoneNo;  // FOR Valid "^[6-9][0-9]{9}$"

	@Past(message = "BirthDate must be in past  not in today or future Date") // @PastOrPresent
	private LocalDate birthDate;

	@Pattern(regexp = "\\d{6}", message = "Invalid Pincode")
	private String pinCode;

	@Digits(integer = 2, fraction = 3, message = "Invliad Percentage")
	private Double lastSchoolPercentag;	

}
