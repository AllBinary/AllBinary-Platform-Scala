/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullCanvas
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.graphics.paint.ProcessPaintable
import _root_.org.allbinary.util.CircularIndexUtil

class BufferedGameCanvasPaintHelper(param_gameCanvas : AllBinaryGameCanvas) extends ProcessPaintable {
    import _root_.org.allbinary.game.displayable.canvas.BufferedGameCanvasPaintHelper.{*}

    private var gameCanvas : Canvas = NullCanvas.NULL_CANVAS

    private val offScreenImage : Array[Image] = new Array[Image](BufferedGameCanvasPaintHelper.MAX_IMAGES)

    private var previousImage : Image = NullImage.NULL_IMAGE

    private val circularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstance(BufferedGameCanvasPaintHelper.MAX_IMAGES)

    private val drawCircularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstanceAt(BufferedGameCanvasPaintHelper.MAX_IMAGES - 1, BufferedGameCanvasPaintHelper.MAX_IMAGES)

    private var anchor : Int = Anchor.TOP_LEFT

    //Constructor
    {
        val gameCanvas : AllBinaryGameCanvas = param_gameCanvas
        throw new Exception("No Longer Used")
    }

    override def process() : Unit = {
        val myCanvas : MyCanvas = (this.gameCanvas.asInstanceOf[MyCanvas])
        myCanvas.draw(this.offScreenImage(this.circularIndexUtil.getIndex()).getGraphics())
        this.circularIndexUtil.next()
        this.drawCircularIndexUtil.next()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.previousImage = this.offScreenImage(this.drawCircularIndexUtil.getIndex())
        graphics.drawImage(this.previousImage, 0, 0, this.anchor)
    }

}

object BufferedGameCanvasPaintHelper {
    // Buffering Magic
    private val MAX_IMAGES : Int = 4

}


