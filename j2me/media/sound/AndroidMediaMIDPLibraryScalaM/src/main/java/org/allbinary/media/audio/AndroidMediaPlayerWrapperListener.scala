/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.PlayerListener
import _root_.android.media.MediaPlayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

class AndroidMediaPlayerWrapperListener(param_androidMediaPlayerWrapper : AndroidMediaPlayerWrapper) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var androidMediaPlayerWrapper : AndroidMediaPlayerWrapper = AndroidMediaPlayerWrapper.NULL_ANDROID_MEDIA_PLAYER_WRAPPER

    private var mOnBufferingUpdateListener : MediaPlayer.OnBufferingUpdateListener = new AndroidMediaPlayerOnBufferingUpdateListener(this)

    private var mOnPreparedListener : MediaPlayer.OnPreparedListener = new AndroidMediaPlayerOnPreparedListener(this)

    private var mOnErrorListener : MediaPlayer.OnErrorListener = new AndroidMediaPlayerOnErrorListener(this)

    private var mOnCompletionListener : MediaPlayer.OnCompletionListener = new AndroidMediaPlayerOnCompletionListener(this)

    //    }
    //Constructor
    {
        val androidMediaPlayerWrapper : AndroidMediaPlayerWrapper = param_androidMediaPlayerWrapper
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
            this.androidMediaPlayerWrapper = androidMediaPlayerWrapper
            val mediaPlayer : MediaPlayer = androidMediaPlayerWrapper.getMediaPlayer()
            mediaPlayer.setOnCompletionListener(this.mOnCompletionListener)
            mediaPlayer.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener)
            mediaPlayer.setOnPreparedListener(this.mOnPreparedListener)
            mediaPlayer.setOnErrorListener(this.mOnErrorListener)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    class MediaPlayerOnBufferingUpdateListener extends MediaPlayer.OnBufferingUpdateListener {

        override def onBufferingUpdate(mediaPlayer : MediaPlayer, i : Int) : Unit = {
        }

    }

    class MediaPlayerOnPreparedListener extends MediaPlayer.OnPreparedListener {

        override def onPrepared(mp : MediaPlayer) : Unit = {
        }

    }

    class MediaPlayerOnErrorListener extends MediaPlayer.OnErrorListener {

        override def onError(mp : MediaPlayer, what : Int, extra : Int) : Boolean = {
            return false
        }

    }

    class MediaPlayerOnCompletionListener extends MediaPlayer.OnCompletionListener {

        override def onCompletion(mp : MediaPlayer) : Unit = {
        }

    }

    class AndroidMediaPlayerOnBufferingUpdateListener(param_androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener) extends MediaPlayerOnBufferingUpdateListener {

        private[AndroidMediaPlayerOnBufferingUpdateListener] val ON_BUFFERING_UPDATE : String = "onBufferingUpdate()"

        private[AndroidMediaPlayerOnBufferingUpdateListener] var androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = null

        //Constructor
        {
            val androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = param_androidMediaPlayerWrapperListener
            this.androidMediaPlayerWrapperListener = androidMediaPlayerWrapperListener
        }

        override def onBufferingUpdate(mediaPlayer : MediaPlayer, i : Int) : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            logUtil.putF(new StringMaker().append("Update buffer: ").appendint(i).append("%").toString(), this, this.ON_BUFFERING_UPDATE)
            this.androidMediaPlayerWrapperListener.androidMediaPlayerWrapper.update(PlayerListener.DEVICE_UNAVAILABLE)
        }

    }

    class AndroidMediaPlayerOnPreparedListener(param_androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener) extends MediaPlayerOnPreparedListener {

        private[AndroidMediaPlayerOnPreparedListener] val ON_PREPARE : String = "onPrepare()"

        private[AndroidMediaPlayerOnPreparedListener] var androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = null

        //Constructor
        {
            val androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = param_androidMediaPlayerWrapperListener
            this.androidMediaPlayerWrapperListener = androidMediaPlayerWrapperListener
        }

        override def onPrepared(mp : MediaPlayer) : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            logUtil.putF(commonStrings.START, this, this.ON_PREPARE)
            this.androidMediaPlayerWrapperListener.androidMediaPlayerWrapper.update(PlayerListener.DEVICE_AVAILABLE)
        }

    }

    class AndroidMediaPlayerOnErrorListener(param_androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener) extends MediaPlayerOnErrorListener {

        private[AndroidMediaPlayerOnErrorListener] val ON_ERROR : String = "onError()"

        private[AndroidMediaPlayerOnErrorListener] var androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = null

        //Constructor
        {
            val androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = param_androidMediaPlayerWrapperListener
            this.androidMediaPlayerWrapperListener = androidMediaPlayerWrapperListener
        }

        override def onError(mp : MediaPlayer, what : Int, extra : Int) : Boolean = {
            val logUtil : LogUtil = LogUtil.getInstance()
            logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append("What: ").appendint(what).append(" Extra: ").appendint(extra).toString(), this, this.ON_ERROR)
            this.androidMediaPlayerWrapperListener.androidMediaPlayerWrapper.update(PlayerListener.ERROR)
            return true
        }

    }

    class AndroidMediaPlayerOnCompletionListener(param_androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener) extends MediaPlayerOnCompletionListener {

        private[AndroidMediaPlayerOnCompletionListener] val ON_COMPLETE : String = "onComplete()"

        private[AndroidMediaPlayerOnCompletionListener] var androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = null

        //Constructor
        {
            val androidMediaPlayerWrapperListener : AndroidMediaPlayerWrapperListener = param_androidMediaPlayerWrapperListener
            this.androidMediaPlayerWrapperListener = androidMediaPlayerWrapperListener
        }

        override def onCompletion(mp : MediaPlayer) : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            logUtil.putF(commonStrings.START, this, this.ON_COMPLETE)
            this.androidMediaPlayerWrapperListener.androidMediaPlayerWrapper.update(PlayerListener.END_OF_MEDIA)
        }

    }

}


