/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.rts.technology


/**  *  * @author user  */
class UnitTechnologySingletonFactory private() {
    import _root_.org.allbinary.game.rts.technology.UnitTechnologySingletonFactory.{*}

    private var damage : Int = 0

    private var health : Int = 0

    private var reload : Int = 0

    private var repair : Int = 0

    private var speed : Int = 0

    def init() : Unit = {
        this.setDamage(0)
        this.setHealth(0)
        this.setReload(0)
        this.setRepair(0)
        this.setSpeed(0)
    }

    /**      * @return the damage      */
    def getDamage() : Int = {
        return this.damage
    }

    /**      * @param damage the damage to set      */
    def setDamage(damage : Int) : Unit = {
        this.damage = damage
    }

    /**      * @return the health      */
    def getHealth() : Int = {
        return this.health
    }

    /**      * @param health the health to set      */
    def setHealth(health : Int) : Unit = {
        this.health = health
    }

    /**      * @return the reload      */
    def getReload() : Int = {
        return this.reload
    }

    /**      * @param reload the reload to set      */
    def setReload(reload : Int) : Unit = {
        this.reload = reload
    }

    /**      * @return the repair      */
    def getRepair() : Int = {
        return this.repair
    }

    /**      * @param repair the repair to set      */
    def setRepair(repair : Int) : Unit = {
        this.repair = repair
    }

    /**      * @return the speed      */
    def getSpeed() : Int = {
        return this.speed
    }

    /**      * @param speed the speed to set      */
    def setSpeed(speed : Int) : Unit = {
        this.speed = speed
    }

}

object UnitTechnologySingletonFactory {
    private val instance : UnitTechnologySingletonFactory = new UnitTechnologySingletonFactory()

    /**      * @return the instance      */
    def getInstance() : UnitTechnologySingletonFactory = {
        return UnitTechnologySingletonFactory.instance
    }

}


