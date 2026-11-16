/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.*
import _root_.java.awt.geom.AffineTransform
import _root_.java.awt.image.AffineTransformOp
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.communication.log.LogUtil

class MirrorImageUtil private() {
    import _root_.org.allbinary.media.image.MirrorImageUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    def getImage(param_bufferedImage : BufferedImage, verticle : Boolean, horizontal : Boolean) : BufferedImage = {
        var bufferedImage : BufferedImage = param_bufferedImage
        this.logUtil.putF("Starting", this, "getImage")
        var newBufferedImage : BufferedImage = this.imageUtil.create(bufferedImage.getWidth(null), bufferedImage.getHeight(null))
        var g : Graphics2D = newBufferedImage.createGraphics()
        if (verticle) {
            var tx : AffineTransform = AffineTransform.getScaleInstance(1, -1)
            tx.translate(0, -bufferedImage.getHeight(null))
            var op : AffineTransformOp = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR)
            bufferedImage = op.filter(bufferedImage, null)
        }
        if (horizontal) {
            var tx : AffineTransform = AffineTransform.getScaleInstance(-1, 1)
            tx.translate(-bufferedImage.getWidth(null), 0)
            var op : AffineTransformOp = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR)
            bufferedImage = op.filter(bufferedImage, null)
        }
        g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(null), bufferedImage.getHeight(null), null)
        g.dispose()
        return newBufferedImage
    }

    def getImages(bufferedImage : BufferedImage, verticle : Boolean, horizontal : Boolean) : Array[BufferedImage] = {
        var width : Int = bufferedImage.getWidth()
        var height : Int = bufferedImage.getHeight()
        var cellHeight : Int = height
        var cellWidth : Int = height
        var numberOfFramesPerOrientation : Int = width / cellWidth
        var numberOfFrames : Int = numberOfFramesPerOrientation
        if (verticle) {
            numberOfFrames *= 2
        }
        if (horizontal) {
            numberOfFrames *= 2
        }
        this.logUtil.putF((("numberOfFramesPerOrientation: " + numberOfFramesPerOrientation) + " numberOfFrames: ") + numberOfFrames, this, "getImages")
        val bufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](numberOfFrames)
        var y : Int = 0

        {
            var index : Int = 0
            while (index < numberOfFramesPerOrientation) {
                var x : Int = index * cellWidth
                bufferedImageArray(index) = bufferedImage.getSubimage(x, y, cellWidth, cellHeight)
                index += 1
            }
        }

        {
            var index : Int = 0
            while (index < numberOfFramesPerOrientation) {
                bufferedImageArray(index + numberOfFramesPerOrientation) = this.getImage(bufferedImageArray(index), verticle, horizontal)
                index += 1
            }
        }
        //bufferedImageArray[bufferedImageArray.length - 1] = bufferedImage;
        return bufferedImageArray
    }

}

object MirrorImageUtil {
    private val instance : MirrorImageUtil = new MirrorImageUtil()

    /**      * @return the instance      */
    def getInstance() : MirrorImageUtil = {
        return MirrorImageUtil.instance
    }

}


