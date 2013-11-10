package com.solusgames.Dogfight_2;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.solusgames.screens.menus.MainMenu;

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

	new LwjglApplication(new MainMenu(), cfg);
    }

    Stage stage;
    Image image;

    @Override
    public void create() {
	stage = new Stage();

	Texture tex = new Texture("assets/data/libgdx.png");
	image = new Image(tex);

	stage.addActor(image);
    }

    @Override
    public void resize(int width, int height) {
	stage.setViewport(width, height, true);
    }

    @Override
    public void render() {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	stage.act(Gdx.graphics.getDeltaTime());
	stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
	stage.dispose();
    }

}