/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.org.allbinary.thread.ARunnable
import _root_.java.io.ByteArrayInputStream
import _root_.java.io.InputStream
import _root_.javax.microedition.media.Control
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.PlayerListener
import _root_.javax.sound.sampled.AudioInputStream
import _root_.javax.sound.sampled.AudioSystem
import _root_.javax.sound.sampled.Clip
import _root_.javax.sound.sampled.FloatControl
import _root_.javax.sound.sampled.LineEvent
import _root_.javax.sound.sampled.LineListener
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.thread.MusicThreadPool

class PCClipWavPlayer(param_inputStream : InputStream) extends BasicPlayer with LineListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var audioInputStream : AudioInputStream = null

    private var clip : Clip = null

    //Constructor
    {
        val inputStream : InputStream = param_inputStream
        var audioInputStream : AudioInputStream = new AudioInputStream(new ByteArrayInputStream(NullUtil.getInstance().NULL_BYTE_ARRAY), NullAudioFormat.NULL_AUDIO_FORMAT, 0)
        var clip : Clip = new NullClip()
        try {
            audioInputStream = AudioSystem.getAudioInputStream(inputStream)
            clip = this.create(audioInputStream)
            if (clip == null) {
                this.logUtil.put("Clip was null", this, this.commonStrings.CONSTRUCTOR, new Exception())
                throw new RuntimeException()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
        this.audioInputStream = audioInputStream
        this.clip = clip
    }

    override def close() : Unit = {
        MusicThreadPool.getInstance().runTask(new ARunnable {
                override def run() : Unit = {
                    try {
                        close2()
                    } catch {
                        case e : Exception => {
                            PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.PROCESS, e)
                        }
                    }
                }

            })
    }

    private def close2() : Unit = {
        this.clip.drain()
        this.clip.flush()
        this.clip.close()
    }

    override def getContentType() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def start() : Unit = this.synchronized {
        MusicThreadPool.getInstance().runTask(new ARunnable {
                override def run() : Unit = {
                    try {
                        start2()
                    } catch {
                        case e : Exception => {
                            PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.PROCESS, e)
                        }
                    }
                }

            })
    }

    private def start2() : Unit = {
        this.clip.setFramePosition(0)
        this.clip.loop(this.getLoopCount())
        this.clip.start()
        super.start()
    }

    final private def create(audioInputStream : AudioInputStream) : Clip = {
        val clip : Clip = AudioSystem.getClip()
        clip.addLineListener(this)
        clip.open(audioInputStream)
        //PrelogUtil.putF(clip.getFormat().toString(), this, commonStrings.PROCESS);
        return clip
    }

    override def stop() : Unit = this.synchronized {
        MusicThreadPool.getInstance().runTask(new ARunnable {
                override def run() : Unit = {
                    try {
                        stop2()
                    } catch {
                        case e : Exception => {
                            PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.PROCESS, e)
                        }
                    }
                }

            })
    }

    private def stop2() : Unit = {
        //clip.drain();
        this.clip.stop()
        ////clip.close();
        super.stop()
    }

    override def getControl(controlType : String) : Control = {
        return new NullControl()
    }

    override def getControls() : Array[Control] = {
        return new Array[Control](0)
    }

    override def setVolume(leftVolume : Int, rightVolume : Int) : Unit = {
        this.setVolumeF((leftVolume.toFloat) / 100.0f)
    }

    private def getVolume() : Float = {
        val masterGainFloatControl : FloatControl = clip.getControl(FloatControl.Type.MASTER_GAIN).asInstanceOf[FloatControl]
        return Math.pow(10f, masterGainFloatControl.getValue() / 20f).toFloat
    }

    private def setVolumeF(volume : Float) : Unit = {
        if ((volume < 0f) || (volume > 1f)) {
            throw new IllegalArgumentException("Volume: " + volume)
        }
        val masterGainFloatControl : FloatControl = this.clip.getControl(FloatControl.Type.MASTER_GAIN).asInstanceOf[FloatControl]
        masterGainFloatControl.setValue(20f * Math.log10(volume).toFloat)
    }

    override def getDuration() : Long = {
        return this.clip.getMicrosecondLength() / 1000
    }

    override def update(event : LineEvent) : Unit = {
        //this.logUtil.putF("LineEvent: " + event.getType(), this, "update");
        if (event.getType().equals(LineEvent.Type.STOP)) {
            //this.close();
            val size : Int = this.listenersList.size()

            {
                var index : Int = 0
                while (index < size) {
                    var listener : PlayerListener = this.listenersList.get(size).asInstanceOf[PlayerListener]
                    listener.playerUpdate(this, PlayerListener.END_OF_MEDIA, null)
                    index += 1
                }
            }
        }
    }

}


