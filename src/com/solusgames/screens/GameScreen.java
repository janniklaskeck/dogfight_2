package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.tiled.SimpleTileAtlas;
import com.badlogic.gdx.graphics.g2d.tiled.TileMapRenderer;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.controls.Controls;
import com.solusgames.entities.Entity.EntityType;
import com.solusgames.entities.planes.Plane;
import com.solusgames.entities.planes.Planetype;
import com.solusgames.render.Camera;
import com.solusgames.render.Render;

public class GameScreen implements Screen {
    Controls c = new Controls();
    Render r = new Render();
    

    @Override
    public void dispose() {
	// TODO Auto-generated method stub

    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub

    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    /**
     * Update method
     */
    public void update() {
	c.input();
	Global.player1.update();
	Global.camera_player1.centerOn(Global.player1);
	Global.player2.update();
	Global.camera_player2.centerOn(Global.player2);
System.out.println(Gdx.graphics.getFramesPerSecond());

    }

    @Override
    public void render(float delta) {
	// System.out.println(Gdx.graphics.getFramesPerSecond());
	update();
	r.render();

    }

    @Override
    public void resize(int width, int height) {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public void show() {
	Global.player1 = new Plane(100, 100, 0, new Planetype(100, 6, 1, 2,
		true, true, true, true, new Texture(
			Gdx.files.internal("assets/data/planes/plane1.png"))),
		EntityType.PLAYER1);
	
	Global.player2 = new Plane(200, 200, 0, new Planetype(100, 6, 1, 2,
		true, true, true, true, new Texture(
			Gdx.files.internal("assets/data/planes/plane1.png"))),
		EntityType.PLAYER2);

	Global.map = TiledLoader.createMap(Gdx.files
		.internal("assets/data/map/map_test/map2.tmx"));
	Global.atlas = new SimpleTileAtlas(Global.map,
		Gdx.files.internal("assets/data/map/map_test"));
	Global.map_renderer = new TileMapRenderer(Global.map, Global.atlas,
		Global.map.tileWidth, Global.map.tileHeight,
		Global.map.tileWidth, Global.map.tileHeight);

	Global.camera_player1 = new Camera(new OrthographicCamera(
		Global.dim_720.getWidth(), Global.dim_720.getHeight() / 2),
		Global.map);
	
	Global.camera_player2 = new Camera(new OrthographicCamera(
		Global.dim_720.getWidth(), Global.dim_720.getHeight() / 2),
		Global.map);
    }

}
