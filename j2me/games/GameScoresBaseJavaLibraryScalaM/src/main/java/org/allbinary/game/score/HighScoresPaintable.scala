/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.ColorChangeEvent
import _root_.org.allbinary.graphics.color.ColorChangeListener
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.util.BasicArrayList

class HighScoresPaintable() extends Paintable with ColorChangeListener with UpdateMyFontInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    private var highScores : HighScores = NullHighScoresSingletonFactory.getInstance()

    private var anchor : Int = Anchor.TOP_LEFT

    private var charHeight : Int = 0

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.charHeight = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        //this.logUtil.putF("Color Change Event: " + basicColor.getName(), this, "onEvent");
        val colorChangeEvent : ColorChangeEvent = eventObject.asInstanceOf[ColorChangeEvent]
        this.basicColor = colorChangeEvent.getBasicColorP()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        //int height = graphics.getClipHeight();
        val width : Int = this.displayInfoSingleton.getLastWidth()
        val height : Int = this.displayInfoSingleton.getLastHeight()
        graphics.setColor(this.getBasicColorP().intValue())
        var heading : String = this.highScores.getHeading()
        val topScoresWidth : Int = (graphics.getFont().stringWidth(heading) >> 1)
        val charHeight : Int = this.charHeight
        graphics.drawString(heading, (width >> 1) - topScoresWidth, charHeight, this.anchor)
        graphics.drawString(this.highScores.getColumnOneHeading(), 10, charHeight * 3, this.anchor)
        var columnTwoHeading : String = this.highScores.getColumnTwoHeading()
        val columnTwoHeadingWidth : Int = graphics.getFont().stringWidth(columnTwoHeading)
        graphics.drawString(columnTwoHeading, (width - 10) - columnTwoHeadingWidth, charHeight * 3, this.anchor)
        var index : Int = 4
        var largestSecondColumnWidth : Int = columnTwoHeadingWidth
        var list : BasicArrayList = this.highScores.getList()
        var size : Int = list.size()
        var vectorIndex : Int = 0
        var highScore : HighScore = null

        {
            while ((vectorIndex < size) && ((charHeight * index) < (height - (charHeight * 2)))) {
                highScore = list.objectArray(vectorIndex).asInstanceOf[HighScore]
                var nextScoreWidth : Int = graphics.getFont().stringWidth(highScore.getScoreString())
                if (nextScoreWidth > largestSecondColumnWidth) {
                    largestSecondColumnWidth = nextScoreWidth
                }
                vectorIndex += 1
            }
        }
        vectorIndex = 0

        {
            while ((vectorIndex < size) && ((charHeight * index) < (height - (charHeight * 2)))) {
                highScore = list.objectArray(vectorIndex).asInstanceOf[HighScore]
                // this.highScoresHashTable.get(enumeration.nextElement());
                graphics.drawString(highScore.getName(), 10, charHeight * index, this.anchor)
                graphics.drawString(highScore.getScoreString(), (width - 10) - largestSecondColumnWidth, charHeight * index, this.anchor)
                index += 1
                vectorIndex += 1
            }
        }
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    def setHighScores(highScores : HighScores) : Unit = {
        this.highScores = highScores
    }

}


