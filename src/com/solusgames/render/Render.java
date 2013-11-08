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

    int[] layers = new int[1];
    SpriteBatch player1_batch = new SpriteBatch();
    SpriteBatch player2_batch = new SpriteBatch();
    SpriteBatch ui_batch = new SpriteBatch();
    Texture bg = new Texture(Gdx.files.internal("assets/data/img_bg.jpg"));

    Rectangle viewportPlayer2 = new Rectangle(0, 0, Global.dim_720.getWidth(),
	    Global.dim_720.getHeight() / 2);
    Rectangle viewportPlayer1 = new Rectangle(0,
	    Global.dim_720.getHeight() / 2, Global.dim_720.getWidth(),
	    Global.dim_720.getHeight() / 2);

    /**
     * Render method
     */
    public void render() {
	layers[0] = 1;

	// player 1 stuff
	player1_batch.begin();
	// clear screen
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
	// set viewport player 1
	Gdx.gl20.glViewport((int) viewportPlayer1.x, (int) viewportPlayer1.y,
		(int) viewportPlayer1.width, (int) viewportPlayer1.height);

	player1_batch
		.setProjectionMatrix(Global.camera_player1.getCam().combined);
	// basic bg img
	player1_batch.draw(bg, 0, 0, Global.map.width * Global.map.tileWidth,
		Global.map.height * Global.map.tileHeight);

	Global.player1.render(player1_batch);
	Global.player2.render(player1_batch);

	Global.map_renderer.render(Global.camera_player1.getCam(), layers);

	player1_batch.end();

	// player 2 stuff
	player2_batch.begin();
	// set viewport player 2
	Gdx.gl20.glViewport((int) viewportPlayer2.x, (int) viewportPlayer2.y,
		(int) viewportPlayer2.width, (int) viewportPlayer2.height);

	player2_batch
		.setProjectionMatrix(Global.camera_player2.getCam().combined);
	// basic bg img
	player2_batch.draw(bg, 0, 0, Global.map.width * Global.map.tileWidth,
		Global.map.height * Global.map.tileHeight);
	Global.player1.render(player2_batch);
	Global.player2.render(player2_batch);

	Global.map_renderer.render(Global.camera_player2.getCam(), layers);
	player2_batch.end();

	// ui components
	ui_batch.begin();
	Gdx.gl20.glViewport(0, 0, Global.dim_720.getWidth(),
		Global.dim_720.getHeight());
	BitmapFont font = new BitmapFont();

	font.draw(ui_batch, "" + Gdx.graphics.getFramesPerSecond(),
		Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - 50);

	ui_batch.end();
    }
}
