/* Generated Code Do Not Modify */
package org.allbinary.media.audio.music

import _root_.org.allbinary.thread.ARunnable
import _root_.javax.microedition.media.Player
import _root_.javax.microedition.media.PlayerListener
import _root_.org.allbinary.AvianUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.audio.NoSound
import _root_.org.allbinary.media.audio.PlayerStateUtil
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

class MusicManager(param_musicServiceClass : Class[?], param_songList : BasicArrayList) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    private val playerStateUtil : PlayerStateUtil = PlayerStateUtil.getInstance()

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private val playerListener : PlayerListener = new MusicManagerPlayerListener(this)

    private val PLAY : String = "Play "

    private val SONG : String = " for: "

    private val NEXT_SONG : String = CommonLabels.getInstance().NEXT + " Song: "

    private val STOPPING : String = "Stopping Current Song: "

    private val ENDING : String = "Ending Current Song: "

    private val WAITING_FOR_MEDIA_TO_END : String = "Waiting for media to end"

    private val ALREADY_PLAYING : String = "Already Playing: "

    private val ALREADY_ENDED : String = "Last Song already ended: "

    private var songList : BasicArrayList = null

    private var currentSongSound : Sound = NoSound.getInstance()

    private var nextSongSound : Sound = NoSound.getInstance()

    private var reset_MusicManager : Boolean = false

    private var noDuration : Boolean = false

    private var stopped : Boolean = true

    //Constructor
    {
        val musicServiceClass : Class[?] = param_musicServiceClass
        val songList : BasicArrayList = param_songList
        this.songList = songList
    }

    //Handle Media ending for Avian
    class MusicManagerPlayerListener(param_musicManager : MusicManager) extends PlayerListener {

        private[MusicManagerPlayerListener] var musicManager : MusicManager = null

        //Constructor
        {
            val musicManager : MusicManager = param_musicManager
            this.musicManager = musicManager
        }

        override def playerUpdate(player : Player, event : String, eventData : Object) : Unit = {
            PreLogUtil.put(event, this, this.musicManager.commonStrings.PROCESS)
            if (((event eq PlayerListener.END_OF_MEDIA) || (event eq PlayerListener.STOPPED)) || (event eq PlayerListener.CLOSED)) {
                this.musicManager.reset()
            }
        }

    }

    def startNewSong() : Unit = {
        //PreLogUtil.put("startNewSong - Stop MusicService", this, this.commonStrings.PROCESS);
        if (this.nextSongSound eq NoSound.getInstance()) {
            val randomSongSound : Sound = this.basicArrayListUtil.getRandom(this.songList).asInstanceOf[Sound]
            this.nextSong(randomSongSound, 0, 0)
        }
        this.process()
    }

    def nextSong(nextSongSound : Sound, leftVolume : Int, rightVolume : Int) : Unit = {
        PreLogUtil.put(new StringMaker().append(NEXT_SONG).append(nextSongSound.getResource()).toString(), this, this.commonStrings.PROCESS)
        this.nextSongSound = nextSongSound
        this.reset()
        this.stopped = false
    }

    def reset() : Unit = {
        this.reset_MusicManager = true
    }

    def process() : Unit = {
        try {
            if (this.stopped) {
                return
            }
            if (this.songList.size() == 0) {
                return
            }
            if ((this.timeDelayHelper.isTime(this.gameTickTimeDelayHelper.startTime) && !this.noDuration) || this.reset_MusicManager) {
                this.reset_MusicManager = false
                this.noDuration = false
                val endingCurrentSongSound : Sound = this.currentSongSound
                val nextSongSound : Sound = this.nextSongSound
                this.nextSongSound = NoSound.getInstance()
                if (nextSongSound eq NoSound.getInstance()) {
                    this.currentSongSound = BasicArrayListUtil.getInstance().getRandom(this.songList).asInstanceOf[Sound]
                } else {
                    this.currentSongSound = nextSongSound
                }
                val startingCurrentSongSound : Sound = this.currentSongSound
                //this.currentSongSound.init();
                val duration : Long = this.currentSongSound.getDuration().toLong
                this.timeDelayHelper.delay = duration.toInt
                if (duration <= 0) {
                    //Handle HTML5 duration with media not playing
                    val NO_DURATION_FOR : String = "No Duration for: "
                    //PreLogUtil.put(new StringMaker().append("nextSongSound duration: ").append(nextSongSound.getDuration()).toString(), this, this.commonStrings.PROCESS);
                    PreLogUtil.put(new StringMaker().append(NO_DURATION_FOR).append(this.currentSongSound.getResource()).toString(), this, this.commonStrings.PROCESS)
                    this.currentSongSound.getPlayerP().addPlayerListener(playerListener)
                    this.noDuration = true
                }
                if (endingCurrentSongSound ne NoSound.getInstance()) {
                    //                            try {
                    if ((endingCurrentSongSound eq startingCurrentSongSound) && (endingCurrentSongSound.getPlayerP().getState() == Player.STARTED)) {
                        PreLogUtil.put(new StringMaker().append(this.ALREADY_PLAYING).append(endingCurrentSongSound.getResource()).toString(), this, this.commonStrings.PROCESS)
                        //this.addPlayNextOnEnd(endingCurrentSongSound, startingCurrentSongSound);
                        PreLogUtil.put(new StringMaker().append(this.STOPPING).append(endingCurrentSongSound.getResource()).append(this.SONG).appendlong(duration).toString(), this, this.commonStrings.PROCESS)
                        endingCurrentSongSound.getPlayerP().stop()
                        //currentSongSound.getPlayerP().close();
                        this.waitForStateChange(endingCurrentSongSound, startingCurrentSongSound)
                    } else {
                        if (endingCurrentSongSound.getPlayerP().getState() == Player.STARTED) {
                            PreLogUtil.put(new StringMaker().append(this.STOPPING).append(endingCurrentSongSound.getResource()).append(this.SONG).appendlong(duration).toString(), this, this.commonStrings.PROCESS)
                            //this.addPlayNextOnEnd(endingCurrentSongSound, startingCurrentSongSound);
                            endingCurrentSongSound.getPlayerP().stop()
                            this.waitForStateChange(endingCurrentSongSound, startingCurrentSongSound)
                        } else {
                            PreLogUtil.put(new StringMaker().append(this.ALREADY_ENDED).append(this.PLAY).append(startingCurrentSongSound.getResource()).toString(), this, this.commonStrings.PROCESS)
                            if (AvianUtil.isAvian()) {
                                endingCurrentSongSound.getPlayerP().stop()
                                startingCurrentSongSound.getPlayerP().stop()
                            }
                            startingCurrentSongSound.getPlayerP().start()
                        }
                    }
                } else {
                    PreLogUtil.put(new StringMaker().append(this.PLAY).append(this.currentSongSound.getResource()).append(this.SONG).appendlong(duration).toString(), this, this.commonStrings.PROCESS)
                    //MusicThreadPool.getInstance().runTask(this.currentSongSound);
                    this.currentSongSound.getPlayerP().start()
                }
            }
        } catch {
            case e : Exception => {
                var resource : String = StringUtil.getInstance().EMPTY_STRING
                if (this.currentSongSound ne NoSound.getInstance()) {
                    resource = this.currentSongSound.getResource()
                }
                PreLogUtil.putOE(this.commonStrings.EXCEPTION_LABEL + resource, this, this.commonStrings.PROCESS, e)
            }
        }
    }

    //    }
    private def waitForStateChange(endingCurrentSongSound : Sound, startingCurrentSongSound : Sound) : Unit = {

        {
            while (endingCurrentSongSound.getPlayerP().getState() == Player.STARTED) {
                PreLogUtil.put(this.WAITING_FOR_MEDIA_TO_END, this, this.commonStrings.PROCESS)
                Thread.sleep(100)
            }
        }
        PreLogUtil.put(new StringMaker().append(this.playerStateUtil.convert(endingCurrentSongSound.getPlayerP().getState())).append(this.commonSeps.SPACE).append(this.PLAY).append(startingCurrentSongSound.getResource()).toString(), this, this.commonStrings.PROCESS)
        startingCurrentSongSound.getPlayerP().start()
    }

    def stop() : Unit = {
        try {
            val currentSongSound : Sound = this.currentSongSound
            if (currentSongSound ne NoSound.getInstance()) {
                this.stopped = true
                //                        try {
                PreLogUtil.put(new StringMaker().append(this.ENDING).append(currentSongSound.getResource()).toString(), this, this.commonStrings.PROCESS)
                currentSongSound.getPlayerP().stop()
            }
            this.timeDelayHelper.setStartTime(0)
            PreLogUtil.put(new StringMaker().append(this.commonStrings.END).append(StringUtil.getInstance().toString(currentSongSound)).toString(), this, this.commonStrings.END)
        } catch {
            case e : Exception => {
                var resource : String = StringUtil.getInstance().EMPTY_STRING
                if (currentSongSound ne NoSound.getInstance()) {
                    resource = currentSongSound.getResource()
                }
                PreLogUtil.putOE(this.commonStrings.EXCEPTION_LABEL + resource, this, this.commonStrings.END, e)
            }
        }
    }

}


