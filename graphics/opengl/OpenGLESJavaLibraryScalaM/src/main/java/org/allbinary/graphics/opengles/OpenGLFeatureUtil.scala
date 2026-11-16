/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.org.allbinary.game.configuration.feature.Features

class OpenGLFeatureUtil() {
    import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil.{*}

    private var anyThreed : Boolean = false

    //Constructor
    {
        val openGLConfiguration : OpenGLConfiguration = OpenGLConfiguration.getInstance()
        val features : Features = Features.getInstance()
        val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
        this.anyThreed = openGLConfiguration.isOpenGL() && (features.isFeature(openGLFeatureFactory.OPENGL_2D_AND_3D) || features.isFeature(openGLFeatureFactory.OPENGL_3D))
    }

    def isAnyThreed() : Boolean = {
        return this.anyThreed
    }

}

object OpenGLFeatureUtil {
    private val instance : OpenGLFeatureUtil = new OpenGLFeatureUtil()

    def getInstance() : OpenGLFeatureUtil = {
        return OpenGLFeatureUtil.instance
    }

}


