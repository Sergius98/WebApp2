package ua.training.controller.servlets;

import ua.training.controller.Cookies.CookieManager;
import ua.training.controller.Cookies.LanguageCookieManager;
import ua.training.controller.IConstants;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

public class TaxServlet extends HttpServlet {
    static CookieManager languageManager = new LanguageCookieManager();


    /**
     * return language tag that should be used
     * search parameters and cookies to find current language tag
     */
    String processLanguage(HttpServletRequest request, HttpServletResponse response){
        String languageTag = request.getParameter(IConstants.LANGUAGE);
        if (null != languageTag && languageManager.isValidValue(languageTag)){
            languageManager.addCookie(response, IConstants.LANGUAGE, languageTag);
        } else {
            languageTag = languageManager.getCookie(request.getCookies(), IConstants.LANGUAGE);
        }
        return languageTag;
    }

    /**
     * prepare attributes that will be passed to jsp from both servlets
     * IConstants.MESSAGE
     * IConstants.LANGUAGES_LIST
     * IConstants.URL
     */
    void processAttributes(HttpServletRequest request, String languageTag){
        ResourceBundle messages = ResourceBundle.getBundle(IConstants.MESSAGES_LOCALE_BASE_NAME, Locale.forLanguageTag(languageTag));
        request.setAttribute(IConstants.MESSAGE, messages);
        request.setAttribute(IConstants.LANGUAGES_LIST, IConstants.language_tags_list);
        request.setAttribute(IConstants.URL, request.getRequestURL().toString());
    }
}
