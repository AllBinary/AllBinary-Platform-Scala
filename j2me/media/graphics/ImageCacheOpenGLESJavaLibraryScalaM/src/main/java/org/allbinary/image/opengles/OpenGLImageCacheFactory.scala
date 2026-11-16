/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.org.allbinary.image.ImageCache

//ImageCacheOpenGLESJavaLibrary
class OpenGLImageCacheFactory {
    import _root_.org.allbinary.image.opengles.OpenGLImageCacheFactory.{*}

}

object OpenGLImageCacheFactory {
    private val IMAGE_CACHE : ImageCache = new OpenGLImageCache()

    /*     public static void init(GL10 gl)     {         ((OpenGLImageCache) OpenGLImageCacheFactory.IMAGE_CACHE).setGl(gl);     }     */
    def getInstance() : ImageCache = {
        return OpenGLImageCacheFactory.IMAGE_CACHE
    }

    //require special attention and special calls for Android
    def init() : Unit = {
    }

}


