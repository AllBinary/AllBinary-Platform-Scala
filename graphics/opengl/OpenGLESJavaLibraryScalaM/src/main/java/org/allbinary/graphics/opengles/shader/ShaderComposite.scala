/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.graphics.opengles.OpenGLProcessor
import _root_.org.allbinary.graphics.opengles.NullOpenGLProcessorFactory

/**  *  * @author User  */
class ShaderComposite(param_requiresOpenGLVersion : String, param_shaderArray : Array[Shader], param_compositeShaderUpdater : CompositeShaderUpdater, param_shaderInitializer : ShaderInitializer, param_modelViewProjection : ModelViewProjection, param_colorOpenGLProcessor : OpenGLProcessor, param_vertexOpenGLProcessor : OpenGLProcessor, param_disableProgramShaderOpenGLProcessor : OpenGLProcessor) {

    var disableProgramShaderOpenGLProcessor : OpenGLProcessor = null

    var requiresOpenGLVersion : String = null

    var shaderArray : Array[Shader] = null

    var shaderInitializer : ShaderInitializer = null

    var compositeShaderUpdater : CompositeShaderUpdater = null

    var modelViewProjection : ModelViewProjection = null

    var colorOpenGLProcessor : OpenGLProcessor = null

    var vertexOpenGLProcessor : OpenGLProcessor = null

    var useProgramShaderOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var shaderMatrixOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var colorEnableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var normalEnableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var vertexEnableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var textureEnableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var colorDisableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var normalDisableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var vertexDisableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var textureDisableVertexAttribArrayOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var uniformLightPositionOpenGLProcessor : OpenGLObject3dProcessor = NullOpenGLTextureProcessor.getInstance()

    var uniformLightColorOpenGLProcessor : OpenGLObject3dProcessor = NullOpenGLTextureProcessor.getInstance()

    var uniformCameraPositionOpenGLProcessor : OpenGLObject3dProcessor = NullOpenGLTextureProcessor.getInstance()

    var uniformTextureUnitOpenGLProcessor : OpenGLObject3dProcessor = NullOpenGLTextureProcessor.getInstance()

    var programHandle : Int = 0

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
        this.requiresOpenGLVersion = requiresOpenGLVersion
        this.shaderArray = shaderArray
        this.shaderInitializer = shaderInitializer
        this.compositeShaderUpdater = compositeShaderUpdater
        this.modelViewProjection = modelViewProjection
        this.colorOpenGLProcessor = colorOpenGLProcessor
        this.vertexOpenGLProcessor = vertexOpenGLProcessor
        this.disableProgramShaderOpenGLProcessor = disableProgramShaderOpenGLProcessor
    }

    def init(gl : GL10) : Unit = {
        this.programHandle = this.shaderInitializer.init(gl, this.shaderArray, this.compositeShaderUpdater.attributeArray)
    }

}


