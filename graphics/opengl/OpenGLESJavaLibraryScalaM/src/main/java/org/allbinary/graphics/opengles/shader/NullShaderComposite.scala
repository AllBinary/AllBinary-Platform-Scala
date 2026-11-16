/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.graphics.opengles.NullOpenGLProcessorFactory
import _root_.org.allbinary.graphics.opengles.OpenGLCapabilities
import _root_.org.allbinary.graphics.opengles.OpenGLProcessor

/**  *  * @author User  */
class NullShaderComposite(param_requiresOpenGLVersion : String, param_shaderArray : Array[Shader], param_compositeShaderUpdater : CompositeShaderUpdater, param_shaderInitializer : ShaderInitializer, param_modelViewProjection : ModelViewProjection, param_colorOpenGLProcessor : OpenGLProcessor, param_vertexOpenGLProcessor : OpenGLProcessor, param_disableProgramShaderOpenGLProcessor : OpenGLProcessor) extends ShaderComposite(param_requiresOpenGLVersion, param_shaderArray, param_compositeShaderUpdater, param_shaderInitializer, param_modelViewProjection, param_colorOpenGLProcessor, param_vertexOpenGLProcessor, param_disableProgramShaderOpenGLProcessor) {
    import _root_.org.allbinary.graphics.opengles.shader.NullShaderComposite.{*}

    //Constructor
    {
        val requiresOpenGLVersion : String = param_requiresOpenGLVersion
        val shaderArray : Array[Shader] = param_shaderArray
        val compositeShaderUpdater : CompositeShaderUpdater = param_compositeShaderUpdater
        val shaderInitializer : ShaderInitializer = param_shaderInitializer
        val modelViewProjection : ModelViewProjection = param_modelViewProjection
        val colorOpenGLProcessor : OpenGLProcessor = param_colorOpenGLProcessor
        val vertexOpenGLProcessor : OpenGLProcessor = param_vertexOpenGLProcessor
        val disableProgramShaderOpenGLProcessor : OpenGLProcessor = param_disableProgramShaderOpenGLProcessor
        this.useProgramShaderOpenGLProcessor = NullOpenGLProcessorFactory.getInstance()
    }

}

object NullShaderComposite {
    private val instance : NullShaderComposite = new NullShaderComposite(OpenGLCapabilities.getInstance().VERSION_2_0, Array[Shader](new Shader(), new Shader()), CompositeShaderUpdater.getInstance(), ShaderInitializer.getInstance(), ModelViewProjection.getInstance(), NullOpenGLProcessorFactory.getInstance(), NullOpenGLProcessorFactory.getInstance(), NullOpenGLProcessorFactory.getInstance()) {
            override def init(gl : GL10) : Unit = {
            }

        }

    /**      * @return the instance      */
    def getInstance() : ShaderComposite = {
        return NullShaderComposite.instance
    }

}


