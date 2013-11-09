package com.solusgames.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;
import com.solusgames.entities.Entity.EntityType;

/**
 * Camara class with own constraints
 * 
 * @author keckjs
 * 
 */
public class Camera {

    private OrthographicCamera cam;

    /**
     * 
     * @param camera
     * @param map
     */
    public Camera(OrthographicCamera camera, TiledMap ma) {
	this.cam = camera;
	cam.setToOrtho(false, Global.dim_720.width, Global.dim_720.height / 2);
    }

    /**
     * Centers this Camera on given entity
     * 
     * @param entity
     */
    public void centerOn(Entity entity) {
	
	cam.position.set(entity.getXpos(), entity.getYpos(), 0);

	if (cam == null) {
	    Gdx.app.error("ERROR", "WARNING! ERROR IN CAMERA");
	    return;
	}
	if (entity.getEType() == EntityType.PLAYER1) {
	    // camera constraint left
	    if (cam.position.x - (Global.dim_720.getWidth() / 2) <= 0) {
		cam.position.x = (float) (Global.dim_720.getWidth() / 2);
	    }
	    // camera constraint down
	    if (cam.position.y - (Global.dim_720.getHeight() / 4) <= 0) {
		cam.position.y = (float) (Global.dim_720.getHeight() / 4);
	    }
	    // camera constraint up
	    if (cam.position.y + (Global.dim_720.getHeight() / 4) >= (Global.map_columns * Global.map_tileHeight)) {
		cam.position.y = (Global.map_columns * Global.map_tileHeight)
			- ((float) Global.dim_720.getHeight() / 4);
	    }
	    // camera constraint right
	    if (cam.position.x + (Global.dim_720.getWidth() / 2) >= (Global.map_rows * Global.map_tileWidth)) {
		cam.position.x = (Global.map_rows * Global.map_tileWidth)
			- ((float) Global.dim_720.getWidth() / 2);
	    }
	} else if (entity.getEType() == EntityType.PLAYER2) {
	    // camera constraint left
	    if (cam.position.x - (Global.dim_720.getWidth() / 2) <= 0) {
		cam.position.x = (float) (Global.dim_720.getWidth() / 2);
	    }
	    // camera constraint down
	    if (cam.position.y - (Global.dim_720.getHeight() / 4) <= 0) {
		cam.position.y = (float) (Global.dim_720.getHeight() / 4);
	    }
	    // camera constraint up
	    if (cam.position.y + (Global.dim_720.getHeight() / 4) >= (Global.map_columns * Global.map_tileHeight)) {
		cam.position.y = (Global.map_columns * Global.map_tileHeight)
			- ((float) Global.dim_720.getHeight() / 4);
	    }
	    // camera constraint right
	    if (cam.position.x + (Global.dim_720.getWidth() / 2) >= (Global.map_rows * Global.map_tileWidth)) {
		cam.position.x = (Global.map_rows * Global.map_tileWidth)
			- ((float) Global.dim_720.getWidth() / 2);
	    }
	}
	cam.update();
    }

    /**
     * Returns Orthographic camera
     * 
     * @return cam
     */
    public OrthographicCamera getCam() {
	return cam;
    }

    /**
     * Sets Orthographic camera
     * 
     * @param cam
     */
    public void setCam(OrthographicCamera cam) {
	this.cam = cam;
    }

}
