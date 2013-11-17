package com.solusgames.screens.handler;

import com.badlogic.gdx.Gdx;
import com.solusgames.controls.Controls;
import com.solusgames.screens.Screen;
import com.solusgames.screens.ScreenManager;
import com.solusgames.screens.parts.Button.ButtonHandler;

public class ScreenSwitchHandler implements ButtonHandler {
	
	private Screen screen = null;
	
	public ScreenSwitchHandler(Screen screen) {
		this.screen = screen;
	}

	@Override
	public void onClick() {
		/* easily implemented screen switching thanks to singleton pattern */
		ScreenManager.getInstance().show(screen);
		// TODO: remove when possible
		Gdx.input.setInputProcessor(new Controls());
	}

}