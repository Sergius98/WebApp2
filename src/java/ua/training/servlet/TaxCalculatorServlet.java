package ua.training.servlet;

import ua.training.model.Taxes;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        for (Taxes field : Taxes.values()){
            Controller.addFieldInCookies(response, field.getName(), request.getParameter(field.getName()));
        }
        response.sendRedirect("/calculator");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        for (Taxes field : Taxes.values()){
            request.setAttribute(field.getName(), Controller.getFieldValueFromCookies(request.getCookies(), field.getName()));
        }

        String languageTag = request.getParameter(IConstants.LANGUAGE);

        if (null != languageTag && Controller.isValidLanguage(languageTag)){
            Controller.addLanguageInCookies(response, IConstants.LANGUAGE, languageTag);
        } else {
            languageTag = Controller.getLanguageFromCookies(request.getCookies());
        }

        ResourceBundle messages = ResourceBundle.getBundle(IConstants.MESSAGES_LOCALE_BASE_NAME, Locale.forLanguageTag(languageTag));
        request.setAttribute("MESSAGE", messages);
        request.setAttribute("TAXES", Taxes.values());
        request.setAttribute("LANGUAGES_LIST", IConstants.language_tags_list);
        request.setAttribute("URL", request.getRequestURL().toString());

        request.getRequestDispatcher(IConstants.CALCULATOR_PAGE).forward(request, response);
    }
}
