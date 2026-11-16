/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Control
import _root_.javax.microedition.media.Controllable
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player
import _root_.javax.microedition.media.PlayerListener
import _root_.javax.microedition.media.TimeBase
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

//BasicPlayerMIDP2
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
    def addPlayerListener(playerListener : PlayerListener) : Unit = this.synchronized {
        this.player.addPlayerListener(playerListener)
    }

    def removePlayerListener(playerListener : PlayerListener) : Unit = {
        this.player.removePlayerListener(playerListener)
    }

    def close() : Unit = {
        this.player.close()
    }

    def deallocate() : Unit = {
        this.player.deallocate()
    }

    def getContentType() : String = {
        return this.player.getContentType()
    }

    def getDuration() : Long = {
        return this.player.getDuration()
    }

    def getMediaTime() : Long = {
        return this.player.getMediaTime()
    }

    def getTimeBase() : TimeBase = {
        return (this.player.asInstanceOf[TimeBaseInterface]).getTimeBase()
    }

    def setTimeBase(timeBase : TimeBase) : Unit = this.synchronized {
        (this.player.asInstanceOf[TimeBaseInterface]).setTimeBase(timeBase)
    }

    def prefetch() : Unit = {
        try {
            this.player.prefetch()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "prefetch", e)
            }
        }
    }

    def realize() : Unit = {
        try {
            this.player.realize()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "realize", e)
            }
        }
    }

    def getState() : Int = {
        return this.player.getState()
    }

    def setLoopCount(count : Int) : Unit = {
        this.player.setLoopCount(count)
    }

    def setMediaTime(now : Long) : Long = {
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

    def start() : Unit = {
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

    def stop() : Unit = {
        try {
            this.player.stop()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "stop", e)
            }
        }
    }

    def getControl(controlType : String) : Control = {
        return this.player.getControl(controlType)
    }

    def getControls() : Array[Control] = {
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


