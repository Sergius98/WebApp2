package ua.training.model.entity.assistance;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.TaxFabric;
import java.util.HashMap;

public class AssistanceTaxFabric extends TaxFabric {

    public AssistanceTaxFabric(String locale) {
        super(locale);

        HashMap<String, Class> taxes = getTaxes();

        taxes.put(IResourcesManager.FINANCIAL, FinancialAssistanceTax.class);
        taxes.put(IResourcesManager.CHILD_BENEFITS,
                ChildBenefitsAssistanceTax.class);
    }
}
