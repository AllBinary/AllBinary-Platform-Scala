/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.image.opengles.OpenGLImageCacheFactory

class TouchButtonResourceOpenGLESAnimationInterfaceFactoryInterfaceFactory() extends TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory("OpenGL TouchButton Animations") {

    override def init(level : Int) : Unit = {
        super.initImageCache(OpenGLImageCacheFactory.getInstance(), level)
    }

    override def isFeature() : Boolean = {
        if (Features.getInstance().isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


