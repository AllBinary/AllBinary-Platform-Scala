/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.khronos.opengles.GL11
import _root_.javax.microedition.khronos.opengles.GL11Ext
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.opengles.OpenGLLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory

//Many devices don't support this even though it is supposed to
class OpenGLESGL11ExtImage(param_image : Image, param_bitmapFactory : PlatformBitmapBaseFactory, param_textureFactory : PlatformTextureBaseFactory) extends OpenGLESImage(param_image, param_bitmapFactory, param_textureFactory) {

    val logUtil_OpenGLESGL11ExtImage : LogUtil = LogUtil.getInstance()

    // private IntBuffer rectParams;
    private var a : Int = 0

    private var rectangle : Array[Int] = null

    //Constructor
    {
        val image : Image = param_image
        val bitmapFactory : PlatformBitmapBaseFactory = param_bitmapFactory
        val textureFactory : PlatformTextureBaseFactory = param_textureFactory
        this.onDisplayChangeEvent(DisplayInfoSingleton.getInstance().displayChangeEvent)
        this.rectangle = Array[Int](0, this.getHeight(), this.getWidth(), -this.getHeight())
    }

    /*     public OpenGLESGL11ExtImage(GL10 gl, Image image, boolean matchColor)     {         super(gl, image, matchColor);          this.onDisplayChangeEvent(DisplayInfoSingleton.getInstance().displayChangeEvent);          this.rectangle = new int[]         { 0, this.getHeight(), this.getWidth(), -this.getHeight() };                  this.update(gl);     }     */
    def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        try {
            this.logUtil_OpenGLESGL11ExtImage.putF(this.commonStrings.START, this, "onResize")
            this.a = DisplayInfoSingleton.getInstance().getLastHeight() - this.getHeight()
        } catch {
            case e : Exception => {
                this.logUtil_OpenGLESGL11ExtImage.put(this.commonStrings.EXCEPTION, this, "onResize", e)
            }
        }
    }

    override def set(gl : GL) : Unit = {
        this.onDisplayChangeEvent(DisplayInfoSingleton.getInstance().displayChangeEvent)
        val gl11 : GL11 = gl.asInstanceOf[GL11]
        if (super.initTexture(gl11)) {
            //}
            this.textureFactory.load(gl11, GL10.GL_TEXTURE_2D, 0, this, 0, true)
            gl11.glTexParameteriv(GL10.GL_TEXTURE_2D, GL11Ext.GL_TEXTURE_CROP_RECT_OES, this.rectangle, 0)
            gl11.glDisable(GL10.GL_TEXTURE_2D)
            OpenGLLogUtil.getInstance().logError(gl11, this)
        }
    }

    override def draw(gl : GL10, x : Int, y : Int, z : Int) : Unit = {
        gl.glEnable(GL10.GL_TEXTURE_2D)
        gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.textureID)
        //glDrawTexiOES
        val gl11Ext : GL11Ext = gl.asInstanceOf[GL11Ext]
        gl11Ext.glDrawTexfOES(x.toFloat, (this.a - y).toFloat, z.toFloat, this.getWidth().toFloat, this.getHeight().toFloat)
        gl.glDisable(GL10.GL_TEXTURE_2D)
    }

}


