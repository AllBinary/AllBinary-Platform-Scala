/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.paint.InitUpdatePaintable
import _root_.org.allbinary.graphics.paint.NullInitUpdatePaintable

/**  *  * @author user  */
class RTSLayerInfoPaintable() extends InitUpdatePaintable {

    private var initUpdatePaintable : InitUpdatePaintable = NullInitUpdatePaintable.getInstance()

    override def update() : Unit = {
        this.initUpdatePaintable.update()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.initUpdatePaintable.paint(graphics)
    }

    def updateRTSLayerInfoInit(hudPaintable : InitUpdatePaintable) : Unit = {
        this.initUpdatePaintable = hudPaintable
    }

    def updateRTSLayerInfoSelection(hudPaintable : SelectionHudPaintable) : Unit = {
        hudPaintable.updateSelectionInfo()
        this.initUpdatePaintable = hudPaintable
    }

}


