package com.swingy.view.gameplay;

import com.swingy.model.game.GamePlayer;
import com.swingy.model.players.Hero;
import com.swingy.model.players.Possession;

public interface GamePlay {
    void start();

    void printMap(boolean[][] map, Possession heroPossession);

    void update(GamePlayer game);

    void gameFinished(Hero hero);

    void showMessage(String message);

    void getVillainCollisionInput();

    boolean replaceArtifact(String replaceMessage);

    void gameContinue(Hero hero);
}
