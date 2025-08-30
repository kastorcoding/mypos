abstract class Modification{
    private final String name;
    public Modification(String name) {this.name = name;}
    public abstract double getPriceModifier();
    @Override
    public String toString() {return name;}
}

// Drink Modifications
class Syrup extends Modification{
    private int pumps;
    private String flavor;

    public Syrup(int pumps, String flavor) {
        super(flavor + "Syrup");
        this.flavor = flavor;
        this.pumps = pumps;
    }
    @Override
    public double getPriceModifier() {return 0.80;}
}

class Sugar extends Modification{
    private int packets;
    private String flavor;
    public Sugar(int packets, String flavor) {
        super(flavor);
        this.packets = packets;
        this.flavor = flavor;
    }
    @Override
    public double getPriceModifier() {return 0.00;}
}

class Creamer extends Modification{
    private int amount;
    private String flavor;
    public Creamer(int amount, String flavor) {
        super(flavor);
        this.amount = amount;
        this.flavor = flavor;
    }
    @Override
    public double getPriceModifier() {return 0.00;}
}

class Drizzle extends Modification{
    private String flavor;
    public Drizzle(String flavor) {
        super(flavor + "Drizzle");
        this.flavor = flavor;
    }
    @Override
    public double getPriceModifier() {return 0.00;}
}

class WhipCream extends Modification{
    public WhipCream() {super("Whip Cream");}
    @Override
    public double getPriceModifier() {return 0.00;}
}

class ColdFoam extends Modification {
    private String flavor;
    public ColdFoam(String flavor) {
        super(flavor + "Cold Foam");
        this.flavor = flavor;
    }
    @Override
    public double getPriceModifier() {return 0.00;}
}

class GenericTopping extends Modification{
    private String topping;
    public GenericTopping(String topping) {
        super(topping);
        this.topping = topping;
    }
    @Override
    public double getPriceModifier() {return 0.00;}
}