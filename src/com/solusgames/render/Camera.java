package com.solusgames.render;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
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
    private TiledMap map;

    /**
     * 
     * @param camera
     * @param map
     */
    public Camera(OrthographicCamera camera, TiledMap map) {
	this.cam = camera;
	this.map = map;
    }

    /**
     * Centers this Camera on given entity
     * 
     * @param entity
     */
    public void centerOn(Entity entity) {

	cam.position.set(entity.getXpos(), entity.getYpos(), 0);

	if (map == null || cam == null) {
	    System.out.println("WARNING! ERROR IN CAMERA");
	    return;
	}
	if (entity.getEType() == EntityType.PLAYER1) {
	    // camera constraint left
	    if (cam.position.x - Global.dim_720.getWidth() / 2 <= 0) {
		cam.position.x = Global.dim_720.getWidth() / 2;
	    }
	    // camera constraint down
	    if (cam.position.y - Global.dim_720.getHeight() / 4 <= 0) {
		cam.position.y = Global.dim_720.getHeight() / 4;
	    }
	    // camera constraint up
	    if (cam.position.y + Global.dim_720.getHeight() / 4 >= (map.height * map.tileHeight)) {
		cam.position.y = (map.height * map.tileHeight)
			- Global.dim_720.getHeight() / 4;
	    }
	    // camera constraint right
	    if (cam.position.x + Global.dim_720.getWidth() / 2 >= (map.width * map.tileWidth)) {
		cam.position.x = (map.width * map.tileWidth)
			- Global.dim_720.getWidth() / 2;
	    }
	} else if (entity.getEType() == EntityType.PLAYER2) {
	    // camera constraint left
	    if (cam.position.x - Global.dim_720.getWidth() / 2 <= 0) {
		cam.position.x = Global.dim_720.getWidth() / 2;
	    }
	    // camera constraint down
	    if (cam.position.y - Global.dim_720.getHeight() / 4 <= 0) {
		cam.position.y = Global.dim_720.getHeight() / 4;
	    }
	    // camera constraint up
	    if (cam.position.y + Global.dim_720.getHeight() / 4 >= (map.height * map.tileHeight)) {
		cam.position.y = (map.height * map.tileHeight)
			- Global.dim_720.getHeight() / 4;
	    }
	    // camera constraint right
	    if (cam.position.x + Global.dim_720.getWidth() / 2 >= (map.width * map.tileWidth)) {
		cam.position.x = (map.width * map.tileWidth)
			- Global.dim_720.getWidth() / 2;
	    }
	} else {

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

    /**
     * Returns tiled map
     * 
     * @return
     */
    public TiledMap getMap() {
	return map;
    }

    /**
     * Sets tiled map
     * 
     * @param map
     */
    public void setMap(TiledMap map) {
	this.map = map;
    }

}
