package mypos;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDrink {
    private boolean selected = true; // true or false, default true
    private String name; // ex. Latte
    private Size size; // small, medium, or large
    private Temperature temperature; // hot or iced
    private int shots; // # of espresso shots
    private MilkBase milkBase; // type of milk the drink is mainly made with
    private List<Modification> modifications; // any # of modifications

    public BaseDrink(String name, Size size, Temperature temperature, MilkBase milkBase) {
        this.name = name;
        this.size = size;
        this.temperature = temperature;
        this.milkBase = milkBase;
        this.modifications = new ArrayList<>();
    }

    // Subclasses must implement these methods
    protected abstract double getBasePrice();
    public abstract String getDrinkType();

    // Add Modifications
    public void addModification(Modification mod) {
        if(isModificationAllowed(mod)) {
            modifications.add(mod);
        } else {
            System.out.println(mod.getModification() + " not allowed for " + getTemperature() + " " + getDrinkType());
        }
    }

    // Allow or Deny modifications
    protected boolean isModificationAllowed(Modification mod) {
        return true;
    }

    // Pricing
    public double getPrice(){
        double price = getBasePrice();

        // Add price of milk
        price += milkBase.getPriceModifier();

        // Add prices of each modification
        for(Modification mod : modifications) {
            price += mod.getPriceModifier();
        }

        return price;
    }
    
    // Getters
    public boolean getSelected() {return selected;}
    public String getName() {return name;}
    public Size getSize() {return size;}
    public Temperature getTemperature() {return temperature;}
    public int getShots() {return shots;}
    public MilkBase getMilkBase() {return milkBase;}
    public List<Modification> getModifications() {return modifications;}

    // Setters
    public void setSelection(boolean selection) {selected = selection;}
    public void setSize(Size newSize) {size = newSize;}
    public void setTemperature(Temperature newTemperature) {temperature = newTemperature;}
    public void setShots(int num) {shots = num;}
    public void addShot() {shots += 1;}
    public void setMilkBase(MilkBase newMilkBase) {milkBase = newMilkBase;}


    // Enums
    public enum Size{SMALL, MEDIUM, LARGE}
    public enum Temperature{HOT, ICED}
    public enum MilkBase{
        NONE(0.0), TWO_PERCENT(0.0), SKIM(0.0), WHOLE(0.0),
        ALMOND(0.50), OAT(0.50), COCONUT(0.50), SOY(0.50),
        BREVE(0.70), HEAVY_CREAM(0.70), VSC(1.25);

        private final double priceModifier;
        MilkBase(double modifier) {this.priceModifier = modifier;}
        public double getPriceModifier() {return priceModifier;}
    }
}