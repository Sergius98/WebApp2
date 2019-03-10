package ua.training.model.entity.salary;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.ConstantTax;

import java.util.HashMap;

public class AdditionalSalaryTax  extends ConstantTax {
    @FunctionalInterface
    interface Calculator<T, V>{
        long calculate(T sum, V percent);
    }

    private static HashMap<String, Calculator<Long, Double>> calculators = new HashMap();

    private static Calculator<Long, Double> DefaultCalculator = (
            (sum, percentage) -> ((long)(sum * percentage))
    );
    static {
        calculators.put(IResourcesManager.UKRAINIAN_LANGUAGE_TAG,
                (sum, percentage) -> {
                    if (sum > IResourcesManager.HUNDRED * IResourcesManager.getValue(
                            IResourcesManager.UKRAINIAN_LANGUAGE_TAG, IResourcesManager.MINIMAL_SALARY)){
                        return (long)(sum * percentage);
                    }
                    return (long)(sum * (percentage / IResourcesManager.TWO));
                }
        );
    }

    private Calculator<Long, Double> calculator;
    private double percent;

    public AdditionalSalaryTax(String locale){
        super(locale);
        percent = IResourcesManager.getValue(locale, IResourcesManager.ADDITIONAL_SALARY_PERCENT);
        calculator = calculators.getOrDefault(locale, DefaultCalculator);
    }

    @Override
    protected long getConstantTax(long sum) {
        return calculator.calculate(sum, percent);
    }
}
