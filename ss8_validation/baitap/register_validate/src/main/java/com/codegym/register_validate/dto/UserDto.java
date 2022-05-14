package com.codegym.register_validate.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
	private long id;
	@NotEmpty(message = "Tên không được để trống.")
	@Size(min = 2, max = 45, message = "Phải lớn hơn 2 và nhỏ hơn 45 ký tự")
	private String lastName;
	@NotEmpty(message = "Tên không được để trống.")
	@Size(min = 2, max = 45, message = "Phải lớn hơn 2 và nhỏ hơn 45 ký tự")
	private String firstName;

	@Size(min=10,max=10,message = "Sai định dạng số điện thoại.")
	@Pattern(regexp="^(84|0[3|5|7|8|9])+([0-9]{8})$", message = "Sai định dạng số điện thoại.")
	private String phoneNumber;
	@Min(value = 18, message = "Phải lớn hơn 18 tuổi.")
	private int age;
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Sai định dạng email.")
	private String email;

	public UserDto() {
	}

//	public UserDto(long id , String lastName , String firstName , String phoneNumber , String age , String email) {
//		this.id = id;
//		this.lastName = lastName;
//		this.firstName = firstName;
//		this.phoneNumber = phoneNumber;
//		this.age = age;
//		this.email = email;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target , Errors errors) {

	}
}
