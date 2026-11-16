/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.draw.CanvasDrawLineString
import _root_.org.allbinary.graphics.paint.InitUpdatePaintable

/**  *  * @author user  */
class PreGameSelectorPaintable(param_title : String, param_preGameScrollSelectionForm : PreGameScrollSelectionForm) extends InitUpdatePaintable {

    private var title : String = null

    private var canvasDrawLineString : CanvasDrawLineString = null

    private var preGameScrollSelectionForm : PreGameScrollSelectionForm = null

    //Constructor
    {
        val title : String = param_title
        val preGameScrollSelectionForm : PreGameScrollSelectionForm = param_preGameScrollSelectionForm
        this.title = title
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        this.canvasDrawLineString = new CanvasDrawLineString(displayInfo.getLastHalfWidth(), 0)
        this.preGameScrollSelectionForm = preGameScrollSelectionForm
    }

    override def update() : Unit = {
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        this.canvasDrawLineString = new CanvasDrawLineString(displayInfo.getLastHalfWidth(), 0)
    }

    override def paint(graphics : Graphics) : Unit = {
        graphics.setColor(BasicColorFactory.getInstance().WHITE.intValue())
        this.canvasDrawLineString.paint(graphics, title, 0)
        this.getPreGameSelectionForm().paint(graphics)
    }

    /**      * @return the mapSelectionForm      */
    def getPreGameSelectionForm() : PreGameScrollSelectionForm = {
        return this.preGameScrollSelectionForm
    }

}


