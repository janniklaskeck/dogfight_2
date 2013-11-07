package com.solusgames.entities.weapons;

import com.badlogic.gdx.Gdx;
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
     * Only type as Parameter, weapon settings hardcoded
     * 
     * @param type
     */
    public Weapontype(WeaponTypes type) {

	if (type == WeaponTypes.HYDRA_M247) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.HYDRA_M261) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.S_5_ROCKET) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.S_8KOM_ROCKET) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.ZUNI_ROCKET) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.S_24_ROCKET) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_114K_HELLFIRE_B) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_122_SIDEARM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_114_HELLFIRE) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_71D_TOW_2) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_84_HARPOON) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_65_MAVERICK) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_88_HARM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AGM_71A_TOW) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.GBU_52) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.BLU_109) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.BLU_107_DURANDAL) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R33_AA_9_AMOS) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R77_AA_12_ADDER) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R27TE_AA_10E_ALAMO) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}

	if (type == WeaponTypes.R27TE_AA_10D_ALAMO) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R27RE_AA_10C_ALAMO) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R27T_AA_10B_ALAMO) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R27R_AA_10A_ALAMO) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R73M1_AA_11_ARCHER) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R4OT_AA_6B_ACRID) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R4OR_AA_6A_ACRID) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R4TM_AA_5B_ASH) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R4RM_AA_5A_ASH) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R8T_AA_3A_ANAB) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R8R_AA_3B_ANAB) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R60_AA_8_APHID) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R3R_AA_2_ATOLL) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.R3T_AA_2_ATOLL) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.MK_82) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.MK_83) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.MK_20_ROCKEYE) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}

	if (type == WeaponTypes.MG_12MM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.GUN_30MM) {
	    this.maxSpeed = 10;
	    this.minSpeed = 10;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 30;
	    this.reloadTime = 10;
	    this.damage = 10;
	    this.fireRate = 100;
	    this.texture = new Texture(Gdx.files.internal("assets/data/weapons/30mms.png"));
	    this.sound = null;
	}
	if (type == WeaponTypes.GUN_27MM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.GUN_23MM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.GATLING_7MM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.GATLING_20MM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.GATLING_30MM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_155_AAAM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_54C_PHOENIX) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_120B_AMRAAM) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_7C_SPARROW) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_9X_SIDEWINDER) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_9L_SIDEWINDER) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_9D_SIDEWINDER) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_9C_SIDEWINDER) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}
	if (type == WeaponTypes.AIM_92_STINGER) {
	    this.maxSpeed = 0;
	    this.minSpeed = 0;
	    this.turnSpeed = 0;
	    this.homing = false;
	    this.maxAmmo = 0;
	    this.reloadTime = 0;
	    this.damage = 0;
	    this.fireRate = 0;
	    this.texture = null;
	    this.sound = null;
	}

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

    public enum WeaponTypes {
	HYDRA_M247, HYDRA_M261, S_5_ROCKET, S_8KOM_ROCKET, ZUNI_ROCKET, S_24_ROCKET, AGM_114K_HELLFIRE_B, AGM_122_SIDEARM, AGM_114_HELLFIRE, AGM_71D_TOW_2, AGM_84_HARPOON, AGM_65_MAVERICK, AGM_88_HARM, AGM_71A_TOW, GBU_52, BLU_109, BLU_107_DURANDAL, R33_AA_9_AMOS, R77_AA_12_ADDER, R27TE_AA_10E_ALAMO, R27TE_AA_10D_ALAMO, R27RE_AA_10C_ALAMO, R27T_AA_10B_ALAMO, R27R_AA_10A_ALAMO, R73M1_AA_11_ARCHER, R4OT_AA_6B_ACRID, R4OR_AA_6A_ACRID, R4TM_AA_5B_ASH, R4RM_AA_5A_ASH, R8T_AA_3A_ANAB, R8R_AA_3B_ANAB, R60_AA_8_APHID, R3R_AA_2_ATOLL, R3T_AA_2_ATOLL, MK_82, MK_83, MK_20_ROCKEYE, MG_12MM, GUN_30MM, GUN_27MM, GUN_23MM, GATLING_7MM, GATLING_20MM, GATLING_30MM, AIM_155_AAAM, AIM_54C_PHOENIX, AIM_120B_AMRAAM, AIM_7C_SPARROW, AIM_9X_SIDEWINDER, AIM_9L_SIDEWINDER, AIM_9D_SIDEWINDER, AIM_9C_SIDEWINDER, AIM_92_STINGER;
    }

}
