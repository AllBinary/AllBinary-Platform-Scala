/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels

class ImageUnifierUtil private() {
    import _root_.org.allbinary.media.image.ImageUnifierUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    def getDefaultConfiguration() : GraphicsConfiguration = {
        var ge : GraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()
        var gd : GraphicsDevice = ge.getDefaultScreenDevice()
        return gd.getDefaultConfiguration()
    }

    def getImage(bufferedImageArray : Array[BufferedImage], imageUnifierProperties : ImageUnifierProperties) : BufferedImage = {
        var newBufferedImage : BufferedImage = this.imageUtil.create(imageUnifierProperties.getWidth(), imageUnifierProperties.getHeight())
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        this.logUtil.putF(((("Setting Image - " + commonLabels.WIDTH_LABEL) + newBufferedImage.getWidth()) + commonLabels.HEIGHT_LABEL) + newBufferedImage.getHeight(), this, "getImage")
        var g : Graphics2D = newBufferedImage.createGraphics()
        var columnIndex : Int = 0
        var rowIndex : Int = 0

        {
            var index : Int = 0
            while (index < bufferedImageArray.length) {
                var x : Int = imageUnifierProperties.getImageUnifierCell().getWidth().intValue() * { val value_N69612 = columnIndex; columnIndex += 1; value_N69612 }
                var y : Int = imageUnifierProperties.getImageUnifierCell().getHeight().intValue() * rowIndex
                //imageUnifierProperties.getRows()
                this.logUtil.putF((((("Adding Image: " + index) + " x: ") + x) + " y: ") + y, this, "getImage")
                g.drawImage(bufferedImageArray(index), x, y, imageUnifierProperties.getImageUnifierCell().getWidth().intValue(), imageUnifierProperties.getImageUnifierCell().getHeight().intValue(), null)
                var totalColumnsMinusOne : Int = (imageUnifierProperties.getColumns().intValue() - 1)
                if (columnIndex > totalColumnsMinusOne) {
                    rowIndex += 1
                    columnIndex = 0
                }
                index += 1
            }
        }
        g.dispose()
        return newBufferedImage
    }

}

object ImageUnifierUtil {
    private val instance : ImageUnifierUtil = new ImageUnifierUtil()

    /**      * @return the instance      */
    def getInstance() : ImageUnifierUtil = {
        return ImageUnifierUtil.instance
    }

}


