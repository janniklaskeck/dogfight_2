package com.solusgames.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.solusgames.Dogfight_2.Global;

/**
 * Render class with render loop Should inherit all things which need rendering
 * 
 * @author keckjs
 * 
 */
public class Render {

    BitmapFont font = new BitmapFont();
    Texture bg = new Texture(Gdx.files.internal("assets/data/img_bg.jpg"));

    Rectangle viewportPlayer1 = new Rectangle();
    Rectangle viewportPlayer2 = new Rectangle();
    Rectangle viewportCombined = new Rectangle();
    Rectangle viewportUI = new Rectangle();

    /**
     * Render method
     */
    public void render() {
	if (Global.singlePlayer) {
	    renderSingleplayer(Global.batch);
	} else if (!Global.singlePlayer) {
	    renderMultiplayer(Global.batch);
	}
    }

    /**
     * Singleplayer render
     * 
     * @param batch
     */
    public void renderSingleplayer(SpriteBatch batch) {
	viewportPlayer1.set(0, (float) Global.current_dim.getHeight() / 2,
		(float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight() / 2);
	viewportUI.set(0, 0, (float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight());

	int[] layers = new int[1];
	layers[0] = 1;
	// clear screen
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

	// player 1 stuff
	Global.batch.begin();

	// set viewport player 1
	Gdx.gl20.glViewport((int) viewportPlayer1.x, (int) viewportPlayer1.y,
		(int) viewportPlayer1.width, (int) viewportPlayer1.height);

	Global.batch
		.setProjectionMatrix(Global.camera_player1.getCam().combined);
	// basic bg img
	Global.batch.draw(bg, 0, 0, Global.map_rows * Global.map_tileWidth,
		Global.map_columns * Global.map_tileHeight);

	Global.player1.render(Global.batch);
	Global.player2.render(Global.batch);

	Global.map_renderer.setView(Global.camera_player1.getCam());
	Global.map_renderer.render();

	Global.batch.end();
	// ui components
	Global.batch.begin();

	Global.batch.setProjectionMatrix(Global.camera_ui.combined);
	Gdx.gl20.glViewport(0, 0, (int) viewportUI.width,
		(int) viewportUI.height);

	font.draw(Global.batch, "" + Gdx.graphics.getFramesPerSecond(), 300,
		Gdx.graphics.getHeight() / 2);

	Global.batch.end();
    }

    /**
     * Multiplayer render
     * 
     * @param batch
     */
    public void renderMultiplayer(SpriteBatch batch) {
	viewportPlayer2.set(0, 0, (float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight() / 2);
	viewportPlayer1.set(0, (float) Global.current_dim.getHeight() / 2,
		(float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight() / 2);
	viewportUI.set(0, 0, (float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight());
	viewportCombined.set(0, 0, (float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight());

	int[] layers = new int[1];
	layers[0] = 1;
	// clear screen
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
	// player 1 stuff
	Global.batch
		.setProjectionMatrix(Global.camera_player1.getCam().combined);
	Global.batch.begin();

	// set viewport player 1
	Gdx.gl20.glViewport((int) viewportPlayer1.x, (int) viewportPlayer1.y,
		(int) viewportPlayer1.width, (int) viewportPlayer1.height);

	// basic bg img
	Global.batch.draw(bg, 0, 0, Global.map_rows * Global.map_tileWidth,
		Global.map_columns * Global.map_tileHeight);

	Global.player1.render(Global.batch);
	Global.player2.render(Global.batch);

	Global.map_renderer.setView(Global.camera_player1.getCam());
	Global.map_renderer.render();

	Global.batch.end();
	// player 2 stuff
	Global.batch
		.setProjectionMatrix(Global.camera_player2.getCam().combined);

	Global.batch.begin();
	// set viewport player 2
	Gdx.gl20.glViewport((int) viewportPlayer2.x, (int) viewportPlayer2.y,
		(int) viewportPlayer2.width, (int) viewportPlayer2.height);

	// basic bg img
	Global.batch.draw(bg, 0, 0, Global.map_rows * Global.map_tileWidth,
		Global.map_columns * Global.map_tileHeight);

	Global.player1.render(Global.batch);
	Global.player2.render(Global.batch);

	Global.map_renderer.setView(Global.camera_player2.getCam());
	Global.map_renderer.render();
	Global.batch.end();
	// ui components

	Global.batch.setProjectionMatrix(Global.camera_ui.combined);
	Global.batch.begin();
	Gdx.gl20.glViewport(0, 0, (int) viewportUI.width,
		(int) viewportUI.height);

	font.draw(Global.batch, "A" + Gdx.graphics.getFramesPerSecond(), -100,
		-100);

	Global.batch.end();
    }

    public void dispose() {
	Global.batch.dispose();
	font.dispose();
	bg.dispose();
    }
}
