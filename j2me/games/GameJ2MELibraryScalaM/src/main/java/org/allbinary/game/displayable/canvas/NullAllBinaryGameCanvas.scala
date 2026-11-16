/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager

/**  *  * @author User  */
class NullAllBinaryGameCanvas extends AllBinaryGameCanvasInterface {
    import _root_.org.allbinary.game.displayable.canvas.NullAllBinaryGameCanvas.{NULL_ALLBINARY_GAME_CANVAS as _, *}
    def NULL_ALLBINARY_GAME_CANVAS : NullAllBinaryGameCanvas = _root_.org.allbinary.game.displayable.canvas.NullAllBinaryGameCanvas.NULL_ALLBINARY_GAME_CANVAS

    override def getLayerManager() : AllBinaryGameLayerManager = {
        throw new RuntimeException()
    }

    override def addCommand(cmd : Command) : Unit = {
        throw new RuntimeException()
    }

    override def getHeight() : Int = {
        throw new RuntimeException()
    }

    override def getWidth() : Int = {
        throw new RuntimeException()
    }

    override def removeCommand(cmd : Command) : Unit = {
        throw new RuntimeException()
    }

    override def setCommandListener(l : CommandListener) : Unit = {
        throw new RuntimeException()
    }

}

object NullAllBinaryGameCanvas {
    val NULL_ALLBINARY_GAME_CANVAS : NullAllBinaryGameCanvas = new NullAllBinaryGameCanvas()

}


