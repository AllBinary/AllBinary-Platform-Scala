/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.java.nio.ByteBuffer
import _root_.java.nio.ByteOrder
import _root_.java.nio.FloatBuffer
import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.opengles.OpenGLLogUtil
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.opengles.GLUtil
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory

//This is not actually VBO impl
class OpenGLESGL11VBOImage(param_image : Image, param_bitmapFactory : PlatformBitmapBaseFactory, param_textureFactory : PlatformTextureBaseFactory) extends OpenGLESImage(param_image, param_bitmapFactory, param_textureFactory) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val glUtil : GLUtil = GLUtil.getInstance()

    private var textureVertexFloatBuffer : FloatBuffer = ByteBuffer.allocateDirect((4 * 4) * 2).order(ByteOrder.nativeOrder()).asFloatBuffer()

    val regionRectangleFloatArray : Array[Float] = Array[Float](0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

    var regionRectangleVertexFloatBuffer : FloatBuffer = ByteBuffer.allocateDirect((4 * 4) * 3).order(ByteOrder.nativeOrder()).asFloatBuffer()

    private val regionTextureRectangleFloatArray : Array[Float] = new Array[Float](8)

    private var regionTextureVertexFloatBuffer : FloatBuffer = ByteBuffer.allocateDirect((4 * 4) * 2).order(ByteOrder.nativeOrder()).asFloatBuffer()

    //Constructor
    {
        val image : Image = param_image
        val bitmapFactory : PlatformBitmapBaseFactory = param_bitmapFactory
        val textureFactory : PlatformTextureBaseFactory = param_textureFactory
        this.initVertices()
        this.regionRectangleVertexFloatBuffer.put(FloatBuffer.wrap(this.regionRectangleFloatArray))
        this.regionTextureVertexFloatBuffer.put(FloatBuffer.wrap(this.regionTextureRectangleFloatArray))
    }

    /*     public OpenGLESGL10Image(GL10 gl, Image image, boolean matchColor)     {         super(gl, image, matchColor);          this.init();                  this.update(gl);     }     */
    def initVertices() : Unit = {
        this.textureVertexFloatBuffer.put(0f)
        this.textureVertexFloatBuffer.put(1f)
        this.textureVertexFloatBuffer.put(1f)
        this.textureVertexFloatBuffer.put(1f)
        this.textureVertexFloatBuffer.put(0f)
        this.textureVertexFloatBuffer.put(0f)
        this.textureVertexFloatBuffer.put(1f)
        this.textureVertexFloatBuffer.put(0f)
        this.textureVertexFloatBuffer.rewind()
    }

    override def set(gl : GL) : Unit = {
        val gl10 : GL10 = gl.asInstanceOf[GL10]
        if (super.initTexture(gl10)) {
            //}
            this.textureFactory.load(gl10, GL10.GL_TEXTURE_2D, 0, this, 0, true)
            gl10.glDisable(GL10.GL_TEXTURE_2D)
            OpenGLLogUtil.getInstance().logError(gl10, this)
        }
    }

    override def drawRegion(gl : GL10, viewHeight : Int, x_src : Float, y_src : Float, width : Float, height : Float, x : Int, y : Int, z : Int) : Unit = {
        this.regionRectangleFloatArray(0) = x
        this.regionRectangleFloatArray(7) = viewHeight - y
        this.regionRectangleFloatArray(1) = this.regionRectangleFloatArray(7) - height
        this.regionRectangleFloatArray(3) = x + width
        this.regionRectangleFloatArray(4) = this.regionRectangleFloatArray(1)
        this.regionRectangleFloatArray(6) = x
        this.regionRectangleFloatArray(9) = this.regionRectangleFloatArray(3)
        this.regionRectangleFloatArray(10) = this.regionRectangleFloatArray(7)
        //regionTextureVertexFloatBuffer.rewind();
        this.regionTextureRectangleFloatArray(0) = x_src / this.getWidth()
        this.regionTextureRectangleFloatArray(1) = (y_src + height) / this.getHeight()
        this.regionTextureRectangleFloatArray(2) = (x_src + width) / this.getWidth()
        this.regionTextureRectangleFloatArray(3) = this.regionTextureRectangleFloatArray(1)
        this.regionTextureRectangleFloatArray(4) = this.regionTextureRectangleFloatArray(0)
        this.regionTextureRectangleFloatArray(5) = y_src / this.getHeight()
        this.regionTextureRectangleFloatArray(6) = this.regionTextureRectangleFloatArray(2)
        this.regionTextureRectangleFloatArray(7) = this.regionTextureRectangleFloatArray(5)
        /*         float textureX1 = x_src / this.getWidth();         float textureY1 = y_src / this.getHeight();         float textureY2 = ((float) (y_src + height)) / this.getHeight();         float textureX2 = ((float) (x_src + width)) / this.getWidth();                  textureVertexFloatBuffer.put(textureX1);         textureVertexFloatBuffer.put(textureY2);          textureVertexFloatBuffer.put(textureX2);         textureVertexFloatBuffer.put(textureY2);          textureVertexFloatBuffer.put(textureX1);         textureVertexFloatBuffer.put(textureY1);          textureVertexFloatBuffer.put(textureX2);         textureVertexFloatBuffer.put(textureY1);         */
        this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0)
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer)
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glEnable(GL10.GL_TEXTURE_2D)
        gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.textureID)
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
        this.glUtil.position(this.regionTextureVertexFloatBuffer, 0)
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.regionTextureVertexFloatBuffer)
        // ((GL11Ext) gl).glDrawTexiOES(x, a - y, z, width, height);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
        gl.glDisable(GL10.GL_TEXTURE_2D)
    }

    override def draw(gl : GL10, x : Int, y : Int, z : Int) : Unit = {
        this.regionRectangleFloatArray(0) = x
        this.regionRectangleFloatArray(7) = (DisplayInfoSingleton.getInstance().getLastHeight() - y).toFloat
        this.regionRectangleFloatArray(1) = this.regionRectangleFloatArray(7) - this.getHeight()
        this.regionRectangleFloatArray(3) = (x + this.getWidth()).toFloat
        this.regionRectangleFloatArray(4) = this.regionRectangleFloatArray(1)
        this.regionRectangleFloatArray(6) = x
        //regionRectangleVertexFloatBuffer.put(regionRectangleVertexFloatBuffer.get(7));
        this.regionRectangleFloatArray(9) = this.regionRectangleFloatArray(3)
        this.regionRectangleFloatArray(10) = this.regionRectangleFloatArray(7)
        //textureVertexFloatBuffer.rewind();
        this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0)
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer)
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glEnable(GL10.GL_TEXTURE_2D)
        gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.textureID)
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
        this.glUtil.position(this.textureVertexFloatBuffer, 0)
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.textureVertexFloatBuffer)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
        gl.glDisable(GL10.GL_TEXTURE_2D)
    }

}


