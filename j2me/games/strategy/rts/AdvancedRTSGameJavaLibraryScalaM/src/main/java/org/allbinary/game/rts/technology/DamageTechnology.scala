/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.rts.technology

import _root_.org.allbinary.game.layer.RTSInterface

/**  *  * @author user  */
class DamageTechnology(param_maxLevel : Int) extends RTSInterface {

    private var level : Int = 0

    private var maxLevel : Int = 0

    //Constructor
    {
        val maxLevel : Int = param_maxLevel
        this.maxLevel = maxLevel
    }

    override def isCompleted() : Boolean = {
        return false
    }

    override def getPercentComplete() : Int = {
        return 0
    }

    override def getLevel() : Int = {
        return this.level
    }

    override def getMaxLevel() : Int = {
        return this.maxLevel
    }

    override def getCost() : Int = {
        return 0
    }

    override def downgrade() : Unit = {
    }

    override def getDowngradeCost() : Int = {
        return 0
    }

    override def isDowngradeable() : Boolean = {
        return false
    }

    override def getUpgradeCost() : Int = {
        return (this.getLevel() * this.getLevel()) * 1000
    }

    override def isUpgradeable() : Boolean = {
        if (this.getLevel() < this.getMaxLevel()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def upgrade() : Unit = {
        this.level += 1
        var unitTechnologySingletonFactory : UnitTechnologySingletonFactory = UnitTechnologySingletonFactory.getInstance()
        unitTechnologySingletonFactory.setDamage(unitTechnologySingletonFactory.getDamage() + (this.getLevel() * 100))
    }

    override def isSelfUpgradeable() : Boolean = {
        return false
    }

}


