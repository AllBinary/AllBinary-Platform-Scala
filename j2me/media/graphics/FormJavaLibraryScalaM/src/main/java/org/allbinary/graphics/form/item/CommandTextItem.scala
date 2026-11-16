/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.graphics.color.BasicColor

class CommandTextItem(param_command : Command, param_layout : Int, param_altText : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ABTextItem(param_command.getLabel(), param_layout, param_altText, param_backgroundBasicColor, param_foregroundBasicColor) {

    private var command : Command = null

    //Constructor
    {
        val command : Command = param_command
        val layout : Int = param_layout
        val altText : String = param_altText
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.command = command
    }

    override def isFocusable() : Boolean = {
        return true
    }

    /**      * @return the command      */
    def getCommand() : Command = {
        return this.command
    }

}


