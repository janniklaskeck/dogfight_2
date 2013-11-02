package com.solusgames.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.solusgames.Dogfight_2.Global;

public class Render {

    SpriteBatch batch = new SpriteBatch();
    Texture bg = new Texture(Gdx.files.internal("assets/data/img_bg.jpg"));

    public void render() {
	batch.begin();
	// basic bg img
	batch.draw(bg, 0, 0, Global.dim_720.getWidth(),
		Global.dim_720.getHeight());
	Global.player1.render(batch);
	
	// TODO: render loop

	batch.end();
    }
}
