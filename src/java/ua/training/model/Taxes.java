package ua.training.model;

import java.util.EnumSet;

public enum Taxes {
    INCOME_FROM_THE_MAIN_EMPLOYMENT ("income_from_the_main_employment", 0.25),
    INCOME_FROM_THE_ADDITIONAL_EMPLOYMENT    ("income_from_the_additional_employment", 0.4),
    ROYALTIES ("royalties", 0.42),
    PROPERTY_SALES ("property_sales", 0.2),
    RECEIVING_A_GIFT_OF_CASH ("receiving_a_gift_of_cash",   0.666),
    RECEIVING_A_GIFT_OF_PROPERTY ("receiving_a_gift_of_property", 0.4),
    TRANSFERS_FROM_ABROAD ("transfers_from_abroad", 0.1),
    CHILD_BENEFITS ("child_benefits", 0.01),
    FINANCIAL_ASSISTANCE ("financial_assistance", 0.5);

    protected String name;
    protected double tax;

    Taxes(String name, double tax){
        this.name = name;
        this.tax = tax;
    }

    public String getName(){
        return name;
    }

    public double getTax(){
        return tax;
    }
}
