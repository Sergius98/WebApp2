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
import java.util.Arrays;

public class TaxCalculatorTable extends TaxCalculator {
    static CookieManager fieldManager = new FieldCookieManager();

    /**
     * loads information from Cookies about income that was inputted by user
     * sets attributes IConstants.TAX_LIST and IConstants.TAX_SUM to be used in jsp
     */
    public void processUser(HttpServletRequest request, String languageTag) {
        Model model = new Model(languageTag);

        Arrays.stream(Taxes.values())
                .forEach(tax -> model.loadTax(
                        tax.getNameArray(), fieldManager.getCookie(request.getCookies(), tax.getName()))
                );

        model.sortTaxes();

        request.setAttribute(IConstants.TAX_LIST, model.getTaxes());
        request.setAttribute(IConstants.TAX_SUM, model.getTaxSum());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String languageTag = processLanguage(request, response);

        processUser(request, languageTag);

        processAttributes(request, languageTag);

        request.setAttribute(IConstants.TAXES_TABLE, Taxes.values());
        request.getRequestDispatcher(IConstants.CALCULATOR_RESULT_PAGE).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
