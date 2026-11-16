/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.khronos.opengles.GL10

/**  *  * @author User  */
class OpenGLESImageProcessor {
    import _root_.org.allbinary.image.opengles.OpenGLESImageProcessor.{*}

    def translate(gl : GL10, translateX : Float, translateY : Float) : Unit = {
    }

    def rotate(gl : GL10, angle : Float) : Unit = {
    }

    def scale(gl : GL10, scaleX : Float, scaleY : Float) : Unit = {
    }

    def colorMask(gl : GL10, red : Float, green : Float, blue : Float, alpha : Float) : Unit = {
    }

}

object OpenGLESImageProcessor {
    private val instance : OpenGLESImageProcessor = new OpenGLESImageProcessor()

    /**      * @return the instance      */
    def getInstance() : OpenGLESImageProcessor = {
        return OpenGLESImageProcessor.instance
    }

}


