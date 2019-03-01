package ua.training.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public final class Controller {

    public static boolean isValidLanguage(String language){
        for (String tag : IConstants.language_tags_list){
            if (tag.equals(language)){
                return true;
            }
        }
        return false;
    }

    public static void addLanguageInCookies(HttpServletResponse response, String field, String language){
        if (isValidLanguage(language)){
            Cookie languageCookie = new Cookie(field, language);
            languageCookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(languageCookie);
        }
    }
    public static void addFieldInCookies(HttpServletResponse response, String field, String value){
        if (isValidFieldValue(value)){
            Cookie fieldCookie = new Cookie(field, value);
            fieldCookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(fieldCookie);
        }
    }

    public static  String getLanguageFromCookies(Cookie[] cookies){
        for (Cookie cookie : cookies){
            if (IConstants.LANGUAGE.equals(cookie.getName())){
                if (isValidLanguage(cookie.getValue())){
                    return(cookie.getValue());
                }
                break;
            }
        }
        return IConstants.DEFAULT_LANGUAGE;
    }

    public static boolean isValidFieldValue(String field){
        return ((null != field) && (field.matches(IConstants.FIELD_REG_EX)));
    }

    public static String getFieldValueFromCookies(Cookie[] cookies, String field){
        for (Cookie cookie : cookies){
            if (field.equals(cookie.getName())){
                if (isValidFieldValue(cookie.getValue())){
                    return(cookie.getValue());
                }
                break;
            }
        }
        return IConstants.DEFAULT_FIELD_VALUE;
    }
}
