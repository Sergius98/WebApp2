package ua.training.controller;

import ua.training.controller.Cookies.CookieManager;
import ua.training.controller.Cookies.FieldCookieManager;
import ua.training.controller.servlets.TaxCalculator;
import ua.training.controller.servlets.TaxCalculatorInput;
import ua.training.controller.servlets.TaxCalculatorTable;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class TaxCalculatorServlet extends HttpServlet {
    private CookieManager fieldManager = new FieldCookieManager();

    static final private HashMap<String, TaxCalculator> PAGES = new HashMap<>();
    @Override
    public void init(){
        PAGES.put(IConstants.DEFAULT_PAGE, new TaxCalculatorInput());
        PAGES.put("/table", new TaxCalculatorTable());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PAGES.getOrDefault(request.getRequestURI(),
                PAGES.get(IConstants.DEFAULT_PAGE)
        ).doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PAGES.getOrDefault(request.getRequestURI(),
                PAGES.get(IConstants.DEFAULT_PAGE)
        ).doGet(request, response);
        request.setAttribute("PATHES", IConstants.PATHES);
    }
}
