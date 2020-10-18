package com.swingy.model.players;

public abstract class CharacterClass {
    public static Hero newPlayer(String name, String heroClass){
        Hero newHero = null;

        if (heroClass.equalsIgnoreCase("Mastermind")){
            newHero = Characters.createWarrior(name);
        }
        else if (heroClass.equalsIgnoreCase("Blaze")){
            newHero = Characters.createShaman(name);
        }
        else if (heroClass.equalsIgnoreCase("Quicksand")){
            newHero = Characters.createPriest(name);
        }
        else if (heroClass.equalsIgnoreCase("Slingshot")){
            newHero = Characters.createPaladin(name);
        }
        else if (heroClass.equalsIgnoreCase("Apex")){
            newHero = Characters.createMage(name);
        }
        else if (heroClass.equalsIgnoreCase("Titan")){
            newHero = Characters.createHunter(name);
        }

        return newHero;
    }
}
