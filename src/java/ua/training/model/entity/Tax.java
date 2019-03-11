package ua.training.model.entity;

public abstract class Tax {
    private long sum = 0; // in coins
    private long tax = 0; // in coins

    public Tax(String locale){
        //all childs can't use default constructor
    }


    public final double getSum(){
        return ((double) Math.round((double)sum)) / 100;
    }
    public double getTaxSum(){
        return (double) Math.round((double)tax) / 100;
    }
    public double getTaxPercentage(){
        return (
                ((double) Math.round((double)tax))
                / ((double) Math.round((double)sum))
        );
    }

    protected final void setSum(long sum){  // in coins
        this.sum = sum;
    }
    protected void setTax(long tax){  // in coins
        this.tax = tax;
    }

    abstract public void calculateTax(long sum);
}
