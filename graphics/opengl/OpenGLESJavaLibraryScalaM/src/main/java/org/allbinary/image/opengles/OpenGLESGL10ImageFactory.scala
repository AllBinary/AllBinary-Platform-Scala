/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory

class OpenGLESGL10ImageFactory extends OpenGLImageFactory {

    /*     public Image getInstance(GL10 gl, Image image, boolean matchColor)     {         return new OpenGLESGL10Image(gl, image, matchColor);     }     */
    override def getInstance(image : Image, bitmapFactory : PlatformBitmapBaseFactory, textureFactory : PlatformTextureBaseFactory) : Image = {
        //PreLogUtil.put("opengl " + image.getName(), this, this.commonStrings.GET_INSTANCE);
        return new OpenGLESGL10Image(image, bitmapFactory, textureFactory)
    }

}


