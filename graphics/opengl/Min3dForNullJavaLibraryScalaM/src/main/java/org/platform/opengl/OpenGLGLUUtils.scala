/* Generated Code Do Not Modify */
package org.platform.opengl

import _root_.java.nio.ByteBuffer
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.graphics.OpenGLBitmap
import _root_.org.allbinary.image.opengles.OpenGLESImage

/**  *  * @author User  */
class OpenGLGLUUtils {
    import _root_.org.platform.opengl.OpenGLGLUUtils.{*}

    def makeByteBuffer(bmp : OpenGLBitmap, flip : Boolean) : ByteBuffer = {
        throw new RuntimeException()
    }

    def texImage2D(gl : GL10, glVersion : String, target : Int, level : Int, generateMipMap : Boolean, openGLESImage : OpenGLESImage, border : Int, flip : Boolean) : Unit = {
        throw new RuntimeException()
    }

    def texImage2D(gl : GL10, glVersion : String, target : Int, level : Int, generateMipMap : Boolean, bitmap : OpenGLBitmap, border : Int, flip : Boolean) : Unit = {
        throw new RuntimeException()
    }

}

object OpenGLGLUUtils {
    private val instance : OpenGLGLUUtils = new OpenGLGLUUtils()

    /**      * @return the instance      */
    def getInstance() : OpenGLGLUUtils = {
        return OpenGLGLUUtils.instance
    }

}


