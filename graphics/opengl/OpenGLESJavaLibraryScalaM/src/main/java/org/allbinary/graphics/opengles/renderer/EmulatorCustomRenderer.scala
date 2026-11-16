/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.renderer

import _root_.javax.microedition.khronos.egl.EGLConfig
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.org.allbinary.emulator.InitEmulatorFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil

/**  *  * @author User  */
class EmulatorCustomRenderer {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val renderStrings : RendererStrings = RendererStrings.getInstance()

    //Wait until emulator is initialized
    def onSurfaceCreated(gl : GL10, eglConfig : EGLConfig) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.renderStrings.ON_SURFACE_CREATED)
        val initEmulatorFactory : InitEmulatorFactory = InitEmulatorFactory.getInstance()
        if (!initEmulatorFactory.isInitEmulator()) {
            try {
                val WAIT_FOR_EMULATOR : String = "Waiting on Emulator Initialization"

                {
                    while (!initEmulatorFactory.isInitEmulator()) {
                        //this.logUtil.putF(WAIT_FOR_EMULATOR, this, METHOD_NAME);
                        PreLogUtil.put(WAIT_FOR_EMULATOR, this, this.renderStrings.ON_SURFACE_CREATED)
                        Thread.sleep(180)
                    }
                }
            } catch {
                case e : Exception => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.renderStrings.ON_SURFACE_CREATED, e)
                }
            }
        }
    }

}


