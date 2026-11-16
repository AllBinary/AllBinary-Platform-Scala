/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media

import _root_.java.awt.Dimension
import _root_.java.awt.DisplayMode
import _root_.java.awt.GraphicsDevice
import _root_.java.awt.GraphicsEnvironment
import _root_.java.awt.Toolkit
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle

/**  *  * @author User  */
class DisplaysUtil {
    import _root_.org.allbinary.media.DisplaysUtil.{*}

    def getPrimaryScreenSize() : Rectangle = {
        val dimension : Dimension = Toolkit.getDefaultToolkit().getScreenSize()
        return new Rectangle(PointFactory.getInstance().ZERO_ZERO, dimension.width, dimension.height)
    }

    def getScreenSizesAsRectangleArray() : Array[Rectangle] = {
        val graphicsEnvironment : GraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()
        val graphicsDeviceArray : Array[GraphicsDevice] = graphicsEnvironment.getScreenDevices()
        var graphicsDevice : GraphicsDevice = null
        var displayMode : DisplayMode = null
        var rectangle : Rectangle = null
        val size : Int = graphicsDeviceArray.length
        val rectangleArray : Array[Rectangle] = new Array[Rectangle](size)

        {
            var index : Int = 0
            while (index < size) {
                graphicsDevice = graphicsDeviceArray(index)
                displayMode = graphicsDevice.getDisplayMode()
                rectangle = new Rectangle(PointFactory.getInstance().ZERO_ZERO, displayMode.getWidth(), displayMode.getHeight())
                rectangleArray(index) = rectangle
                index += 1
            }
        }
        return rectangleArray
    }

}

object DisplaysUtil {
    /**      * @return the instance      */
    def getInstance() : DisplaysUtil = {
        return DisplaysUtil.instance
    }

    private val instance : DisplaysUtil = new DisplaysUtil()

}


