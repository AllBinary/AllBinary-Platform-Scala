/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.org.allbinary.logic.string.StringUtil

class OpenGLCapabilities private() {
    import _root_.org.allbinary.graphics.opengles.OpenGLCapabilities.{*}

    val CUSTOM_GL_SURFACE_VIEW : Boolean = true

    val VERSION_1_0 : String = "1.0"

    val VERSION_1_1 : String = "1.1"

    val VERSION_2_0 : String = "2.0"

    val VERSION_3_0 : String = "3.0"

    val VERSION_3_1 : String = "3.1"

    val VERSION_3_2 : String = "3.2"

    val VERSION_HIGHER_THAN_EXISTS : String = "999.999"

    private var glVersion : String = StringUtil.getInstance().EMPTY_STRING

    var shaderVersion : Int = 0

    var glInstanceVersion : String = StringUtil.getInstance().EMPTY_STRING

    var maxTextureSize : Int = 64

    def isInitialized() : Boolean = {
        return true
    }

    def initCapabilities(gl : Object) : Unit = {
    }

    def isGlExtensionDrawTexture() : Boolean = {
        return false
    }

    def getGlVersion() : String = {
        return this.glVersion
    }

    def isVertexBufferObjectSupport() : Boolean = {
        return false
    }

    def isTextureSizeValid(widthAndHeight : Int) : Boolean = {
        return true
    }

}

object OpenGLCapabilities {
    private val instance : OpenGLCapabilities = new OpenGLCapabilities()

    def getInstance() : OpenGLCapabilities = {
        return OpenGLCapabilities.instance
    }

}


