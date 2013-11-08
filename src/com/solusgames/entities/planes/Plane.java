package com.solusgames.entities.planes;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;
import com.solusgames.entities.weapons.Weapon;
import com.solusgames.entities.weapons.Weapontype;
import com.solusgames.entities.weapons.Weapontype.WeaponTypes;

public class Plane extends Entity {

    // contains plane settings
    private Planetype type;
    // is plane still alive
    private boolean alive;
    // control booleans
    private boolean throttleUp;
    private boolean throttleDown;
    private boolean turnUp;
    private boolean turnDown;
    private boolean airBreak;
    // movement variables
    private float acceleration = 0;
    private float hspeed = 0;
    private float vspeed = 0;
    private float inertAngle = 0;

    // ammo count
    private int ammo_slot1;
    private int ammo_slot2;
    private int ammo_slot3;
    private int ammo_slot4;

    // weapons
    private Weapon slot1;
    private Weapon slot2;
    private Weapon slot3;
    private Weapon slot4;

    // shooting booleans
    private boolean slot1_fire;
    private boolean slot2_fire;
    private boolean slot3_fire;
    private boolean slot4_fire;

    // reload timers
    private int reload_slot1;
    private int reload_slot2;
    private int reload_slot3;
    private int reload_slot4;

    // weapon array
    public ArrayList<Weapon> weapons;

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
	weapons = new ArrayList<>();

	// TEST
	setSlot1(new Weapon(xpos, ypos, angle, new Weapontype(
		WeaponTypes.GUN_30MM)));
	ammo_slot1 = slot1.getType().getMaxAmmo();
	setSlot2(new Weapon(xpos, ypos, angle, new Weapontype(
		WeaponTypes.GUN_30MM)));
	ammo_slot2 = slot2.getType().getMaxAmmo();
	setSlot3(new Weapon(xpos, ypos, angle, new Weapontype(
		WeaponTypes.GUN_30MM)));
	ammo_slot3 = slot3.getType().getMaxAmmo();
	setSlot4(new Weapon(xpos, ypos, angle, new Weapontype(
		WeaponTypes.GUN_30MM)));
	ammo_slot4 = slot4.getType().getMaxAmmo();
    }

    /**
     * Render method
     */
    public void render(SpriteBatch batch) {
	// Texture tex = type.getTexture();
	// float texWidth = tex.getWidth();
	// float texHeight = tex.getHeight();
	float origx = type.getTexture().getWidth() / 2;
	float origy = type.getTexture().getHeight() / 2;

	// if (getEType() == EntityType.PLAYER1) {
	// System.out.println("DRAW P1");
	// batch.draw(tex, xpos, ypos, origx, origy, texWidth, texHeight, 1,
	// 1, angle, 0, 0, (int) texWidth, (int) texHeight, false,
	// false);
	// } else if (getEType() == EntityType.PLAYER2) {
	// System.out.println("DRAW P2");
	// batch.draw(tex, xpos, ypos, origx, origy, texWidth, texHeight, 1,
	// 1, angle, 0, 0, (int) texWidth, (int) texHeight, false,
	// false);
	// } else {

	batch.draw(type.getTexture(), xpos, ypos, origx, origy, type
		.getTexture().getWidth(), type.getTexture().getHeight(), 1, 1,
		angle, 0, 0, type.getTexture().getWidth(), type.getTexture()
			.getHeight(), false, false);
	// }

	// iterate through weapons and render them
	for (int i = 0; i < weapons.size(); i++) {
	    weapons.get(i).render(batch);
	}

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

	// if slot is used
	if (isSlot1_fire()) {
	    shoot_slot1();
	}

	if (isSlot2_fire()) {
	    shoot_slot2();
	}

	if (isSlot3_fire()) {
	    shoot_slot3();
	}

	if (isSlot4_fire()) {
	    shoot_slot4();
	}
	for (int i = 0; i < weapons.size(); i++) {
	    weapons.get(i).update();
	    if (!weapons.get(i).isAlive()) {
		weapons.remove(i);
	    }
	}
	reloadWeapons();

    }

    public void checkCollision(TiledMap map) {
	if (getXpos() >= Global.map.width * Global.map.tileWidth
		|| getYpos() >= Global.map.height * Global.map.tileHeight
		|| getYpos() <= 0 || getXpos() <= 0) {
	    respawn();
	}
    }

    /**
     * Respawn method
     */
    public void respawn() {
	setXpos(100);
	setYpos(100);
    }

    /**
     * Reload method
     */
    public void reloadWeapons() {

	if (ammo_slot1 <= 0) {
	    reload_slot1--;
	    if (reload_slot1 <= 0) {
		ammo_slot1 = slot1.getType().getMaxAmmo();
	    }
	} else {
	    reload_slot1 = slot1.getType().getReloadTime();
	}
	if (ammo_slot2 <= 0) {
	    reload_slot2--;
	    if (reload_slot2 <= 0) {
		ammo_slot2 = slot2.getType().getMaxAmmo();
	    }
	} else {
	    reload_slot2 = slot2.getType().getReloadTime();
	}
	if (ammo_slot3 <= 0) {
	    reload_slot3--;
	    if (reload_slot3 <= 0) {
		ammo_slot3 = slot3.getType().getMaxAmmo();
	    }
	} else {
	    reload_slot3 = slot3.getType().getReloadTime();
	}
	if (ammo_slot4 <= 0) {
	    reload_slot4--;
	    if (reload_slot4 <= 0) {
		ammo_slot4 = slot4.getType().getMaxAmmo();
	    }
	} else {
	    reload_slot4 = slot4.getType().getReloadTime();
	}
    }

    /**
     * Fires Weapon of slot1
     * 
     * @param weapon
     */
    public void shoot_slot1() {
	if (type.isSlot_1()) {
	    if (ammo_slot1 > 0) {
		weapons.add(new Weapon(xpos, ypos, angle, slot1.getType()));
		ammo_slot1--;
	    }
	}
    }

    /**
     * Fires Weapon of slot2
     * 
     * @param weapon
     */
    public Weapon shoot_slot2() {
	if (type.isSlot_2()) {
	    return new Weapon(xpos, ypos, angle, slot2.getType());
	} else {
	    return null;
	}
    }

    /**
     * Fires Weapon of slot3
     * 
     * @param weapon
     */
    public Weapon shoot_slot3() {
	if (type.isSlot_3()) {
	    return new Weapon(xpos, ypos, angle, slot3.getType());
	} else {
	    return null;
	}
    }

    /**
     * Fires Weapon of slot4
     * 
     * @param weapon
     */
    public Weapon shoot_slot4() {
	if (type.isSlot_4()) {
	    return new Weapon(xpos, ypos, angle, slot4.getType());
	} else {
	    return null;
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

    /**
     * @return the slot1_fire
     */
    public boolean isSlot1_fire() {
	return slot1_fire;
    }

    /**
     * @param slot1_fire
     *            the slot1_fire to set
     */
    public void setSlot1_fire(boolean slot1_fire) {
	this.slot1_fire = slot1_fire;
    }

    /**
     * @return the slot2_fire
     */
    public boolean isSlot2_fire() {
	return slot2_fire;
    }

    /**
     * @param slot2_fire
     *            the slot2_fire to set
     */
    public void setSlot2_fire(boolean slot2_fire) {
	this.slot2_fire = slot2_fire;
    }

    /**
     * @return the slot3_fire
     */
    public boolean isSlot3_fire() {
	return slot3_fire;
    }

    /**
     * @param slot3_fire
     *            the slot3_fire to set
     */
    public void setSlot3_fire(boolean slot3_fire) {
	this.slot3_fire = slot3_fire;
    }

    /**
     * @return the slot4_fire
     */
    public boolean isSlot4_fire() {
	return slot4_fire;
    }

    /**
     * @param slot4_fire
     *            the slot4_fire to set
     */
    public void setSlot4_fire(boolean slot4_fire) {
	this.slot4_fire = slot4_fire;
    }

    /**
     * @return the weapons
     */
    public ArrayList<Weapon> getWeapons() {
	return weapons;
    }

}
