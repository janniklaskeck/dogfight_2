package com.solusgames.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.solusgames.Dogfight_2.Global;

/**
 * Render class with render loop
 * Should inherit all things which need rendering
 * @author keckjs
 *
 */
public class Render {

    SpriteBatch batch = new SpriteBatch();
    SpriteBatch batch1 = new SpriteBatch();
    Texture bg = new Texture(Gdx.files.internal("assets/data/img_bg.jpg"));

    Rectangle viewportPlayer2 = new Rectangle(0, 0, Global.dim_720.getWidth(),
	    Global.dim_720.getHeight() / 2);
    Rectangle viewportPlayer1 = new Rectangle(0, Global.dim_720.getHeight() / 2, Global.dim_720.getWidth(),
	    Global.dim_720.getHeight() / 2);

    /**
     * Render method
     */
    public void render() {
	int[] a = new int[1];
	a[0] = 1;
	batch.begin();
	
	// clear screen
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

	// set viewport player 1
	Gdx.gl20.glViewport((int) viewportPlayer1.x, (int) viewportPlayer1.y,
		(int) viewportPlayer1.width, (int) viewportPlayer1.height);
	
	batch.setProjectionMatrix(Global.camera_player1.getCam().combined);
	// basic bg img
	batch.draw(bg, 0, 0, Global.map.width * Global.map.tileWidth, Global.map.height * Global.map.tileHeight);
	
	Global.player1.render(batch);
	Global.player2.render(batch);
	
	Global.map_renderer.render(Global.camera_player1.getCam(), a);
	
	batch.end();
	batch1.begin();
	
	Gdx.gl20.glViewport((int) viewportPlayer2.x, (int) viewportPlayer2.y,
		(int) viewportPlayer2.width, (int) viewportPlayer2.height);
	
	batch1.setProjectionMatrix(Global.camera_player2.getCam().combined);
	// basic bg img
	batch1.draw(bg, 0, 0, Global.map.width * Global.map.tileWidth, Global.map.height * Global.map.tileHeight);
	Global.player1.render(batch1);
	Global.player2.render(batch1);
	
	Global.map_renderer.render(Global.camera_player2.getCam(), a);
	// TODO: render loop
	
	
	batch1.end();
    }
}
