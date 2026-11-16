/* Generated Code Do Not Modify */
package org.allbinary.media.audio.music

import _root_.android.app.Service
import _root_.android.content.Intent
import _root_.android.media.MediaPlayer
import _root_.android.os.IBinder
import _root_.org.allbinary.android.NullAndroidCanvas
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStateStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.ARunnable

class BaseMusicService extends Service {
    import _root_.org.allbinary.media.audio.music.BaseMusicService.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val commonStateStrings : CommonStateStrings = CommonStateStrings.getInstance()

    private val ALREADY_PLAYING : String = "This is one song per music service"

    private val WAITING_FOR_MUSIC_TO_END : String = "Waiting for music to end"

    private var player : MediaPlayer = NullAndroidCanvas.NULL_MEDIA_PLAYER

    private var songId : Int = -1

    private var leftVolume : Int = -1

    private var rightVolume : Int = -1

    override def onBind(intent : Intent) : IBinder = {
        //PrelogUtil.putF(this.commonStrings.START, this, "onBind");
        this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.BIND)
        //songId = intent.getIntExtra("SONG", AndroidResources.raw.angels_we_have_heard);
        return null
    }

    override def onCreate() : Unit = {
        //Toast.makeText(this, "Music Service Created", Toast.LENGTH_LONG).show();
        this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.CREATE)
    }

    override def onDestroy() : Unit = {
        //Toast.makeText(this, "Music Service Stopped", Toast.LENGTH_LONG).show();
        this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.DESTROY)
        //PrelogUtil.putF(this.commonStrings.START, this, "onDestroy");
        if (this.player ne NullAndroidCanvas.NULL_MEDIA_PLAYER) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.PAUSE)
            this.player.stop()
            this.player.reset()
            this.player.release()
        }
    }

    def pause() : Unit = {
        if (this.player ne NullAndroidCanvas.NULL_MEDIA_PLAYER) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.PAUSE)
            this.player.pause()
        }
    }

    def resume() : Unit = {
        if ((this.player ne NullAndroidCanvas.NULL_MEDIA_PLAYER) && !this.player.isPlaying()) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.RESUME)
            this.player.start()
        }
    }

    def start() : Unit = {
        this.player = MediaPlayer.create(this, this.songId)
        this.player.setVolume((this.leftVolume.toFloat) / 100.0f, (this.rightVolume.toFloat) / 100.0f)
        this.player.setLooping(false)
        this.player.start()
    }

    override def onStart(intent : Intent, startid : Int) : Unit = {
        //Toast.makeText(this, "Music Service Started", Toast.LENGTH_LONG).show();
        this.onStartCommandIntent(intent)
        //PrelogUtil.putF(this.commonStrings.START, this, "onStart");
        this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.START)
    }

    override def onStartCommand(intent : Intent, flags : Int, startId : Int) : Int = {
        this.onStartCommandIntent(intent)
        return Service.START_STICKY
    }

    def onStartCommandIntent(intent : Intent) : Unit = {
        //PrelogUtil.putF(this.commonStrings.START, this, "onStartCommand");
        this.logUtil.putF(this.commonStrings.START, this, this.commonStateStrings.ON_START_COMMAND)
        val musicStrings : MusicStrings = MusicStrings.getInstance()
        if (intent != null) {
            val command : Int = intent.getIntExtra(this.commonStateStrings.ON_START_COMMAND, -1)
            this.logUtil.putF(CommonLabels.getInstance().COMMAND_LABEL + command, this, this.commonStateStrings.ON_START_COMMAND)
            if (command == 1) {
                this.pause()
                return
            } else if (command == 2) {
                this.resume()
                return
            } else {
                this.songId = intent.getIntExtra(musicStrings.SONG_EXTRA, -1)
                this.leftVolume = intent.getIntExtra(musicStrings.LEFT_VOLUME, -1)
                this.rightVolume = intent.getIntExtra(musicStrings.RIGHT_VOLUME, -1)
            }
        } else {
            throw new RuntimeException("Started service without intent")
        }
        if (this.songId != -1) {
            System.gc()
            if ((this.player ne NullAndroidCanvas.NULL_MEDIA_PLAYER) && this.player.isPlaying()) {
                val player : MediaPlayer = this.player
                this.logUtil.putF(this.ALREADY_PLAYING, this, this.commonStateStrings.ON_START_COMMAND)
                val runnable : Runnable = new MusicRunnable(this, player, intent)
                val thread : Thread = new Thread(runnable)
                thread.start()
                return
            }
            this.start()
        }
    }

}

object BaseMusicService {
    //A member class instead of a local class using the method's player and intent since most of the converted languages do not have local classes.
    class MusicRunnable(param_baseMusicService : BaseMusicService, param_player : MediaPlayer, param_intent : Intent) extends ARunnable {

        private[MusicRunnable] var baseMusicService : BaseMusicService = null

        private[MusicRunnable] var player : MediaPlayer = null

        private[MusicRunnable] var intent : Intent = null

        //Constructor
        {
            val baseMusicService : BaseMusicService = param_baseMusicService
            val player : MediaPlayer = param_player
            val intent : Intent = param_intent
            this.baseMusicService = baseMusicService
            this.player = player
            this.intent = intent
        }

        override def run() : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            val commonStateStrings : CommonStateStrings = CommonStateStrings.getInstance()
            try {

                {
                    while (this.player.isPlaying()) {
                        logUtil.putF(this.baseMusicService.WAITING_FOR_MUSIC_TO_END, this, commonStateStrings.ON_START_COMMAND)
                        Thread.sleep(1200)
                    }
                }
                this.baseMusicService.onStartCommandIntent(this.intent)
            } catch {
                case e : Exception => {
                    logUtil.put(commonStrings.EXCEPTION, this, commonStateStrings.ON_START_COMMAND, e)
                }
            }
        }

    }

}


