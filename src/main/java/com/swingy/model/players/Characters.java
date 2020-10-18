package com.swingy.model.players;

import com.swingy.model.artifacts.Helm;

public class Characters {
    public static PlayerBuilder playerNew(String name){
        PlayerBuilder playerBuilder = new PlayerBuilder();
        playerBuilder.setName(name);
        playerBuilder.setLevel(0);
        playerBuilder.setExperience(0);
        return playerBuilder;
    }

    public static Hero createWarrior(String name){
        PlayerBuilder playerBuilder = playerNew(name);
        playerBuilder.setAttack(40);
        playerBuilder.setDefense(20);
        playerBuilder.setHitPoints(100);
        playerBuilder.setHeroClass("Mastermind");
        return playerBuilder.getHero();
    }

    public static Hero createShaman(String name){
        PlayerBuilder playerBuilder = playerNew(name);
        playerBuilder.setAttack(30);
        playerBuilder.setDefense(15);
        playerBuilder.setHitPoints(90);
        playerBuilder.setHeroClass("Blaze");
        return playerBuilder.getHero();
    }

    public static Hero createPriest(String name){
        PlayerBuilder playerBuilder = playerNew(name);
        playerBuilder.setAttack(25);
        playerBuilder.setDefense(25);
        playerBuilder.setHitPoints(70);
        playerBuilder.setHeroClass("Quicksand");
        return playerBuilder.getHero();
    }

    public static Hero createPaladin(String name){
        PlayerBuilder playerBuilder = playerNew(name);
        playerBuilder.setAttack(40);
        playerBuilder.setDefense(30);
        playerBuilder.setHitPoints(120);
        playerBuilder.setHeroClass("Slingshot");
        return playerBuilder.getHero();
    }

    public static Hero createMage(String name){
        PlayerBuilder playerBuilder = playerNew(name);
        playerBuilder.setAttack(45);
        playerBuilder.setDefense(10);
        playerBuilder.setHitPoints(80);
        playerBuilder.setHeroClass("Apex");
        return playerBuilder.getHero();
    }

    public static Hero createHunter(String name){
        PlayerBuilder playerBuilder = playerNew(name);
        playerBuilder.setAttack(25);
        playerBuilder.setDefense(20);
        playerBuilder.setHitPoints(110);
        playerBuilder.setHeroClass("Titan");
        return playerBuilder.getHero();
    }
}
