/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader


/**  *  * @author User  */
class ShaderStrings {
    import _root_.org.allbinary.graphics.opengles.shader.ShaderStrings.{*}

    val NO_PROGRAM_HANDLE : String = "No program handle"

    val UNIFORM_BLOCK_HANDLE : String = "Uniform Block Handle: "

    val UNIFORM_HANDLE : String = "Uniform Handle: "

    val UNIFORM_ATTRIBUTE_HANDLE : String = "Uniform Attribute Handle: "

}

object ShaderStrings {
    private val instance : ShaderStrings = new ShaderStrings()

    /**      * @return the instance      */
    def getInstance() : ShaderStrings = {
        return ShaderStrings.instance
    }

}


