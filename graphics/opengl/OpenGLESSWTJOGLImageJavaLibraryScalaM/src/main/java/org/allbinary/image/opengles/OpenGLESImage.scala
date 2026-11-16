/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.javax.microedition.lcdui.OpenGLESPostLoadPlatformImage
import _root_.javax.microedition.lcdui.PostLoadImageProcessor
import _root_.org.allbinary.graphics.GraphicsStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.platform.graphics.PlatformBitmapBase
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

//OpenGLESSWTJOGLImageJavaLibrary
class OpenGLESImage(param_image : Image, param_bitmapFactory : PlatformBitmapBaseFactory, param_textureFactory : PlatformTextureBaseFactory) extends Image(param_image.getName(), PostLoadImageProcessor.NULL_POST_LOAD_IMAGE_PROCESSOR) with OpenGLSurfaceChangedInterface {
    import _root_.org.allbinary.image.opengles.OpenGLESImage.{NULL_OPENGL_IMAGE as _, texture2dList as _, TYPE as _, *}
    def NULL_OPENGL_IMAGE : OpenGLESImage = _root_.org.allbinary.image.opengles.OpenGLESImage.NULL_OPENGL_IMAGE
    def texture2dList : BasicArrayList = _root_.org.allbinary.image.opengles.OpenGLESImage.texture2dList
    def TYPE : Int = _root_.org.allbinary.image.opengles.OpenGLESImage.TYPE

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var textureFactory : PlatformTextureBaseFactory = null

    var openGLBitmap : PlatformBitmapBase = null

    var imageProcessor : OpenGLESImageProcessor = OpenGLESImageProcessor.getInstance()

    var openGLESImageTranslate : OpenGLESImageTranslate = OpenGLESImageTranslate.getInstance()

    val openGLESImageProperties : OpenGLESImageProperties = new OpenGLESImageProperties()

    //JOGL
    //Constructor
    {
        val image : Image = param_image
        val bitmapFactory : PlatformBitmapBaseFactory = param_bitmapFactory
        val textureFactory : PlatformTextureBaseFactory = param_textureFactory
        //this.logUtil.putF(new StringMaker().append("opengl: create ").append(this).append(this.getName()).append(" from " ).append(image).toString(), this, this.commonStrings.INIT);
        this.openGLBitmap = bitmapFactory.createBitmap(image)
        this.textureFactory = textureFactory
        OpenGLImageCacheFactory.getInstance().init(this)
        this.platformImage = OpenGLESPostLoadPlatformImage.getInstance()
    }

    /*     public OpenGLESImage(GL10 gl, Image image, boolean matchColor)     {         super(image);                  //this.matchColor = matchColor;     }     */
    def getHeight() : Int = {
        return (this.openGLBitmap.getHeight() * this.openGLESImageProperties.scaleY2).toInt
    }

    def getWidth() : Int = {
        return (this.openGLBitmap.getWidth() * this.openGLESImageProperties.scaleX2).toInt
    }

    /*     protected void update(GL10 gl)     {         try         {             this.set(gl);         } catch (Exception e)         {             this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.UPDATE, e);         }     }     */
    def set(gl : GL) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def initTexture(gl : GL10) : Boolean = {
        if (!OpenGLESImage.texture2dList.contains(this)) {
            OpenGLESImage.texture2dList.add(this)
            //PreLogUtil.put(this.commonStrings.INIT, this, "OpenGLESImage->initTexture");
            val textures : Array[Int] = new Array[Int](1)
            /*             if(this.matchColor)             {                 gl.glActiveTexture(GL10.GL_TEXTURE0);                 gl.glClientActiveTexture(GL10.GL_TEXTURE0);              }             else             {                 gl.glActiveTexture(GL10.GL_TEXTURE1);                 gl.glClientActiveTexture(GL10.GL_TEXTURE1);             }             */
            gl.glEnable(GL10.GL_TEXTURE_2D)
            //Delete old texture
            if (this.openGLESImageProperties.textureID != -1) {
                textures(0) = this.openGLESImageProperties.textureID
                gl.glDeleteTextures(1, textures, 0)
            }
            gl.glGenTextures(1, textures, 0)
            this.openGLESImageProperties.textureID = textures(0)
            gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.textureID)
            //gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR_MIPMAP_LINEAR);
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST)
            // texture wrapping settings
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_CLAMP_TO_EDGE)
            gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_CLAMP_TO_EDGE)
            /*         ByteBuffer bytebuf = ByteBuffer.allocateDirect(bmp.getHeight() * bmp.getWidth() * 4);         bytebuf.order(ByteOrder.nativeOrder());         IntBuffer pixelbuf = bytebuf.asIntBuffer();                   for(int y = 0; y &lt; bmp.getHeight(); y++)           for(int x = 0; x &lt; bmp.getWidth(); x++) {             pixelbuf.put(bmp.getPixel(x, y));           }         this.glUtil.position(pixelbuf, 0);         this.glUtil.position(bytebuf, 0);                   gl.glTexImage2D(GL10.GL_TEXTURE_2D, level, GL10.GL_RGBA, bmp.getWidth(), bmp.getHeight(), 0, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, pixelbuf);         */
            return true
        }
        return false
    }

    def drawRegion(gl : GL10, viewHeight : Int, x_src : Float, y_src : Float, width : Float, height : Float, x : Int, y : Int, z : Int) : Unit = {
    }

    def draw(gl : GL10, x : Int, y : Int, z : Int) : Unit = {
    }

    def getType() : Int = {
        return OpenGLESImage.TYPE
    }

    override def toString() : String = {
        val graphicsStrings : GraphicsStrings = GraphicsStrings.getInstance()
        return new StringMaker().append(this.getName()).append(super.toString()).append(graphicsStrings.OPACITY).appendfloat(this.openGLESImageProperties.alphaf).toString()
    }

}

object OpenGLESImage {
    val NULL_OPENGL_IMAGE : OpenGLESImage = new OpenGLESImage(NullImage.NULL_IMAGE, PlatformBitmapBaseFactory.NULL_PLATFORM_BITMAP_BASE_FACTORY, PlatformTextureBaseFactory.NULL_PLATFORM_TEXTURE_BASE_FACTORY)

    val texture2dList : BasicArrayList = new BasicArrayListD()

    val TYPE : Int = 4

}


