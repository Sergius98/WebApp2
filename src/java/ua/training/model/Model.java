package ua.training.model;

import ua.training.controller.IConstants;
import ua.training.model.entity.Tax;
import ua.training.model.entity.TaxFabricProducer;

import java.util.ArrayList;
import java.util.Collections;

public class Model {

    ArrayList<TableLine> taxTable;
    double sum;
    TaxFabricProducer fabrics;
    public Model(String locale){
        taxTable = new ArrayList<>();
        sum = 0;
        fabrics = new TaxFabricProducer(locale);
    }

    /**
     * @param name - name of the category
     * @param fieldValueFromCookies - value received from user, amount of money in the category
     *
     * Tax category will be added to the output only if value passed from user bigger than 0.01
     */
    public void loadTax(String[] name,String fieldValueFromCookies) {
        double value = Double.parseDouble(fieldValueFromCookies);
        if (Math.abs(value) >= IConstants.APPROXIMATION){
            Tax tax = fabrics.getTaxFabric(name).getTax(name);
            tax.calculateTax((long)(value * IResourcesManager.HUNDRED));
            TableLine line = new TableLine(String.join("_", name),
                    tax.getSum(), tax.getTaxPercentage(), tax.getTaxSum());
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
        return (double) Math.round(sum * 100) / 100;
    }
}
