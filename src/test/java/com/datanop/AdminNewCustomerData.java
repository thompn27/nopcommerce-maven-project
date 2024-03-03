package com.datanop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class AdminNewCustomerData {
    public AdminNewCustomerData() {
    }

    public static AdminNewCustomerData getAdminNewCustomerData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "/src/test/datanop/AdminNewCustomerData.json.json"), AdminNewCustomerData.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAdminComment() {
        return adminComment;
    }

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("adminComment")
    private String adminComment;
}
