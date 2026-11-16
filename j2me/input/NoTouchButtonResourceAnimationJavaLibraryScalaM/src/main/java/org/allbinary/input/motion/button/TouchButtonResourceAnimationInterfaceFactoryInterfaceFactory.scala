/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.image.ImageCacheFactory
import _root_.org.allbinary.logic.StdUtil

class TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory(param_name : String) extends BaseResourceAnimationInterfaceFactoryInterfaceFactory(param_name, StdUtil.getInstance().createHashtable(), StdUtil.getInstance().createHashtable(), StdUtil.getInstance().createHashtable()) {
    import _root_.org.allbinary.input.motion.button.TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory.{*}

    //Constructor
    {
        val name : String = param_name
    }

    override def init(level : Int) : Unit = {
        this.initImageCache(ImageCacheFactory.getInstance(), level)
    }

    override def initImageCache(imageCache : ImageCache, level : Int) : Unit = {
        if (this.isInitialized()) {
            return
        }
        super.init(level)
    }

    override def isLoadingLevel(level : Int) : Boolean = {
        var resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        if (level == resourceLoadingLevelFactory.LOAD_TOUCH.getLevel()) {
            return true
        } else {
            return super.isLoadingLevel(level)
        }
        throw new IllegalStateException()
    }

    override def isFeature() : Boolean = {
        if (!Features.getInstance().isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}

object TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory {
    def createFactory() : TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory = {
        return new TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory("TouchButton Animations")
    }

}


