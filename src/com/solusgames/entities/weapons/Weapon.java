package com.solusgames.entities.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;

public class Weapon extends Entity {

    private Weapontype type;
    private boolean alive;
    private float originX;
    private float originY;
    private float movedDistance;

    public Weapon(float x, float y, float angle, Texture texture,
	    Weapontype type, EntityType EType) {
	super(x, y, angle, 0, texture, EType);
	alive = true;
	this.type = type;
	originX = getSprite().getWidth() / 2;
	originY = getSprite().getHeight() / 2;
	movedDistance = 0;
    }

    public void render(SpriteBatch batch) {
	batch.end();
	batch.begin();

	getSprite().setPosition(xpos, ypos);
	getSprite().setOrigin(originX, originY);
	getSprite().setRotation(angle);
	getSprite().draw(batch);

	batch.end();
	batch.begin();
    }

    public void update(float delta) {
	if (alive) {
	    if (movedDistance >= type.getRange()) {
		setAlive(false);
	    }
	    if (type.isHoming()) {
		float deltaX = 0;
		float deltaY = 0;

		if (getEType() == EntityType.WEAPON_PLAYER1) {
		    deltaX = Global.player2.getXpos() - xpos;
		    deltaY = Global.player2.getYpos() - ypos;
		} else if (getEType() == EntityType.WEAPON_PLAYER2) {
		    deltaX = Global.player1.getXpos() - xpos;
		    deltaY = Global.player1.getYpos() - ypos;
		}

		double atan2 = Math.atan2(deltaY, deltaX);
		// change atan2 to 0-360 degrees
		if (atan2 < 0) {
		    atan2 = Math.abs(atan2);
		} else {
		    atan2 = 2 * Math.PI - atan2;
		}
		float angle = Math.round(Math.toDegrees(atan2));
		if (angle >= 360) {
		    angle = 0;
		}
		// with help from http://krinstudio.com/?p=523
		angle = (360 - (int) angle) % 360;

		// Keep them on the right side. (Direction is in degrees, not
		// radians)
		if (getAngle() < 0)
		    addAngle(360);
		if (angle < getAngle())
		    angle += 360;

		// Find the difference in the angle.
		float angleDifference = angle - Math.abs(getAngle());

		// Turn the actual direction towards the target direction.
		if (((angleDifference < 180) && (angleDifference > 0))
			|| ((angleDifference < -180))) {
		    addAngle(type.getTurnSpeed());
		} else if (angleDifference == 0) {
		    addAngle(0);
		} else {
		    addAngle(-type.getTurnSpeed());
		}
<<<<<<< de9c82a1dff3febd3cca2deb9778fd4734e02bcd
=======
		// speed calculation
		xpos += type.getMinSpeed()
			* Math.cos(Math.toRadians(getAngle())) * delta;
		ypos += type.getMinSpeed()
			* Math.sin(Math.toRadians(getAngle())) * delta;

	    } else {
		xpos += type.getMinSpeed() * Math.cos(Math.toRadians(angle))
			* delta;
		ypos += type.getMinSpeed() * Math.sin(Math.toRadians(angle))
			* delta;
>>>>>>> e399fa58dd1095ed3e785cc8078002c195dff51c
	    }
	    float hspeed = type.getMinSpeed()
		    * (float) Math.cos(Math.toRadians(getAngle())) * delta;
	    float vspeed = type.getMinSpeed()
		    * (float) Math.sin(Math.toRadians(getAngle())) * delta;

	    xpos += hspeed;
	    ypos += vspeed;
	    movedDistance += Math.sqrt((hspeed) * (hspeed) + (vspeed)
		    * (vspeed));

	    checkCollision();

	}
    }

    /**
     * Plays sound belonging to weapon type
     */
    public void playSound() {
	type.getSound().play(Global.sounds_volume);
    }

    public void checkCollision() {
	// map collision
	for (float[] r : Global.currentMap.getCol_map()) {
	    if (Intersector.overlapConvexPolygons(new Polygon(r), new Polygon(
		    this.returnSpriteCornerArrayF()))) {
		setAlive(false);
	    }
	}
	// bounds collision
	if (getXpos() >= Global.currentMap.getMap_rows()
		* Global.currentMap.getMap_tileWidth()
		|| getYpos() >= Global.currentMap.getMap_columns()
			* Global.currentMap.getMap_tileHeight()
		|| getYpos() <= 0 || getXpos() <= 0) {
	    setAlive(false);
	}

	if (EType == EntityType.WEAPON_PLAYER1) {
	    float[] poly = Global.player2.returnSpriteCornerArrayF();
	    if (Intersector.overlapConvexPolygons(new Polygon(poly),
		    new Polygon(this.returnSpriteCornerArrayF()))) {
		Global.player2.addHitpoints(-type.getDamage());
		setAlive(false);
	    }

	} else if (EType == EntityType.WEAPON_PLAYER2) {
	    float[] poly = Global.player1.returnSpriteCornerArrayF();
	    if (Intersector.overlapConvexPolygons(new Polygon(poly),
		    new Polygon(this.returnSpriteCornerArrayF()))) {
		Global.player1.addHitpoints(-type.getDamage());
		setAlive(false);
	    }
	}
    }

    /**
     * Dispose method
     */
    public void dispose() {
	super.dispose();
	getType().getTexture().dispose();
    }

    /**
     * @return the type
     */
    public Weapontype getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Weapontype type) {
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

}
