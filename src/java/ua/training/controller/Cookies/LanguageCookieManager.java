package ua.training.controller.Cookies;

import ua.training.controller.IConstants;

public class LanguageCookieManager extends CookieManager{

    public String getDefaultValue(){
        return IConstants.DEFAULT_LANGUAGE;
    }
    public boolean isValidValue(String value){
        for (String tag : IConstants.language_tags_list){
            if (tag.equals(value)){
                return true;
            }
        }
        return false;
    }
}
