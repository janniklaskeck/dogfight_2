package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity.EntityType;
import com.solusgames.entities.planes.Plane;
import com.solusgames.entities.planes.Planetype;
import com.solusgames.map.Map;
import com.solusgames.render.Camera;
import com.solusgames.render.Render;

public class GameScreen implements Screen {
    Render r = new Render();

    public GameScreen() {

    }

    @Override
    public void dispose() {
	r.dispose();
	Global.currentMap.dispose();
	Global.player1.dispose();
	Global.player2.dispose();

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
    public void update(float delta) {
	Global.camera_ui.setToOrtho(false, Global.current_dim.width,
		Global.current_dim.height);
	Global.camera_ui.position.set(0, 0, 0);
	Global.camera_ui.update();
	Global.player1.update(delta);
	Global.camera_player1.centerOn(Global.player1);
	Global.player2.update(delta);
	Global.camera_player2.centerOn(Global.player2);
	checkPlayerDistance();

    }

    /**
     * Checks if players are close enough for a camera merge
     */
    private void checkPlayerDistance() {
	if (getYDistance() < (Global.current_dim.getHeight() / 2)
		* (Global.current_dim.getHeight() / 2)
		&& getXDistance() < (Global.current_dim.getWidth() / 2)
			* (Global.current_dim.getWidth() / 2)) {
	    Global.camCombined = true;
	} else {
	    Global.camCombined = false;
	}
    }

    @Override
    public void render(float delta) {
	update(delta * 100);
	r.render(delta);
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

	Global.currentMap = new Map("map2.tmx");
	createPlayers();
    }

    /**
     * Creates players and cameras
     */
    private void createPlayers() {
	Global.camera_player1 = new Camera(new OrthographicCamera());
	Global.camera_player2 = new Camera(new OrthographicCamera());
	Global.camera_ui = new OrthographicCamera();

	Global.player1 = new Plane(300,
		(Global.currentMap.getMap_columns() * Global.currentMap
			.getMap_tileHeight()) / 2, 0, new Planetype(100, 6, 1,
			2, true, true, true, true,
			new Texture(Gdx.files
				.internal("assets/data/planes/gen5/f35.png"))),
		EntityType.PLAYER1);

	Global.player2 = new Plane(
		(Global.currentMap.getMap_rows() * Global.currentMap
			.getMap_tileWidth()) - 300,
		(Global.currentMap.getMap_columns() * Global.currentMap
			.getMap_tileHeight()) / 2, 0, new Planetype(100, 6, 1,
			2, true, true, true, true, new Texture(Gdx.files
				.internal("assets/data/planes/plane1.png"))),
		EntityType.PLAYER2);
    }

    /**
     * Returns vertical distance between player 1 and player 2
     * 
     * @return distance
     */
    public static float getYDistance() {
	float d_y = (Global.player1.getYpos() - Global.player2.getYpos());
	return (d_y * d_y);
    }

    /**
     * Returns horizontal distance between player 1 and player 2
     * 
     * @return distance
     */
    public static float getXDistance() {
	float d_x = (Global.player1.getXpos() - Global.player2.getXpos());
	return (d_x * d_x);
    }
}
