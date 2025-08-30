package mypos.drinks;

import mypos.BaseDrink;
import mypos.Modification;

// DrinkTemplate should be the name of the drink, like a latte, and should be the filename as well
public class DrinkTemplate extends BaseDrink {
    public DrinkTemplate() {
        // Sets drink name and default parameters such as size, temperature, and milk base
        super("DRINK_NAME", BaseDrink.Size.MEDIUM, BaseDrink.Temperature.HOT, BaseDrink.MilkBase.TWO_PERCENT);

        // If a drink has espresso shots, you can set them based on size or remove the case statement and just use setShots();
        switch(getSize()) {
            case SMALL:
                setShots(1);
                break;
            case MEDIUM:
                setShots(2);
                break;
            case LARGE:
                setShots(2);
                if(getTemperature() == BaseDrink.Temperature.ICED) {
                    setShots(3);
                }
                break;
        }

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
        return "DRINK_NAME";
    }

    @Override
    protected boolean isModificationAllowed(Modification mod) {
        // Example of a drink modification restriction
        /*if(getTemperature() == BaseDrink.Temperature.HOT && mod.getModification() == "COLD_FOAM") {
            return false;
        }*/
        return true;
    }

    
}
