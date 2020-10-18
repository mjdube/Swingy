package com.swingy.model.players;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;

public abstract class Players {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 10, message = "Name length should not be less than 2 or greater than 10")
    protected String name;

    @Min(value = 0, message = "Attack should not be less than 0")
    protected int attack;

    @Min(value = 0, message = "Defense should not be less than 0")
    protected int defense;

    @Min(value = 1, message = "Hit points should not be less than 1")
    protected int hitpoints;

    private Random random;

    public Players(String name, int attack, int defense, int hitpoints){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hitpoints = hitpoints;
    }

    public void attack(Players opponent){
        random = new Random();
        if (this.attack > opponent.defense) {
            opponent.setHitpoints(opponent.getHitpoints() - (this.attack - opponent.defense));
        } else if (random.nextInt( 10) + 1 <= 2) {
            opponent.setHitpoints(opponent.getHitpoints() - this.attack);
        }
    }

    public boolean fight(Players opponent){
        while (opponent.getHitpoints() > 0 && this.getHitpoints() > 0) {
            this.attack(opponent);
            opponent.attack(this);
        }
        return this.getHitpoints() > 0;
    }

    public String getName(){
        return this.name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
}
