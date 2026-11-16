/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.java.nio.ByteBuffer
import _root_.java.nio.ByteOrder
import _root_.java.nio.FloatBuffer
import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.opengles.OpenGLLogUtil
import _root_.org.allbinary.opengles.GLUtil
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory

class OpenGLESGL10Image(param_image : Image, param_bitmapFactory : PlatformBitmapBaseFactory, param_textureFactory : PlatformTextureBaseFactory) extends OpenGLESImage(param_image, param_bitmapFactory, param_textureFactory) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val textureVertexFloatBuffer : FloatBuffer = ByteBuffer.allocateDirect((4 * 4) * 2).order(ByteOrder.nativeOrder()).asFloatBuffer()

    private val realOpenGLESImageDraw : OpenGLESImageDraw = new OpenGLESImageDraw {
            private val glUtil : GLUtil = GLUtil.getInstance()

            private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

            private val textureVertexFloatBuffer : FloatBuffer = OpenGLESGL10Image.this.textureVertexFloatBuffer

            private val regionTextureRectangleFloatArray : Array[Float] = new Array[Float](8)

            private val regionTextureVertexFloatBuffer : FloatBuffer = ByteBuffer.allocateDirect((4 * 4) * 2).order(ByteOrder.nativeOrder()).asFloatBuffer()

            private val regionRectangleFloatArray : Array[Float] = Array[Float](0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

            //    };    
            val regionRectangleVertexFloatBuffer : FloatBuffer = ByteBuffer.allocateDirect((4 * 4) * 3).order(ByteOrder.nativeOrder()).asFloatBuffer()

            val openGLESImageProperties : OpenGLESImageProperties = OpenGLESGL10Image.this.openGLESImageProperties

            override def drawRegion(gl : GL10, viewHeight : Int, x_src : Float, y_src : Float, width : Float, height : Float, x : Int, y : Int, z : Int) : Unit = {
                //PreLogUtil.put(this.commonStrings.START + "Texture", this, "drawRegion");
                val imageWidth : Int = OpenGLESGL10Image.this.getWidth()
                val imageHeight : Int = OpenGLESGL10Image.this.getHeight()
                //            regionRectangleFloatArray[10] = regionRectangleFloatArray[7];
                this.regionRectangleFloatArray(7) = viewHeight.toFloat
                this.regionRectangleFloatArray(1) = this.regionRectangleFloatArray(7) - height
                this.regionRectangleFloatArray(3) = width
                this.regionRectangleFloatArray(4) = this.regionRectangleFloatArray(1)
                this.regionRectangleFloatArray(9) = this.regionRectangleFloatArray(3)
                this.regionRectangleFloatArray(10) = this.regionRectangleFloatArray(7)
                //regionTextureVertexFloatBuffer.rewind();
                this.regionTextureRectangleFloatArray(0) = x_src / imageWidth
                this.regionTextureRectangleFloatArray(1) = (y_src + height) / imageHeight
                this.regionTextureRectangleFloatArray(2) = (x_src + width) / imageWidth
                this.regionTextureRectangleFloatArray(3) = this.regionTextureRectangleFloatArray(1)
                this.regionTextureRectangleFloatArray(4) = this.regionTextureRectangleFloatArray(0)
                this.regionTextureRectangleFloatArray(5) = y_src / imageHeight
                this.regionTextureRectangleFloatArray(6) = this.regionTextureRectangleFloatArray(2)
                this.regionTextureRectangleFloatArray(7) = this.regionTextureRectangleFloatArray(5)
                val u_center : Float = (this.regionTextureRectangleFloatArray(0) + this.regionTextureRectangleFloatArray(2)) / 2.0f
                val v_center : Float = (this.regionTextureRectangleFloatArray(5) + this.regionTextureRectangleFloatArray(1)) / 2.0f
                this.glUtil.rotateUVs(this.regionTextureRectangleFloatArray, (-this.openGLESImageProperties.angle).toFloat, u_center, v_center)
                //Matrix operations in modelview
                gl.glPushMatrix()
                //            imageProcessor.translate(gl, x - (width / 2), (viewHeight - y - (height / 2)));
                val imageProcessor : OpenGLESImageProcessor = OpenGLESGL10Image.this.imageProcessor
                OpenGLESGL10Image.this.openGLESImageTranslate.translate(gl, OpenGLESGL10Image.this, x.toFloat, (-y).toFloat)
                imageProcessor.scale(gl, this.openGLESImageProperties.scaleX, this.openGLESImageProperties.scaleY)
                //imageProcessor.scale(gl, scaleX * width, scaleY * height * 2.0f);
                imageProcessor.colorMask(gl, this.openGLESImageProperties.redf, this.openGLESImageProperties.greenf, this.openGLESImageProperties.bluef, this.openGLESImageProperties.alphaf)
                OpenGLESGL10Image.this.openGLESImageTranslate.translate2(gl, OpenGLESGL10Image.this)
                this.regionRectangleVertexFloatBuffer.put(this.regionRectangleFloatArray)
                this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0)
                gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer)
                gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
                gl.glEnable(GL10.GL_TEXTURE_2D)
                gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.textureID)
                gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
                this.regionTextureVertexFloatBuffer.put(this.regionTextureRectangleFloatArray)
                this.glUtil.position(this.regionTextureVertexFloatBuffer, 0)
                gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.regionTextureVertexFloatBuffer)
                //gl.glDrawArrays(GL10.GL_TRIANGLES, 1, 3);
                gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)
                gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
                gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
                gl.glDisable(GL10.GL_TEXTURE_2D)
                //Restore matrix
                gl.glPopMatrix()
            }

            override def draw(gl : GL10, x : Int, y : Int, z : Int) : Unit = {
                //PreLogUtil.put(commonStrings.START + "Texture", this, "draw");
                val width : Int = OpenGLESGL10Image.this.getWidth()
                val height : Int = OpenGLESGL10Image.this.getHeight()
                //            regionRectangleFloatArray[10] = regionRectangleFloatArray[7];
                this.regionRectangleFloatArray(7) = this.displayInfoSingleton.getLastHeight().toFloat
                this.regionRectangleFloatArray(1) = this.regionRectangleFloatArray(7) - height
                this.regionRectangleFloatArray(3) = width.toFloat
                this.regionRectangleFloatArray(4) = this.regionRectangleFloatArray(1)
                this.regionRectangleFloatArray(9) = this.regionRectangleFloatArray(3)
                this.regionRectangleFloatArray(10) = this.regionRectangleFloatArray(7)
                /*         regionRectangleVertexFloatBuffer.put(0, x);         regionRectangleVertexFloatBuffer.put(7, DisplayInfoSingleton.getInstance().getLastHeight() - y);         regionRectangleVertexFloatBuffer.put(1, regionRectangleVertexFloatBuffer.get(7) - getHeight());          regionRectangleVertexFloatBuffer.put(3, x + getWidth());         regionRectangleVertexFloatBuffer.put(4, regionRectangleVertexFloatBuffer.get(1));          regionRectangleVertexFloatBuffer.put(6, x);         //         //glUtil.position(regionRectangleVertexFloatBuffer, 7);         //regionRectangleVertexFloatBuffer.put(regionRectangleVertexFloatBuffer.get(7));          regionRectangleVertexFloatBuffer.put(9, regionRectangleVertexFloatBuffer.get(3));         regionRectangleVertexFloatBuffer.put(10, regionRectangleVertexFloatBuffer.get(7));              */
                this.regionTextureRectangleFloatArray(0) = 0f
                this.regionTextureRectangleFloatArray(1) = 1f
                this.regionTextureRectangleFloatArray(2) = 1f
                this.regionTextureRectangleFloatArray(3) = 1f
                this.regionTextureRectangleFloatArray(4) = 0f
                this.regionTextureRectangleFloatArray(5) = 0f
                this.regionTextureRectangleFloatArray(6) = 1f
                this.regionTextureRectangleFloatArray(7) = 0f
                //Matrix operations in modelview
                gl.glPushMatrix()
                //            imageProcessor.translate(gl, x - (width / 2), (viewHeight - y - (height / 2)));
                OpenGLESGL10Image.this.openGLESImageTranslate.translate(gl, OpenGLESGL10Image.this, x.toFloat, (-y).toFloat)
                val imageProcessor : OpenGLESImageProcessor = OpenGLESGL10Image.this.imageProcessor
                imageProcessor.scale(gl, this.openGLESImageProperties.scaleX, this.openGLESImageProperties.scaleY)
                //imageProcessor.scale(gl, scaleX * width, scaleY * height * 2.0f);
                imageProcessor.colorMask(gl, this.openGLESImageProperties.redf, this.openGLESImageProperties.greenf, this.openGLESImageProperties.bluef, this.openGLESImageProperties.alphaf)
                OpenGLESGL10Image.this.openGLESImageTranslate.translate2(gl, OpenGLESGL10Image.this)
                this.regionRectangleVertexFloatBuffer.put(this.regionRectangleFloatArray)
                this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0)
                gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer)
                gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
                gl.glEnable(GL10.GL_TEXTURE_2D)
                gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.textureID)
                gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
                this.glUtil.rotateUVs(this.regionTextureRectangleFloatArray, (-this.openGLESImageProperties.angle).toFloat, 0.5f, 0.5f)
                this.glUtil.position(this.textureVertexFloatBuffer, 0)
                this.textureVertexFloatBuffer.put(this.regionTextureRectangleFloatArray)
                this.glUtil.position(this.textureVertexFloatBuffer, 0)
                gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.textureVertexFloatBuffer)
                //gl.glDrawArrays(GL10.GL_TRIANGLES, 1, 3);            
                gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)
                gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
                gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY)
                gl.glDisable(GL10.GL_TEXTURE_2D)
                //Restore matrix
                gl.glPopMatrix()
            }

        }

    private var openGLESImageDraw : OpenGLESImageDraw = OpenGLESImageDraw.getInstance()

    //Constructor
    {
        val image : Image = param_image
        val bitmapFactory : PlatformBitmapBaseFactory = param_bitmapFactory
        val textureFactory : PlatformTextureBaseFactory = param_textureFactory
        this.initVertices()
    }

    /*     public OpenGLESGL10Image(GL10 gl, Image image, boolean matchColor)     {         super(gl, image, matchColor);          this.initVertices();                  this.update(gl);     }     */
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
            this.openGLESImageDraw = this.realOpenGLESImageDraw
            OpenGLLogUtil.getInstance().logError(gl10, this)
        }
    }

    override def drawRegion(gl : GL10, viewHeight : Int, x_src : Float, y_src : Float, width : Float, height : Float, x : Int, y : Int, z : Int) : Unit = {
        this.openGLESImageDraw.drawRegion(gl, viewHeight, x_src, y_src, width, height, x, y, z)
    }

    override def draw(gl : GL10, x : Int, y : Int, z : Int) : Unit = {
        this.openGLESImageDraw.draw(gl, x, y, z)
    }

}


