/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.opengles.OpenGLStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil

class OpenGLLogUtil {
    import _root_.org.allbinary.graphics.opengles.OpenGLLogUtil.{*}

    private val MAX_TEXTURE : String = " Max Texture Size: "

    private val LOG_ERROR : String = "logError"

    private val IMAGE : String = " Image: "

    def logError(gl : GL10) : Unit = {
        val error : Int = gl.glGetError()
        if (error != GL10.GL_NO_ERROR) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(OpenGLStrings.getInstance().GL_ERROR_LABEL)
            stringBuffer.appendint(error)
            if (error == 1281) {
                stringBuffer.append(this.MAX_TEXTURE)
                val maxTextureSize : Array[Int] = new Array[Int](1)
                gl.glGetIntegerv(GL10.GL_MAX_TEXTURE_SIZE, maxTextureSize, 0)
                stringBuffer.appendint(maxTextureSize(0))
            }
            if (error == 1280) {
                PreLogUtil.put(stringBuffer.toString(), this, OpenGLStrings.getInstance().SET)
            } else {
                ForcedLogUtil.log(stringBuffer.toString(), this)
            }
        }
    }

    def logError(gl : GL10, image : Image) : Unit = {
        val error : Int = gl.glGetError()
        if (error != GL10.GL_NO_ERROR) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(OpenGLStrings.getInstance().GL_ERROR_LABEL)
            stringBuffer.appendint(error)
            if (error == 1281) {
                stringBuffer.append(this.MAX_TEXTURE)
                val maxTextureSize : Array[Int] = new Array[Int](1)
                gl.glGetIntegerv(GL10.GL_MAX_TEXTURE_SIZE, maxTextureSize, 0)
                stringBuffer.appendint(maxTextureSize(0))
            }
            stringBuffer.append(this.IMAGE)
            stringBuffer.append(image.toString())
            //ForcedLogUtil.log(stringBuffer.toString(), this);
            PreLogUtil.put(stringBuffer.toString(), this, this.LOG_ERROR)
        }
    }

}

object OpenGLLogUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : OpenGLLogUtil = new OpenGLLogUtil()

    def getInstance() : OpenGLLogUtil = {
        return OpenGLLogUtil.instance
    }

}


