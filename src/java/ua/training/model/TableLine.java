package ua.training.model;

public class TableLine implements Comparable<TableLine> {
    private String name;
    private double value;
    private double tax_per_cent;
    private double tax;

    /**
     *
     */
    public TableLine(String name, double value, double tax_per_cent, double tax) {
        this.name = name;
        this.value = value;
        this.tax_per_cent = tax_per_cent;
        this.tax = tax;
    }

    public int compareTo(TableLine tableLine) {
        // to sort in ascending order
        //return this.tax > tableLine.tax ? 1 : this.tax < tableLine.tax ? -1 : 0;
        // to sort in descending order
        return Double.compare(tableLine.tax, this.tax);
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public double getTax_per_cent() {
        return tax_per_cent;
    }

    public double getTax() {
        return tax;
    }
}
