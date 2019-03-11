package ua.training.model.entity.sales;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.TaxFabric;
import java.util.HashMap;

public class SalesTaxFabric extends TaxFabric {

    public SalesTaxFabric(String locale) {
        super(locale);

        HashMap<String, Class> taxes = getTaxes();

        taxes.put(IResourcesManager.PROPERTY, PropertySalesTax.class);
        taxes.put(IResourcesManager.ROYALTY, RoyaltySalesTax.class);
    }
}
