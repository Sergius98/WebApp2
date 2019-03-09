package ua.training.model.entity.gift;

import ua.training.model.entity.TaxFabric;

import java.util.HashMap;

public class GiftTaxFabric extends TaxFabric {
    public GiftTaxFabric(String locale) {
        super(locale);
        HashMap<String, Class> taxes = getTaxes();
        taxes.put("cash", CashGiftTax.class);
        taxes.put("foreign_cash", ForeignCashGiftTax.class);
        taxes.put("property", PropertyGiftTax.class);
    }
}
