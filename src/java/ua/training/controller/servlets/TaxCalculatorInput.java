package ua.training.controller.servlets;

import ua.training.controller.Cookies.CookieManager;
import ua.training.controller.Cookies.FieldCookieManager;
import ua.training.controller.IConstants;
import ua.training.controller.Taxes;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class TaxCalculatorInput extends TaxCalculator {
    private CookieManager fieldManager = new FieldCookieManager();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Arrays.stream(Taxes.values())
                .forEach(tax -> fieldManager.addCookie(response, tax.getName(), request.getParameter(tax.getName())));

        response.sendRedirect(IConstants.TABLE_PATH);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Arrays.stream(Taxes.values())
                .forEach(tax -> request.setAttribute(
                        tax.getName(), fieldManager.getCookie(request.getCookies(), tax.getName())
                ));

        processAttributes(request, processLanguage(request, response));
        request.setAttribute(IConstants.TAXES, Taxes.values());
        request.getRequestDispatcher(IConstants.CALCULATOR_PAGE).forward(request, response);
    }
}
