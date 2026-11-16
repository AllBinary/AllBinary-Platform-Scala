/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.graphics.color.ColorCacheFactory
import _root_.org.allbinary.graphics.color.ColorCacheable
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface

/**  *  * @author Admin  */
class GraphicsAnalysisUtil private() {
    import _root_.org.allbinary.input.automation.module.game.GraphicsAnalysisUtil.{*}

}

object GraphicsAnalysisUtil {
    private val MAX : Int = 122

    def getNominator(bufferedImage : BufferedImage, min_x : Integer, max_x : Integer, y : Integer) : Double = {

        {
            var index : Int = max_x.intValue()
            while (index > min_x.intValue()) {
                var colorInteger : Integer = Integer.valueOf(bufferedImage.getRGB(index, y.intValue()))
                var automaticCacheInterface : AutomaticCacheInterface = ColorCacheFactory.getInstance()
                var colorCacheable : ColorCacheable = automaticCacheInterface.get(colorInteger).asInstanceOf[ColorCacheable]
                var color : Color = colorCacheable.getColor()
                //If it is dark
                if (((color.getRed() < GraphicsAnalysisUtil.MAX) && (color.getGreen() < GraphicsAnalysisUtil.MAX)) && (color.getBlue() < GraphicsAnalysisUtil.MAX)) {
                } else {
                    return index - min_x.intValue()
                }
                index -= 1
            }
        }
        return 0
    }

}


