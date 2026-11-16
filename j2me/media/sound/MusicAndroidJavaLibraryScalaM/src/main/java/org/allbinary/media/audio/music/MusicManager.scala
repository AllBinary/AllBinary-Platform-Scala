/* Generated Code Do Not Modify */
package org.allbinary.media.audio.music

import _root_.android.app.Activity
import _root_.android.content.Context
import _root_.android.content.Intent
import _root_.org.allbinary.android.AndroidServicesUtil
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.audio.NoSound
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.string.CommonStateStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

class MusicManager(param_musicServiceClass : Class[?], param_songList : BasicArrayList) {
    import _root_.org.allbinary.media.audio.music.MusicManager.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val PLAY : String = "Play "

    private val FOR : String = " for: "

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val musicStrings : MusicStrings = MusicStrings.getInstance()

    private val commonStateStrings : CommonStateStrings = CommonStateStrings.getInstance()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    private val resourceUtil : ResourceUtil = ResourceUtil.getInstance()

    private val androidServicesUtil : AndroidServicesUtil = AndroidServicesUtil.getInstance()

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private val timeDelayHelper2 : TimeDelayHelper = new TimeDelayHelper(1200)

    //private final String NEXT_SONG = "nextSong - this does not change the MusicService";
    private var songList : BasicArrayList = null

    private var currentSongSound : Sound = NoSound.getInstance()

    private var nextSongSound : Sound = NoSound.getInstance()

    private var leftVolume : Int = 100

    private var rightVolume : Int = 100

    //MusicService.class
    private var musicServiceClass : Class[?] = null

    private var currentIntent : Intent = null

    //Constructor
    {
        val musicServiceClass : Class[?] = param_musicServiceClass
        val songList : BasicArrayList = param_songList
        PreLogUtil.put(this.commonStateStrings.CONTEXT + this.resourceUtil.getContext(), this, this.commonStrings.CONSTRUCTOR)
        this.musicServiceClass = musicServiceClass
        this.currentIntent = new Intent(this.resourceUtil.getContext(), musicServiceClass)
        this.songList = songList
    }

    def nextSong(param_nextSongSound : Sound, leftVolume : Int, rightVolume : Int) : Unit = {
        var nextSongSound : Sound = param_nextSongSound
        //PreLogUtil.put(NEXT_SONG, this, this.commonStrings.PROCESS);
        if (nextSongSound == null) {
            nextSongSound = NoSound.getInstance()
        }
        this.nextSongSound = nextSongSound
        this.leftVolume = leftVolume
        this.rightVolume = rightVolume
        this.reset()
    }

    def reset() : Unit = {
        this.timeDelayHelper.delay = 0
    }

    def process() : Unit = {
        if (this.songList.size() == 0) {
            return
        }
        if (this.timeDelayHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
            this.startNewSong()
            return
        }
        if (this.timeDelayHelper2.isTime(this.gameTickTimeDelayHelper.startTime)) {
            if (this.androidServicesUtil.isServiceRunning(this.musicServiceClass.getName())) {
            } else {
                this.startNewSong()
            }
        }
    }

    def show() : Unit = {

        {
            var index : Int = this.songList.size()
            while ({ index -= 1; index } >= 0) {
                val sound : Sound = this.songList.get(index).asInstanceOf[Sound]
                val duration : Long = sound.getDuration().toLong
                PreLogUtil.put(new StringMaker().append(this.PLAY).append(sound.getResource()).append(this.FOR).appendlong(duration).toString(), this, this.commonStrings.PROCESS)
            }
        }
    }

    def startNewSong() : Unit = {
        try {
            //PreLogUtil.put(Memory.getInfo(), this, this.commonStrings.PROCESS);
            this.resourceUtil.getContext().stopService(this.currentIntent)
            if (this.nextSongSound eq NoSound.getInstance()) {
                this.currentSongSound = this.basicArrayListUtil.getRandom(this.songList).asInstanceOf[Sound]
            } else {
                this.currentSongSound = this.nextSongSound
                this.nextSongSound = NoSound.getInstance()
            }
            val duration : Long = this.currentSongSound.getDuration().toLong
            //18000;
            PreLogUtil.put(new StringMaker().append(this.PLAY).append(this.currentSongSound.getResource()).append(this.FOR).appendlong(duration).toString(), this, this.commonStrings.PROCESS)
            this.timeDelayHelper.delay = duration.toInt
            this.currentIntent.putExtra(this.musicStrings.SONG_EXTRA, this.resourceUtil.getResourceId(this.currentSongSound.getResource()).intValue())
            this.currentIntent.putExtra(this.musicStrings.LEFT_VOLUME, this.leftVolume)
            this.currentIntent.putExtra(this.musicStrings.RIGHT_VOLUME, this.rightVolume)
            //PreLogUtil.put("startNewSong - Start MusicService", this, this.commonStrings.PROCESS);
            this.resourceUtil.getContext().startService(this.currentIntent)
        } catch {
            case e : Exception => {
                var resource : String = StringUtil.getInstance().EMPTY_STRING
                if (this.currentSongSound != null) {
                    resource = this.currentSongSound.getResource()
                }
                PreLogUtil.putOE(this.commonStrings.EXCEPTION_LABEL + resource, this, this.commonStrings.PROCESS, e)
            }
        }
    }

    def stop() : Unit = {
        //PreLogUtil.put(STOP_MUSIC_SERVICE, this, this.commonStrings.PROCESS);
        this.resourceUtil.getContext().stopService(this.currentIntent)
    }

}

object MusicManager {
    def pause(activity : Activity, musicServiceClass : Class[?]) : Unit = {
        val commonStateStrings : CommonStateStrings = CommonStateStrings.getInstance()
        val musicPauseIntent : Intent = new Intent(activity.asInstanceOf[Context], musicServiceClass)
        musicPauseIntent.putExtra(commonStateStrings.ON_START_COMMAND, 1)
        activity.startService(musicPauseIntent)
    }

    def resume(activity : Activity, musicServiceClass : Class[?]) : Unit = {
        if (AndroidServicesUtil.getInstance().isServiceRunning(musicServiceClass.getName())) {
            val commonStateStrings : CommonStateStrings = CommonStateStrings.getInstance()
            val musicResumeIntent : Intent = new Intent(activity, musicServiceClass)
            musicResumeIntent.putExtra(commonStateStrings.ON_START_COMMAND, 2)
            activity.startService(musicResumeIntent)
        }
    }

}


