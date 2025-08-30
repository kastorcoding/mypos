package mypos;

import mypos.drinks.*;

public class main{
    public static void main(String[] args) {
        Latte latte = new Latte();

        latte.addModification(new ColdFoam("Vanilla"));
    }
}
