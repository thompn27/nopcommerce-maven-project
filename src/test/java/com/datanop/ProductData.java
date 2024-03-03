package com.datanop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class ProductData {
    public static ProductData getProductData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "/src/test/datanop/ProductData.json"), ProductData.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String getProductName1() {
        return productName1;
    }

    public String getProductName2() {
        return productName2;
    }
    public String getAddProcessorName() {
        return addProduct.processorName;
    }

    public String getAddRamType() {
        return addProduct.ramType;
    }

    public String getAddHddName() {
        return addProduct.hddName;
    }

    public String getAddoSName() {
        return addProduct.oSName;
    }

    public String getAddSoftwareName() {
        return addProduct.softwareName;
    }
    public String getUpdateProcessorName() {
        return updateProduct.processorName;
    }

    public String getUpdateRamType() {
        return updateProduct.ramType;
    }

    public String getUpdateHddName() {
        return updateProduct.hddName;
    }

    public String getUpdateoSName() {
        return updateProduct.oSName;
    }

    public String getUpdateSoftwareName() {
        return updateProduct.softwareName;
    }

    public String getUpdateProductQuantities() {
        return updateProduct.productQuantities;
    }
    public String getSearchKeyword() {
        return updateShoppingCart.searchKeyword;
    }

    public String getProductName() {
        return updateShoppingCart.productName;
    }

    public String getQuantitiesString() {
        return updateShoppingCart.quantitiesString;
    }
    @JsonProperty("productName1")
    private String productName1;
    @JsonProperty("productName2")
    private String productName2;
    @JsonProperty("addProduct")
    private AddProduct addProduct;
    public static class AddProduct {
        @JsonProperty("processorName")
        private String processorName;
        @JsonProperty("ramType")
        private String ramType;
        @JsonProperty("hddName")
        private String hddName;
        @JsonProperty("oSName")
        private String oSName;
        @JsonProperty("softwareName")
        private String softwareName;
    }
    @JsonProperty("updateProduct")
    private UpdateProduct updateProduct;
    public static class UpdateProduct {
        @JsonProperty("processorName")
        private String processorName;
        @JsonProperty("ramType")
        private String ramType;
        @JsonProperty("hddName")
        private String hddName;
        @JsonProperty("oSName")
        private String oSName;
        @JsonProperty("softwareName")
        private String softwareName;
        @JsonProperty("productQuantities")
        private String productQuantities;
    }
    @JsonProperty("updateShoppingCart")
    private UpdateShoppingCart updateShoppingCart;
    public static class UpdateShoppingCart {
        @JsonProperty("searchKeyword")
        private String searchKeyword;
        @JsonProperty("productName")
        private String productName;
        @JsonProperty("quantitiesString")
        private String quantitiesString;
    }
}
