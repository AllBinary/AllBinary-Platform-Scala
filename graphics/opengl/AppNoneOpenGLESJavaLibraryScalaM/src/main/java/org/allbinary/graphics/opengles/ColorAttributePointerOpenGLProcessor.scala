/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.graphics.threed.min3d.renderer.processor.ObjectThreedOpenGLProcessor

/**  *  * @author User  */
class ColorAttributePointerOpenGLProcessor() extends ObjectThreedOpenGLProcessor {
    import _root_.org.allbinary.graphics.opengles.ColorAttributePointerOpenGLProcessor.{*}

    override def process(gl : GL10, anyType : Object) : Unit = {
        throw new RuntimeException()
    }

}

object ColorAttributePointerOpenGLProcessor {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ColorAttributePointerOpenGLProcessor = new ColorAttributePointerOpenGLProcessor()

    /**      * @return the instance      */
    def getInstance() : ColorAttributePointerOpenGLProcessor = {
        return ColorAttributePointerOpenGLProcessor.instance
    }

}


