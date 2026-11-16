/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.hud.event

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class GameNotificationEvent(param_anyType : Object, param_string : String, param_seconds : Integer, param_basicColor : BasicColor, param_permanent : _root_.java.lang.Boolean) extends AllBinaryEventObject(param_anyType) {

    private var string : String = StringUtil.getInstance().EMPTY_STRING

    private var seconds : Integer = null

    private var basicColor : BasicColor = BasicColorFactory.getInstance().BLACK

    private var removeable : _root_.java.lang.Boolean = null

    //Constructor
    {
        val anyType : Object = param_anyType
        val string : String = param_string
        val seconds : Integer = param_seconds
        val basicColor : BasicColor = param_basicColor
        val permanent : _root_.java.lang.Boolean = param_permanent
        this.setString(string)
        this.seconds = seconds
        this.setBasicColorP(basicColor)
        this.removeable = permanent
    }

    def getString() : String = {
        return this.string
    }

    def getSeconds() : Integer = {
        return this.seconds
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    def getPermanent() : _root_.java.lang.Boolean = {
        return this.removeable
    }

    def setString(string : String) : Unit = {
        this.string = string
    }

    def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

}


