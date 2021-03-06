package com.swingy.view.gameplay;

import com.swingy.model.game.GamePlayer;
import com.swingy.model.players.Hero;

public interface GamePlay {
    void start();
    void update(GamePlayer game);
    void gameFinished(Hero hero);
    void showMessage(String message);
    void getVillainCollisionInput();
    boolean replaceArtifact(String replaceMessage);
}
