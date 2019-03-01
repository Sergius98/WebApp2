package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class ModelTest {
    Model model;
    @Before
    public void init(){
        model = new Model();
        model.loadTax("second", 0.2, "1000");
        model.loadTax("first", 0.25, "1000");
        model.loadTax("third", 0.1, "1000");
    }

    @Test
    public void sortTaxes() {
        ArrayList<TableLine> taxes = model.getTaxes();
        Collections.sort(taxes);
        int sum1 = (int) taxes.get(0).getTax();
        int sum2 = (int) taxes.get(1).getTax();
        int sum3 = (int) taxes.get(2).getTax();
        assertEquals(250, sum1);
        assertEquals(200, sum2);
        assertEquals(100, sum3);
    }

    @Test
    public void getTaxes() {
        ArrayList<TableLine> taxes = model.getTaxes();
        int sum1 = (int) taxes.get(0).getTax();
        int sum2 = (int) taxes.get(1).getTax();
        int sum3 = (int) taxes.get(2).getTax();
        assertEquals(200, sum1);
        assertEquals(250, sum2);
        assertEquals(100, sum3);
    }

    @Test
    public void getTaxSum() {
        assertEquals(550, (int) model.getTaxSum());
    }
}