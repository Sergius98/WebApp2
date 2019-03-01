package ua.training.model;

import java.util.ArrayList;
import java.util.Collections;

public class Model {

    ArrayList<TableLine> taxTable;
    double sum;
    public Model(){
        taxTable = new ArrayList<>();
        sum = 0;
    }
    public void loadTax(String name, double tax, String fieldValueFromCookies) {
        double value = Double.parseDouble(fieldValueFromCookies);
        if (Math.abs(value) >= 1e-2){
            TableLine line = new TableLine(name, value, tax);
            taxTable.add(line);
            sum += line.getTax();
        }
    }

    public void sortTaxes() {
        Collections.sort(taxTable);
    }

    public Object getTaxes() {
        return taxTable;
    }

    public Object getTaxSum() {
        return sum;
    }
}
