/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.health

import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class Health(param_maxHealth : Int) extends HealthInterface {
    import _root_.org.allbinary.game.health.Health.{NULL_HEALTH as _, NAME as _, *}
    def NULL_HEALTH : Health = _root_.org.allbinary.game.health.Health.NULL_HEALTH
    def NAME : String = _root_.org.allbinary.game.health.Health.NAME

    private var health : Int = 0

    private var maxHealth : Int = 0

    private var healthListenerInterface : HealthListenerInterface = NullHealthListener.NULL_HEALTH_LISTENER

    //Constructor
    {
        val maxHealth : Int = param_maxHealth
        this.setMaxHealth(maxHealth)
        this.setHealth(maxHealth)
    }

    override def heal(ahealth : Int) : Unit = {
        var newHealth : Int = this.getHealth() + ahealth
        if (newHealth > this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth())
        } else {
            this.setHealth(newHealth)
        }
    }

    override def healMax() : Unit = {
        this.setHealth(this.getMaxHealth())
    }

    def isDamaged() : Boolean = {
        if (this.getHealth() != this.getMaxHealth()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def damage(ahealth : Int) : Unit = {
        if (ahealth < 0) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("******* Trying to heal when damaging. Damage: ")
            stringBuffer.appendint(ahealth)
            stringBuffer.append(CommonSeps.getInstance().SPACE)
            stringBuffer.append(this.toString())
            ForcedLogUtil.log(stringBuffer.toString(), this)
            return
        }
        var health : Int = this.getHealth() - ahealth
        this.setHealth(health)
    }

    override def isAlive() : Boolean = {
        if (this.getHealth() <= 0) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    override def getMaxHealth() : Int = {
        return this.maxHealth
    }

    override def setMaxHealth(maxHealth : Int) : Unit = {
        this.maxHealth = maxHealth
    }

    def setHealth(health : Int) : Unit = {
        if (health > this.getMaxHealth()) {
            this.health = this.getMaxHealth()
        } else if (health < 0) {
            this.health = 0
        } else {
            this.health = health
        }
        if (this.healthListenerInterface != null) {
            //this);
            this.healthListenerInterface.onHealthChange()
        }
    }

    override def getHealth() : Int = {
        return this.health
    }

    override def addListener(healthGraphic : HealthListenerInterface) : Unit = {
        this.healthListenerInterface = healthGraphic
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(Health.HEALTH_LABEL)
        stringBuffer.appendint(this.health)
        stringBuffer.append(Health.MAX_HEALTH_LABEL)
        stringBuffer.appendint(this.maxHealth)
        return stringBuffer.toString()
    }

}

object Health {
    val NULL_HEALTH : Health = new Health(0)

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val NAME : String = "Health Resource"

    private val HEALTH_LABEL : String = "Health: "

    private val MAX_HEALTH_LABEL : String = " Max: "

}


