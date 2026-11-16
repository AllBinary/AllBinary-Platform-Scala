/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.NullRunnable

/**  *  * @author User  */
class RepaintBehavior {
    import _root_.org.allbinary.game.displayable.RepaintBehavior.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val NAME : String = "RepaintBehavior"

    def repaint(canvas : Canvas) : Unit = {
    }

    def onChangeRepaint(canvas : Canvas) : Unit = {
        val features : Features = Features.getInstance()
        val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
        if (features.isFeature(openGLFeatureFactory.OPENGL)) {
            DisplayInfoSingleton.getInstance().process()
        } else {
            val thread : Thread = new Thread(new RepaintRunnable(canvas), this.NAME)
            thread.start()
        }
    }

}

object RepaintBehavior {
    private val instance : RepaintBehavior = new RepaintBehavior()

    /**      * @return the instance      */
    def getInstance() : RepaintBehavior = {
        return RepaintBehavior.instance
    }

}


