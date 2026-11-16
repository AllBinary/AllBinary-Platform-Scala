/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.NullPathFindingLayer
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.SelectionHudPaintable
import _root_.org.allbinary.graphics.draw.KeyValueDrawString

/**  *   * @author user  */
class WaypointInfoHudPaintable() extends SelectionHudPaintable {

    private var keyvalueDrawString : KeyValueDrawString = null

    var rtsLayerP : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    private var textLine2Y : Int = 0

    //protected
    //Constructor
    {
        this.keyvalueDrawString = new KeyValueDrawString("Owner: ", this.textX)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        super.updateMeasurement(graphics)
        val font : Font = graphics.getFont()
        this.textLine2Y = (this.y + font.getHeight())
    }

    override def updateSelectionInfo() : Unit = {
        //WaypointLayer
        val rtsLayer : RTSLayer = this.rtsLayerP.asInstanceOf[RTSLayer]
        this.setName(rtsLayer.getName())
        this.setAnimationInterface(rtsLayer.getVerticleBuildAnimationInterface())
        this.keyvalueDrawString.update(rtsLayer.getParentLayer().getName())
    }

    def setRtsLayer(rtsLayer : RTSLayer) : Unit = {
        this.rtsLayerP = rtsLayer
    }

    def getRtsLayer() : PathFindingLayerInterface = {
        return this.rtsLayerP
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        this.keyvalueDrawString.paint(graphics, this.textLine2Y)
        this.getAnimationInterface().paintXY(graphics, this.imageX, this.y)
    }

}


