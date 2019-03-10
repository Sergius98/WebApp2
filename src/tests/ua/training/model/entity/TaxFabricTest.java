package ua.training.model.entity;

import org.junit.Test;
import ua.training.model.entity.assistance.ChildBenefitsAssistanceTax;
import ua.training.model.entity.assistance.FinancialAssistanceTax;
import ua.training.model.entity.gift.CashGiftTax;
import ua.training.model.entity.gift.ForeignCashGiftTax;
import ua.training.model.entity.gift.PropertyGiftTax;
import ua.training.model.entity.salary.AdditionalSalaryTax;
import ua.training.model.entity.salary.MainSalaryTax;
import ua.training.model.entity.sales.PropertySalesTax;
import ua.training.model.entity.sales.RoyaltySalesTax;

import static org.junit.Assert.*;

public class TaxFabricTest {

    @Test
    public void AssistanceTaxFabric() {
        String[] nameArray  = new String[]{"child", "benefits", "assistance"};
        String[] name2Array  = new String[]{"financial", "assistance"};
        TaxFabric fabric = new TaxFabricProducer("en_US")
                .getTaxFabric(nameArray);

        assertEquals(ChildBenefitsAssistanceTax.class, fabric.getTax(nameArray).getClass());
        assertEquals(FinancialAssistanceTax.class, fabric.getTax(name2Array).getClass());
    }

    @Test
    public void GiftTaxFabric() {
        String[] nameArray  = new String[]{"cash", "gift"};
        String[] name1Array  = new String[]{"foreign", "cash", "gift"};
        String[] name2Array  = new String[]{"property", "gift"};
        TaxFabric fabric = new TaxFabricProducer("en_US")
                .getTaxFabric(nameArray);

        assertEquals(CashGiftTax.class, fabric.getTax(nameArray).getClass());
        assertEquals(ForeignCashGiftTax.class, fabric.getTax(name1Array).getClass());
        assertEquals(PropertyGiftTax.class, fabric.getTax(name2Array).getClass());
    }

    @Test
    public void SalaryTaxFabric() {
        String[] nameArray  = new String[]{"main", "salary"};
        String[] name2Array  = new String[]{"additional", "salary"};
        TaxFabric fabric = new TaxFabricProducer("en_US")
                .getTaxFabric(nameArray);

        assertEquals(MainSalaryTax.class, fabric.getTax(nameArray).getClass());
        assertEquals(AdditionalSalaryTax.class, fabric.getTax(name2Array).getClass());
    }

    @Test
    public void SalesTaxFabric() {
        String[] nameArray  = new String[]{"property", "sales"};
        String[] name2Array  = new String[]{"royalty", "sales"};
        TaxFabric fabric = new TaxFabricProducer("en_US")
                .getTaxFabric(nameArray);

        assertEquals(PropertySalesTax.class, fabric.getTax(nameArray).getClass());
        assertEquals(RoyaltySalesTax.class, fabric.getTax(name2Array).getClass());
    }
}