package com.solusgames.entities.planes;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
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
    // extra break
    private boolean airBreak;
    // movement variables
    private float acceleration = 0;
    // inertia angle
    private float inertAngle = 0;
    // origin points to rotate around
    private float origx;
    private float origy;

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
	super(x, y, angle, type.getHitpoints(), type.getTexture(), eType);
	this.setType(type);
	this.alive = true;

	weapons = new ArrayList<>();
	origx = getSprite().getWidth() / 2;
	origy = getSprite().getHeight() / 2;
	if (eType == EntityType.PLAYER2) {
	    setAngle(180);
	    inertAngle = 180;
	    getSprite().flip(false, true);

	}

	// TODO: Remove when no longer needed
	if (EType == EntityType.PLAYER1) {
	    Weapontype t = new Weapontype(WeaponTypes.GUN_30MM);
	    setSlot1(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER1));
	    ammo_slot1 = t.getMaxAmmo();
	    setSlot2(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER1));
	    ammo_slot2 = t.getMaxAmmo();
	    setSlot3(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER1));
	    ammo_slot3 = t.getMaxAmmo();
	    setSlot4(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER1));
	    ammo_slot4 = t.getMaxAmmo();
	} else if (EType == EntityType.PLAYER2) {
	    Weapontype t = new Weapontype(WeaponTypes.GUN_30MM);
	    setSlot1(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER2));
	    ammo_slot1 = t.getMaxAmmo();
	    setSlot2(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER2));
	    ammo_slot2 = t.getMaxAmmo();
	    setSlot3(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER2));
	    ammo_slot3 = t.getMaxAmmo();
	    setSlot4(new Weapon(xpos, ypos, angle, t.getTexture(), t,
		    EntityType.WEAPON_PLAYER2));
	    ammo_slot4 = t.getMaxAmmo();
	}

    }

    /**
     * Render method
     */
    public void render(SpriteBatch batch) {
	batch.end();
	batch.begin();

	Sprite sprite = getSprite();

	if (getEType() == EntityType.PLAYER1) {
	    sprite.setPosition(xpos, ypos);
	    sprite.setOrigin(origx, origy);
	    sprite.setRotation(angle);
	} else if (getEType() == EntityType.PLAYER2) {
	    sprite.setPosition(xpos, ypos);
	    sprite.setOrigin(origx, origy);
	    sprite.setRotation(angle);

	}

	sprite.draw(batch);

	// iterate through weapons and render them
	for (int i = 0; i < weapons.size(); i++) {
	    weapons.get(i).render(batch);
	}

	batch.end();
	batch.begin();

    }

    /**
     * Update method
     */
    public void update(float delta) {
	checkCollision(delta);
	updateMovement(delta);
	updateWeapons(delta);

    }

    /**
     * Check collision of 4 corner points with map collision polygons
     */
    private void checkCollision(float delta) {
	Vector2 minmin = new Vector2(getSprite().getVertices()[0], getSprite()
		.getVertices()[1]);
	Vector2 minmax = new Vector2(getSprite().getVertices()[5], getSprite()
		.getVertices()[6]);
	Vector2 maxmin = new Vector2(getSprite().getVertices()[15], getSprite()
		.getVertices()[16]);
	Vector2 maxmax = new Vector2(getSprite().getVertices()[10], getSprite()
		.getVertices()[11]);
	// map collision
	for (ArrayList<Vector2> r : Global.currentMap.getCol_map()) {
	    Array<Vector2> arr = Global.toArray(r);
	    if (Intersector.isPointInPolygon(arr, minmin)
		    || Intersector.isPointInPolygon(arr, minmax)
		    || Intersector.isPointInPolygon(arr, maxmin)
		    || Intersector.isPointInPolygon(arr, maxmax)) {
		setAlive(false);
		respawn();
	    }
	}
	// bounds collision
	if (getXpos() >= Global.currentMap.getMap_rows()
		* Global.currentMap.getMap_tileWidth()
		|| getYpos() >= Global.currentMap.getMap_columns()
			* Global.currentMap.getMap_tileHeight()
		|| getYpos() <= 0 || getXpos() <= 0) {
	    setAlive(false);
	    respawn();
	}

    }

    /**
     * Movement update method
     */
    private void updateMovement(float delta) {
	// movement
	// inertia emulation
	if (inertAngle <= angle) {
	    if (inertAngle != angle) {
		inertAngle += (4 * type.getTurnSpeed() / 5) * delta;
	    }

	} else if (inertAngle > angle) {
	    if (inertAngle != angle) {
		inertAngle -= (4 * type.getTurnSpeed() / 5) * delta;
	    }
	}

	if (isThrottleUp()) {
	    addAcceleration(0.3f);
	}

	if (isThrottleDown()) {
	    addAcceleration(-0.1f);
	}

	if (isTurnUp()) {
	    addAngle(type.getTurnSpeed() * delta);
	}

	if (isTurnDown()) {
	    addAngle(-type.getTurnSpeed() * delta);
	}

	xpos += acceleration * Math.cos(Math.toRadians(inertAngle)) * delta;
	ypos += acceleration * Math.sin(Math.toRadians(inertAngle)) * delta;

    }

    /**
     * Weapons update method
     */
    private void updateWeapons(float delta) {
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
	    weapons.get(i).update(delta);
	    if (!weapons.get(i).isAlive()) {
		weapons.remove(i);
	    }
	}
	reloadWeapons();
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
     * Respawn method
     */
    public void respawn() {
	setXpos(x_respawn);
	setYpos(y_respawn);
	setAlive(true);
	if (EType == EntityType.PLAYER1) {
	    setAngle(0);
	    inertAngle = 0;
	    acceleration = 0;
	} else if (EType == EntityType.PLAYER2) {
	    setAngle(180);
	    inertAngle = 180;
	    acceleration = 0;
	}
    }

    /**
     * Returns a array from the planes sprite corners
     * 
     * @return
     */
    public Array<Vector2> returnSpriteCornerArray() {
	Vector2 minmin = new Vector2(getSprite().getVertices()[0], getSprite()
		.getVertices()[1]);
	Vector2 minmax = new Vector2(getSprite().getVertices()[5], getSprite()
		.getVertices()[6]);
	Vector2 maxmin = new Vector2(getSprite().getVertices()[15], getSprite()
		.getVertices()[16]);
	Vector2 maxmax = new Vector2(getSprite().getVertices()[10], getSprite()
		.getVertices()[11]);

	Array<Vector2> poly = new Array<>();
	poly.add(minmin);
	poly.add(minmax);
	poly.add(maxmin);
	poly.add(maxmax);
	return poly;
    }

    public void dispose() {
	super.dispose();
	type.getTexture().dispose();
    }

    /**
     * Fires Weapon of slot1
     * 
     * @param weapon
     */
    public void shoot_slot1() {
	if (type.isSlot_1()) {
	    if (ammo_slot1 > 0) {
		if (EType == EntityType.PLAYER1) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot1
			    .getTexture(), slot1.getType(),
			    EntityType.WEAPON_PLAYER1));
		} else if (EType == EntityType.PLAYER2) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot1
			    .getTexture(), slot1.getType(),
			    EntityType.WEAPON_PLAYER2));
		}

		ammo_slot1--;
	    }
	}
    }

    /**
     * Fires Weapon of slot2
     * 
     * @param weapon
     */
    public void shoot_slot2() {
	if (type.isSlot_2()) {
	    if (ammo_slot2 > 0) {
		if (EType == EntityType.PLAYER1) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot2
			    .getTexture(), slot2.getType(),
			    EntityType.WEAPON_PLAYER1));
		} else if (EType == EntityType.PLAYER2) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot2
			    .getTexture(), slot2.getType(),
			    EntityType.WEAPON_PLAYER2));
		}
		ammo_slot2--;
	    }
	}
    }

    /**
     * Fires Weapon of slot3
     * 
     * @param weapon
     */
    public void shoot_slot3() {
	if (type.isSlot_3()) {
	    if (ammo_slot3 > 0) {
		if (EType == EntityType.PLAYER1) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot3
			    .getTexture(), slot3.getType(),
			    EntityType.WEAPON_PLAYER1));
		} else if (EType == EntityType.PLAYER2) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot3
			    .getTexture(), slot3.getType(),
			    EntityType.WEAPON_PLAYER2));
		}
		ammo_slot3--;
	    }
	}
    }

    /**
     * Fires Weapon of slot4
     * 
     * @param weapon
     */
    public void shoot_slot4() {
	if (type.isSlot_4()) {
	    if (ammo_slot4 > 0) {
		if (EType == EntityType.PLAYER1) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot4
			    .getTexture(), slot4.getType(),
			    EntityType.WEAPON_PLAYER1));
		} else if (EType == EntityType.PLAYER2) {
		    weapons.add(new Weapon(xpos, ypos, angle, slot4
			    .getTexture(), slot4.getType(),
			    EntityType.WEAPON_PLAYER2));
		}
		ammo_slot4--;
	    }
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
