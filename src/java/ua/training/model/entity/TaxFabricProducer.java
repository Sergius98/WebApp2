package ua.training.model.entity;

import ua.training.model.entity.assistance.AssistanceTaxFabric;
import ua.training.model.entity.gift.GiftTaxFabric;
import ua.training.model.entity.salary.SalaryTaxFabric;
import ua.training.model.entity.sales.SalesTaxFabric;
import java.util.HashMap;
import java.util.Optional;

public class TaxFabricProducer {
    private HashMap<String, TaxFabric> fabrics = new HashMap<>();

    public TaxFabricProducer(String locale){
        fabrics.put("assistance", new AssistanceTaxFabric(locale));
        fabrics.put("gift", new GiftTaxFabric(locale));
        fabrics.put("salary", new SalaryTaxFabric(locale));
        fabrics.put("sales", new SalesTaxFabric(locale));
    }
    public TaxFabric getTaxFabric(String[] name) {
        Optional<TaxFabric> fabric = Optional.ofNullable(fabrics.get(name[name.length - 1]));
        if (fabric.isPresent()){
            return fabric.get();
        }
        throw new IllegalArgumentException("there is no fabric that matches" + name[name.length - 1]);
    }
}
