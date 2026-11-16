/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles


class OpenGLFeatureUtil() {
    import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil.{*}

    //Could become true if non opengl 3d is added like direct3d or other
    def isAnyThreed() : Boolean = {
        return false
    }

}

object OpenGLFeatureUtil {
    private val instance : OpenGLFeatureUtil = new OpenGLFeatureUtil()

    def getInstance() : OpenGLFeatureUtil = {
        return OpenGLFeatureUtil.instance
    }

}


