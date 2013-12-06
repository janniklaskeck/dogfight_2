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

    public Render() {
	viewportPlayer2.set(0, 0, (float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight() / 2);
	viewportPlayer1.set(0, (float) Global.current_dim.getHeight() / 2,
		(float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight() / 2);
	viewportUI.set(0, 0, (float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight());
	viewportCombined.set(0, 0, (float) Global.current_dim.getWidth(),
		(float) Global.current_dim.getHeight());
    }

    /**
     * Render method
     */
    public void render(float delta) {
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
	// clear screen
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

	renderPlayer1(viewportUI);
	renderUI();
    }

    /**
     * Multiplayer render
     * 
     * @param batch
     */
    public void renderMultiplayer(SpriteBatch batch) {
	// clear screen
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

	if (Global.camCombined) {
	    renderPlayer1(viewportUI);

	} else {
	    renderPlayer1(viewportPlayer1);
	    renderPlayer2();
	}

	renderUI();
    }

    /**
     * Helper method for rendering player 1
     */
    private void renderPlayer1(Rectangle rect) {
	// player 1 stuff
	Global.batch
		.setProjectionMatrix(Global.camera_player1.getCam().combined);
	Global.batch.begin();

	// set viewport player 1
	setGL20Viewport(rect);

	// basic bg img
	Global.batch.draw(
		bg,
		0,
		0,
		Global.currentMap.getMap_rows()
			* Global.currentMap.getMap_tileWidth(),
		Global.currentMap.getMap_columns()
			* Global.currentMap.getMap_tileHeight());

	Global.player1.render(Global.batch);
	Global.player2.render(Global.batch);

	Global.currentMap.getMap_renderer().setView(
		Global.camera_player1.getCam());
	Global.currentMap.getMap_renderer().render();
	Global.batch.end();

    }

    /**
     * Helper method for rendering player 2
     */
    private void renderPlayer2() {
	// player 2 stuff
	Global.batch
		.setProjectionMatrix(Global.camera_player2.getCam().combined);

	Global.batch.begin();
	// set viewport player 2
	setGL20Viewport(viewportPlayer2);

	// basic bg img
	Global.batch.draw(
		bg,
		0,
		0,
		Global.currentMap.getMap_rows()
			* Global.currentMap.getMap_tileWidth(),
		Global.currentMap.getMap_columns()
			* Global.currentMap.getMap_tileHeight());

	Global.player1.render(Global.batch);
	Global.player2.render(Global.batch);

	Global.currentMap.getMap_renderer().setView(
		Global.camera_player2.getCam());
	Global.currentMap.getMap_renderer().render();

	Global.batch.end();

    }

    /**
     * Helper method for rendering the UI
     */
    private void renderUI() {
	// ui components

	Global.batch.setProjectionMatrix(Global.camera_ui.combined);
	Global.batch.begin();
	setGL20Viewport(viewportUI);

	font.draw(Global.batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 0,
		(Gdx.graphics.getHeight() / 2) - 25);
	font.draw(Global.batch, "P1 Health: " + Global.player1.getHitpoints(),
		-100, (Gdx.graphics.getHeight() / 2) - 25);
	font.draw(Global.batch, "P2 Health: " + Global.player2.getHitpoints(),
		100, (Gdx.graphics.getHeight() / 2) - 25);
	font.draw(Global.batch, "Delta: " + Gdx.graphics.getDeltaTime(), 0,
		(Gdx.graphics.getHeight() / 2) - 50);

	Global.batch.end();
    }

    /**
     * Helper method for opengl 2.0 viewport
     * 
     * @param rect
     */
    public void setGL20Viewport(Rectangle rect) {
	Gdx.gl20.glViewport((int) rect.x, (int) rect.y, (int) rect.width,
		(int) rect.height);
    }

    /**
     * Dispose method
     */
    public void dispose() {
	Global.batch.dispose();
	font.dispose();
	bg.dispose();
    }
}
