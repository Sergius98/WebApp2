package ua.training.model.entity.tax_pattern;

import ua.training.model.entity.Tax;

public abstract class ConstantTax extends Tax {

    public ConstantTax(String locale){
        super(locale);
    }

    @Override
    public void calculateTax(long sum) {
        setSum(sum);
        setTax(getConstantTax(sum));
    }
    abstract protected long getConstantTax(long sum);
}
