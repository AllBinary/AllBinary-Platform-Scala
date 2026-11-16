/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.org.allbinary.graphics.opengles.shader.ShaderComposite

/**  *  * @author User  */
class OpenGLVersionValidator {
    import _root_.org.allbinary.graphics.opengles.OpenGLVersionValidator.{*}

    var EGL_CONTEXT_CLIENT_VERSION_VALUE : Int = -1

    def isGL31OrHigher() : Boolean = {
        return false
    }

    def isAvailable(glVersionRequired : String) : Boolean = {
        return false
    }

    def setShaderComposite(shaderComposite : ShaderComposite, anyType : Object) : Unit = {
    }

}

object OpenGLVersionValidator {
    private val instance : OpenGLVersionValidator = new OpenGLVersionValidator()

    /**      * @return the instance      */
    def getInstance() : OpenGLVersionValidator = {
        return OpenGLVersionValidator.instance
    }

}


