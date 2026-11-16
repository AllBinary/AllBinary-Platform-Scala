/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.NullCanvas
import _root_.org.allbinary.canvas.RunnableCanvas
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.input.GameInputStrings
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList

class DemoCanvasBasicStartInputProcessor(param_gameKeyEventList : BasicArrayList, param_gameCanvas : RunnableCanvas) extends BasicMenuInputProcessor(param_gameKeyEventList, -1, param_gameCanvas) {

    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val gameCanvas : RunnableCanvas = param_gameCanvas
    }

    /*     public int processInput(int key) throws Exception     {         return -1;     }      */
    override def processInputList() : Int = {
        var list : BasicArrayList = this.getGameKeyEventList()
        var size : Int = list.size()
        var gameKeyEvent : GameKeyEvent = null

        {
            var index : Int = 0
            while (index < size) {
                gameKeyEvent = list.objectArray(index).asInstanceOf[GameKeyEvent]
                this.logUtil.putF(new StringMaker().append("Start GameKey: ").append(StringUtil.getInstance().toString(gameKeyEvent)).toString(), this, GameInputStrings.getInstance().PROCESS_INPUT)
                index += 1
            }
        }
        this.getCanvas().getCustomCommandListener().commandAction(GameCommandsFactory.getInstance().START_COMMAND, NullCanvas.NULL_CANVAS)
        return size
    }

}


