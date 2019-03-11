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
    String NAME_DELIMETER = "_";
    String CREATING_A_TAX_OBJECT_FAILED_FOR = "creating a Tax object failed for ";
    String NO_TAX = "there is no Tax that matches ";
    String WRONG_ARRAYS = "length of sections and percentage should be even and non-zero";

    String ASSISTANCE = "assistance";
    String GIFT = "gift";
    String SALARY = "salary";
    String SALES = "sales";

    String PROPERTY = "property";
    String ROYALTY = "royalty";

    String ADDITIONAL = "additional";
    String MAIN = "main";

    String CASH = "cash";
    String FOREIGN_CASH = "foreign_cash";

    String CHILD_BENEFITS = "child_benefits";
    String FINANCIAL = "financial";

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
        return Arrays.stream(messages.getString(key).split(ARRAY_DELIMITER))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }

    static long[] getLongArray(String locale, String key) {
        return Arrays.stream(getArray(locale, key))
                .mapToLong(d -> (long)d).toArray();
    }
}
