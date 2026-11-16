/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Control
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player
import _root_.javax.microedition.media.PlayerListener
import _root_.javax.microedition.media.TimeBase
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

//BasicPlayerMIDP2JavaLibrary
class BasicPlayer() extends Player with TimeBaseInterface with Controllable2 {
    import _root_.org.allbinary.media.audio.BasicPlayer.{*}

    val listenersList : BasicArrayList = new BasicArrayListD()

    private var timeBase : TimeBase = null

    var stateP : Int = 0

    var loopCountP : Int = 0

    //Constructor
    {
        this.setLoopCount(0)
        this.setState(Player.UNREALIZED)
    }

    def getContentType() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def getControl(controlType : String) : Control = {
        return new NullControl()
    }

    def getControls() : Array[Control] = {
        return new Array[Control](0)
    }

    def close() : Unit = {
    }

    def addPlayerListener(playerListener : PlayerListener) : Unit = this.synchronized {
        if (!this.listenersList.contains(playerListener)) {
            this.listenersList.add(playerListener)
        }
    }

    def removePlayerListener(playerListener : PlayerListener) : Unit = {
        this.listenersList.remove(playerListener)
    }

    def getState() : Int = {
        return this.stateP
    }

    def setState(state : Int) : Unit = this.synchronized {
        this.stateP = state
    }

    def getDuration() : Long = {
        return 0
    }

    def getMediaTime() : Long = {
        return 0
    }

    def getTimeBase() : TimeBase = {
        return this.timeBase
    }

    def setTimeBase(timeBase : TimeBase) : Unit = this.synchronized {
        this.timeBase = timeBase
    }

    def deallocate() : Unit = {
    }

    def prefetch() : Unit = {
    }

    def realize() : Unit = {
    }

    def setLoopCount(count : Int) : Unit = this.synchronized {
        this.loopCountP = count
    }

    def getLoopCount() : Int = {
        return this.loopCountP
    }

    def setMediaTime(now : Long) : Long = this.synchronized {
        return 0
    }

    def start() : Unit = this.synchronized {
        this.setState(Player.STARTED)
    }

    def stop() : Unit = this.synchronized {
        this.setState(Player.PREFETCHED)
    }

    def setVolume(leftVolume : Int, rightVolume : Int) : Unit = {
    }

}

object BasicPlayer {
    var CONTROL_TYPE : String = "ToneControl"

}


