package com.solusgames.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.solusgames.Dogfight_2.Global;

public class Render {

    SpriteBatch batch = new SpriteBatch();
    Texture bg = new Texture(Gdx.files.internal("assets/data/img_bg.jpg"));

    Rectangle glViewport = new Rectangle(0, 0, Global.dim_720.getWidth(),
	    Global.dim_720.getHeight() / 2);

    public void render() {

	batch.begin();
	int[] a = new int[1];
	a[0] = 1;
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

	Gdx.gl20.glViewport((int) glViewport.x, (int) glViewport.y,
		(int) glViewport.width, (int) glViewport.height);
	batch.setProjectionMatrix(Global.camera_player1.combined);
	// basic bg img
	batch.draw(bg, 0, 0, Global.map.width * Global.map.tileWidth, Global.map.height * Global.map.tileHeight);
	Global.player1.render(batch);
	Global.map_renderer.render(Global.camera_player1, a);
	// TODO: render loop

	batch.end();
    }
}
