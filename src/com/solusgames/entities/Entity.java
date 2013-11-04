package com.solusgames.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {

    protected float xpos;
    protected float ypos;
    protected float angle;
    protected int hitpoints;
    protected EntityType EType;

    /**
     * Create with angle zero
     * 
     * @param x
     * @param y
     * @param hitpoints
     * @param eType
     */
    public Entity(float x, float y, int hitpoints, EntityType EType) {
	this.xpos = x;
	this.ypos = y;
	this.angle = 0;
	this.hitpoints = hitpoints;
	this.EType = EType;
    }

    /**
     * Create with parameters
     * 
     * @param x
     * @param y
     * @param angle
     * @param hitpoints
     * @param eType
     */
    public Entity(float x, float y, float angle, int hitpoints, EntityType EType) {
	this.xpos = x;
	this.ypos = y;
	this.angle = angle;
	this.hitpoints = hitpoints;
	this.EType = EType;
    }

    /**
     * Render Method
     * 
     * @param batch
     */
    public void render(SpriteBatch batch) {

    }

    /**
     * Update Method
     */
    public void update() {
    }

    /**
     * @return the xpos
     */
    public float getXpos() {
	return xpos;
    }

    /**
     * @param xpos
     *            the xpos to set
     */
    public void setXpos(float xpos) {
	this.xpos = xpos;
    }

    /**
     * @return the ypos
     */
    public float getYpos() {
	return ypos;
    }

    /**
     * @param ypos
     *            the ypos to set
     */
    public void setYpos(float ypos) {
	this.ypos = ypos;
    }

    /**
     * @return the angle
     */
    public float getAngle() {
	return angle;
    }

    /**
     * @param angle
     *            the angle to set
     */
    public void setAngle(float angle) {
	this.angle = angle;
    }

    /**
     * @param angle
     *            the angle to add
     */
    public void addAngle(float angle) {
	this.angle += angle;
	if (this.angle >= 360) {
	    // this.angle = 0;
	}
	if (this.angle < 0) {
	    // this.angle += 359;
	}
    }

    /**
     * @return the hitpoints
     */
    public int getHitpoints() {
	return hitpoints;
    }

    /**
     * @param hitpoints
     *            the hitpoints to set
     */
    public void setHitpoints(int hitpoints) {
	this.hitpoints = hitpoints;
    }

    public EntityType getEType() {
	return EType;
    }

    public void setEType(EntityType EType) {
	this.EType = EType;
    }

    public enum EntityType {
	NONE, STRUCTURE, PLANE, HELICOPTER, TURRET, PLAYER1, PLAYER2, WEAPON;
    };

}
