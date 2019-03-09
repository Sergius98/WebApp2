package ua.training.model.entity.salary;

import ua.training.model.entity.TaxFabric;
import java.util.HashMap;

public class SalaryTaxFabric extends TaxFabric {
    public SalaryTaxFabric(String locale) {
        super(locale);
        HashMap<String, Class> taxes = getTaxes();
        taxes.put("main", MainSalaryTax.class);
        taxes.put("additional", AdditionalSalaryTax.class);
    }
}
