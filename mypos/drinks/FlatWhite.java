package mypos.drinks;

import mypos.BaseDrink;
import mypos.Modification;

public class FlatWhite extends BaseDrink {
    public FlatWhite() {
        super("Flat White", BaseDrink.Size.MEDIUM, BaseDrink.Temperature.HOT, BaseDrink.MilkBase.WHOLE);

        // Espresso Shots
        switch(getSize()) {
            case SMALL:
                setShots(2);
                break;
            case MEDIUM:
                setShots(3);
                break;
            case LARGE:
                setShots(3);
                if(getTemperature() == BaseDrink.Temperature.ICED) {
                    setShots(4);
                }
                break;
        }
    }

    @Override
    protected double getBasePrice() {
        double basePrice = 0;
        switch(getSize()) {
            case SMALL:
                basePrice = 4.00; // Small Price
                break;
            case MEDIUM:
                basePrice = 4.50; // Medium Price
                break;
            case LARGE:
                basePrice = 5.00; // Large Price
                break;
        }

        // Temperature based pricing
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
        return "Flat White";
    }

    @Override
    protected boolean isModificationAllowed(Modification mod) {
        if(getTemperature() == BaseDrink.Temperature.HOT && mod.getModification() == "COLD_FOAM") {
            return false;
        }
        return true;
    }

    
}
