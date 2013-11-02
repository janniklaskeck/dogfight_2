package com.solusgames.entities.planes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    public Plane(float x, float y, float angle, Planetype type) {
	super(x, y, angle, type.getHitpoints());
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
	if (alive) {
	    // Movement
	    hspeed = Math.abs(acceleration)
		    * (float) Math.cos(Math.toRadians(angle)
			    * Gdx.graphics.getDeltaTime() * 60);
	    vspeed = Math.abs(acceleration)
		    * (float) Math.sin(Math.toRadians(angle)
			    * Gdx.graphics.getDeltaTime() * 60);
	    xpos += hspeed;
	    ypos += vspeed;

	    if (!isThrottleUp() && !isThrottleDown()) {
		if (vspeed < 0) {
		    // addVelocity(-0.08f);
		} else {
		    // addVelocity(-0.04f);
		}
	    }
	    if (isTurnUp()) {
		addAngle(type.getTurnSpeed() * Gdx.graphics.getDeltaTime() * 10);
	    }
	    if (isTurnDown()) {
		addAngle(-type.getTurnSpeed() * Gdx.graphics.getDeltaTime()
			* 10);
	    }
	    if (isThrottleUp()) {
		if (vspeed < 0) {
		    addAcceleration(1 / 2 * Gdx.graphics.getDeltaTime());
		} else if (vspeed >= 0) {
		    addAcceleration(1 * Gdx.graphics.getDeltaTime());
		} else {
		    addAcceleration(1 / 20 * Gdx.graphics.getDeltaTime());
		}
	    }
	    if (isThrottleDown()) {
		if (acceleration <= 0.3) {
		    setAcceleration(0.3f);
		} else {
		    addAcceleration(-0.035f);
		}
	    }
	} else {

	}

    }

    /**
     * experimental
     */

    public void update2() {
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
