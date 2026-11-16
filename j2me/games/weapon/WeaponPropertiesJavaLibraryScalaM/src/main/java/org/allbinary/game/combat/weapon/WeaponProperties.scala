/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.weapon

import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class WeaponProperties(param_reloadTime : Long, param_targetingTime : Long, param_speed : Long, param_damage : Int, param_dissipation : Short) extends SimpleWeaponProperties {
    import _root_.org.allbinary.game.combat.weapon.WeaponProperties.{NULL_WEAPON_PROPERTIES as _, *}
    def NULL_WEAPON_PROPERTIES : WeaponProperties = _root_.org.allbinary.game.combat.weapon.WeaponProperties.NULL_WEAPON_PROPERTIES

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var reloadTime : Long = 0L

    private var targetingTime : Long = 0L

    private var speed : BasicDecimal = BasicDecimal.ZERO_BIGDECIMAL

    private val MAX : Long = 10240L

    private val ZERO : Short = 0

    //Constructor
    {
        val reloadTime : Long = param_reloadTime
        val targetingTime : Long = param_targetingTime
        val speed : Long = param_speed
        val damage : Int = param_damage
        val dissipation : Short = param_dissipation
        if (((speed < this.MAX) && (speed != 0L)) && !WeaponProperties.messageSent) {
            val MESSAGE : String = "Danger Danger Danger: Speed probably to slow if using 1 degree calculations as velocity for a single axis could be below 1024: "
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            PreLogUtil.put(new StringMaker().append(MESSAGE).appendlong(speed).toString(), this, commonStrings.CONSTRUCTOR)
            //throw new Exception(MESSAGE + speed);
            WeaponProperties.messageSent = true
        }
        this.setReloadTime(reloadTime)
        this.setTargetingTime(targetingTime)
        this.setDamage(damage)
        this.setDissipation(dissipation)
        this.setSpeed(new BasicDecimal(speed))
        if (dissipation != this.ZERO) {
            val unscaledDamage : Long = this.speed.getUnscaled() * damage
            val scaledDissipation : Int = dissipation * this.speed.getScaledFactorValue()
            val value : Long = (unscaledDamage / scaledDissipation)
            this.setRange((value * 9).toInt / 10)
        }
    }

    private def setReloadTime(reloadTime : Long) : Unit = {
        this.reloadTime = reloadTime
    }

    def getReloadTime() : Long = {
        return this.reloadTime
    }

    private def setTargetingTime(targetingTime : Long) : Unit = {
        this.targetingTime = targetingTime
    }

    def getTargetingTime() : Long = {
        return this.targetingTime
    }

    /**      * @return the speed      */
    def getSpeed() : BasicDecimal = {
        return this.speed
    }

    /**      * @param speed the speed to set      */
    def setSpeed(speed : BasicDecimal) : Unit = {
        this.speed = speed
    }

    def getDamageI(range : Int) : Int = {
        return this.getDamage() - ((this.getDissipation() * range) / this.speed.getScaled())
    }

    def toStringArray() : Array[String] = {
        var index : Int = 0
        val stringArray : Array[String] = new Array[String](3)
        val stringBuffer : StringMaker = new StringMaker()
        stringArray({ val value_N69279 = index; index += 1; value_N69279 }) = stringBuffer.append(WeaponProperties.DAMAGE).appendint(this.getDamage()).toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringArray({ val value_N69421 = index; index += 1; value_N69421 }) = stringBuffer.append(WeaponProperties.RANGE).appendint(this.getRange()).toString()
        //stringArray[index++] = "Speed: " + this.getSpeed();
        stringBuffer.delete(0, stringBuffer.length())
        stringArray({ val value_N69567 = index; index += 1; value_N69567 }) = stringBuffer.append(WeaponProperties.RELOAD).appendlong(this.getReloadTime()).toString()
        return stringArray
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(WeaponProperties.DAMAGE).appendint(this.getDamage())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(WeaponProperties.RANGE).appendint(this.getRange())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(WeaponProperties.RELOAD).appendlong(this.getReloadTime())
        return stringBuffer.toString()
    }

}

object WeaponProperties {
    val NULL_WEAPON_PROPERTIES : WeaponProperties = new WeaponProperties(0L, 0L, 0L, 0, (0).toShort)

    private var messageSent : Boolean = false

    private val DAMAGE : String = "Damage: "

    private val RANGE : String = "Range: "

    private val RELOAD : String = "Reload: "

}


