package ua.training.model;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ModelTest {

    Model model;
    @Before
    public void init(){
        model = new Model("en");
        model.loadTax("main_salary".split("_"), "1111");
        model.loadTax("additional_salary".split("_"), "5555");
        model.loadTax("royalty_sales".split("_"), "3333");
    }

    @Test
    public void sortTaxes() {
        ArrayList<TableLine> taxes = model.getTaxes();
        Collections.sort(taxes);
        int sum1 = (int) taxes.get(0).getTax();
        int sum2 = (int) taxes.get(1).getTax();
        int sum3 = (int) taxes.get(2).getTax();
        assertEquals(1111, sum1);
        assertEquals(999, sum2);
        assertEquals(276, sum3);
    }

    @Test
    public void getTaxes() {
        ArrayList<TableLine> taxes = model.getTaxes();
        int sum1 = (int) taxes.get(0).getTax();
        int sum2 = (int) taxes.get(1).getTax();
        int sum3 = (int) taxes.get(2).getTax();
        assertEquals(276, sum1);
        assertEquals(1111, sum2);
        assertEquals(999, sum3);
    }

    @Test
    public void getTaxSum() {
        assertEquals(2387, (int) model.getTaxSum());
    }
}