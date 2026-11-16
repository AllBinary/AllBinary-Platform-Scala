/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory

class ColorFromEventUtil {
    import _root_.org.allbinary.media.graphics.geography.map.ColorFromEventUtil.{*}

    private val YELLOW : BasicColor = BasicColorFactory.getInstance().YELLOW

    val COLOR_INT : Int = this.YELLOW.intValue()

    def getForegroundColor(gameCanvasInterface : AllBinaryGameCanvas) : BasicColor = {
        var color : BasicColor = this.YELLOW
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = gameCanvasInterface.getLayerManager().asInstanceOf[GeographicMapCompositeInterface]
        // menu selection
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        if (geographicMapInterface != null) {
            val foregroundBasicColor : BasicColor = geographicMapInterface.getForegroundBasicColor()
            color = foregroundBasicColor
        }
        return color
    }

}

object ColorFromEventUtil {
    private val instance : ColorFromEventUtil = new ColorFromEventUtil()

    def getInstance() : ColorFromEventUtil = {
        return ColorFromEventUtil.instance
    }

}


