/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.shader

import _root_.javax.microedition.khronos.egl.EGLConfig
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.graphics.opengles.renderer.RendererStrings
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class ShaderUpdater {
    import _root_.org.allbinary.graphics.opengles.shader.ShaderUpdater.{*}

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val rendererStrings : RendererStrings = RendererStrings.getInstance()

    def onSurfaceCreated(gl : GL10, eglConfig : EGLConfig) : Unit = {
    }

}

object ShaderUpdater {
    private val instance : ShaderUpdater = new ShaderUpdater()

    /**      * @return the instance      */
    def getInstance() : ShaderUpdater = {
        return ShaderUpdater.instance
    }

}


