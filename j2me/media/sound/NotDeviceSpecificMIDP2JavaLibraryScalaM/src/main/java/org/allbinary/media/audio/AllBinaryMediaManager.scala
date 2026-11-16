/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.java.io.InputStream
import _root_.javax.microedition.media.Manager
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player
import _root_.org.allbinary.MIDPUtil
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.audio.AudioContentTypeDataFactory
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

//NotDeviceSpecificMIDP2JavaLibrary
class AllBinaryMediaManager private() {
    import _root_.org.allbinary.media.audio.AllBinaryMediaManager.{*}

}

object AllBinaryMediaManager {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val THIS : String = "AllBinaryMediaManagerNoMIPD2"

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

    def createPlayer(resource : String) : Player = {
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().SOUND)) {
            if (TsUtil.getInstance().compareTo(resource, Manager.TONE_DEVICE_LOCATOR) == 0) {
                return Manager.createPlayer(resource)
            } else {
                var inputStream : InputStream = ResourceUtil.getInstance().getResourceAsStream(resource)
                return MIDPUtil.getInstance().createPlayerFromInputStream(inputStream, AudioContentTypeDataFactory.getInstance().MIME_AUDIO_WAV.getName())
            }
        } else {
            return NoPlayer.NO_PLAYER
        }
        throw new IllegalStateException()
    }

    def playTone(frequency : Int, time : Int, volume : Int) : Unit = this.synchronized {
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().SOUND)) {
            Manager.playTone(frequency, time, volume)
        }
    }

}


