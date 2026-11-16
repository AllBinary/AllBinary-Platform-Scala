/* Generated Code Do Not Modify */
package org.platform.opengl

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory

class OpenGLTextureFactory private() extends PlatformTextureBaseFactory {
    import _root_.org.platform.opengl.OpenGLTextureFactory.{*}

    private val gluUtils : OpenGLGLUUtils = OpenGLGLUUtils.getInstance()

    override def load(gl : GL10, target : Int, level : Int, image : Image, border : Int, flip : Boolean) : Unit = {
        throw new RuntimeException()
    }

}

object OpenGLTextureFactory {
    private val instance : OpenGLTextureFactory = new OpenGLTextureFactory()

    def getInstance() : OpenGLTextureFactory = {
        return OpenGLTextureFactory.instance
    }

}


