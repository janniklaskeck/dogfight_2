package com.solusgames.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity.EntityType;
import com.solusgames.entities.planes.Plane;
import com.solusgames.entities.planes.Planetype;
import com.solusgames.render.Camera;
import com.solusgames.render.Render;

public class GameScreen implements Screen {
    Render r = new Render();

    public GameScreen() {

    }

    @Override
    public void dispose() {
	r.dispose();
	Global.map_renderer.dispose();
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
    public void update() {
	Global.camera_ui.setToOrtho(false, Global.current_dim.width,
		Global.current_dim.height);
	Global.camera_ui.position.set(0, 0, 0);
	Global.camera_ui.update();
	Global.player1.update();
	Global.camera_player1.centerOn(Global.player1);
	Global.player2.update();
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

	createMap();
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
     * Creates the map with collision polygons
     */
    private void createMap() {
	Global.col_map = new ArrayList<>();
	Global.map = new TmxMapLoader()
		.load("assets/data/map/map_test/map2.tmx");
	Global.map_renderer = new OrthogonalTiledMapRenderer(Global.map, 1);

	TiledMapTileLayer l = (TiledMapTileLayer) Global.map.getLayers().get(0);
	Global.map_columns = l.getHeight();
	Global.map_rows = l.getWidth();
	Global.map_tileHeight = l.getTileHeight();
	Global.map_tileWidth = l.getTileWidth();

	for (int i = 0; i < Global.map_rows; i++) {
	    for (int e = 0; e < Global.map_columns; e++) {
		if (l.getCell(i, e) != null) {
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("half")) {
			ArrayList<Vector2> list = new ArrayList<>();
			list.add(new Vector2(i * Global.map_tileWidth + 0, e
				* Global.map_tileHeight + 0));
			list.add(new Vector2(i * Global.map_tileWidth + 0, e
				* Global.map_tileHeight + Global.map_tileHeight
				/ 2));
			list.add(new Vector2(i * Global.map_tileWidth
				+ Global.map_tileWidth, e
				* Global.map_tileHeight + 0));
			list.add(new Vector2(i * Global.map_tileWidth
				+ Global.map_tileWidth, e
				* Global.map_tileHeight + Global.map_tileHeight
				/ 2));
			Global.col_map.add(list);
		    }
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("full")) {
			ArrayList<Vector2> list = new ArrayList<>();
			list.add(new Vector2(i * Global.map_tileWidth + 0, e
				* Global.map_tileHeight + 0));
			list.add(new Vector2(i * Global.map_tileWidth + 0, e
				* Global.map_tileHeight + Global.map_tileHeight));
			list.add(new Vector2(i * Global.map_tileWidth
				+ Global.map_tileWidth, e
				* Global.map_tileHeight + 0));
			list.add(new Vector2(i * Global.map_tileWidth
				+ Global.map_tileWidth, e
				* Global.map_tileHeight + Global.map_tileHeight));
			Global.col_map.add(list);
		    }
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("triangle_l")) {
			ArrayList<Vector2> list = new ArrayList<>();
			list.add(new Vector2(i * Global.map_tileWidth + 0, e
				* Global.map_tileHeight + 0));
			list.add(new Vector2(i * Global.map_tileWidth
				+ Global.map_tileWidth, e
				* Global.map_tileHeight + 0));
			list.add(new Vector2(i * Global.map_tileWidth + 0, e
				* Global.map_tileHeight + Global.map_tileHeight));
			Global.col_map.add(list);
		    }
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("triangle_r")) {
			ArrayList<Vector2> list = new ArrayList<>();
			list.add(new Vector2(i * Global.map_tileWidth + 0, e
				* Global.map_tileHeight));
			list.add(new Vector2(i * Global.map_tileWidth
				+ Global.map_tileWidth, e
				* Global.map_tileHeight + 0));
			list.add(new Vector2(i * Global.map_tileWidth
				+ Global.map_tileWidth, e
				* Global.map_tileHeight + Global.map_tileHeight));
			Global.col_map.add(list);
		    }
		}
	    }
	}
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
