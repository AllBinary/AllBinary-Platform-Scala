/* Generated Code Do Not Modify */
package org.allbinary.device

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Font
import _root_.org.allbinary.graphics.font.FontDebugBase
import _root_.org.allbinary.image.opengles.OpenGLSurfaceChangedInterface
import _root_.org.allbinary.string.CommonStrings

class OpenGLESGraphics() extends OpenGLSurfaceChangedInterface with GraphicsInterface {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var gl : GL10 = NullGL10.NULL_GL10

    def updateGL(gl : GL) : Unit = {
    }

    override def set(gl : GL) : Unit = {
    }

    def init() : Unit = {
    }

    def update() : Unit = {
    }

    def setOrthoginalMode() : Unit = {
    }

    def setCameraMode() : Unit = {
    }

    def getGlP() : GL10 = {
        return this.gl
    }

    override def setFontDebug(font : Font, fontDebug : FontDebugBase) : Unit = {
        throw new RuntimeException()
    }

}


