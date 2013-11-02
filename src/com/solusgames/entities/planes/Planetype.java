package com.solusgames.entities.planes;

import com.badlogic.gdx.graphics.Texture;

/**
 * Class to create different Planetypes with every needed property
 * 
 * @author keckjs
 * 
 */
public class Planetype {

    private int hitpoints;
    // movement
    private float maxSpeed;
    private float minSpeed;
    private float turnSpeed;
    // weapon capabilities
    private boolean slot_1 = true;
    private boolean slot_2 = true;
    private boolean slot_3 = true;
    private boolean slot_4 = true;
    // assets
    private Texture texture;

    /**
     * 
     * @param hitpoints
     * @param max
     * @param min
     * @param turn
     * @param slot_1
     * @param slot_2
     * @param slot_3
     * @param slot_4
     * @param texture
     */
    public Planetype(int hitpoints, float max, float min, float turn,
	    boolean slot_1, boolean slot_2, boolean slot_3, boolean slot_4,
	    Texture texture) {
	this.hitpoints = hitpoints;
	this.maxSpeed = max;
	this.minSpeed = min;
	this.turnSpeed = turn;
	this.slot_1 = slot_1;
	this.slot_2 = slot_2;
	this.slot_3 = slot_3;
	this.slot_4 = slot_4;
	this.texture = texture;
	
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

    /**
     * @return the maxSpeed
     */
    public float getMaxSpeed() {
	return maxSpeed;
    }

    /**
     * @param maxSpeed
     *            the maxSpeed to set
     */
    public void setMaxSpeed(float maxSpeed) {
	this.maxSpeed = maxSpeed;
    }

    /**
     * @return the minSpeed
     */
    public float getMinSpeed() {
	return minSpeed;
    }

    /**
     * @param minSpeed
     *            the minSpeed to set
     */
    public void setMinSpeed(float minSpeed) {
	this.minSpeed = minSpeed;
    }

    /**
     * @return the turnSpeed
     */
    public float getTurnSpeed() {
	return turnSpeed;
    }

    /**
     * @param turnSpeed
     *            the turnSpeed to set
     */
    public void setTurnSpeed(float turnSpeed) {
	this.turnSpeed = turnSpeed;
    }

    /**
     * @return the slot_1
     */
    public boolean isSlot_1() {
	return slot_1;
    }

    /**
     * @param slot_1
     *            the slot_1 to set
     */
    public void setSlot_1(boolean slot_1) {
	this.slot_1 = slot_1;
    }

    /**
     * @return the slot_2
     */
    public boolean isSlot_2() {
	return slot_2;
    }

    /**
     * @param slot_2
     *            the slot_2 to set
     */
    public void setSlot_2(boolean slot_2) {
	this.slot_2 = slot_2;
    }

    /**
     * @return the slot_3
     */
    public boolean isSlot_3() {
	return slot_3;
    }

    /**
     * @param slot_3
     *            the slot_3 to set
     */
    public void setSlot_3(boolean slot_3) {
	this.slot_3 = slot_3;
    }

    /**
     * @return the slot_4
     */
    public boolean isSlot_4() {
	return slot_4;
    }

    /**
     * @param slot_4
     *            the slot_4 to set
     */
    public void setSlot_4(boolean slot_4) {
	this.slot_4 = slot_4;
    }

    /**
     * @return the texture
     */
    public Texture getTexture() {
	return texture;
    }

    /**
     * @param texture
     *            the texture to set
     */
    public void setTexture(Texture texture) {
	this.texture = texture;
    }

}
