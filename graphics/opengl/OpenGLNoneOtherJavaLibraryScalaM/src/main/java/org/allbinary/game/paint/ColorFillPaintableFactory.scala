/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory

class ColorFillPaintableFactory {
    import _root_.org.allbinary.game.paint.ColorFillPaintableFactory.{*}

    def getInstance(basicColor : BasicColor, forThreedCanvas : Boolean) : ColorFillBasePaintable = {
        val operatingSystem : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
        if (operatingSystem.isOverScan()) {
            return new OverScanColorFillPaintable(basicColor)
        } else {
            return new ColorFillPaintable(basicColor)
        }
        throw new IllegalStateException()
    }

}

object ColorFillPaintableFactory {
    private val instance : ColorFillPaintableFactory = new ColorFillPaintableFactory()

    def getInstance() : ColorFillPaintableFactory = {
        return ColorFillPaintableFactory.instance
    }

}


