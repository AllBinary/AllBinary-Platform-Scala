/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.paint.PaintableInterface

class PaintableToImageUtil {
    import _root_.org.allbinary.image.PaintableToImageUtil.{*}

}

object PaintableToImageUtil {
    private val instance : PaintableToImageUtil = new PaintableToImageUtil()

    def getImage(paintableInterface : PaintableInterface, width : Int, height : Int) : Image = {
        var image : Image = GameFeatureImageCacheFactory.getInstance().get(PaintableToImageUtil.instance.getClass().getName(), width, height)
        var graphics : Graphics = image.getGraphics()
        paintableInterface.paint(graphics)
        return image
    }

}


