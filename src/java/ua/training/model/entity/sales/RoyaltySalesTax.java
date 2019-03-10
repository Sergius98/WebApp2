package ua.training.model.entity.sales;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.ConstantTax;

public class RoyaltySalesTax extends ConstantTax {
    private double percent;

    public RoyaltySalesTax(String locale){
        super(locale);
        percent = IResourcesManager.getValue(locale, IResourcesManager.ROYALTIES_PERCENT);
    }

    @Override
    protected long getConstantTax(long sum) {
        return (long) (sum * percent);
    }
}
