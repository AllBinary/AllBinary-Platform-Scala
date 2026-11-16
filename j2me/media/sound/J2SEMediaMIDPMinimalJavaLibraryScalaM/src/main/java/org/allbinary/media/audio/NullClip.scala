/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.java.io.IOException
import _root_.javax.sound.sampled.AudioFormat
import _root_.javax.sound.sampled.AudioInputStream
import _root_.javax.sound.sampled.BooleanControl
import _root_.javax.sound.sampled.Clip
import _root_.javax.sound.sampled.Control
import _root_.javax.sound.sampled.Control.Type
import _root_.javax.sound.sampled.Line.Info
import _root_.javax.sound.sampled.LineListener
import _root_.javax.sound.sampled.LineUnavailableException

/**  *  * @author User  */
class NullClip extends Clip {
    import _root_.org.allbinary.media.audio.NullClip.{NULL_CONTROL as _, *}
    def NULL_CONTROL : NullJ2SEControl = _root_.org.allbinary.media.audio.NullClip.NULL_CONTROL

    override def open(format : AudioFormat, data : Array[Byte], offset : Int, bufferSize : Int) : Unit = {
    }

    override def open(stream : AudioInputStream) : Unit = {
    }

    override def getFrameLength() : Int = {
        return 0
    }

    override def getMicrosecondLength() : Long = {
        return 0
    }

    override def setFramePosition(frames : Int) : Unit = {
    }

    override def setMicrosecondPosition(microseconds : Long) : Unit = {
    }

    override def setLoopPoints(start : Int, end : Int) : Unit = {
    }

    override def loop(count : Int) : Unit = {
    }

    override def drain() : Unit = {
    }

    override def flush() : Unit = {
    }

    override def start() : Unit = {
    }

    override def stop() : Unit = {
    }

    override def isRunning() : Boolean = {
        return false
    }

    override def isActive() : Boolean = {
        return false
    }

    override def getFormat() : AudioFormat = {
        return NullAudioFormat.NULL_AUDIO_FORMAT
    }

    override def getBufferSize() : Int = {
        return 0
    }

    override def available() : Int = {
        return 0
    }

    override def getFramePosition() : Int = {
        return 0
    }

    override def getLongFramePosition() : Long = {
        return 0L
    }

    override def getMicrosecondPosition() : Long = {
        return 0L
    }

    override def getLevel() : Float = {
        return 0.0f
    }

    override def getLineInfo() : Info = {
        return new Info(this.getClass(), NullAudioFormat.NULL_AUDIO_FORMAT)
    }

    override def open() : Unit = {
    }

    override def close() : Unit = {
    }

    override def isOpen() : Boolean = {
        return false
    }

    override def getControls() : Array[Control] = {
        return new Array[Control](0)
    }

    override def isControlSupported(control : Type) : Boolean = {
        return false
    }

    override def getControl(control : Type) : Control = {
        return NullClip.NULL_CONTROL
    }

    override def addLineListener(listener : LineListener) : Unit = {
    }

    override def removeLineListener(listener : LineListener) : Unit = {
    }

}

object NullClip {
    val NULL_CONTROL : NullJ2SEControl = new NullJ2SEControl(BooleanControl.Type.MUTE)

}


