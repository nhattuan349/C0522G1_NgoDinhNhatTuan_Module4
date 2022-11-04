package com.furama_casestudy_module_4.dto.Customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {

    private Integer id;
    @NotBlank(message = " Tên Customer không được để trống")
    private String name;
    private String dateOfBirth;
    private Integer gender;
    @NotBlank (message = " Tên Customer không được để trống")
    private String idCard;
    @NotBlank (message = " Tên Customer không được để trống")
    private String phoneNumber;
    @NotBlank (message = " Tên Customer không được để trống")
    private String email;
    private String address;
    private String status;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String dateOfBirth,
                       Integer gender, String idCard, String phoneNumber,
                       String email, String address, String status) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerDto customerDto = (CustomerDto) target;

        if (!customerDto.name.matches("^[A-Z][A-Za-zàáãạảăắằẳẵặâấ" +
                "ầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹý" +
                "ÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨ" +
                "ỤỦƯỨỪỬỮỰỲỴỶỸÝ ]*$")){
            errors.rejectValue("Name", "name.errors",
                    "Name không hợp lệ (5-45 kí tự)");
        }

        if (!customerDto.phoneNumber.matches("^0[0-9]{9,11}$")) {
            errors.rejectValue("phoneNumber","phoneNumber.errors",
                    "Phone Number không hợp lệ");
        }

        if (!customerDto.phoneNumber.matches("^[0-9]{9,10}$")) {
            errors.rejectValue("idCard","idCard.errors",
                    "idCard không hợp lệ");
        }

        if (!customerDto.email.matches("^[(a-zA-Z0-9-\\_\\.!\\D)]" +
                "+@[(a-zA-Z)]+\\.[(a-zA-Z)]{2,3}$")){
            errors.rejectValue("email","email.errors",
                    "Email không hợp lệ");
        }
    }


}
