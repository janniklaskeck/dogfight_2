package com.solusgames.entities.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;

public class Weapon extends Entity {

    private Weapontype type;
    private boolean alive;
    private float originX;
    private float originY;

    public Weapon(float x, float y, float angle, Texture texture,
	    Weapontype type) {
	super(x, y, angle, 0, texture, EntityType.WEAPON);
	alive = true;
	this.type = type;
	originX = getSprite().getWidth() / 2;
	originY = getSprite().getHeight() / 2;

    }

    public void render(SpriteBatch batch) {
	batch.end();
	batch.begin();

	getSprite().setPosition(xpos, ypos);
	getSprite().setOrigin(originX, originY);
	getSprite().setRotation(angle);
	getSprite().draw(batch);
	
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
	super.dispose();
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
