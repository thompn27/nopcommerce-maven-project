package com.datanop;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

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

    public String getProductName() {
        return productName;
    }

    public String getProductSku() {
        return productSku;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    private String productName;
    private String productSku;
    private String attributeValue;
}
