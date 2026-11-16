/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Control
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player
import _root_.javax.microedition.media.PlayerListener
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

//BasicPlayerJavaLibrary
class BasicPlayer() extends Player with Controllable2 {
    import _root_.org.allbinary.media.audio.BasicPlayer.{*}

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val listenersList : BasicArrayList = new BasicArrayListD()

    //private TimeBase timeBase;
    var stateP : Int = 0

    var loopCountP : Int = 0

    //Constructor
    {
        this.setLoopCount(0)
        this.setState(Player.UNREALIZED)
    }

    override def getContentType() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def getControl(controlType : String) : Control = {
        return new NullControl()
    }

    override def getControls() : Array[Control] = {
        return new Array[Control](0)
    }

    override def close() : Unit = {
    }

    override def addPlayerListener(playerListener : PlayerListener) : Unit = this.synchronized {
        if (!this.listenersList.contains(playerListener)) {
            this.listenersList.add(playerListener)
        }
    }

    override def removePlayerListener(playerListener : PlayerListener) : Unit = {
        this.listenersList.remove(playerListener)
    }

    override def getState() : Int = {
        return this.stateP
    }

    def setState(state : Int) : Unit = this.synchronized {
        this.stateP = state
    }

    override def getDuration() : Long = {
        return 0
    }

    override def getMediaTime() : Long = {
        return 0
    }

    /*    public TimeBase getTimeBase()    {       return this.timeBase;    }        public synchronized void setTimeBase(TimeBase timeBase)    {       this.timeBase = timeBase;    }    */
    override def deallocate() : Unit = {
    }

    override def prefetch() : Unit = {
    }

    override def realize() : Unit = {
    }

    override def setLoopCount(count : Int) : Unit = this.synchronized {
        this.loopCountP = count
    }

    def getLoopCount() : Int = {
        return this.loopCountP
    }

    override def setMediaTime(now : Long) : Long = this.synchronized {
        return 0
    }

    override def start() : Unit = this.synchronized {
        this.setState(Player.STARTED)
    }

    override def stop() : Unit = this.synchronized {
        this.setState(Player.PREFETCHED)
    }

    override def setVolume(leftVolume : Int, rightVolume : Int) : Unit = {
    }

}

object BasicPlayer {
    var CONTROL_TYPE : String = "ToneControl"

}


