package com.datanop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import lombok.Getter;

import java.io.File;

@Getter
public class AdminNewCustomerData {
    public static AdminNewCustomerData getAdminNewCustomerData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "/src/test/datanop/AdminNewCustomerData.json"), AdminNewCustomerData.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
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
