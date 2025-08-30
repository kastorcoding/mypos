package mypos;

import mypos.drinks.*;

public class main{
    public static void main(String[] args) {
        Latte latte = new Latte(BaseDrink.Size.MEDIUM, BaseDrink.Temperature.HOT,
        BaseDrink.MilkBase.WHOLE);

        latte.addModification(new ColdFoam("Vanilla"));
    }
}
