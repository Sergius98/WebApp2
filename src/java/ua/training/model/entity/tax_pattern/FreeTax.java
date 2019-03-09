package ua.training.model.entity.tax_pattern;

import ua.training.model.entity.Tax;

public abstract class FreeTax extends Tax {

    public FreeTax(String locale){
        super(locale);
    }

    @Override
    public void calculateTax(long sum){
        setSum(sum);
        setTax(0);
    }
}
