/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.org.allbinary.logic.util.cache.BasicArrayListResetablePool
import _root_.org.allbinary.logic.util.cache.CacheableInterface
import _root_.org.allbinary.logic.util.cache.CacheableInterfaceFactoryInterface
import _root_.org.allbinary.logic.util.cache.PoolInterface

class ImageArrayRotationAnimationPool(param_cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface) extends BasicArrayListResetablePool(param_cacheableInterfaceFactoryInterface) {
    import _root_.org.allbinary.animation.image.ImageArrayRotationAnimationPool.{*}

    //Constructor
    {
        val cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface = param_cacheableInterfaceFactoryInterface
    }

    override def remove(key : Object) : CacheableInterface = {
        // this.cacheableInterfaceFactoryInterface.getInstance(key);
        val cacheableInterface : CacheableInterface = super.remove(key)
        val allBinaryImageRotationAnimationInfo : ImageArrayRotationAnimationInfo = key.asInstanceOf[ImageArrayRotationAnimationInfo]
        val imageArrayRotationAnimationCacheable : ImageArrayRotationAnimationCacheable = (cacheableInterface.asInstanceOf[ImageArrayRotationAnimationCacheable])
        imageArrayRotationAnimationCacheable.setImageArray(allBinaryImageRotationAnimationInfo.getImageArray())
        //allBinaryImageRotationAnimationInfo.getDy());
        return cacheableInterface
    }

}

object ImageArrayRotationAnimationPool {
    private var IMAGE_ROTATION_ANIMATION_POOL : PoolInterface = new ImageArrayRotationAnimationPool(new ImageArrayRotationAnimationCacheableInterfaceFactory())

    def getInstance() : PoolInterface = {
        return ImageArrayRotationAnimationPool.IMAGE_ROTATION_ANIMATION_POOL
    }

}


