/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Control
import _root_.javax.microedition.media.Controllable
import _root_.javax.microedition.media.Player
import _root_.javax.microedition.media.PlayerListener
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

//BasicPlayer
class PlayerComposite(param_player : Player, param_repeatTime : Int) extends Controllable with Player {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var player : Player = null

    private val timeElapsedHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    //Constructor
    {
        val player : Player = param_player
        val repeatTime : Int = param_repeatTime
        this.player = player
        this.timeElapsedHelper.delay = repeatTime
    }

    /*      * public PlayerComposite(Player player, long repeatTime) { this.player =      * player; this.repeatTime = repeatTime; timeElapsedHelper.setStartTime(); }      */
    override def addPlayerListener(playerListener : PlayerListener) : Unit = this.synchronized {
        this.player.addPlayerListener(playerListener)
    }

    override def removePlayerListener(playerListener : PlayerListener) : Unit = {
        this.player.removePlayerListener(playerListener)
    }

    override def close() : Unit = {
        this.player.close()
    }

    override def deallocate() : Unit = {
        this.player.deallocate()
    }

    override def getContentType() : String = {
        return this.player.getContentType()
    }

    override def getDuration() : Long = {
        return this.player.getDuration()
    }

    override def getMediaTime() : Long = {
        return this.player.getMediaTime()
    }

    /*    public TimeBase getTimeBase()    {       return this.player.getTimeBase();    }     public synchronized void setTimeBase(TimeBase timeBase)        throws MediaException    {       this.player.setTimeBase(timeBase);    }    */
    override def prefetch() : Unit = {
        try {
            this.player.prefetch()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "prefetch", e)
            }
        }
    }

    override def realize() : Unit = {
        try {
            this.player.realize()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "realize", e)
            }
        }
    }

    override def getState() : Int = {
        return this.player.getState()
    }

    override def setLoopCount(count : Int) : Unit = {
        this.player.setLoopCount(count)
    }

    override def setMediaTime(now : Long) : Long = {
        try {
            // this.logUtil.putF(this.commonStrings.START, this, this.commonStrings);
            return this.player.setMediaTime(now)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "setMediaTime", e)
                return -1
            }
        }
        throw new IllegalStateException()
    }

    override def start() : Unit = {
        try {
            // this.getMediaTime()
            if (this.timeElapsedHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
                this.player.start()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.START_METHOD_NAME, e)
            }
        }
    }

    override def stop() : Unit = {
        try {
            this.player.stop()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "stop", e)
            }
        }
    }

    override def getControl(controlType : String) : Control = {
        return this.player.getControl(controlType)
    }

    override def getControls() : Array[Control] = {
        throw new RuntimeException()
    }

    def setVolume(leftVolume : Int, rightVolume : Int) : Unit = {
        val controllable2 : Controllable2 = (this.player.asInstanceOf[Controllable2])
        controllable2.setVolume(leftVolume, rightVolume)
    }

    def getPlayerP() : Player = {
        return this.player
    }

}


