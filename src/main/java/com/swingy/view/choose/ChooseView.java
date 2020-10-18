package com.swingy.view.choose;

public interface ChooseView {
    public void start();
    public void updateInfo(String info);
    public void showErrorMessage(String message);
    public void openGame();
    public void openCreateHero();
}
