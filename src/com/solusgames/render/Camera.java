package com.solusgames.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    public Camera(OrthographicCamera camera) {
	this.cam = camera;
	cam.setToOrtho(false, Global.current_dim.width,
		Global.current_dim.height / 2);
    }

    /**
     * Centers this Camera on given entity
     * 
     * @param entity
     */
    public void centerOn(Entity entity) {
	if (Global.camCombined) {
	    cam.setToOrtho(false, Global.current_dim.width,
		    Global.current_dim.height);
	} else {
	    cam.setToOrtho(false, Global.current_dim.width,
		    Global.current_dim.height / 2);
	}

	cam.position.set(entity.getXpos(), entity.getYpos(), 0);

	if (cam == null) {
	    Gdx.app.error("ERROR", "WARNING! ERROR IN CAMERA");
	    return;
	}
	if (entity.getEType() == EntityType.PLAYER1) {
	    // camera constraint left
	    if (cam.position.x - (Global.current_dim.getWidth() / 2) <= 0) {
		cam.position.x = (float) (Global.current_dim.getWidth() / 2);
	    }
	    // camera constraint down
	    if (cam.position.y - (Global.current_dim.getHeight() / 4) <= 0) {
		cam.position.y = (float) (Global.current_dim.getHeight() / 4);
	    }
	    // camera constraint up
	    if (cam.position.y + (Global.current_dim.getHeight() / 4) >= (Global.currentMap
		    .getMap_columns() * Global.currentMap.getMap_tileHeight())) {
		cam.position.y = (Global.currentMap.getMap_columns() * Global.currentMap
			.getMap_tileHeight())
			- ((float) Global.current_dim.getHeight() / 4);
	    }
	    // camera constraint right
	    if (cam.position.x + (Global.current_dim.getWidth() / 2) >= (Global.currentMap
		    .getMap_rows() * Global.currentMap.getMap_tileWidth())) {
		cam.position.x = (Global.currentMap.getMap_rows() * Global.currentMap
			.getMap_tileWidth())
			- ((float) Global.current_dim.getWidth() / 2);
	    }
	} else if (entity.getEType() == EntityType.PLAYER2) {
	    // camera constraint left
	    if (cam.position.x - (Global.current_dim.getWidth() / 2) <= 0) {
		cam.position.x = (float) (Global.current_dim.getWidth() / 2);
	    }
	    // camera constraint down
	    if (cam.position.y - (Global.current_dim.getHeight() / 4) <= 0) {
		cam.position.y = (float) (Global.current_dim.getHeight() / 4);
	    }
	    // camera constraint up
	    if (cam.position.y + (Global.current_dim.getHeight() / 4) >= (Global.currentMap
		    .getMap_columns() * Global.currentMap.getMap_tileHeight())) {
		cam.position.y = (Global.currentMap.getMap_columns() * Global.currentMap
			.getMap_tileHeight())
			- ((float) Global.current_dim.getHeight() / 4);
	    }
	    // camera constraint right
	    if (cam.position.x + (Global.current_dim.getWidth() / 2) >= (Global.currentMap
		    .getMap_rows() * Global.currentMap.getMap_tileWidth())) {
		cam.position.x = (Global.currentMap.getMap_rows() * Global.currentMap
			.getMap_tileWidth())
			- ((float) Global.current_dim.getWidth() / 2);
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
