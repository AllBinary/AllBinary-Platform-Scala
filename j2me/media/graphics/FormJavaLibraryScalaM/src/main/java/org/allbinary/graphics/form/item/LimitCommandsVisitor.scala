/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.form.ScreenInfo
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.util.visitor.Visitor

class LimitCommandsVisitor() extends Visitor {

    private var isNotSmallDisplay : Boolean = false

    //Constructor
    {
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        this.isNotSmallDisplay = (displayInfo.isPortrait() && (displayInfo.getLastHeight() > ScreenInfo.getInstance().SMALL_WIDTH)) || (!displayInfo.isPortrait() && (displayInfo.getLastHeight() > ScreenInfo.getInstance().SMALL_HEIGHT))
    }

    override def visit(anyType : Object) : Object = {
        var command : Command = anyType.asInstanceOf[Command]
        var booleanFactory : BooleanFactory = BooleanFactory.getInstance()
        if (((this.isNotSmallDisplay || (command.getPriority() == 1)) || (command eq GameCommandsFactory.getInstance().EXIT_COMMAND)) || (command eq GameCommandsFactory.getInstance().EXIT_WITHOUT_PROGRESS_COMMAND)) {
            return booleanFactory.TRUE
        } else {
            return booleanFactory.FALSE
        }
        throw new IllegalStateException()
    }

}


