package ua.training.controller.Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

public abstract class CookieManager {

    /**
     * search for value in Cookies
     * if it is incorrect or inexistent then return a default value
     */
    public String getCookie(Cookie[] cookies, String name){
        if (null != cookies){
            Optional<Cookie> cook = Arrays.stream(cookies)
                    .filter(cookie -> name.equals(cookie.getName()))
                    .filter(cookie -> isValidValue(cookie.getValue())).findFirst();

            if (cook.isPresent()){
                return(cook.get().getValue());
            }
        }
        return getDefaultValue();
    }

    /**
     * add to Cookies if value is correct
     */
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
