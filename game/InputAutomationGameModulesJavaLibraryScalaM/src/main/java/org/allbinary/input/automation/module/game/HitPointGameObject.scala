/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class HitPointGameObject(param_bufferedImage : Array[BufferedImage], param_minX : Integer, param_maxX : Integer, param_y : Integer) extends MeteredGameObject(param_bufferedImage, param_minX, param_maxX, param_y) with HitPointGameObjectInterface {

    private var damaged : Boolean = false

    private var closeDeath : Boolean = false

    private val HP_LABEL : String = "HP: "

    private val IS_DAMAGED_LABEL : String = "isDamaged: "

    private val IS_CLOSE_DEATH_LABEL : String = "isCloseDeath: "

    //Constructor
    {
        val bufferedImage : Array[BufferedImage] = param_bufferedImage
        val minX : Integer = param_minX
        val maxX : Integer = param_maxX
        val y : Integer = param_y
        if (this.getRatios()(bufferedImage.length - 1).doubleValue() < 1.0F) {
            this.setDamaged(true)
        } else {
            this.setDamaged(false)
        }
        if (this.getRatios()(bufferedImage.length - 1).doubleValue() > 0.25F) {
            this.closeDeath = false
        } else {
            this.closeDeath = true
        }
    }

    def isMoreThan(aFloat : Float) : Boolean = {
        if (this.getRatios()(this.getRatios().length - 1).doubleValue() > aFloat) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isCloseDeath() : Boolean = {
        return this.closeDeath
    }

    def setCloseDeath(closeDeath : Boolean) : Unit = {
        this.closeDeath = closeDeath
    }

    def isDamaged() : Boolean = {
        return this.damaged
    }

    def setDamaged(damaged : Boolean) : Unit = {
        this.damaged = damaged
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.HP_LABEL)
        stringBuffer.append(super.toString())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(this.IS_DAMAGED_LABEL)
        stringBuffer.appendboolean(this.isDamaged())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(this.IS_CLOSE_DEATH_LABEL)
        stringBuffer.appendboolean(this.isCloseDeath())
        return stringBuffer.toString()
    }

}


