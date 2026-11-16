/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.IndexedAnimation

class IndexedAnimationToImageArrayUtil {
    import _root_.org.allbinary.image.IndexedAnimationToImageArrayUtil.{*}

}

object IndexedAnimationToImageArrayUtil {
    def getInstance(width : Int, height : Int, sequentialAnimationInterface : IndexedAnimation) : Array[Image] = {
        var size : Int = sequentialAnimationInterface.getAnimationSize()
        var imageArray : Array[Image] = new Array[Image](size)

        {
            var index : Int = 0
            while (index < size) {
                sequentialAnimationInterface.setFrame(index)
                imageArray(index) = AnimationFrameToImageUtil.getInstance().getInstanceWH(width, height, sequentialAnimationInterface)
                index += 1
            }
        }
        return imageArray
    }

}


