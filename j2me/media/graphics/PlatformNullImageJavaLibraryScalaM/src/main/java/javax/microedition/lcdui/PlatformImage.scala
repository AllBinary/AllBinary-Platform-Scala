/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package javax.microedition.lcdui

import _root_.org.allbinary.logic.NullUtil

//PlatformNullImageJavaLibrary
class PlatformImage {

    def getImage(graphicsSurface2 : Object) : Object = {
        return NullImage.NULL_IMAGE
    }

    def getSurfaceWidth(graphicsSurface2 : Object, width : Int) : Int = {
        return width
    }

    def getSurfaceHeight(graphicsSurface2 : Object, height : Int) : Int = {
        return height
    }

    def getWidth(image : Image, width : Int) : Int = {
        return width
    }

    def getHeight(image : Image, height : Int) : Int = {
        return height
    }

    def getGraphics(graphicsSurface : Object, width : Int, height : Int, image : Image) : Graphics = {
        throw new RuntimeException()
    }

    def drawImage(image : Image, x : Int, y : Int, anchor : Int, g2 : Graphics, g : Object) : Unit = {
    }

    def drawRegion(image : Image, x_src : Int, y_src : Int, width : Int, height : Int, transform : Int, x_dst : Int, y_dst : Int, anchor : Int, g : Graphics) : Unit = {
    }

    def getRGB(argb : Array[Int], offset : Int, scanlength : Int, x : Int, y : Int, width : Int, height : Int, image : Image) : Unit = {
    }

    def setRGB(argb : Array[Int], offset : Int, scanlength : Int, x : Int, y : Int, width : Int, height : Int, image : Image) : Unit = {
    }

    def getData(image : Image) : Array[Int] = {
        return NullUtil.getInstance().NULL_INT_ARRAY
    }

}


