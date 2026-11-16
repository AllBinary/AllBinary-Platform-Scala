/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.Animation

class AnimationFrameToImageUtil {
    import _root_.org.allbinary.image.AnimationFrameToImageUtil.{*}

    def getInstanceTranslate(width : Int, height : Int, animationInterface : Animation) : Image = {
        var image : Image = GameFeatureImageCacheFactory.getInstance().get(AnimationFrameToImageUtil.instance.getClass().getName(), ((width * 3) >> 1), ((height * 3) >> 1))
        var graphics : Graphics = image.getGraphics()
        var tranlateX : Int = (width >> 2)
        var tranlateY : Int = (height >> 2)
        graphics.translate(tranlateX, tranlateY)
        animationInterface.paintXY(graphics, 0, 0)
        graphics.translate(-tranlateX, -tranlateY)
        return image
    }

    def getInstanceWH(width : Int, height : Int, animationInterface : Animation) : Image = {
        var image : Image = GameFeatureImageCacheFactory.getInstance().get(AnimationFrameToImageUtil.instance.getClass().getName(), width, height)
        var graphics : Graphics = image.getGraphics()
        animationInterface.paintXY(graphics, 0, 0)
        return image
    }

}

object AnimationFrameToImageUtil {
    private val instance : AnimationFrameToImageUtil = new AnimationFrameToImageUtil()

    def getInstance() : AnimationFrameToImageUtil = {
        return AnimationFrameToImageUtil.instance
    }

}


