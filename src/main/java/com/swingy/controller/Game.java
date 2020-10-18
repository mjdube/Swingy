package com.swingy.controller;

import com.swingy.model.artifacts.Armor;
import com.swingy.model.artifacts.Artifact;
import com.swingy.model.artifacts.Helm;
import com.swingy.model.artifacts.Weapon;
import com.swingy.model.game.GamePlayer;
import com.swingy.model.players.Possession;
import com.swingy.model.players.Villain;
import com.swingy.view.gameplay.GamePlay;

import java.util.Random;

public class Game {
    private GamePlay gamePlayView;
    private GamePlayer gamePlayer;
    private Possession possession;

    public Game(GamePlay gamePlayView){
        this.gamePlayView = gamePlayView;
        this.gamePlayer = GamePlayer.getInstance();
        this.possession = new Possession(0, 0);
    }

    public void onStart(){
        this.gamePlayView.update(gamePlayer);
    }

    public void onMove(String direction){
        int x = gamePlayer.getHeroPossession().getX();
        int y = gamePlayer.getHeroPossession().getY();

        possession.setX(x);
        possession.setY(y);

        if (direction.equalsIgnoreCase("North"))
            y++;
        else if (direction.equalsIgnoreCase("East"))
            x++;
        else if (direction.equalsIgnoreCase("West"))
            x--;
        else if (direction.equalsIgnoreCase("South"))
            y--;

        if (x < 0 || y < 0 || x >= gamePlayer.getMapSize() || y >= gamePlayer.getMapSize()){
            winGame();
            return;
        }

        gamePlayer.getHeroPossession().setX(x);
        gamePlayer.getHeroPossession().setY(y);

        if (gamePlayer.getMap()[y][x]){
            villianCollid();
        }

        if (gamePlayer.getHero().getHitpoints() > 0)
            gamePlayView.update(gamePlayer);
    }

    private void villianCollid(){
        gamePlayView.getVillainCollisionInput();
    }

    public void onRun() {
        if (new Random().nextBoolean()) {
            gamePlayView.showMessage("You are lucky! And moved to previous position!");
            gamePlayer.getHeroPossession().setX(possession.getX());
            gamePlayer.getHeroPossession().setY(possession.getY());
        } else {
            gamePlayView.showMessage("You have to fight");
            onFight();
        }
    }

    private void winGame() {
        gamePlayView.showMessage("You win! And got additional " + gamePlayer.getMapSize() * 100 + "xp!");
        addExperience(gamePlayer.getMapSize() * 100);
        gamePlayView.gameFinished(gamePlayer.getHero());
    }

    public void onFight() {
        Villain villain = gamePlayer.generateVillain();
        int xp = gamePlayer.fightResult(villain);

        if (xp >= 0) {
            gamePlayView.showMessage("You win, and got " + xp + "xp.");
            addExperience(xp);
            gamePlayer.getMap()[gamePlayer.getHeroPossession().getY()][gamePlayer.getHeroPossession().getX()] = false;
            setArtifact(villain.getArtifact());
        } else {
            gamePlayView.showMessage("Game over :(");
            gamePlayView.gameFinished(gamePlayer.getHero());
        }
    }

    private void addExperience(int addXP) {
        int level = gamePlayer.getHero().getLevel();
        gamePlayer.getHero().heroExp(addXP);
        if (level != gamePlayer.getHero().getLevel())
            gamePlayView.showMessage("Level UP!\nHP, attack and defense were increased!");
    }

    private void setArtifact(Artifact artifact) {
        if (artifact != null) {
            if (artifact instanceof Weapon) {
                if (gamePlayer.getHero().getWeapon() == null || gamePlayView.replaceArtifact("your weapon: " + gamePlayer.getHero().getWeapon() + ", found: " + artifact)) {
                    gamePlayer.getHero().heroWeapon((Weapon) artifact);
                    gamePlayView.showMessage("You equipped new weapon: " + artifact);
                }
            } else if (artifact instanceof Helm) {
                if (gamePlayer.getHero().getHelm() == null || gamePlayView.replaceArtifact("your helmet: " + gamePlayer.getHero().getHelm() + ", found: " + artifact)) {
                    gamePlayer.getHero().heroHelm((Helm) artifact);
                    gamePlayView.showMessage("You equipped new helm: " + artifact);
                }
            } else if (artifact instanceof Armor) {
                if (gamePlayer.getHero().getArmor() == null || gamePlayView.replaceArtifact("your armor: " + gamePlayer.getHero().getArmor() + ", found: " + artifact)) {
                    gamePlayer.getHero().heroArmor((Armor) artifact);
                    gamePlayView.showMessage("You equipped new armor: " + artifact);
                }
            }
        }
    }
}