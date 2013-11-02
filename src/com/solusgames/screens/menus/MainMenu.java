package com.solusgames.screens.menus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.solusgames.screens.MainMenuScreen;

public class MainMenu extends Game {

    @Override
    public void create() {
	setScreen(new MainMenuScreen(this));

    }

    @Override
    public void dispose() {
	Gdx.app.exit();
    }

}
