package com.solusgames.entities.planes;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;
import com.solusgames.entities.weapons.Weapon;

public class Plane extends Entity {

    private Planetype type;
    private boolean alive;
    private boolean throttleUp;
    private boolean throttleDown;
    private boolean turnUp;
    private boolean turnDown;
    private boolean airBreak;
    private float acceleration = 0;
    private float hspeed = 0;
    private float vspeed = 0;
    private float inertAngle = 0;

    private boolean weapon_slot1;
    private boolean weapon_slot2;
    private boolean weapon_slot3;
    private boolean weapon_slot4;

    private int ammo_slot1;
    private int ammo_slot2;
    private int ammo_slot3;
    private int ammo_slot4;

    private Weapon slot1;
    private Weapon slot2;
    private Weapon slot3;
    private Weapon slot4;

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

	// movement
	
	// inertia emulation
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

	// weapons
	if (weapon_slot1) {
	    // if slot is used
	    if (type.isSlot_1()) {
		// if ammo is greater zero
		if (ammo_slot1 > 0) {
		    // shoot slot weapon
		    shoot(slot1);
		    ammo_slot1--;
		}
	    }
	}
	if (weapon_slot2) {
	    if (type.isSlot_2()) {
		if (ammo_slot2 > 0) {
		    shoot(slot2);
		    ammo_slot2--;
		}
	    }
	}
	if (weapon_slot3) {
	    if (type.isSlot_3()) {
		if (ammo_slot3 > 0) {
		    shoot(slot3);
		    ammo_slot3--;
		}
	    }
	}
	if (weapon_slot4) {
	    if (type.isSlot_4()) {
		if (ammo_slot4 > 0) {
		    shoot(slot4);
		    ammo_slot4--;
		}
	    }
	}

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
     * Fires Weapon of given type
     * 
     * @param weapon
     */
    public Weapon shoot(Weapon weapon) {
	return new Weapon(xpos, ypos, angle, weapon.getType());
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

    /**
     * @return the hspeed
     */
    public float getHspeed() {
	return hspeed;
    }

    /**
     * @return the vspeed
     */
    public float getVspeed() {
	return vspeed;
    }

    /**
     * @return the inertAngle
     */
    public float getInertAngle() {
	return inertAngle;
    }

    /**
     * @return the weapon_slot1
     */
    public boolean isWeapon_slot1() {
	return weapon_slot1;
    }

    /**
     * @param weapon_slot1
     *            the weapon_slot1 to set
     */
    public void setWeapon_slot1(boolean weapon_slot1) {
	this.weapon_slot1 = weapon_slot1;
    }

    /**
     * @return the weapon_slot2
     */
    public boolean isWeapon_slot2() {
	return weapon_slot2;
    }

    /**
     * @param weapon_slot2
     *            the weapon_slot2 to set
     */
    public void setWeapon_slot2(boolean weapon_slot2) {
	this.weapon_slot2 = weapon_slot2;
    }

    /**
     * @return the weapon_slot3
     */
    public boolean isWeapon_slot3() {
	return weapon_slot3;
    }

    /**
     * @param weapon_slot3
     *            the weapon_slot3 to set
     */
    public void setWeapon_slot3(boolean weapon_slot3) {
	this.weapon_slot3 = weapon_slot3;
    }

    /**
     * @return the weapon_slot4
     */
    public boolean isWeapon_slot4() {
	return weapon_slot4;
    }

    /**
     * @param weapon_slot4
     *            the weapon_slot4 to set
     */
    public void setWeapon_slot4(boolean weapon_slot4) {
	this.weapon_slot4 = weapon_slot4;
    }

    /**
     * @return the ammo_slot1
     */
    public int getAmmo_slot1() {
	return ammo_slot1;
    }

    /**
     * @param ammo_slot1
     *            the ammo_slot1 to set
     */
    public void setAmmo_slot1(int ammo_slot1) {
	this.ammo_slot1 = ammo_slot1;
    }

    /**
     * @return the ammo_slot2
     */
    public int getAmmo_slot2() {
	return ammo_slot2;
    }

    /**
     * @param ammo_slot2
     *            the ammo_slot2 to set
     */
    public void setAmmo_slot2(int ammo_slot2) {
	this.ammo_slot2 = ammo_slot2;
    }

    /**
     * @return the ammo_slot3
     */
    public int getAmmo_slot3() {
	return ammo_slot3;
    }

    /**
     * @param ammo_slot3
     *            the ammo_slot3 to set
     */
    public void setAmmo_slot3(int ammo_slot3) {
	this.ammo_slot3 = ammo_slot3;
    }

    /**
     * @return the ammo_slot4
     */
    public int getAmmo_slot4() {
	return ammo_slot4;
    }

    /**
     * @param ammo_slot4
     *            the ammo_slot4 to set
     */
    public void setAmmo_slot4(int ammo_slot4) {
	this.ammo_slot4 = ammo_slot4;
    }

    /**
     * @return the slot1
     */
    public Weapon getSlot1() {
	return slot1;
    }

    /**
     * @param slot1
     *            the slot1 to set
     */
    public void setSlot1(Weapon slot1) {
	this.slot1 = slot1;
    }

    /**
     * @return the slot2
     */
    public Weapon getSlot2() {
	return slot2;
    }

    /**
     * @param slot2
     *            the slot2 to set
     */
    public void setSlot2(Weapon slot2) {
	this.slot2 = slot2;
    }

    /**
     * @return the slot3
     */
    public Weapon getSlot3() {
	return slot3;
    }

    /**
     * @param slot3
     *            the slot3 to set
     */
    public void setSlot3(Weapon slot3) {
	this.slot3 = slot3;
    }

    /**
     * @return the slot4
     */
    public Weapon getSlot4() {
	return slot4;
    }

    /**
     * @param slot4
     *            the slot4 to set
     */
    public void setSlot4(Weapon slot4) {
	this.slot4 = slot4;
    }
}
