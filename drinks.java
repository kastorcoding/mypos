public class Latte extends BaseDrink {
    public Latte(Size size, Temperature temperature, MilkBase milkBase) {
        super("Latte", size, temperature, milkBase);
    }
    @Override
    protected double getBasePrice() {
        return 0;
    }

    @Override
    public String getDrinkType() {
        return "Latte";
    }

    @Override
    protected boolean isModificationAllowed(Modification mod) {
        return true;
    }
}

public class Coffee extends BaseDrink {
    public Coffee(Size size, Temperature temperature, MilkBase milkBase) {
        super("Coffee", size, temperature, milkBase);
    }
    @Override
    protected double getBasePrice() {
        return 0;
    }

    @Override
    public String getDrinkType() {
        return "Latte";
    }

    @Override
    protected boolean isModificationAllowed(Modification mod) {
        return true;
    }
}