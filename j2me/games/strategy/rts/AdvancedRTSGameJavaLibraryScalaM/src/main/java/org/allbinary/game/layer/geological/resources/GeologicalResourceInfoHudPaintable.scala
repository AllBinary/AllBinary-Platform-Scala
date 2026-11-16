/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geological.resources

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.waypoint.WaypointInfoHudPaintable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.graphics.draw.KeyValueDrawCharArray

/**  *  * @author user  */
class GeologicalResourceInfoHudPaintable() extends WaypointInfoHudPaintable {
    import _root_.org.allbinary.game.layer.geological.resources.GeologicalResourceInfoHudPaintable.{*}

    private var keyvalueDrawString : KeyValueDrawCharArray = null

    private var fontHeight : Int = 0

    //protected
    //Constructor
    {
        this.keyvalueDrawString = new KeyValueDrawCharArray(GeologicalResourceInfoHudPaintable.RESOURCES, this.textX)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        super.updateMeasurement(graphics)
        val font : Font = graphics.getFont()
        this.fontHeight = (2 * font.getHeight())
    }

    override def updateSelectionInfo() : Unit = {
        super.updateSelectionInfo()
        val rtsLayer : RTSLayer = this.rtsLayerP.asInstanceOf[RTSLayer]
        val list : BasicArrayList = rtsLayer.geographicMapCellPositionAreaBase.getOccupyingGeographicMapCellPositionList()
        var total : Int = 0

        {
            var index : Int = list.size()
            while ({ index -= 1; index } >= 0) {
                var geographicMapCellPosition : GeologicalGeographicMapCellPosition = list.get(index).asInstanceOf[GeologicalGeographicMapCellPosition]
                total += geographicMapCellPosition.getGeologicalResource().getTotal()
            }
        }
        this.keyvalueDrawString.update(this.getPrimitiveLongUtil().getCharArray(total), this.getPrimitiveLongUtil().getCurrentTotalDigits())
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        this.keyvalueDrawString.paint(graphics, (this.y + this.fontHeight))
    }

}

object GeologicalResourceInfoHudPaintable {
    private val RESOURCES : String = "Resources: "

}


