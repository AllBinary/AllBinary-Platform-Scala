/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader

import _root_.javax.microedition.khronos.egl.EGLConfig
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps

/**  *  * @author User  */
class CompositeShaderUpdater(param_uniformBlockArray : Array[String], param_uniformArray : Array[String], param_attributeArray : Array[String], param_attributeHandleArray : Array[Int]) extends ShaderUpdater {
    import _root_.org.allbinary.graphics.opengles.shader.CompositeShaderUpdater.{*}

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    val shaderStrings : ShaderStrings = ShaderStrings.getInstance()

    var uniformBlockHandleArray : Array[Int] = null

    var uniformBlockArray : Array[String] = null

    var uniformHandleArray : Array[Int] = null

    var uniformArray : Array[String] = null

    var attributeHandleArray : Array[Int] = null

    var attributeArray : Array[String] = null

    //    }
    //Constructor
    {
        val uniformBlockArray : Array[String] = param_uniformBlockArray
        val uniformArray : Array[String] = param_uniformArray
        val attributeArray : Array[String] = param_attributeArray
        val attributeHandleArray : Array[Int] = param_attributeHandleArray
        this.uniformBlockArray = uniformBlockArray
        this.uniformBlockHandleArray = new Array[Int](this.uniformBlockArray.length)
        this.uniformArray = uniformArray
        this.uniformHandleArray = new Array[Int](this.uniformArray.length)
        this.attributeArray = attributeArray
        this.attributeHandleArray = attributeHandleArray
    }

    def onSurfaceCreated(gl : GL10, eglConfig : EGLConfig, programHandle : Int) : Unit = {
    }

    def onSurfaceDestroyed(gl : GL10) : Unit = {
    }

}

object CompositeShaderUpdater {
    private val instanceC : CompositeShaderUpdater = new CompositeShaderUpdater(StringUtil.getInstance().getArrayInstance(), StringUtil.getInstance().getArrayInstance(), StringUtil.getInstance().getArrayInstance(), NullUtil.getInstance().NULL_INT_ARRAY)

    /**      * @return the instance      */
    def getInstance() : CompositeShaderUpdater = {
        return CompositeShaderUpdater.instanceC
    }

}


