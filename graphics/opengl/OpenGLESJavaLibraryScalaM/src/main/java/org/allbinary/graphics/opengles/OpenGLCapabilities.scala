/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.khronos.opengles.GL11
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.image.opengles.OpenGLESGL10ImageFactory
import _root_.org.allbinary.image.opengles.OpenGLESGL11VBOImageFactory
import _root_.org.allbinary.image.opengles.OpenGLImageSpecificFactory
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.tokens.Tokenizer
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.logic.communication.log.LogUtil

class OpenGLCapabilities private() {
    import _root_.org.allbinary.graphics.opengles.OpenGLCapabilities.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val CUSTOM_GL_SURFACE_VIEW : Boolean = true

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private var initialized : Boolean = false

    private var glVersionString : String = this.stringUtil.EMPTY_STRING

    private var glShaderVersionString : String = this.stringUtil.EMPTY_STRING

    var shaderVersion : Int = 0

    private var glRenderer : String = this.stringUtil.EMPTY_STRING

    private var glVendor : String = this.stringUtil.EMPTY_STRING

    private var glExtensions : String = this.stringUtil.EMPTY_STRING

    private var possiblyAccelerated : Boolean = false

    private var acceleratedString : String = this.stringUtil.EMPTY_STRING

    var maxTextureSize : Int = 64

    val VERSION_1_0 : String = "1.0"

    val VERSION_1_1 : String = "1.1"

    val VERSION_2_0 : String = "2.0"

    val VERSION_3_0 : String = "3.0"

    val VERSION_3_1 : String = "3.1"

    val VERSION_3_2 : String = "3.2"

    val VERSION_HIGHER_THAN_EXISTS : String = "999.999"

    val VERSION_UNK : String = "Unk"

    val GL_EXT_GPU_SHADER_100 : String = "GL_ARB_shading_language_100"

    //4.50              4.5
    val GL_EXT_GPU_SHADER4 : String = "GL_EXT_gpu_shader4"

    private var glVersion : String = this.glVersionString

    var glInstanceVersion : String = this.VERSION_UNK

    private var glExtensionDrawTexture : Boolean = false

    private var glThreedDrawTexture : Boolean = false

    private var glExtensionGPUShader4 : Boolean = false

    private var glExtensionGPUShader100 : Boolean = false

    private var vertexBufferObjectSupport : Boolean = false

    def isInitialized() : Boolean = {
        return this.initialized
    }

    private def requireInitialization() : Unit = {
    }

    def initCapabilities(gl : GL10) : Unit = {
        val METHOD_NAME : String = "initGLCapabilities"
        try {
            val features : Features = Features.getInstance()
            val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
            val openGLImageSpecificFactory : OpenGLImageSpecificFactory = OpenGLImageSpecificFactory.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            this.glVersionString = gl.glGetString(GL10.GL_VERSION)
            val GL_SHADING_LANGUAGE_VERSION : Int = 0x8b8c
            this.glShaderVersionString = gl.glGetString(GL_SHADING_LANGUAGE_VERSION)
            //GL_ARB_fragment_program: SM 2.0 or better.            
            if (this.glShaderVersionString == null) {
                this.glShaderVersionString = this.stringUtil.EMPTY_STRING
            }
            try {
                if ((this.glShaderVersionString != null) && (this.glShaderVersionString.indexOf('.') >= 0)) {
                    val startIndex : Int = this.glShaderVersionString.lastIndexOf(' ')
                    if (startIndex >= 0) {
                        this.glShaderVersionString = this.glShaderVersionString.substring(startIndex + 1)
                    }
                    this.shaderVersion = Integer.parseInt(this.glShaderVersionString.replace(CommonSeps.getInstance().PERIOD, StringUtil.getInstance().EMPTY_STRING))
                }
            } catch {
                case e : Exception => {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, METHOD_NAME, e)
                }
            }
            this.glRenderer = gl.glGetString(GL10.GL_RENDERER)
            this.glVendor = gl.glGetString(GL10.GL_VENDOR)
            this.glExtensions = gl.glGetString(GL10.GL_EXTENSIONS)
            if (this.glExtensions.indexOf(this.GL_EXT_GPU_SHADER_100) >= 0) {
                this.glExtensionGPUShader100 = true
            } else {
                this.glExtensionGPUShader100 = false
            }
            if (this.glExtensions.indexOf(this.GL_EXT_GPU_SHADER4) >= 0) {
                this.glExtensionGPUShader4 = true
            } else {
                this.glExtensionGPUShader4 = false
            }
            if (this.glRenderer == null) {
                this.glRenderer = this.stringUtil.EMPTY_STRING
            }
            if (this.glRenderer.toLowerCase().indexOf("pixelflinger") >= 0) {
                this.acceleratedString = "Probably Not for " + this.glRenderer
                this.possiblyAccelerated = false
            } else {
                this.acceleratedString = "Probably for " + this.glRenderer

                this.possiblyAccelerated = true
            }
            /*         if(this.isExtension(openGLFeatureFactory.OPENGL_DRAW_TEXTURE))         {             this.glExtensionDrawTexture = true;         }         else         {             this.glExtensionDrawTexture = false;         }              */
            this.glExtensionDrawTexture = false
            if (this.glVersionString == null) {
                this.glVersionString = this.stringUtil.EMPTY_STRING
                this.glVersion = this.VERSION_UNK
            } else if (this.glVersionString.indexOf(" 1.0") >= 0) {
                this.glVersion = this.VERSION_1_0
            } else if (this.glVersionString.indexOf(" 1.1") >= 0) {
                this.glVersion = this.VERSION_1_1
            } else {
                this.glVersion = this.VERSION_UNK
            }
            if (gl.isInstanceOf[GL11]) {
                this.glInstanceVersion = this.VERSION_1_1
            } else if (gl.isInstanceOf[GL10]) {
                this.glInstanceVersion = this.VERSION_1_0
            }
            if (this.glVendor == null) {
                this.glVendor = this.stringUtil.EMPTY_STRING
            }
            if (this.glExtensions == null) {
                this.glExtensions = this.stringUtil.EMPTY_STRING
            }
            if (this.possiblyAccelerated) {
                PreLogUtil.put(new StringMaker().append("VBO:?").appendboolean((this.glInstanceVersion eq this.VERSION_1_1)).append("||").appendboolean(this.isExtension(openGLFeatureFactory.OPENGL_VERTEX_BUFFER_OBJECT)).toString(), this, METHOD_NAME)
                if (((this.glInstanceVersion eq this.VERSION_1_1) || this.isExtension(openGLFeatureFactory.OPENGL_VERTEX_BUFFER_OBJECT))) {
                    if (AndroidUtil.isAndroid()) {
                        PreLogUtil.put("VBO implementation was detected, but disabled by default for Android", this, METHOD_NAME)
                    } else {
                        PreLogUtil.put("VBO implementation was detected, but disabled for now", this, METHOD_NAME)
                    }
                }
            }
            val stringUtil : StringUtil = StringUtil.getInstance()
            if (features.isDefault(openGLFeatureFactory.OPENGL_AUTO_SELECT)) {
                //StupidTimer.visit(new RendererSurfaceCreatedVisitor());
                if (this.vertexBufferObjectSupport) {
                    openGLImageSpecificFactory.setImageFactory(new OpenGLESGL11VBOImageFactory())
                } else {
                    stringBuffer.append("OpenGL is on but ")
                    stringBuffer.append(stringUtil.toString(openGLFeatureFactory.OPENGL_DRAW_TEXTURE))
                    stringBuffer.append(" was not available")
                    PreLogUtil.put(stringBuffer.toString(), this, METHOD_NAME)
                    openGLImageSpecificFactory.setImageFactory(new OpenGLESGL10ImageFactory())
                }
            } else {
                stringBuffer.append(stringUtil.toString(openGLFeatureFactory.OPENGL_AUTO_SELECT))
                stringBuffer.append(" is not on")
                PreLogUtil.put(stringBuffer.toString(), this, METHOD_NAME)
                openGLImageSpecificFactory.setImageFactory(new OpenGLESGL10ImageFactory())
            }
            //GL_MAX_RECTANGLE_TEXTURE_SIZE, and maybe GL_MAX_3D_TEXTURE_SIZE            
            val maxTextureSizeArray : Array[Int] = new Array[Int](1)
            gl.glGetIntegerv(GL10.GL_MAX_TEXTURE_SIZE, maxTextureSizeArray, 0)
            this.maxTextureSize = maxTextureSizeArray(0)
            //OpenGLImageSpecificFactory.getInstance().setImageFactory(new OpenGLESGL10RectangleImageFactory());
            this.initialized = true
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, METHOD_NAME, e)
            }
        }
    }

    private def isExtension(gameFeature : OpenGLFeature) : Boolean = {
        var index : Int = this.glExtensions.indexOf(gameFeature.getName())
        if (index >= 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isGlExtensionDrawTexture() : Boolean = {
        this.requireInitialization()
        return this.glExtensionDrawTexture
    }

    def isGlExtensionGPUShader100() : Boolean = {
        return this.glExtensionGPUShader100
    }

    def isGlExtensionGPUShader4() : Boolean = {
        this.requireInitialization()
        return this.glExtensionGPUShader4
    }

    def getGlVersion() : String = {
        this.requireInitialization()
        return this.glVersion
    }

    def getGlVersionString() : String = {
        this.requireInitialization()
        return this.glVersionString
    }

    def getGlShaderVersion() : String = {
        this.requireInitialization()
        return this.glShaderVersionString
    }

    def isGlThreedDrawTexture() : Boolean = {
        this.requireInitialization()
        return this.glThreedDrawTexture
    }

    def getGlRenderer() : String = {
        this.requireInitialization()
        return this.glRenderer
    }

    def isVertexBufferObjectSupport() : Boolean = {
        this.requireInitialization()
        return this.vertexBufferObjectSupport
    }

    def isTextureSizeValid(widthAndHeight : Int) : Boolean = {
        this.requireInitialization()
        if (this.maxTextureSize >= widthAndHeight) {
            return true
        }
        return false
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("GL_VERSION: ")
        stringBuffer.append(this.glVersionString)
        stringBuffer.append(" GL_SHADING_LANGUAGE_VERSION: ")
        stringBuffer.append(this.glShaderVersionString)
        stringBuffer.append(" GL_RENDERER: ")
        stringBuffer.append(this.glRenderer)
        stringBuffer.append(" GL_VENDOR: ")
        stringBuffer.append(this.glVendor)
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(" Is Accelerated: ")
        stringBuffer.append(this.acceleratedString)
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(" VBO Support: ")
        stringBuffer.appendboolean(this.isVertexBufferObjectSupport())
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(" Max Texture Size: ")
        stringBuffer.appendint(this.maxTextureSize)
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(" GL_EXTENSIONS: ")
        try {
            var tokenizer : Tokenizer = new Tokenizer(commonSeps.SPACE)
            var list : BasicArrayList = tokenizer.getTokensFromString(this.glExtensions, new BasicArrayListD())
            val size : Int = list.size()

            {
                var index : Int = 0
                while (index < size) {
                    stringBuffer.append(commonSeps.NEW_LINE)
                    stringBuffer.append(this.stringUtil.toString(list.objectArray(index)))
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.TOSTRING, e)
            }
        }
        return stringBuffer.toString()
    }

}

object OpenGLCapabilities {
    private val instance : OpenGLCapabilities = new OpenGLCapabilities()

    def getInstance() : OpenGLCapabilities = {
        return OpenGLCapabilities.instance
    }

}


