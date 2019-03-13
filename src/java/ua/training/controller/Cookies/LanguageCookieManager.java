package ua.training.controller.Cookies;

import ua.training.controller.IConstants;

import java.util.Arrays;

public class LanguageCookieManager extends CookieManager{

    public String getDefaultValue(){
        return IConstants.DEFAULT_LANGUAGE;
    }
    public boolean isValidValue(String value){
        return Arrays.asList(IConstants.language_tags_list).contains(value);
        /*
        return Arrays.stream(IConstants.language_tags_list)
                .anyMatch(tag -> tag.equals(value));
        */
        /*
        return Arrays.stream(IConstants.language_tags_list)
                .filter(tag -> tag.equals(value))
                .findFirst().isPresent();
        */
        /*
        for (String tag : IConstants.language_tags_list){
            if (tag.equals(value)){
                return true;
            }
        }
        return false;
        */
    }
}
