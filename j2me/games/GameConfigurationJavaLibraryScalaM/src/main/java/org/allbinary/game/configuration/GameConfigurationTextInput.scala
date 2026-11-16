/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.TextField
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.ABHashtable

class GameConfigurationTextInput(param_label : String, param_text : String) {
    import _root_.org.allbinary.game.configuration.GameConfigurationTextInput.{*}

    private var label : String = StringUtil.getInstance().EMPTY_STRING

    private var text : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val label : String = param_label
        val text : String = param_text
        this.setText(text)
        this.setLabel(label)
        GameConfigurationTextInput.hashtable.put(this.getLabel(), this)
    }

    def setText(text : String) : Unit = {
        this.text = text
    }

    def getText() : String = {
        return this.text
    }

    def setLabel(label : String) : Unit = {
        this.label = label
    }

    def getLabel() : String = {
        return this.label
    }

}

object GameConfigurationTextInput {
    private var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    var SIMULATOR_IP : GameConfigurationTextInput = new GameConfigurationTextInput("IP: ", "192.168.1.3")

    var SIMULATOR_PORT : GameConfigurationTextInput = new GameConfigurationTextInput("Port: ", "8010")

    def update(textField : TextField) : Unit = {
        val anyType : Object = textField.getLabel().asInstanceOf[Object]
        var gameConfigurationTextInput : GameConfigurationTextInput = GameConfigurationTextInput.hashtable.get(anyType).asInstanceOf[GameConfigurationTextInput]
        gameConfigurationTextInput.setText(textField.getString())
    }

    def getHashtable() : ABHashtable[Object, Object] = {
        return GameConfigurationTextInput.hashtable
    }

}


