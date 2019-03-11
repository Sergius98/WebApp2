package ua.training.model.entity.salary;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.AccumulativeTax;

public class MainSalaryTax extends AccumulativeTax {
    public MainSalaryTax(String locale) {
        super(locale, IResourcesManager.MAIN_SALARY_SECTION_LIMITS,
                IResourcesManager.MAIN_SALARY_SECTION_PERCENTS);
    }

    @Override
    protected long taxMath(long sum, long[] sections, double[] percents) {
        long buff = sum;
        long tax = 0;

        for (int i = 0; i < sections.length; i++) {
            if (buff > sections[i] * IResourcesManager.HUNDRED){
                tax += (long)((double)sections[i] * percents[i]);
                buff -= sections[i];
            } else {
                tax += (long)((double)buff * percents[i]);
                break;
            }
        }
        return tax;
    }
}
