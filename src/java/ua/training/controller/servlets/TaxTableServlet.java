package ua.training.controller.servlets;

import ua.training.controller.IConstants;
import ua.training.controller.Taxes;
import ua.training.model.Model;
import ua.training.controller.Cookies.CookieManager;
import ua.training.controller.Cookies.FieldCookieManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaxTableServlet extends TaxServlet {
    static CookieManager fieldManager = new FieldCookieManager();

    public static void processUser(HttpServletRequest request) {
        Model model = new Model();

        for (Taxes field : Taxes.values()){
            model.loadTax(field.getName(), field.getTax(),
                    fieldManager.getCookie(request.getCookies(), field.getName()));
        }
        model.sortTaxes();
        request.setAttribute(IConstants.TAX_LIST, model.getTaxes());
        request.setAttribute(IConstants.TAX_SUM, model.getTaxSum());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processUser(request);

        processAttributes(request, processLanguage(request, response));
        request.setAttribute(IConstants.TAXES_TABLE, Taxes.values());
        request.getRequestDispatcher(IConstants.CALCULATOR_RESULT_PAGE).forward(request, response);
    }
}
