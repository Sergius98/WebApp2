package ua.training.model.entity.gift;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.TaxFabric;

import java.util.HashMap;

public class GiftTaxFabric extends TaxFabric {
    public GiftTaxFabric(String locale) {
        super(locale);

        HashMap<String, Class> taxes = getTaxes();

        taxes.put(IResourcesManager.CASH, CashGiftTax.class);
        taxes.put(IResourcesManager.FOREIGN_CASH, ForeignCashGiftTax.class);
        taxes.put(IResourcesManager.PROPERTY, PropertyGiftTax.class);
    }
}
