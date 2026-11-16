/* Generated Code Do Not Modify */
package javax.microedition.lcdui

import _root_.java.util.Stack

class NullCanvas() extends Canvas {
    import _root_.javax.microedition.lcdui.NullCanvas.{NULL_CANVAS as _, *}
    def NULL_CANVAS : NullCanvas = _root_.javax.microedition.lcdui.NullCanvas.NULL_CANVAS

    override def setFullScreenMode(mode : Boolean) : Unit = {
    }

    override def sizeChanged(w : Int, h : Int) : Unit = {
    }

    def getCommandStack() : Stack[Object] = {
        throw new RuntimeException()
    }

    def isCommand(command : Command) : Boolean = {
        throw new RuntimeException()
    }

    override def addCommand(command : Command) : Unit = {
    }

    override def removeCommand(command : Command) : Unit = {
    }

    def removeAllCommands() : Unit = {
    }

    override def setCommandListener(l : CommandListener) : Unit = {
    }

    def getCustomCommandListener() : CommandListener = {
        throw new RuntimeException()
    }

    def isPaused() : Boolean = {
        throw new RuntimeException()
    }

    def removePauseCommand() : Unit = {
    }

    def pause() : Unit = {
    }

    def unPause() : Unit = {
    }

    def process() : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
    }

    def destroy() : Unit = {
    }

    def setPaused(isPaused : Boolean) : Unit = {
        throw new RuntimeException()
    }

    override def pointerDragged(x : Int, y : Int) : Unit = {
    }

    override def pointerPressed(x : Int, y : Int) : Unit = {
    }

    override def pointerReleased(x : Int, y : Int) : Unit = {
    }

}

object NullCanvas {
    val NULL_CANVAS : NullCanvas = new NullCanvas()

}


