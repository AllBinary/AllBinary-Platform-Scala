/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.score.displayable.HighScoresCanvas
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class HighScoresCanvasInputProcessor(param_highScoresCanvas : HighScoresCanvas) extends PlayerGameInput(new BasicArrayListD(), new BasicArrayListD(), -1) {

    private var highScoresCanvas : HighScoresCanvas = null

    //Constructor
    {
        val highScoresCanvas : HighScoresCanvas = param_highScoresCanvas
        this.highScoresCanvas = highScoresCanvas
    }

    def open() : Unit = {
    }

    def close() : Unit = {
    }

    override def onPressGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        super.onPressGameKeyEvent(gameKeyEvent)
        this.update()
    }

    override def onDownGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        super.onDownGameKeyEvent(gameKeyEvent)
        this.update()
    }

    override def onUpGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        super.onUpGameKeyEvent(gameKeyEvent)
        this.update()
    }

    def paint(graphics : Graphics) : Unit = {
    }

    def getHighScoresCanvas() : HighScoresCanvas = {
        return this.highScoresCanvas
    }

}


