package ua.training.model.entity;

import org.junit.Test;
import ua.training.model.entity.assistance.AssistanceTaxFabric;
import ua.training.model.entity.gift.GiftTaxFabric;
import ua.training.model.entity.salary.SalaryTaxFabric;
import ua.training.model.entity.sales.SalesTaxFabric;

import static org.junit.Assert.*;

public class TaxFabricProducerTest {

    @Test
    public void AssistanceTaxFabric() {
        Class clazz = new TaxFabricProducer("en_US")
                .getTaxFabric(new String[]{"smth", "another smth", "assistance"})
                .getClass();
        assertEquals(AssistanceTaxFabric.class, clazz);
    }

    @Test
    public void GiftTaxFabric() {
        Class clazz = new TaxFabricProducer("en_US")
                .getTaxFabric(new String[]{"smth", "another smth", "gift"})
                .getClass();
        assertEquals(GiftTaxFabric.class, clazz);
    }

    @Test
    public void SalaryTaxFabric() {
        Class clazz = new TaxFabricProducer("en_US")
                .getTaxFabric(new String[]{"smth", "another smth", "salary"})
                .getClass();
        assertEquals(SalaryTaxFabric.class, clazz);
    }

    @Test
    public void SalesTaxFabric() {
        Class clazz = new TaxFabricProducer("en_US")
                .getTaxFabric(new String[]{"smth", "another smth", "sales"})
                .getClass();
        assertEquals(SalesTaxFabric.class, clazz);
    }
}