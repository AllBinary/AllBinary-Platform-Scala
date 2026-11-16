/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.java.io.InputStream
import _root_.javax.microedition.media.Player
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

//NotDeviceSpecificNoMediaMIDP1Library
class AllBinaryMediaManager private() {
    import _root_.org.allbinary.media.audio.AllBinaryMediaManager.{*}

}

object AllBinaryMediaManager {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val THIS : String = "AllBinaryMediaManagerNoMediaMIDP1"

    /**      * @return the muted      */
    def isMuted() : Boolean = {
        return false
    }

    /**      * @param aMuted the muted to set      */
    def setMuted(aMuted : Boolean) : Unit = {
    }

    def update() : Boolean = {
        return true
    }

    def init(soundsFactoryInterface : SoundsFactoryInterface) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonString : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(commonString.START, AllBinaryMediaManager.THIS, commonString.INIT)
        ProgressCanvasFactory.getInstance().addNormalPortion(50, "Media Manager")
        new Sounds(soundsFactoryInterface).init()
    }

    def shutdown(soundsFactoryInterface : SoundsFactoryInterface) : Unit = {
        new Sounds(soundsFactoryInterface).stopAll()
        new Sounds(soundsFactoryInterface).closeAll()
        TsUtil.getInstance().gc()
    }

    def createPlayerFromInputStream(stream : InputStream, `type` : String) : Player = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonString : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(commonString.START, AllBinaryMediaManager.THIS, "creatPlayer(InputStream)")
        return NoPlayer.NO_PLAYER.asInstanceOf[Player]
    }

    def createPlayer(locator : String) : Player = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonString : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(commonString.START, AllBinaryMediaManager.THIS, "creatPlayer(locator)")
        return NoPlayer.NO_PLAYER.asInstanceOf[Player]
    }

    def playTone(frequency : Int, time : Int, volume : Int) : Unit = this.synchronized {
    }

    def getSupportedContentTypes(protocol : String) : Array[String] = {
        return StringUtil.getInstance().getArrayInstance()
    }

    def getSupportedProtocols(content_type : String) : Array[String] = {
        return StringUtil.getInstance().getArrayInstance()
    }

}


