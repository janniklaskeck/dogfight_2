package com.solusgames.Dogfight_2;

import com.badlogic.gdx.Game;
import com.solusgames.screens.Screen;
import com.solusgames.screens.ScreenManager;

public class GameMain extends Game {

    @Override
    public void create() {
	ScreenManager.getInstance().initialize(this);
	ScreenManager.getInstance().show(Screen.MAIN_MENU);

    }

    @Override
    public void dispose() {
	super.dispose();
	ScreenManager.getInstance().dispose();
    }

}
