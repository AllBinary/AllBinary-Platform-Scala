/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player
import _root_.javax.microedition.media.PlayerListener
import _root_.android.media.MediaPlayer
import _root_.org.allbinary.android.NullAndroidCanvas
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class AndroidMediaPlayerWrapper(param_resource : String) extends BasicPlayer {
    import _root_.org.allbinary.media.audio.AndroidMediaPlayerWrapper.{NULL_ANDROID_MEDIA_PLAYER_WRAPPER as _, *}
    def NULL_ANDROID_MEDIA_PLAYER_WRAPPER : AndroidMediaPlayerWrapper = _root_.org.allbinary.media.audio.AndroidMediaPlayerWrapper.NULL_ANDROID_MEDIA_PLAYER_WRAPPER

    val logUtil : LogUtil = LogUtil.getInstance()

    private var mediaPlayer : MediaPlayer = NullAndroidCanvas.NULL_MEDIA_PLAYER

    //private AndroidMediaPlayerWrapperListener mediaPlayerHelper;
    //Constructor
    {
        val resource : String = param_resource
        try {
            //TWB - replace with MediaPlayer create method to remove if
            if (resource eq StringUtil.getInstance().EMPTY_STRING) {
            } else {
                val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
                val mediaPlayer : MediaPlayer = MediaPlayer.create(resourceUtil.getContext(), resourceUtil.getResourceId(resource).intValue())
                if (mediaPlayer == null) {
                    throw new Exception(new StringMaker().append("Failed to create media player for: ").append(resource).append(" with id: ").append(resourceUtil.getResourceId(resource).toString()).toString())
                }
                this.setMediaPlayer(mediaPlayer)
                this.mediaPlayer.setLooping(false)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION_LABEL + resource, this, this.commonStrings.CONSTRUCTOR, e)
                throw e
            }
        }
    }

    override def setLoopCount(count : Int) : Unit = {
        super.setLoopCount(count)
        if ((this.mediaPlayer ne NullAndroidCanvas.NULL_MEDIA_PLAYER) && (this.mediaPlayer != null)) {
            if (count == 0) {
                this.mediaPlayer.setLooping(false)
            } else {
            }
        }
    }

    override def addPlayerListener(playerListener : PlayerListener) : Unit = this.synchronized {
        //mediaPlayerHelper = new AndroidMediaPlayerWrapperListener(this, 1);
        super.addPlayerListener(playerListener)
    }

    override def removePlayerListener(playerListener : PlayerListener) : Unit = {
        super.removePlayerListener(playerListener)
    }

    override def getState() : Int = {
        if (this.mediaPlayer.isPlaying()) {
            return Player.STARTED
        } else {
            return Player.PREFETCHED
        }
        throw new IllegalStateException()
    }

    override def close() : Unit = {
        try {
            this.mediaPlayer.release()
            this.mediaPlayer = NullAndroidCanvas.NULL_MEDIA_PLAYER
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CLOSE, e)
            }
        }
    }

    override def start() : Unit = this.synchronized {
        try {
            // this.logUtil.putF(this.commonStrings.START, this, CommonStrings.getInstance());
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause()
                this.mediaPlayer.seekTo(0)
            }
            this.mediaPlayer.start()
            /*             this.mediaPlayer.setOnCompletionListener(                     new MediaPlayer.OnCompletionListener(){                         public void onCompletion(MediaPlayer mp)                         {                             this.logUtil.putF(this.commonStrings.START, this, "onComplete())");                             AndroidMediaPlayerWrapper.this.update(PlayerListener.END_OF_MEDIA);                         }                     });             */
            super.start()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.START_METHOD_NAME, e)
            }
        }
    }

    override def stop() : Unit = this.synchronized {
        try {
            this.mediaPlayer.stop()
            this.mediaPlayer.prepare()
            super.stop()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "stop", e)
            }
        }
    }

    def update(event : String) : Unit = {
        this.logUtil.putF("LineEvent: " + event, this, this.commonStrings.UPDATE)
        var size : Int = this.listenersList.size()

        {
            var index : Int = 0
            while (index < size) {
                var listener : PlayerListener = this.listenersList.objectArray(index).asInstanceOf[PlayerListener]
                listener.playerUpdate(this, event, NullUtil.getInstance().NULL_OBJECT)
                index += 1
            }
        }
    }

    override def setVolume(leftVolume : Int, rightVolume : Int) : Unit = {
        this.mediaPlayer.setVolume((leftVolume.toFloat) / 100.0f, (rightVolume.toFloat) / 100.0f)
    }

    override def getDuration() : Long = {
        return this.mediaPlayer.getDuration().toLong
    }

    def setMediaPlayer(mediaPlayer : MediaPlayer) : Unit = {
        this.mediaPlayer = mediaPlayer
    }

    def getMediaPlayer() : MediaPlayer = {
        return this.mediaPlayer
    }

}

object AndroidMediaPlayerWrapper {
    //implements LineListener
    def createPlayerWrapper() : AndroidMediaPlayerWrapper = {
        try {
            return new AndroidMediaPlayerWrapper(StringUtil.getInstance().EMPTY_STRING)
        } catch {
            case e : Exception => {
                throw new RuntimeException()
            }
        }
        throw new IllegalStateException()
    }

    val NULL_ANDROID_MEDIA_PLAYER_WRAPPER : AndroidMediaPlayerWrapper = AndroidMediaPlayerWrapper.createPlayerWrapper()

}


