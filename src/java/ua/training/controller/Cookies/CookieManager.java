package ua.training.controller.Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public abstract class CookieManager {

    public String getCookie(Cookie[] cookies, String name){
        if (null != cookies){
            for (Cookie cookie : cookies){
                if (name.equals(cookie.getName())){
                    if (isValidValue(cookie.getValue())){
                        return(cookie.getValue());
                    }
                    break;
                }
            }
        }
        return getDefaultValue();
    }
    public void addCookie(HttpServletResponse response, String name, String value){
        if (isValidValue(value)){
            Cookie fieldCookie = new Cookie(name, value);
            fieldCookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(fieldCookie);
        }
    }

    public abstract String getDefaultValue();
    public abstract boolean isValidValue(String value);
}
