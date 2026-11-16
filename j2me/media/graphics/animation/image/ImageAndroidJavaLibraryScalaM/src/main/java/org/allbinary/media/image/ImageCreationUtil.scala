/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.GameFeatureImageCacheFactory

class ImageCreationUtil private() {
    import _root_.org.allbinary.media.image.ImageCreationUtil.{*}

    def createImageWH(width : Int, height : Int) : Image = {
        val image : Image = GameFeatureImageCacheFactory.getInstance().get(this.getClass().getName(), width, height)
        return image
    }

    def createImage(width : Int, height : Int, maxScaleX : Float, maxScaleY : Float) : Image = {
        //this.logUtil.putF(CommonLabels.getInstance().COLON_SEP + scaleNominatorX + " / " + scaleDenominatorX + " = " + scaleX, this, "createImage");
        val image : Image = GameFeatureImageCacheFactory.getInstance().get(this.getClass().getName(), (width * maxScaleX).toInt + 1, (height * maxScaleY).toInt + 1)
        return image
    }

}

object ImageCreationUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageCreationUtil = new ImageCreationUtil()

    def getInstance() : ImageCreationUtil = {
        return ImageCreationUtil.instance
    }

}


