/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.platform.graphics.PlatformBitmapBase
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

//OpenGLESNullImageJ2MEJavaLibrary
class OpenGLESImage(param_image : Image, param_bitmapFactory : PlatformBitmapBaseFactory, param_textureFactory : PlatformTextureBaseFactory) extends OpenGLSurfaceChangedInterface {
    import _root_.org.allbinary.image.opengles.OpenGLESImage.{NULL_OPENGL_IMAGE as _, texture2dList as _, TYPE as _, *}
    def NULL_OPENGL_IMAGE : OpenGLESImage = _root_.org.allbinary.image.opengles.OpenGLESImage.NULL_OPENGL_IMAGE
    def texture2dList : BasicArrayList = _root_.org.allbinary.image.opengles.OpenGLESImage.texture2dList
    def TYPE : Int = _root_.org.allbinary.image.opengles.OpenGLESImage.TYPE

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var textureFactory : PlatformTextureBaseFactory = null

    var openGLBitmap : PlatformBitmapBase = null

    val openGLESImageProperties : OpenGLESImageProperties = new OpenGLESImageProperties()

    //Constructor
    {
        val image : Image = param_image
        val bitmapFactory : PlatformBitmapBaseFactory = param_bitmapFactory
        val textureFactory : PlatformTextureBaseFactory = param_textureFactory
        //super(image);
        this.openGLBitmap = bitmapFactory.createBitmap(image)
        this.textureFactory = textureFactory
    }

    override def set(gl : GL) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def initTexture(gl : GL10) : Boolean = {
        return false
    }

    def drawRegion(gl : GL10, viewHeight : Int, x_src : Float, y_src : Float, width : Float, height : Float, x : Int, y : Int, z : Int) : Unit = {
    }

    def draw(gl : GL10, x : Int, y : Int, z : Int) : Unit = {
    }

    def getType() : Int = {
        return OpenGLESImage.TYPE
    }

}

object OpenGLESImage {
    val NULL_OPENGL_IMAGE : OpenGLESImage = new OpenGLESImage(NullImage.NULL_IMAGE, PlatformBitmapBaseFactory.NULL_PLATFORM_BITMAP_BASE_FACTORY, PlatformTextureBaseFactory.NULL_PLATFORM_TEXTURE_BASE_FACTORY)

    val texture2dList : BasicArrayList = new BasicArrayListD()

    val TYPE : Int = 4

}


