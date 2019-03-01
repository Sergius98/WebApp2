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

    /**
     * @param name - name of the category
     * @param tax - tax percentage of the category
     * @param fieldValueFromCookies - value received from user, amount of money in the category
     *
     * Tax category will be added to the output only if value passed from user bigger than 0.01
     */
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

    public ArrayList<TableLine> getTaxes() {
        return taxTable;
    }

    public double getTaxSum() {
        return sum;
    }
}
