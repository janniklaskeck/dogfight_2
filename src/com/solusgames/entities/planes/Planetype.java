package com.solusgames.entities.planes;

import com.badlogic.gdx.Gdx;
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

    private String name;
    private PlaneTypes type;

    /**
     * Creats Plane given on parameters
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
	this.setName("Standard");
	this.hitpoints = hitpoints;
	this.maxSpeed = max;
	this.minSpeed = min;
	this.turnSpeed = turn;
	this.slot_1 = slot_1;
	this.slot_2 = slot_2;
	this.slot_3 = slot_3;
	this.slot_4 = slot_4;
	this.setTexture(texture);

    }

    /**
     * Creats Plane given on Type
     * 
     * @param type
     */
    public Planetype(PlaneTypes type) {
	if (type == PlaneTypes.F35) {
	    this.setType(type);
	    this.setName("F35");
	    this.hitpoints = 100;
	    this.maxSpeed = 7;
	    this.minSpeed = 0;
	    this.turnSpeed = 2;
	    this.slot_1 = true;
	    this.slot_2 = true;
	    this.slot_3 = true;
	    this.slot_4 = true;
	    this.setTexture(new Texture(Gdx.files
		    .internal("assets/data/planes/gen5/f35.png")));
	} else if (type == PlaneTypes.MIG_35) {
	    this.setType(type);
	    this.setName("MIG");
	    this.hitpoints = 100;
	    this.maxSpeed = 7;
	    this.minSpeed = 0;
	    this.turnSpeed = 2;
	    this.slot_1 = true;
	    this.slot_2 = true;
	    this.slot_3 = true;
	    this.slot_4 = true;
	    this.setTexture(new Texture(Gdx.files
		    .internal("assets/data/planes/plane1.png")));
	} else {
	    //standard plane
	    this.setType(type);
	    this.setName("MIG");
	    this.hitpoints = 100;
	    this.maxSpeed = 7;
	    this.minSpeed = 1;
	    this.turnSpeed = 2;
	    this.slot_1 = true;
	    this.slot_2 = true;
	    this.slot_3 = true;
	    this.slot_4 = true;
	    this.setTexture(new Texture(Gdx.files
		    .internal("assets/data/planes/plane1.png")));
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

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public PlaneTypes getType() {
	return type;
    }

    public void setType(PlaneTypes type) {
	this.type = type;
    }

    /**
     * All available Planes
     * 
     * @author Jan-Niklas
     * 
     */
    public enum PlaneTypes {
	/**
	 * WW1 Gen 1
	 */
	// British
	SE5, SOPWITH_TRI, DH2, SOPWITH_PUP, SOPWITH_F1, SOPWITH_7F1,
	// German
	FOKKER_EIII, PFALZ_E1, SIEMENS_SCHUCKERT_D1, ALBATROSS_DII, ALBATROSS_DV, FOKKER_DR1, FOKKER_DVII, FOKKER_DVIII,
	// French
	MORANE_TYPN, NIEUPORT_11, NIEUPORT_17,
	/**
	 * WW2 Gen 2
	 */
	// British
	HURRICANE_MKI, HURRICANE_MKIIC, SPITFIRE_MKIB, SPITFIRE_MKIX, TYPHOON_MKIB, TEMPEST_MKV, SWORDFISH_MKII,
	// German
	BF_109_E4, BF_109_E4B, BF_109_F4, BF_109_G6, BF_109_K4, BF_100C_4, BF_100C_4B, BF_100G_6, FW_190_A4, FW_190_A9, FW_190_D9, TA_152_H1, DO_335_A, DO_335_B, ME_262A_1A, ME_262A_1A_U4, ME_262A_2, HE_162, GO_229A_D, ME_163, JU_87D, JU_87G,
	// Russian
	I_16, I_153, LAGG_3, LAGG_3IT, LA_5FN, LA_7, MIG_3, MIG_3U, JAK_1, JAK_9U, JAK_9K, PE_2, PE_3BIS, IL_2_3M,
	// American
	F_2A, F4F, F4F_4, F6F, F6F5, F_8F, F_4U, F_4U1C, F2G_2, P_38N_1, P_63C_5, P_40, P_47B, P_47D, P_51D, TBF,
	// Japan
	A6M2, A6M5, KI_43_IIB, N1K1, KI_84, KI_45, J7W1,

	/**
	 * Vietnam Gen 3
	 */
	// American
	F_86, F_100A, F_9F, F_8U, F_4, A_7, UH_1, AH_1,
	// Russian
	MIG_9, MIG_15, MIG_17, MIG_19, MIG_21, SU_17, SU_15, TU_28P, MI_8,
	// German
	F_104G,

	/**
	 * Modern 1 Gen 4
	 */
	// American
	F_5A, F_20, F_14A, F_14D, F_15C, F_15E, F_16, FA_18E, A_10, F_19, F_117A, AH_1W, AH_64A,
	// German
	MIG_29G, F_4F, TORNADO,
	// Russian
	MIG_23, MIG_25, MIG_27, MIG_29, MIG_31, SU_24, SU_25, SU_27, MI_24, MI_28,
	// British
	TORNADO_ADV,
	/**
	 * Modern 2 Gen 5
	 */
	// German
	EUROFIGHTER, UH_TIGER,
	// American
	F_22, F35, AH_64D, AH_66,
	// Russian
	MIG_35, SU_32, SU_33, SU_37, SU47, SU_25T, KA_50;
    }

}
