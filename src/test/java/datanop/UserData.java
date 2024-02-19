package datanop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class UserData {
    public static UserData getUserData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/datanop/UserData.json"),UserData.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public String getDateVale() {
        return dateVale;
    }

    public String getMonthValue() {
        return monthValue;
    }

    public String getYearValue() {
        return yearValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCountryValue() {
        return countryValue;
    }

    public String getCityName() {
        return cityName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNewPassword() {
        return newPassword;
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
