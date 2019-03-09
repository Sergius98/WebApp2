package ua.training.model.entity.sales;

import ua.training.model.entity.TaxFabric;
import java.util.HashMap;

public class SalesTaxFabric extends TaxFabric {

    public SalesTaxFabric(String locale) {
        super(locale);
        HashMap<String, Class> taxes = getTaxes();
        taxes.put("property", PropertySalesTax.class);
        taxes.put("royalty", RoyaltySalesTax.class);
    }
}
