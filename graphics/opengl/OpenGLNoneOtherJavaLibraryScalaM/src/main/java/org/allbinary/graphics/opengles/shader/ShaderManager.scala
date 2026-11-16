/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class ShaderManager(param_GL_VERTEX_SHADER : Int, param_GL_FRAGMENT_SHADER : Int) {
    import _root_.org.allbinary.graphics.opengles.shader.ShaderManager.{*}

    val LOAD_SHADER : String = "loadShader"

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var GL_VERTEX_SHADER : Int = 0

    var GL_FRAGMENT_SHADER : Int = 0

    //Constructor
    {
        val GL_VERTEX_SHADER : Int = param_GL_VERTEX_SHADER
        val GL_FRAGMENT_SHADER : Int = param_GL_FRAGMENT_SHADER
        this.GL_VERTEX_SHADER = GL_VERTEX_SHADER
        this.GL_FRAGMENT_SHADER = GL_FRAGMENT_SHADER
    }

    def load(gl : GL10, resource : String, shaderAsStringArray : Array[String], shaderType : Int) : Int = {
        return -1
    }

    def loadShader(gl : GL10, resource : String, stringList : BasicArrayList, shaderType : Int) : Int = {
        return -1
    }

}

object ShaderManager {
    private val instance : ShaderManager = new ShaderManager(-1, -1)

    /**      * @return the instance      */
    def getInstance() : ShaderManager = {
        return ShaderManager.instance
    }

}


