/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader


/**  *  * @author User  */
class LoadedShaderManager {
    import _root_.org.allbinary.graphics.opengles.shader.LoadedShaderManager.{*}

}

object LoadedShaderManager {
    private val instance : ShaderManager = new ShaderManager(-1, -1)

    /**      * @return the instance      */
    def getInstance() : ShaderManager = {
        return LoadedShaderManager.instance
    }

}


