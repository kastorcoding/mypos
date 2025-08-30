package mypos.drinks;

import mypos.BaseDrink;
import mypos.Modification;

public class Latte extends BaseDrink {
    public Latte(Size size, Temperature temperature, MilkBase milkBase) {
        super("Latte", size, temperature, milkBase);
    }

    @Override
    protected double getBasePrice() {
        double basePrice = 0;
        switch(getSize()) {
            case SMALL:
                basePrice = 3.75; // Small Price
                break;
            case MEDIUM:
                basePrice = 4.25; // Medium Price
                break;
            case LARGE:
                basePrice = 4.75; // Large Price
                break;
        }

        switch(getTemperature()) {
            case HOT:
                break;           
            case ICED:
                basePrice += 0.50;
                break;
        }

        return basePrice;
    }

    @Override
    public String getDrinkType() {
        return "Latte";
    }

    @Override
    protected boolean isModificationAllowed(Modification mod) {
        if(getTemperature() == BaseDrink.Temperature.HOT && mod.getModification() == "COLD_FOAM") {
            return false;
        }
        return true;
    }
}
