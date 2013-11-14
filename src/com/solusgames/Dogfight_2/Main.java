package com.solusgames.Dogfight_2;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main implements ApplicationListener {

    public static void main(String[] args) {
	LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	cfg.width = (int) Global.current_dim.getWidth();
	cfg.height = (int) Global.current_dim.getHeight();
	cfg.fullscreen = Global.fullscreen;
	cfg.vSyncEnabled = Global.vsync;
	
	cfg.resizable = false;
	cfg.useGL20 = true; // 90% or more of your desktop users should support
			    // GL20

	new LwjglApplication(new GameMain(), cfg);
    }


    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

}
