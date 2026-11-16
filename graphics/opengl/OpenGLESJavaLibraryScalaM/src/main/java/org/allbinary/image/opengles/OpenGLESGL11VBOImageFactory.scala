/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory

class OpenGLESGL11VBOImageFactory extends OpenGLImageFactory {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    override def getInstance(image : Image, bitmapFactory : PlatformBitmapBaseFactory, textureFactory : PlatformTextureBaseFactory) : Image = {
        //PreLogUtil.put(image.getName(), this, this.commonStrings.GET_INSTANCE);
        return new OpenGLESGL10Image(image, bitmapFactory, textureFactory)
    }

}


