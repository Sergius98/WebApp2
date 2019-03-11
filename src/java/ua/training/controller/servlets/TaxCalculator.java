package ua.training.controller.servlets;

import ua.training.controller.Cookies.CookieManager;
import ua.training.controller.Cookies.LanguageCookieManager;
import ua.training.controller.IConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class TaxCalculator {
    static CookieManager languageManager = new LanguageCookieManager();

    /**
     * return language tag that should be used
     * search parameters and Cookies to find current language tag
     */

    String processLanguage(HttpServletRequest request, HttpServletResponse response){
        Optional<String> languageTag = Optional.ofNullable(request.getParameter(IConstants.LANGUAGE));

        if (languageTag.isPresent() && languageManager.isValidValue(languageTag.get())){
            languageManager.addCookie(response, IConstants.LANGUAGE, languageTag.get());
        } else {
            languageTag = Optional.of(
                    languageManager.getCookie(request.getCookies(), IConstants.LANGUAGE)
            );
        }
        return languageTag.get();
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

    public abstract void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    public abstract void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
