/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class OpenGLESImageExclusionUtil {
    import _root_.org.allbinary.image.opengles.OpenGLESImageExclusionUtil.{*}

    val list : BasicArrayList = new BasicArrayListD()

    def isCustomScaling(image : Image) : Boolean = {
        return false
    }

}

object OpenGLESImageExclusionUtil {
    private val instance : OpenGLESImageExclusionUtil = new OpenGLESImageExclusionUtil()

    /**      * @return the instance      */
    def getInstance() : OpenGLESImageExclusionUtil = {
        return OpenGLESImageExclusionUtil.instance
    }

}


