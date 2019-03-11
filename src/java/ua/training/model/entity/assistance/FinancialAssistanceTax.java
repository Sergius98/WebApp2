package ua.training.model.entity.assistance;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.AccumulativeTax;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FinancialAssistanceTax extends AccumulativeTax {
    public FinancialAssistanceTax(String locale) {
        super(locale, IResourcesManager.FINANCIAL_ASSISTANCE_SECTION_LIMITS,
                IResourcesManager.FINANCIAL_ASSISTANCE_SECTION_PERCENTS);
    }

    @Override
    protected long taxMath(long sum, long[] sections, double[] percents) {
        OptionalInt index = IntStream.range(0, sections.length)
                .filter(i -> sections[i] * IResourcesManager.HUNDRED >= sum)
                .findFirst();

        if (index.isPresent()){
            return (long)((double)sum * percents[index.getAsInt()]);
        }
        return (long)((double)sum * percents[percents.length - 1]);
    }
}