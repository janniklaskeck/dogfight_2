package com.solusgames.entities;

import static com.badlogic.gdx.graphics.g2d.SpriteBatch.X1;
import static com.badlogic.gdx.graphics.g2d.SpriteBatch.X2;
import static com.badlogic.gdx.graphics.g2d.SpriteBatch.X3;
import static com.badlogic.gdx.graphics.g2d.SpriteBatch.X4;
import static com.badlogic.gdx.graphics.g2d.SpriteBatch.Y1;
import static com.badlogic.gdx.graphics.g2d.SpriteBatch.Y2;
import static com.badlogic.gdx.graphics.g2d.SpriteBatch.Y3;
import static com.badlogic.gdx.graphics.g2d.SpriteBatch.Y4;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

/**
 * Parent Entity class
 * 
 * @author keckjs
 * 
 */
public class Entity {

    // x and y position
    protected float xpos;
    protected float ypos;
    // current angle of sprite
    protected float angle;
    // hitpoints
    protected int hitpoints;
    // Entitytype to identify
    protected EntityType EType;
    // Texture
    protected Texture texture;
    // Sprite from texture
    protected Sprite sprite;

    // Respawn x and y position
    protected float x_respawn;
    protected float y_respawn;

    /**
     * Create with angle zero
     * 
     * @param x
     * @param y
     * @param hitpoints
     * @param eType
     */
    public Entity(float x, float y, int hitpoints, EntityType EType) {
	this.x_respawn = x;
	this.y_respawn = y;
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
	this.x_respawn = x;
	this.y_respawn = y;
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
	this.x_respawn = x;
	this.y_respawn = y;
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
     * @param SpriteBatch
     *            to render with
     */
    public void render(SpriteBatch batch) {

    }

    /**
     * Update Method
     */
    public void update(float delta) {
    }

    /**
     * Dispose of textures
     */
    public void dispose() {
	getSprite().getTexture().dispose();
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
    
    /**
     * @param hitpoints
     *            the hitpoints to add
     */
    public void addHitpoints(int hitpoints) {
	this.hitpoints += hitpoints;
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
    
    /**
     * Returns a array from the planes sprite corners
     * 
     * @return
     */
    public float[] returnSpriteCornerArrayF() {

	float[] vertices = getSprite().getVertices();
	float localX = -getSprite().getOriginX();
	float localY = -getSprite().getOriginY();
	float localX2 = localX + getSprite().getWidth();
	float localY2 = localY + getSprite().getHeight();
	float worldOriginX = getSprite().getX() - localX;
	float worldOriginY = getSprite().getY() - localY;
	if (getSprite().getScaleX() != 1 || getSprite().getScaleY() != 1) {
	    localX *= getSprite().getScaleX();
	    localY *= getSprite().getScaleY();
	    localX2 *= getSprite().getScaleX();
	    localY2 *= getSprite().getScaleY();
	}
	final float cos = MathUtils.cosDeg(getAngle());
	final float sin = MathUtils.sinDeg(getAngle());
	final float localXCos = localX * cos;
	final float localXSin = localX * sin;
	final float localYCos = localY * cos;
	final float localYSin = localY * sin;
	final float localX2Cos = localX2 * cos;
	final float localX2Sin = localX2 * sin;
	final float localY2Cos = localY2 * cos;
	final float localY2Sin = localY2 * sin;

	final float x1 = localXCos - localYSin + worldOriginX;
	final float y1 = localYCos + localXSin + worldOriginY;
	vertices[X1] = x1;
	vertices[Y1] = y1;

	final float x2 = localXCos - localY2Sin + worldOriginX;
	final float y2 = localY2Cos + localXSin + worldOriginY;
	vertices[X2] = x2;
	vertices[Y2] = y2;

	final float x3 = localX2Cos - localY2Sin + worldOriginX;
	final float y3 = localY2Cos + localX2Sin + worldOriginY;
	vertices[X3] = x3;
	vertices[Y3] = y3;

	vertices[X4] = x1 + (x3 - x2);
	vertices[Y4] = y3 - (y2 - y1);

	float[] vert = new float[8];
	vert[0] = vertices[X1];
	vert[1] = vertices[Y1];
	vert[2] = vertices[X2];
	vert[3] = vertices[Y2];
	vert[4] = vertices[X3];
	vert[5] = vertices[Y3];
	vert[6] = vertices[X4];
	vert[7] = vertices[Y4];
	return vert;
    }

    public float getX_respawn() {
	return x_respawn;
    }

    public void setX_respawn(float x_respawn) {
	this.x_respawn = x_respawn;
    }

    public float getY_respawn() {
	return y_respawn;
    }

    public void setY_respawn(float y_respawn) {
	this.y_respawn = y_respawn;
    }

    public enum EntityType {
	NONE, STRUCTURE, PLANE, HELICOPTER, TURRET, PLAYER1, PLAYER2, WEAPON_PLAYER1, WEAPON_PLAYER2;
    };

}
