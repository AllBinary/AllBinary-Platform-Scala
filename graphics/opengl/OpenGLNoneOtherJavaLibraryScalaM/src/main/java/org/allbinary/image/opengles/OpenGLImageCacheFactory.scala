/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.org.allbinary.image.ImageCache

//OpenGLNoneOtherJavaLibrary
class OpenGLImageCacheFactory {
    import _root_.org.allbinary.image.opengles.OpenGLImageCacheFactory.{*}

}

object OpenGLImageCacheFactory {
    private var IMAGE_CACHE : ImageCache = ImageCache.NULL_IMAGE_CACHE

    /*     public static void init(GL10 gl)     {         ((OpenGLImageCache) IMAGE_CACHE).setGl(gl);     }     */
    def getInstance() : ImageCache = {
        return OpenGLImageCacheFactory.IMAGE_CACHE
    }

    def init() : Unit = {
        if (OpenGLImageCacheFactory.IMAGE_CACHE == null) {
        }
    }

}


