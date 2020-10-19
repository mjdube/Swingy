package com.swingy.model.game;

import com.swingy.model.artifacts.Armor;
import com.swingy.model.artifacts.Artifact;
import com.swingy.model.artifacts.Helm;
import com.swingy.model.artifacts.Weapon;
import com.swingy.model.players.Hero;
import com.swingy.model.players.Players;
import com.swingy.model.players.Possession;
import com.swingy.model.players.Villain;

import java.util.Random;

public class GamePlayer {

    private static GamePlayer instance = null;

    private Hero hero;
    private Possession heroPossession;
    private int mapSize;
    private boolean map[][];
    private Random random;

    private GamePlayer(){}

    public static GamePlayer getInstance(){
        if (instance == null){
            instance = new GamePlayer();
        }
        return instance;
    }

    public void initGame(Hero hero){
        this.hero = hero;
        generateMap();
        generateVillains();
        putHero();
    }

    private void generateMap(){
        int level = hero.getLevel();
        mapSize = (level - 1) * 5 + 10 - (level % 2);
        map = new boolean[mapSize][mapSize];
    }

    private void generateVillains() {
        int rand;
        int level = hero.getLevel();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                random = new Random();
                rand = random.nextInt(100) + 1;
                if ((level + 1) * 10 >= rand)
                    map[i][j] = true;
            }
        }
    }

    public Villain generateVillain() {
        random = new Random();
        int attack = (random.nextInt(hero.getAttack() + 20) + 1 -20) + (random.nextInt(hero.getAttack() + 2 + hero.getLevel()) + 1);
        int defense = (random.nextInt(hero.getDefense() + 20) + 1 - 20) + (random.nextInt(hero.getDefense() + 2 + hero.getLevel()) + 1);
        int hitPoints = (random.nextInt(hero.getHitpoints() + 50) + 1 - 50) + (random.nextInt(hero.getHitpoints() + 20 + hero.getLevel()) + 1);

        attack = attack < 0 ? -attack : attack;
        defense = defense < 0 ? -defense : defense;
        hitPoints = hitPoints < 0 ? -hitPoints : hitPoints;
        Artifact artifact = generateArtifact();

        return new Villain("Villain", attack, defense, hitPoints, artifact);
    }

    private Artifact generateArtifact() {
        random = new Random();
        int rand = random.nextInt(3);

        Artifact artifact = null;
        if (rand == 0)
            artifact = new Weapon("Sword", random.nextInt(5 * (hero.getLevel() + 1)) + 1);
        else if (rand == 1)
            artifact = new Helm("Pot", random.nextInt(3 * (hero.getLevel() + 1)) + 1);
        else if (rand == 2)
            artifact = new Armor("Shield", random.nextInt( 4 * (hero.getLevel() + 1)) + 1);
        return artifact;
    }

    public int fightResult(Players villain) {

        int xp = villain.getAttack() + villain.getDefense() + villain.getHitpoints();
        int rand = random.nextInt(100) + 1;

        if (rand < 3)
            return xp;
        else if (rand > 98)
            return -1;

        return hero.fight(villain) ? xp : -1;
    }

    private void putHero() {
        heroPossession = new Possession(mapSize / 2, mapSize / 2);
        map[heroPossession.getY()][heroPossession.getX()] = false;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Possession getHeroPossession() {
        return heroPossession;
    }

    public void setHeroPossession(Possession heroPossession) {
        this.heroPossession = heroPossession;
    }

    public boolean[][] getMap() {
        return map;
    }

    public void setMap(boolean[][] map) {
        this.map = map;
    }
}
