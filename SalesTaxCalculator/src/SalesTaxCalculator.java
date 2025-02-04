public class SalesTaxCalculator {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SalesTaxCalculator <State> <SaleAmount>");
            return;
        }

        String stateName = args[0];
        double saleAmount;

        try {
            saleAmount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid sale amount");
            return;
        }

        State state;

        switch (stateName) {
            case "Alaska":
                state = new Alaska();
                state.setTaxBehavior(new NoTax());
                break;
            case "Indiana":
                state = new Indiana();
                state.setTaxBehavior(new SevenPercent());
                break;
            case "Hawaii":
                state = new Hawaii();
                state.setTaxBehavior(new FourPointFivePercent());
                break;
            default:
                System.out.println("Error: Invalid state");
                return;
        }

        state.showTax(saleAmount);
    }
}
