package ua.training.model.entity.gift;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.ConstantTax;

public class CashGiftTax extends ConstantTax {
    private double percent;

    public CashGiftTax(String locale){
        super(locale);

        percent = IResourcesManager.getValue(locale,
                IResourcesManager.CASH_GIFT_PERCENT);
    }

    @Override
    protected long getConstantTax(long sum) {
        return (long) (sum * percent);
    }
}
