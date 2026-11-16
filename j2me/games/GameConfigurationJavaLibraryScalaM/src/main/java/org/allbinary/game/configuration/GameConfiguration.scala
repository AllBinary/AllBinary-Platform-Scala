/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.org.allbinary.game.configuration.event.GameFeatureEvent
import _root_.org.allbinary.game.configuration.event.GameFeatureEventHandler
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class GameConfiguration(param_name : String, param_defaultValue : Integer, param_minValue : Integer, param_maxValue : Integer) {
    import _root_.org.allbinary.game.configuration.GameConfiguration.{*}

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    private var defaultValue : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

    private var value : Integer = GameConfiguration.MIN_VALUE

    private var minValue : Integer = this.defaultValue

    private var maxValue : Integer = this.defaultValue

    private var modifiable : _root_.java.lang.Boolean = BooleanFactory.getInstance().TRUE

    //Constructor
    {
        val name : String = param_name
        val defaultValue : Integer = param_defaultValue
        val minValue : Integer = param_minValue
        val maxValue : Integer = param_maxValue
        this.setName(name)
        this.setDefaultValue(defaultValue)
        this.value = this.getDefaultValue()
        this.setMinValue(minValue)
        this.setMaxValue(maxValue)
        GameConfigurationSingleton.getInstance().getHashtable().put(this.getName(), this)
    }

    def setValue(value : Integer) : Unit = {
        if (this.value != value) {
            val oldValue : Integer = this.value
            this.value = value
            GameFeatureEventHandler.getInstance().fireEvent(new GameFeatureEvent(this, new StringMaker().append(this.name).append(" value: from: ").appendint(oldValue.intValue()).append(" to ").appendint(this.value.intValue()).toString()))
        }
    }

    def getValue() : Integer = {
        return this.value
    }

    def setMaxValue(maxValue : Integer) : Unit = {
        this.maxValue = maxValue
    }

    def getMaxValue() : Integer = {
        return this.maxValue
    }

    def setMinValue(minValue : Integer) : Unit = {
        this.minValue = minValue
    }

    def getMinValue() : Integer = {
        return this.minValue
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def getName() : String = {
        return this.name
    }

    def setDefaultValue(defaultValue : Integer) : Unit = {
        this.defaultValue = defaultValue
    }

    def getDefaultValue() : Integer = {
        return this.defaultValue
    }

    def setDefault() : Unit = {
        this.setValue(this.getDefaultValue())
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Name: ")
        stringBuffer.append(this.name)
        stringBuffer.append(" Min: ")
        stringBuffer.appendint(this.getMinValue().intValue())
        stringBuffer.append(" Max: ")
        stringBuffer.appendint(this.getMaxValue().intValue())
        stringBuffer.append(" Value: ")
        stringBuffer.appendint(this.getValue().intValue())
        stringBuffer.append(" Default: ")
        stringBuffer.appendint(this.getDefaultValue().intValue())
        stringBuffer.append(" Modifiable: ")
        stringBuffer.appendboolean(this.isModifiable().booleanValue())
        return stringBuffer.toString()
    }

    def setModifiable(modifiable : _root_.java.lang.Boolean) : Unit = {
        this.modifiable = modifiable
    }

    def isModifiable() : _root_.java.lang.Boolean = {
        return this.modifiable
    }

}

object GameConfiguration {
    private val MIN_VALUE : Integer = new Integer(Integer.MIN_VALUE)

}


