package com.solusgames.screens;

public enum Screen {

    INTRO {
	@Override
	protected com.badlogic.gdx.Screen getScreenInstance() {
	    return null;
	}
    },

    MAIN_MENU {
	@Override
	protected com.badlogic.gdx.Screen getScreenInstance() {
	    return new MainMenuScreen();
	}
    },

    GAME {
	@Override
	protected com.badlogic.gdx.Screen getScreenInstance() {
	    return new GameScreen();
	}
    },

    OPTIONS {
	@Override
	protected com.badlogic.gdx.Screen getScreenInstance() {
	    return new OptionsScreen();
	}
    };

    protected abstract com.badlogic.gdx.Screen getScreenInstance();

}
