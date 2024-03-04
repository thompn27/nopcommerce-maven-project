package com.datanop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import lombok.Getter;

import java.io.File;

@Getter
public class UserData {
    public static UserData getUserData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "/src/test/datanop/UserData.json"),UserData.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("newFirstName")
    private String newFirstName;
    @JsonProperty("newLastName")
    private String newLastName;
    @JsonProperty("dateVale")
    private String dateVale;
    @JsonProperty("monthValue")
    private String monthValue;
    @JsonProperty("yearValue")
    private String yearValue;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("countryValue")
    private String countryValue;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("newPassword")
    private String newPassword;

}
