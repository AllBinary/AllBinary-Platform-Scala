/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class ShaderInitializer {
    import _root_.org.allbinary.graphics.opengles.shader.ShaderInitializer.{*}

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def init(gl : GL10, shader : Array[Shader], attributeArray : Array[String]) : Int = {
        return -1
    }

}

object ShaderInitializer {
    private val instance : ShaderInitializer = new ShaderInitializer()

    /**      * @return the instance      */
    def getInstance() : ShaderInitializer = {
        return ShaderInitializer.instance
    }

}


