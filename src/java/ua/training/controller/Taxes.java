package ua.training.controller;

import ua.training.model.entity.Tax;

/**
 * contains all category of entity that can be calculated in the program
 * also contain name of the property field in messages and tax percentage
 */
public enum Taxes {
    /*
    INCOME_FROM_THE_MAIN_EMPLOYMENT ("income_from_the_main_employment", 0.25),
    INCOME_FROM_THE_ADDITIONAL_EMPLOYMENT    ("income_from_the_additional_employment", 0.4),
    ROYALTIES ("royalties", 0.42),
    PROPERTY_SALES ("property_sales", 0.2),
    RECEIVING_A_GIFT_OF_CASH ("receiving_a_gift_of_cash",   0.666),
    RECEIVING_A_GIFT_OF_PROPERTY ("receiving_a_gift_of_property", 0.4),
    TRANSFERS_FROM_ABROAD ("transfers_from_abroad", 0.1),
    CHILD_BENEFITS ("child_benefits", 0.01),
    FINANCIAL_ASSISTANCE ("financial_assistance", 0.5),
*/
    CHILD_BENEFITS_ASSISTANCE(),
    FINANCIAL_ASSISTANCE(),
    CASH_GIFT (),
    PROPERTY_GIFT (),
    FOREIGN_CASH_GIFT (),
    MAIN_SALARY (),
    ADDITIONAL_SALARY (),
    ROYALTY_SALES (),
    PROPERTY_SALES ();

    protected Tax tax;

    Taxes(){
        this.tax = null;
    }

    public String getName(){
        return this.name().toLowerCase();
    }
    public String[] getNameArray(){
        return this.getName().split("_");
    }

    public double getTaxPercentage(){
        return 0;
    }

    public double getTax(){
        return 0;
    }
}
