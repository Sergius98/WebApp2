package ua.training.model.entity.assistance;

import ua.training.model.entity.TaxFabric;
import java.util.HashMap;

public class AssistanceTaxFabric extends TaxFabric {

    public AssistanceTaxFabric(String locale) {
        super(locale);

        HashMap<String, Class> taxes = getTaxes();
        taxes.put("financial", FinancialAssistanceTax.class);
        taxes.put("child_benefits", ChildBenefitsAssistanceTax.class);
    }
}
