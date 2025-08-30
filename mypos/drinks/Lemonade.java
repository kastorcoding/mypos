package mypos.drinks;

import mypos.BaseDrink;
import mypos.Modification;

public class Lemonade extends BaseDrink {
    public Lemonade() {
        super("Lemonade", BaseDrink.Size.MEDIUM, BaseDrink.Temperature.ICED, BaseDrink.MilkBase.NONE);
    }

    @Override
    protected double getBasePrice() {
        double basePrice = 0;
        switch(getSize()) {
            case SMALL:
                basePrice = 3.50; // Small Price
                break;
            case MEDIUM:
                basePrice = 4.00; // Medium Price
                break;
            case LARGE:
                basePrice = 4.50; // Large Price
                break;
        }
        return basePrice;
    }

    // Prevents Lemonade from being made HOT
    @Override
    public void setTemperature(BaseDrink.Temperature newTemperature) {
        if(newTemperature == BaseDrink.Temperature.HOT) {
            System.out.println(getDrinkType() + " is not allowed to be hot.");
        }
        return;
    }

    @Override
    public String getDrinkType() {
        return "Lemonade";
    }

    @Override
    protected boolean isModificationAllowed(Modification mod) {
        return true;
    }
}
