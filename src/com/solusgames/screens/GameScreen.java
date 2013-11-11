package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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
	r.dispose();
	Global.map_renderer.dispose();

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
	Global.camera_ui.setToOrtho(false, Global.current_dim.width,
		Global.current_dim.height);
	Global.camera_ui.position.set(0, 0, 0);
	Global.camera_ui.update();
	Global.player1.update();
	Global.camera_player1.centerOn(Global.player1);
	Global.player2.update();
	Global.camera_player2.centerOn(Global.player2);

	if (getYDistance() < (Global.current_dim.getHeight() / 2)
		* (Global.current_dim.getHeight() / 2) && getXDistance() < (Global.current_dim.getWidth() / 2)
		* (Global.current_dim.getWidth() / 2)) {
	    Global.camCombined = true;
	} else {
	    Global.camCombined = false;
	}

    }

    @Override
    public void render(float delta) {

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

	OnStartUp();
    }

    /**
     * First initialisation
     */
    public void OnStartUp() {
	Global.batch = new SpriteBatch();

	Global.map = new TmxMapLoader()
		.load("assets/data/map/map_test/map2.tmx");
	Global.map_renderer = new OrthogonalTiledMapRenderer(Global.map, 1);
	Global.camera_player1 = new Camera(new OrthographicCamera());
	Global.camera_player2 = new Camera(new OrthographicCamera());
	Global.camera_ui = new OrthographicCamera();

	TiledMapTileLayer l = (TiledMapTileLayer) Global.map.getLayers().get(0);
	Global.map_columns = l.getHeight();
	Global.map_rows = l.getWidth();
	Global.map_tileHeight = l.getTileHeight();
	Global.map_tileWidth = l.getTileWidth();

	Global.player1 = new Plane(300,
		(Global.map_columns * Global.map_tileHeight) / 2, 0,
		new Planetype(100, 6, 1, 2, true, true, true, true,
			new Texture(Gdx.files
				.internal("assets/data/planes/gen5/f35.png"))),
		EntityType.PLAYER1);

	Global.player2 = new Plane(
		(Global.map_rows * Global.map_tileWidth) - 300,
		(Global.map_columns * Global.map_tileHeight) / 2, 0,
		new Planetype(100, 6, 1, 2, true, true, true, true,
			new Texture(Gdx.files
				.internal("assets/data/planes/plane1.png"))),
		EntityType.PLAYER2);

    }

    /**
     * Returns vertical distance between player 1 and player 2
     * 
     * @return distance
     */
    public float getYDistance() {
	float d_y = (Global.player1.getYpos() - Global.player2.getYpos());
	return (d_y * d_y);
    }

    /**
     * Returns horizontal distance between player 1 and player 2
     * 
     * @return distance
     */
    public float getXDistance() {
	float d_x = (Global.player1.getXpos() - Global.player2.getXpos());
	return (d_x * d_x);
    }
}
