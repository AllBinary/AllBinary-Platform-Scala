/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image


class GameFeatureImageCacheFactory {
    import _root_.org.allbinary.image.GameFeatureImageCacheFactory.{*}

}

object GameFeatureImageCacheFactory {
    def getInstance() : ImageCache = {
        return ImageCacheFactory.getInstance()
    }

    def init() : Unit = {
        ImageCacheFactory.init()
    }

    def releaseAll() : Unit = {
        ImageCacheFactory.getInstance().releaseAll()
    }

}


