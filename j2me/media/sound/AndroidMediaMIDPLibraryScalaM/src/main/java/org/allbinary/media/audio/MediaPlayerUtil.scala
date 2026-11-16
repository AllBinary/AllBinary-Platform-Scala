/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.android.media.MediaPlayer
import _root_.org.allbinary.logic.communication.log.LogUtil

class MediaPlayerUtil {
    import _root_.org.allbinary.media.audio.MediaPlayerUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def waitForMediaPlayer(mediaPlayer : MediaPlayer) : Unit = {
        val MESSAGE : String = "Not Stopped Waiting"
        val METHOD_NAME : String = "wait"
        var index : Int = 0

        {
            while (mediaPlayer.isPlaying() && (index < 50)) {
                this.logUtil.putF(MESSAGE, this, METHOD_NAME)
                Thread.sleep(100)
                index += 1
            }
        }
    }

}

object MediaPlayerUtil {
    private val instance : MediaPlayerUtil = new MediaPlayerUtil()

    def getInstance() : MediaPlayerUtil = {
        return MediaPlayerUtil.instance
    }

}


