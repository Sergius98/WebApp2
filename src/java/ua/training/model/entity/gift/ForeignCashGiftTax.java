package ua.training.model.entity.gift;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.ConstantTax;

public class ForeignCashGiftTax extends ConstantTax {
    double percent;

    public ForeignCashGiftTax(String locale){
        super(locale);
        percent = IResourcesManager.getValue(locale, IResourcesManager.FOREIGN_CASH_GIFT_PERCENT);
    }

    @Override
    protected long getConstantTax(long sum) {
        return (long) (sum * percent);
    }
}
