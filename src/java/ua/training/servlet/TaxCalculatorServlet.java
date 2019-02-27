package ua.training.servlet;

import ua.training.model.Taxes;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.http.*;

public class TaxCalculatorServlet extends HttpServlet {
    private static String HOME = "view/index.jsp";
    private static String LOCALE_BASE_NAME = "messages";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                                                    throws javax.servlet.ServletException, IOException {
        request.setAttribute("MESSAGE", "value");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        request.setAttribute("name", name);
        request.setAttribute("login", login);
        request.setAttribute("TAXES", Taxes.values());
        request.getRequestDispatcher(HOME).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                                    throws javax.servlet.ServletException, IOException {
        ResourceBundle messages = ResourceBundle.getBundle(LOCALE_BASE_NAME, Locale.forLanguageTag("en-US"));

        request.setAttribute("MESSAGE", messages);
        request.setAttribute("TAXES", Taxes.values());
        request.getRequestDispatcher(HOME).forward(request, response);
    }
}
