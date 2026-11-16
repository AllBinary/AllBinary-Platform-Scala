/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.logic.ABSystemWrapper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

//AndroidMediaMIDPLibrary
class AllBinaryMediaManager private() {
    import _root_.org.allbinary.media.audio.AllBinaryMediaManager.{*}

}

object AllBinaryMediaManager {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val THIS : String = "AllBinaryMediaManagerAndroid"

    private var mostUsedTotal : Int = 0

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
        AllBinaryMediaManager.shutdown(soundsFactoryInterface)
        ProgressCanvasFactory.getInstance().addNormalPortion(50, "Media Manager")
        TsUtil.getInstance().gc()
        new Sounds(soundsFactoryInterface).init()
        logUtil.putF(commonString.END, AllBinaryMediaManager.THIS, commonString.INIT)
    }

    def shutdown(soundsFactoryInterface : SoundsFactoryInterface) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonString : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(commonString.START, AllBinaryMediaManager.THIS, "shutdown")
        if (soundsFactoryInterface.isInitialized()) {
            new Sounds(soundsFactoryInterface).stopAll()
            var soundInterfaceArray : Array[Sound] = soundsFactoryInterface.getSoundInterfaceArray()
            var player : Player = null
            var player2 : Player = null
            var androidMediaPlayerWrapper : AndroidMediaPlayerWrapper = null

            {
                var i : Int = 0
                while (i < soundInterfaceArray.length) {
                    if (soundInterfaceArray(i) != null) {
                        player = soundInterfaceArray(i).getPlayerP()
                        if (player != null) {
                            //{
                            player2 = (player.asInstanceOf[PlayerComposite]).getPlayerP()
                            if (player2.isInstanceOf[AndroidMediaPlayerWrapper]) {
                                androidMediaPlayerWrapper = player2.asInstanceOf[AndroidMediaPlayerWrapper]
                                MediaPlayerUtil.getInstance().waitForMediaPlayer(androidMediaPlayerWrapper.getMediaPlayer())
                            } else {
                                throw new Exception("Unknown Property Player: " + player.getClass().getName())
                            }
                        }
                    }
                    i += 1
                }
            }
            new Sounds(soundsFactoryInterface).closeAll()
            TsUtil.getInstance().gc()
            soundsFactoryInterface.setInitialized(false)
            AllBinaryMediaManager.mostUsedTotal = 0
        }
        logUtil.putF(commonString.START, AllBinaryMediaManager.THIS, "shutdown")
    }

    def createPlayer(resource : String) : Player = {
        AllBinaryMediaManager.mostUsedTotal += 1
        val logUtil : LogUtil = LogUtil.getInstance()
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().SOUND)) {
            try {
                return new AndroidMediaPlayerWrapper(resource)
            } catch {
                case e : Exception => {
                    logUtil.put(("Could not create AndroidMediaPlayerWrapper using NoPlayer at " + CommonLabels.getInstance().TOTAL_LABEL) + AllBinaryMediaManager.mostUsedTotal, AllBinaryMediaManager.THIS, "createPlayer", e)
                    return NoPlayer.NO_PLAYER
                }
            }
        } else {
            return NoPlayer.NO_PLAYER
        }
        throw new IllegalStateException()
    }

    def createPlayerFromInputStream(stream : InputStream, `type` : String) : Player = {
        // TWB not in Android .9
        throw new MediaException("No Input Stream Player")
    }

    def playTone(frequency : Int, time : Int, volume : Int) : Unit = this.synchronized {
        // TWB not in Android .9
        throw new MediaException("No Tone Player")
    }

    def isInitialized() : Boolean = {
        return true
    }

}


