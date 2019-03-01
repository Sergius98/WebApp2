package ua.training.controller.servlets;

import ua.training.controller.Cookies.CookieManager;
import ua.training.controller.Cookies.FieldCookieManager;
import ua.training.controller.IConstants;
import ua.training.controller.Taxes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxCalculatorServlet extends TaxServlet {
    static CookieManager fieldManager = new FieldCookieManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        for (Taxes tax : Taxes.values()){
            System.out.println(tax.getName() + " : " + request.getParameter(tax.getName()));
            fieldManager.addCookie(response, tax.getName(), request.getParameter(tax.getName()));
        }
        response.sendRedirect(IConstants.TABLE_PATH);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        for (Taxes tax : Taxes.values()){
            request.setAttribute(tax.getName(), fieldManager.getCookie(request.getCookies(), tax.getName()));
        }

        processAttributes(request, processLanguage(request, response));
        request.setAttribute(IConstants.TAXES, Taxes.values());
        request.getRequestDispatcher(IConstants.CALCULATOR_PAGE).forward(request, response);
    }
}
