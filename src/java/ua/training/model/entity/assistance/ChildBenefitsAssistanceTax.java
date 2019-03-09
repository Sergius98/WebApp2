package ua.training.model.entity.assistance;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.ConstantTax;

public class ChildBenefitsAssistanceTax extends ConstantTax {
    double percent;

    public ChildBenefitsAssistanceTax(String locale){
        super(locale);
        percent = IResourcesManager.getValue(locale, IResourcesManager.CHILD_BENEFITS_ASSISTANCE_PERCENT);
    }

    @Override
    protected long getConstantTax(long sum) {
        return (long) (sum * percent);
    }
}
