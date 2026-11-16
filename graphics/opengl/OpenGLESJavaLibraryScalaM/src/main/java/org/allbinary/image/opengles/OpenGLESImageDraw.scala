/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.khronos.opengles.GL10

/**  *  * @author User  */
class OpenGLESImageDraw {
    import _root_.org.allbinary.image.opengles.OpenGLESImageDraw.{*}

    def drawRegion(gl : GL10, viewHeight : Int, x_src : Float, y_src : Float, width : Float, height : Float, x : Int, y : Int, z : Int) : Unit = {
    }

    def draw(gl : GL10, x : Int, y : Int, z : Int) : Unit = {
    }

}

object OpenGLESImageDraw {
    private val instance : OpenGLESImageDraw = new OpenGLESImageDraw()

    /**      * @return the instance      */
    def getInstance() : OpenGLESImageDraw = {
        return OpenGLESImageDraw.instance
    }

}


