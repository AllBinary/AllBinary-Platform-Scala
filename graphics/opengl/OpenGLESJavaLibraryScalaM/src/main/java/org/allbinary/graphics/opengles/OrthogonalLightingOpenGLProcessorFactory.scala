/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles


/**  *  * @author User  */
class OrthogonalLightingOpenGLProcessorFactory {
    import _root_.org.allbinary.graphics.opengles.OrthogonalLightingOpenGLProcessorFactory.{*}

    var sceneLightingOrthogonalModeOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

    var sceneLightsOrthogonalModeOpenGLProcessor : OpenGLProcessor = NullOpenGLProcessorFactory.getInstance()

}

object OrthogonalLightingOpenGLProcessorFactory {
    private val instance : OrthogonalLightingOpenGLProcessorFactory = new OrthogonalLightingOpenGLProcessorFactory()

    /**      * @return the instance      */
    def getInstance() : OrthogonalLightingOpenGLProcessorFactory = {
        return OrthogonalLightingOpenGLProcessorFactory.instance
    }

}


