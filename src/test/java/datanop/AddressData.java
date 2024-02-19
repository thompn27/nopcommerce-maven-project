package datanop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class AddressData {
    public static AddressData getAddressData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/datanop/AddressData.json"), AddressData.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public String getCountry() {
        return country;
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

    @JsonProperty("paymentMethod")
    private String paymentMethod;
    @JsonProperty("shippingMethod")
    private String shippingMethod;
    @JsonProperty("country")
    private String country;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("phoneNumber")
    private String phoneNumber;

}
