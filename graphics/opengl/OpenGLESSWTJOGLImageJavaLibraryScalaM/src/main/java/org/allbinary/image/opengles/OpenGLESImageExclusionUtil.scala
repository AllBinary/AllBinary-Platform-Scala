/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class OpenGLESImageExclusionUtil private() {
    import _root_.org.allbinary.image.opengles.OpenGLESImageExclusionUtil.{*}

    private val EXCLUSION : String = "font"

    val list : BasicArrayList = new BasicArrayListD()

    def isCustomScaling(image : Image) : Boolean = {
        val imageName : String = image.getName()
        var isNormalScaling : Boolean = (this.list.size() == 0) || imageName.startsWith(this.EXCLUSION)
        if (isNormalScaling) {
            return false
        } else {
            val size : Int = this.list.size()
            var name : String = null

            {
                var index : Int = 0
                while (index < size) {
                    name = this.list.get(index).asInstanceOf[String]
                    if (imageName.startsWith(name)) {
                        isNormalScaling = true
                    }
                    index += 1
                }
            }
        }
        if (isNormalScaling) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

}

object OpenGLESImageExclusionUtil {
    private val instance : OpenGLESImageExclusionUtil = new OpenGLESImageExclusionUtil()

    /**      * @return the instance      */
    def getInstance() : OpenGLESImageExclusionUtil = {
        return OpenGLESImageExclusionUtil.instance
    }

}


