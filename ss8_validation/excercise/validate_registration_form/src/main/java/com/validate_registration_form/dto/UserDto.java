package com.validate_registration_form.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto implements Validator {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber ;
    private int age ;
    private String email ;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (!userDto.firstName.matches("^[A-Za-zàáãạảăắằẳẵặâấ" +
                "ầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹý" +
                "ÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨ" +
                "ỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{5,45}$")){
            errors.rejectValue("firstName", "firstName.errors",
                    "First Name không hợp lệ (5-45 kí tự)");
        }

        if (!userDto.lastName.matches("^[A-Za-zàáãạảăắằẳẵặâấ" +
                "ầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹý" +
                "ÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨ" +
                "ỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{5,45}$")){
            errors.rejectValue("lastName", "lastName.errors",
                    "First Name không hợp lệ (5-45 kí tự)");
        }

        if (!userDto.phoneNumber.matches("^0[0-9]{9,11}$")) {
            errors.rejectValue("phoneNumber","phoneNumber.errors",
                    "Phone Number không hợp lệ");
        }

        if (userDto.age<18) {
            errors.rejectValue("age","age.errors",
                    "Tuổi không hợp lệ (a>= 18)");
        }

        if (!userDto.email.matches("^[(a-zA-Z0-9-\\_\\.!\\D)]" +
                "+@[(a-zA-Z)]+\\.[(a-zA-Z)]{2,3}$")){
            errors.rejectValue("email","email.errors",
                    "Email không hợp lệ");
        }
    }
}
