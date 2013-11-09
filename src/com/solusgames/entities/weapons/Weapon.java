package com.solusgames.entities.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;

public class Weapon extends Entity {

    private Weapontype type;
    private boolean alive;

    public Weapon(float x, float y, float angle, Weapontype type) {
	super(x, y, angle, 0, EntityType.WEAPON);
	alive = true;
	this.type = type;
    }

    public void render(SpriteBatch batch) {
	batch.end();
	batch.begin();
	
	batch.draw(type.getTexture(), xpos, ypos,
		type.getTexture().getWidth() / 2,
		type.getTexture().getHeight() / 2, (float) type.getTexture()
			.getWidth(), (float) type.getTexture().getHeight(),
		1f, 1f, angle, 0, 0, type.getTexture().getWidth(), type
			.getTexture().getHeight(), false, false);
	batch.end();
	batch.begin();
    }

    public void update() {
	if (alive) {
	    checkCollision(Global.map);
	    xpos += type.getMinSpeed() * Math.cos(Math.toRadians(angle));
	    ypos += type.getMinSpeed() * Math.sin(Math.toRadians(angle));
	} else {

	}
    }

    public void checkCollision(TiledMap map) {
	if (getXpos() >= Global.map_rows * Global.map_tileWidth
		|| getYpos() >= Global.map_columns * Global.map_tileHeight
		|| getYpos() <= 0 || getXpos() <= 0) {
	    alive = false;
	}
    }
    
    public void playSound() {
	type.getSound().play(Global.sounds_volume);
    }
    
    public void dispose() {
	getType().getTexture().dispose();
    }

    /**
     * @return the type
     */
    public Weapontype getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Weapontype type) {
	this.type = type;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
	return alive;
    }

    /**
     * @param alive
     *            the alive to set
     */
    public void setAlive(boolean alive) {
	this.alive = alive;
    }

}
