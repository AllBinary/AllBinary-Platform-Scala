/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader


/**  *  * @author User  */
class AppRendererShaderUpdaterFactory extends ShaderUpdater {
    import _root_.org.allbinary.graphics.opengles.shader.AppRendererShaderUpdaterFactory.{*}

    private val NULL_SHADER_COMPOSITE_ARRAY : Array[ShaderComposite] = new Array[ShaderComposite](0)

    val shaderCompositeArray : Array[ShaderComposite] = this.NULL_SHADER_COMPOSITE_ARRAY

    private val shaderOpenGLProcessorArray : Array[ShaderOpenGLProcessor] = new Array[ShaderOpenGLProcessor](0)

    def getTestShaders() : Array[ShaderOpenGLProcessor] = {
        return this.shaderOpenGLProcessorArray
    }

    def setShaderComposite(object3d : Object) : Unit = {
    }

}

object AppRendererShaderUpdaterFactory {
    private val instanceC : AppRendererShaderUpdaterFactory = new AppRendererShaderUpdaterFactory()

    /**      * @return the instance      */
    def getInstance() : AppRendererShaderUpdaterFactory = {
        return AppRendererShaderUpdaterFactory.instanceC
    }

}


