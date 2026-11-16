/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.java.io.BufferedInputStream
import _root_.java.io.ByteArrayInputStream
import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.javax.microedition.media.Manager
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.audio.AudioContentTypeDataFactory
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

//J2SEMediaMIDPMinimalJavaLibrary
class AllBinaryMediaManager private() {
    import _root_.org.allbinary.media.audio.AllBinaryMediaManager.{*}

}

object AllBinaryMediaManager {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val THIS : String = "AllBinaryMediaManagerPC"

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

    private val CREATE_PLAYER : String = "createPlayer"

    def createPlayer(resource : String) : Player = {
        if (resource.startsWith(Manager.TONE_DEVICE_LOCATOR)) {
            return AllBinaryMediaManager.createPlayerFromInputStream(new ByteArrayInputStream(NullUtil.getInstance().NULL_BYTE_ARRAY), AudioContentTypeDataFactory.getInstance().MIME_AUDIO_TONE.getName())
        } else if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().SOUND)) {
            try {
                //logUtil.putF(resource, THIS, CREATE_PLAYER);
                val inputStream : InputStream = ResourceUtil.getInstance().getResourceAsStream(resource)
                val bufferedInputStream : BufferedInputStream = new BufferedInputStream(inputStream)
                return new PCClipWavPlayer(bufferedInputStream)
            } catch {
                case e : Exception => {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    val commonString : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonString.EXCEPTION, AllBinaryMediaManager.THIS, CREATE_PLAYER, e)
                    return NoPlayer.NO_PLAYER
                }
            }
        } else {
            return NoPlayer.NO_PLAYER
        }
        throw new IllegalStateException()
    }

    def createPlayerFromInputStream(stream : InputStream, `type` : String) : Player = {
        throw new MediaException("No Impl")
    }

    def playTone(frequency : Int, time : Int, volume : Int) : Unit = this.synchronized {
        throw new MediaException("No Impl")
    }

    def isInitialized() : Boolean = {
        return true
    }

}


