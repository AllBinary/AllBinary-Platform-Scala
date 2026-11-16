/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable

import _root_.javax.microedition.lcdui.Image

class ScreenRelationalUtil {
    import _root_.org.allbinary.graphics.displayable.ScreenRelationalUtil.{*}

    def getScaleImage(image : Image) : Float = {
        return this.getScaleWH(image.getWidth(), image.getHeight())
    }

    def getScaleWH(aWidth : Int, aHeight : Int) : Float = {
        return this.getScaleWHA(aWidth, aHeight, 20)
    }

    def getScaleWHA(aWidth : Int, aHeight : Int, add : Int) : Float = {
        val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        val last : Array[Int] = displayInfoSingleton.getLast()
        val width : Float = last(displayInfoSingleton.WIDTH).toFloat
        val height : Float = last(displayInfoSingleton.HEIGHT).toFloat
        var largestSize : Float = width
        if (largestSize < height) {
            largestSize = height
        }
        var scale : Float = (largestSize) / aWidth
        /*          float scaleX = width/aWidth;          float scaleY = height/aHeight;          float scale = scaleX;                 if(scaleX < scaleY)          {          scale = scaleY;           }          */
        return scale
    }

    def getScaledHeight(aWidth : Int, aHeight : Int) : Int = {
        return (this.getScaleWH(aWidth, aHeight) * aHeight).toInt
    }

    def getScaledHeightAdd(aWidth : Int, aHeight : Int, add : Int) : Int = {
        return (this.getScaleWHA(aWidth, aHeight, add) * aHeight).toInt
    }

}

object ScreenRelationalUtil {
    private val instance : ScreenRelationalUtil = new ScreenRelationalUtil()

    def getInstance() : ScreenRelationalUtil = {
        return ScreenRelationalUtil.instance
    }

}


