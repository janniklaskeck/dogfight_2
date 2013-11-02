package com.solusgames.entities.weapons;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Weapontype {

    private float maxSpeed;
    private float minSpeed;
    private float turnSpeed;
    private boolean homing;
    private int maxAmmo;
    private int reloadTime;
    private int damage;
    private int fireRate;
    private Texture texture;
    private Sound sound;

    /**
     * 
     * @param maxSpeed
     * @param minSpeed
     * @param turnSpeed
     * @param homing
     * @param maxAmmo
     * @param reloadTime
     * @param damage
     * @param fireRate
     */
    public Weapontype(float maxSpeed, float minSpeed, float turnSpeed,
	    boolean homing, int maxAmmo, int reloadTime, int damage,
	    int fireRate, Texture texture, Sound sound) {
	this.maxSpeed = maxSpeed;
	this.minSpeed = minSpeed;
	this.turnSpeed = turnSpeed;
	this.homing = homing;
	this.maxAmmo = maxAmmo;
	this.reloadTime = reloadTime;
	this.damage = damage;
	this.fireRate = fireRate;
	this.texture = texture;
	this.sound = sound;
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
     * @return the homing
     */
    public boolean isHoming() {
	return homing;
    }

    /**
     * @param homing
     *            the homing to set
     */
    public void setHoming(boolean homing) {
	this.homing = homing;
    }

    /**
     * @return the maxAmmo
     */
    public int getMaxAmmo() {
	return maxAmmo;
    }

    /**
     * @param maxAmmo
     *            the maxAmmo to set
     */
    public void setMaxAmmo(int maxAmmo) {
	this.maxAmmo = maxAmmo;
    }

    /**
     * @return the reloadTime
     */
    public int getReloadTime() {
	return reloadTime;
    }

    /**
     * @param reloadTime
     *            the reloadTime to set
     */
    public void setReloadTime(int reloadTime) {
	this.reloadTime = reloadTime;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
	return damage;
    }

    /**
     * @param damage
     *            the damage to set
     */
    public void setDamage(int damage) {
	this.damage = damage;
    }

    /**
     * @return the fireRate
     */
    public int getFireRate() {
	return fireRate;
    }

    /**
     * @param fireRate
     *            the fireRate to set
     */
    public void setFireRate(int fireRate) {
	this.fireRate = fireRate;
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
     * @return the sound
     */
    public Sound getSound() {
	return sound;
    }

    /**
     * @param sound
     *            the sound to set
     */
    public void setSound(Sound sound) {
	this.sound = sound;
    }

}
