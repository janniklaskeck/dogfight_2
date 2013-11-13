package com.solusgames.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {

    protected float xpos;
    protected float ypos;
    protected float angle;
    protected int hitpoints;
    protected EntityType EType;
    protected Texture texture;
    protected Sprite sprite;

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
     * Create with parameters
     * 
     * @param x
     * @param y
     * @param angle
     * @param hitpoints
     * @param texture
     * @param EType
     */
    public Entity(float x, float y, float angle, int hitpoints,
	    Texture texture, EntityType EType) {
	this.xpos = x;
	this.ypos = y;
	this.angle = angle;
	this.hitpoints = hitpoints;
	this.texture = texture;
	this.sprite = new Sprite(texture);
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

    public void dispose() {
	getTexture().dispose();
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

    /**
     * @return the sprite
     */
    public Sprite getSprite() {
	return sprite;
    }

    /**
     * @param sprite
     *            the sprite to set
     */
    public void setSprite(Sprite sprite) {
	this.sprite = sprite;
    }

    public enum EntityType {
	NONE, STRUCTURE, PLANE, HELICOPTER, TURRET, PLAYER1, PLAYER2, WEAPON;
    };

}
