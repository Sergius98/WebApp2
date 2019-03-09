package ua.training.model;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public interface IResourcesManager {
    String LOCALE_VALUES_BASE_NAME = "ua/training/model/resources/locale_values";
    String UKRAINIAN_LANGUAGE_TAG = "uk-UA";

    String MINIMAL_SALARY = "minimal_salary";
    String ROYALTIES_PERCENT = "royalties_percent";
    String ADDITIONAL_SALARY_PERCENT = "additional_salary_percent";
    String CASH_GIFT_PERCENT = "cash_gift_percent";
    String FOREIGN_CASH_GIFT_PERCENT = "foreign_cash_gift_percent";
    String CHILD_BENEFITS_ASSISTANCE_PERCENT = "child_benefits_assistance_percent";
    String MAIN_SALARY_SECTION_LIMITS = "main_salary_section_limits";
    String MAIN_SALARY_SECTION_PERCENTS = "main_salary_section_percents";
    String FINANCIAL_ASSISTANCE_SECTION_LIMITS = "financial_assistance_section_limits";
    String FINANCIAL_ASSISTANCE_SECTION_PERCENTS = "financial_assistance_section_percents";
    String ARRAY_DELIMITER = ", ";

    int HUNDRED = 100;
    int TWO = 2;

    static double getValue(String locale, String key) {
        ResourceBundle messages = ResourceBundle
                .getBundle(IResourcesManager.LOCALE_VALUES_BASE_NAME,
                        Locale.forLanguageTag(locale)
                );
        return Double.parseDouble(messages.getString(key));

    }

    static double[] getArray(String locale, String key) {
        ResourceBundle messages = ResourceBundle
                .getBundle(IResourcesManager.LOCALE_VALUES_BASE_NAME,
                        Locale.forLanguageTag(locale)
                );
        return Arrays.stream(messages.getString(key).split(ARRAY_DELIMITER)).mapToDouble(Double::parseDouble).toArray();
    }

    static long[] getLongArray(String locale, String key) {
        return Arrays.stream(getArray(locale, key)).mapToLong(d -> (long)d).toArray();
    }
}
