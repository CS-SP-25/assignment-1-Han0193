class NoTax implements SalesTaxBehavior {
    @Override
    public double compute(Double value) {
        return 0.0;
    }
}