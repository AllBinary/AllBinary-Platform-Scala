/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class GameCanvasPauseRunnable(param_allBinaryGameCanvas : AllBinaryGameCanvas) extends GameRunnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var allBinaryGameCanvas : AllBinaryGameCanvas = null

    //Constructor
    {
        val allBinaryGameCanvas : AllBinaryGameCanvas = param_allBinaryGameCanvas
        this.allBinaryGameCanvas = allBinaryGameCanvas
    }

    override def run() : Unit = {
    }

    override def processLoopSleep() : Unit = {
        //if(AndroidUtil.isAndroid()) {
        try {
            val features : Features = Features.getInstance()
            val isOpenGL : Boolean = features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)
            if (isOpenGL) {
                this.allBinaryGameCanvas.processSleep()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

}


