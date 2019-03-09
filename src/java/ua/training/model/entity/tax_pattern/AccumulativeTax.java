package ua.training.model.entity.tax_pattern;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.Tax;

public abstract class AccumulativeTax extends Tax{

    protected long[] sections;
    protected double[] percents;


    public AccumulativeTax(String locale, String limit_name, String percent_name){
        super(locale);
        long[] sections = IResourcesManager.getLongArray(locale, limit_name);
        double[] percents = IResourcesManager.getArray(locale, percent_name);
        if (sections.length != percents.length || percents.length == 0){
            throw new ArrayIndexOutOfBoundsException("length of sections and percentage should be even and non-zero");
        }
        this.sections = sections;
        this.percents = percents;
    }
    @Override
    public void calculateTax(long sum) {
        setSum(sum);
        setTax(taxMath(sum, sections, percents));
    }

    protected abstract long taxMath(long sum, long[] sections, double[] percents);
}