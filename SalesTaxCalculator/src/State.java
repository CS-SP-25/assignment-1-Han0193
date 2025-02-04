abstract class State {
    protected String name;
    protected SalesTaxBehavior taxBehavior; // 允许动态修改

    public State(String name) {
        this.name = name;
    }

    public void setTaxBehavior(SalesTaxBehavior taxBehavior) {
        this.taxBehavior = taxBehavior;
    }

    public void showTax(double value) {
        if (taxBehavior == null) {
            System.out.println("Error: Sales tax behavior not set.");
            return;
        }
        double tax = taxBehavior.compute(value);
        System.out.printf("The sales tax on $%.2f in %s is $%.2f.%n", value, name, tax);
    }
}
