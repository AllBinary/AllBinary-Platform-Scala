/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package min3d.core

import _root_.javax.microedition.khronos.egl.EGLConfig
import _root_.javax.microedition.khronos.opengles.GL10

/**  *  * @author User  */
trait Renderer {

    def onSurfaceCreated(gl : GL10, config : EGLConfig) : Unit

    def onSurfaceChanged(gl : GL10, width : Int, height : Int) : Unit

    def onDrawFrame(gl : GL10) : Unit

}


