/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image


/*//JSNI Expose so JSNI can access this class *** 
 globalThis.org.allbinary = globalThis.org.allbinary || {}; 
 globalThis.org.allbinary.image = globalThis.org.allbinary.image || {}; 
 globalThis.org.allbinary.image.ImageCacheFactory = ImageCacheFactory; 
 console.log('Exported ImageCacheFactory as globalThis'); 
 */
class ImageCacheFactory {
    import _root_.org.allbinary.image.ImageCacheFactory.{*}

}

object ImageCacheFactory {
    private val IMAGE_CACHE : ImageCache = new ImageCache()

    def getInstance() : ImageCache = {
        return ImageCacheFactory.IMAGE_CACHE
    }

    //require special attention and special calls for Android
    def init() : Unit = {
    }

}


