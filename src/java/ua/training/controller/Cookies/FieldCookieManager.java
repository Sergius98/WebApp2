package ua.training.controller.Cookies;

import ua.training.controller.IConstants;

public class FieldCookieManager extends CookieManager{

    public String getDefaultValue(){
        return IConstants.DEFAULT_FIELD_VALUE;
    }
    public boolean isValidValue(String value){
        return ((null != value) && (value.matches(IConstants.FIELD_REG_EX)));
    }
}
