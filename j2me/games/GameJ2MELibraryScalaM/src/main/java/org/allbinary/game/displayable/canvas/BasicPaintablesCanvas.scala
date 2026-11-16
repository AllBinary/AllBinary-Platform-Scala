/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.paint.ColorFillBasePaintable
import _root_.org.allbinary.game.paint.ColorFillPaintableFactory
import _root_.org.allbinary.graphics.paint.Paintable

class BasicPaintablesCanvas(param_cmdListener : CommandListener, param_name : String, param_allBinaryGameLayerManager : AllBinaryGameLayerManager, param_paintableArray : Array[Paintable]) extends GameCommandCanvas(param_cmdListener, param_name, param_allBinaryGameLayerManager.getBackgroundBasicColor(), param_allBinaryGameLayerManager.getForegroundBasicColor()) {

    private var paintableArray : Array[Paintable] = null

    private var colorFillPaintable : ColorFillBasePaintable = null

    //Constructor
    {
        val cmdListener : CommandListener = param_cmdListener
        val name : String = param_name
        val allBinaryGameLayerManager : AllBinaryGameLayerManager = param_allBinaryGameLayerManager
        val paintableArray : Array[Paintable] = param_paintableArray
        this.paintableArray = paintableArray
        this.colorFillPaintable = ColorFillPaintableFactory.getInstance().getInstance(allBinaryGameLayerManager.getBackgroundBasicColor(), false)
    }

    /*     public BasicPaintablesCanvas(Paintable[] paintableArray)             throws Exception     {            this.paintableArray = paintableArray;     }     */
    override def paint(graphics : Graphics) : Unit = {
        this.colorFillPaintable.paint(graphics)
        graphics.setColor(this.foregroundColor)

        {
            var index : Int = this.paintableArray.length - 1
            while (index >= 0) {
                this.paintableArray(index).paint(graphics)
                index -= 1
            }
        }
        super.paint(graphics)
    }

}


