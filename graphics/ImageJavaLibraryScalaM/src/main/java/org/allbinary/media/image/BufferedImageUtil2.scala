/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage

class BufferedImageUtil2 {
    import _root_.org.allbinary.media.image.BufferedImageUtil2.{*}

    private val imageUtil : ImageUtil = ImageUtil.getInstance()

    def createSpriteImage(bufferedImageArray : Array[BufferedImage]) : BufferedImage = {
        //GraphicsConfiguration gc = this.imageUtil.getDefaultConfiguration();
        var columns : Int = bufferedImageArray.length
        var max : Int = columns
        var rows : Int = 0
        if (bufferedImageArray.length < columns) {
            columns = bufferedImageArray.length
        }
        rows = (bufferedImageArray.length / columns)
        //Extra row for incomplete but needed row
        if ((bufferedImageArray.length % columns) != 0) {
            rows += 1
        }
        var bufferedImage : BufferedImage = this.imageUtil.create(bufferedImageArray(0).getWidth(null) * columns, bufferedImageArray(0).getHeight(null) * rows)
        var g : Graphics2D = bufferedImage.createGraphics()
        //g.translate((neww-w)/2, (newh-h)/2);
        var columnIndex : Int = 0
        var rowIndex : Int = 0

        {
            var index : Int = 0
            while (index < bufferedImageArray.length) {
                if (((index / max) != 0) && ((index % max) == 0)) {
                    rowIndex += 1
                    columnIndex = 0
                }
                g.drawImage(bufferedImageArray(index), bufferedImageArray(index).getWidth(null) * columnIndex, bufferedImageArray(index).getHeight(null) * rowIndex, bufferedImageArray(index).getWidth(null), bufferedImageArray(index).getHeight(null), null)
                //g.drawRenderedImage(image, null);
                columnIndex += 1
                index += 1
            }
        }
        g.dispose()
        return bufferedImage
    }

}

object BufferedImageUtil2 {
    private val instance : BufferedImageUtil2 = new BufferedImageUtil2()

    /**      * @return the instance      */
    def getInstance() : BufferedImageUtil2 = {
        return BufferedImageUtil2.instance
    }

}


