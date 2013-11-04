package com.solusgames.entities.planes;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;

public class Plane extends Entity {

    private Planetype type;
    private boolean alive;
    private boolean throttleUp;
    private boolean throttleDown;
    private boolean turnUp;
    private boolean turnDown;
    private boolean airBreak;
    private float acceleration = 0;
    float hspeed = 0;
    float vspeed = 0;
    float inertAngle = 0;

    /**
     * 
     * @param x
     * @param y
     * @param angle
     * @param type
     */
    public Plane(float x, float y, float angle, Planetype type, EntityType eType) {
	super(x, y, angle, type.getHitpoints(), eType);
	this.setType(type);
	this.alive = true;
    }

    /**
     * Render method
     */
    public void render(SpriteBatch batch) {
	float origx = type.getTexture().getWidth() / 2;
	float origy = type.getTexture().getHeight() / 2;

	batch.draw(type.getTexture(), xpos, ypos, origx, origy, type
		.getTexture().getWidth(), type.getTexture().getHeight(), 1, 1,
		angle, 0, 0, type.getTexture().getWidth(), type.getTexture()
			.getHeight(), false, false);
	BitmapFont f = new BitmapFont();
	f.draw(batch, "a:" + angle, 50, 50);
	f.draw(batch, "i:" + inertAngle, 100, 50);
    }

    /**
     * Update method
     */
    public void update() {
	checkCollision(Global.map);

	if (inertAngle <= angle) {
	    if (inertAngle != angle) {
		inertAngle += 1.5f;
	    }

	} else if (inertAngle > angle) {
	    if (inertAngle != angle) {
		inertAngle -= 1.5f;
	    }
	}

	if (isThrottleUp()) {
	    addAcceleration(0.3f);
	}

	if (isThrottleDown()) {
	    addAcceleration(-0.1f);
	}

	if (isTurnUp()) {
	    addAngle(type.getTurnSpeed());
	}

	if (isTurnDown()) {
	    addAngle(-type.getTurnSpeed());
	}

	xpos += acceleration * Math.cos(Math.toRadians(inertAngle));
	ypos += acceleration * Math.sin(Math.toRadians(inertAngle));

    }

    public void checkCollision(TiledMap map) {
	if (getXpos() >= Global.map.width * Global.map.tileWidth
		|| getYpos() >= Global.map.height * Global.map.tileHeight
		|| getYpos() <= 0 || getXpos() <= 0) {
	    setXpos(100);
	    setYpos(100);
	}
    }

    /**
     * @return the type
     */
    public Planetype getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Planetype type) {
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

    /**
     * @return the throttleUp
     */
    public boolean isThrottleUp() {
	return throttleUp;
    }

    /**
     * @param throttleUp
     *            the throttleUp to set
     */
    public void setThrottleUp(boolean throttleUp) {
	this.throttleUp = throttleUp;
    }

    /**
     * @return the throttleDown
     */
    public boolean isThrottleDown() {
	return throttleDown;
    }

    /**
     * @param throttleDown
     *            the throttleDown to set
     */
    public void setThrottleDown(boolean throttleDown) {
	this.throttleDown = throttleDown;
    }

    /**
     * @return the turnUp
     */
    public boolean isTurnUp() {
	return turnUp;
    }

    /**
     * @param turnUp
     *            the turnUp to set
     */
    public void setTurnUp(boolean turnUp) {
	this.turnUp = turnUp;
    }

    /**
     * @return the turnDown
     */
    public boolean isTurnDown() {
	return turnDown;
    }

    /**
     * @param turnDown
     *            the turnDown to set
     */
    public void setTurnDown(boolean turnDown) {
	this.turnDown = turnDown;
    }

    /**
     * @return the airBreak
     */
    public boolean isAirBreak() {
	return airBreak;
    }

    /**
     * @param airBreak
     *            the airBreak to set
     */
    public void setAirBreak(boolean airBreak) {
	this.airBreak = airBreak;
    }

    /**
     * @return the velocity
     */
    public float getAcceleration() {
	return acceleration;
    }

    /**
     * @param velocity
     *            the velocity to add
     */
    public void addAcceleration(float acceleration) {
	this.acceleration += acceleration;
	if (this.acceleration >= type.getMaxSpeed()) {
	    this.acceleration = type.getMaxSpeed();
	}
	if (this.acceleration <= type.getMinSpeed()) {
	    this.acceleration = type.getMinSpeed();
	}
    }

    /**
     * @param velocity
     *            the velocity to set
     */
    public void setAcceleration(float acceleration) {
	this.acceleration = acceleration;
    }
}
