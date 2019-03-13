package ua.training.model.entity.salary;

import ua.training.model.IResourcesManager;
import ua.training.model.entity.tax_pattern.AccumulativeTax;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class MainSalaryTax extends AccumulativeTax {
    public MainSalaryTax(String locale) {
        super(locale, IResourcesManager.MAIN_SALARY_SECTION_LIMITS,
                IResourcesManager.MAIN_SALARY_SECTION_PERCENTS);
    }

    @Override
    protected long taxMath(long sum, long[] sections, double[] percents) {
        AtomicLong buffer = new AtomicLong(sum);
        AtomicLong wall = new AtomicLong(0);

        return IntStream.range(0, sections.length)
                .collect(AtomicLong::new, (tax, i) -> {
                        wall.set(sections[i] * IResourcesManager.HUNDRED);
                        tax.set(tax.get() + (long)((buffer.get() > wall.get())
                                ? (sections[i] * percents[i])
                                : (buffer.get() * percents[i])));
            buffer.set(( buffer.get() > wall.get() )
                    ? buffer.get() - sections[i]
                    : 0);
        }, (a, b) -> a.set(a.get() + b.get())).get();

        /* this one is way more effective and pretty, but Ok
        long buff = sum;
        long tax = 0;

        for (int i = 0; i < sections.length; i++) {
            if (buff > sections[i] * IResourcesManager.HUNDRED){
                tax += (long)(sections[i] * percents[i]);
                buff -= sections[i];
            } else {
                tax += (long)(buff * percents[i]);
                break;
            }
        }
        return tax;
        */
    }
}
