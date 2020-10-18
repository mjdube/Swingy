package com.swingy.model.players;
import com.swingy.model.artifacts.Armor;
import com.swingy.model.artifacts.Helm;
import com.swingy.model.artifacts.Weapon;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Hero extends Players{


    private Armor armor;
    private Helm helm;
    private Weapon weapon;

    @Min(value = 0, message = "Level should not be less than 0")
    private int level;

    @Min(value = 0, message = "Experience should not be less than 0")
    private int experience;

    @NotNull(message = "Hero class cannot be null")
    private String heroClass;

    public Hero(String name, int attack, int defense, int hitpoints, Armor armor, Helm helm, Weapon weapon, int level, int experience, String heroClass) {
        super(name, attack, defense, hitpoints);
        this.armor = armor;
        this.helm = helm;
        this.weapon = weapon;
        this.level = level;
        this.experience = experience;
        this.heroClass = heroClass;
    }

    public void heroWeapon(Weapon weapon){
        if (this.weapon != null) {
            this.attack -= this.weapon.getPoints();
        }
        this.attack += weapon.getPoints();
        this.weapon = weapon;
    }

    public void heroHelm(Helm helm){
        if (this.helm != null) {
            this.hitpoints -= this.helm.getPoints();
            if (this.hitpoints + helm.getPoints() <= 0) {
                this.hitpoints += this.helm.getPoints();
                return;
            }
        }
        this.hitpoints += helm.getPoints();
        this.helm = helm;
    }

    public void heroArmor(Armor armor){
        if (this.armor != null) {
            this.defense -= this.armor.getPoints();
        }
        this.defense += armor.getPoints();
        this.armor = armor;
    }

    public void heroExp(int newExperience){
        int nextLevel = (level + 1) * 1000 + level * level * 450;

        if (experience + newExperience >= nextLevel)
            heroLevel();
        experience += newExperience;
    }

    public void heroLevel(){
        level++;
        hitpoints += 50 + level * 10;
        attack += level * 3;
        defense += level * 2;
    }

    public Armor getArmor() {
        return armor;
    }

    public Helm getHelm() {
        return helm;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String heroInfo(){
        String weaponInfo = "";
        String armorInfo = "";
        String helmInfo = "";

        if (weapon != null)
            weaponInfo = weapon.getName() +":"+ weapon.getPoints()+"\n";
        else
            weaponInfo = "Weapon:0\n";

        if (armor != null)
            armorInfo = armor.getName() + ":" +armor.getPoints()+"\n";
        else
            armorInfo = "Armor:0\n";

        if (helm != null)
            helmInfo = helm.getName() + ":" + helm.getPoints() + "\n";
        else
            helmInfo = "Helm:0\n";

        String msg = "Name:"+ getName() +"\n"
                + "Class:"+getHeroClass()+"\n"
                + "Level:"+getLevel()+"\n"
                + "XP:"+getExperience()+"\n"
                + "Attack:"+getAttack()+"\n"
                + "Defense:"+getDefense()+"\n"
                + "Hitpoints:"+getHitpoints()+"\n"
                + weaponInfo
                + armorInfo
                + helmInfo;
        return msg;
    }
}
