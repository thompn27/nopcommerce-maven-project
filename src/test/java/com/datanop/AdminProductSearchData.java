package com.datanop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import lombok.Getter;

import java.io.File;

@Getter
public class AdminProductSearchData {
    public static AdminProductSearchData getAdminProductSearchData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "/src/test/datanop/AdminProductSearchData.json"), AdminProductSearchData.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @JsonProperty("productName")
    private String productName;
    @JsonProperty("productSku")
    private String productSku;
    @JsonProperty("attributeValue")
    private String attributeValue;
}
