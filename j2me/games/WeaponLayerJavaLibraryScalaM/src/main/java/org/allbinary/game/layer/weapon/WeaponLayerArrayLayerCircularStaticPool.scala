/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon

import _root_.org.allbinary.util.CircularIndexUtil

class WeaponLayerArrayLayerCircularStaticPool {
    import _root_.org.allbinary.game.layer.weapon.WeaponLayerArrayLayerCircularStaticPool.{*}

    private val MAX : Int = 5

    private var circularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstance(this.MAX)

    private var WEAPONLAYER_ARRAY : Array[Array[WeaponLayer]] = null

    private var TWO_WEAPONLAYER_ARRAY : Array[Array[WeaponLayer]] = null

    private var THREE_WEAPONLAYER_ARRAY : Array[Array[WeaponLayer]] = null

    def init() : Unit = {
        val WEAPONLAYER_ARRAY : Array[Array[WeaponLayer]] = new Array[Array[WeaponLayer]](this.MAX * 2)
        val TWO_WEAPONLAYER_ARRAY : Array[Array[WeaponLayer]] = new Array[Array[WeaponLayer]](this.MAX)
        val THREE_WEAPONLAYER_ARRAY : Array[Array[WeaponLayer]] = new Array[Array[WeaponLayer]](this.MAX)

        {
            var index : Int = 0
            while (index < this.MAX) {
                WEAPONLAYER_ARRAY(index) = new Array[WeaponLayer](1)
                TWO_WEAPONLAYER_ARRAY(index) = new Array[WeaponLayer](2)
                THREE_WEAPONLAYER_ARRAY(index) = new Array[WeaponLayer](3)
                index += 1
            }
        }
        this.WEAPONLAYER_ARRAY = WEAPONLAYER_ARRAY
        this.TWO_WEAPONLAYER_ARRAY = TWO_WEAPONLAYER_ARRAY
        this.THREE_WEAPONLAYER_ARRAY = THREE_WEAPONLAYER_ARRAY
    }

    private def getWeaponLayerArrays(size : Int) : Array[Array[WeaponLayer]] = {
        if (size == 1) {
            return this.WEAPONLAYER_ARRAY
        } else if (size == 2) {
            return this.TWO_WEAPONLAYER_ARRAY
        } else if (size == 3) {
            return this.THREE_WEAPONLAYER_ARRAY
        }
        throw new RuntimeException()
    }

    def getInstanceArray(size : Int) : Array[WeaponLayer] = {
        val weaponLayerArray : Array[WeaponLayer] = this.getWeaponLayerArrays(size)(this.circularIndexUtil.getIndex())
        // weaponLayerArray.length, this, // commonStrings.GET_INSTANCE);
        this.circularIndexUtil.next()
        return weaponLayerArray
    }

}

object WeaponLayerArrayLayerCircularStaticPool {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : WeaponLayerArrayLayerCircularStaticPool = new WeaponLayerArrayLayerCircularStaticPool()

    def getInstance() : WeaponLayerArrayLayerCircularStaticPool = {
        return WeaponLayerArrayLayerCircularStaticPool.instance
    }

}


