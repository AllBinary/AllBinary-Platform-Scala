/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.event.GameKeyEventHandler
import _root_.org.allbinary.game.input.event.GameKeyEventUtil
import _root_.org.allbinary.game.score.displayable.HighScoresCanvas
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.util.BasicArrayList

class HighScoresCanvasLevelChangeInputProcessor(param_highScoresCanvas : HighScoresCanvas) extends HighScoresCanvasInputProcessor(param_highScoresCanvas) with UpdateMyFontInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    // "(Up = Next Track, Down = Previous Track)";
    private val INSTRUCTIONS : String = "(Right = Next Track, Left = Previous Track)"

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    // private final String INSTRUCTIONS = "(Change Tracks With Game Controls)";
    private var anchor : Int = Anchor.TOP_LEFT

    private var fontHeight : Int = 0

    //Constructor
    {
        val highScoresCanvas : HighScoresCanvas = param_highScoresCanvas
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def open() : Unit = {
        //BasicMotionGesturesHandler.getInstance().addListener(this);
        GameKeyEventHandler.getInstance().addListener(this)
    }

    override def close() : Unit = {
        //BasicMotionGesturesHandler.getInstance().removeListener(this);
        GameKeyEventHandler.getInstance().removeListener(this)
    }

    override def update() : Unit = this.synchronized {
        val list : BasicArrayList = this.getGameKeyEventList()
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                val anyType : Object = list.objectArray(index)
                val key : Int = GameKeyEventUtil.getKey(anyType)
                // if(gameKey == GameKey.UP || gameKey == GameKey.RIGHT)
                if (key == Canvas.RIGHT) {
                    this.getHighScoresCanvas().getGameInfo().nextGameLevel()
                } else if (key == Canvas.LEFT) {
                    this.getHighScoresCanvas().getGameInfo().previousGameLevel()
                }
                this.getHighScoresCanvas().executeUpdate()
                index += 1
            }
        }
        list.clear()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        //int width = graphics.getClipWidth();
        val width : Int = this.displayInfoSingleton.getLastWidth()
        val topScoresWidth : Int = (graphics.getFont().stringWidth(this.INSTRUCTIONS) >> 1)
        graphics.drawString(this.INSTRUCTIONS, (width >> 1) - topScoresWidth, this.fontHeight * 2, this.anchor)
    }

}


