/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Player
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory

class Sounds(param_soundsFactoryInterface : SoundsFactoryInterface) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val soundStrings : SoundStrings = SoundStrings.getInstance()

    private var soundsFactoryInterface : SoundsFactoryInterface = null

    //Constructor
    {
        val soundsFactoryInterface : SoundsFactoryInterface = param_soundsFactoryInterface
        this.soundsFactoryInterface = soundsFactoryInterface
    }

    def init() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.INIT)
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        this.soundsFactoryInterface.init()
        val soundInterfaceArray : Array[Sound] = this.soundsFactoryInterface.getSoundInterfaceArray()
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        var indexInteger : Integer = null
        var indexString : String = null
        val stringBuffer : StringMaker = new StringMaker()

        {
            var i : Int = 0
            while (i < soundInterfaceArray.length) {
                val soundInterface : Sound = soundInterfaceArray(i)
                if (soundInterface != null) {
                    indexInteger = smallIntegerSingletonFactory.getAt(i)
                    indexString = indexInteger.toString()
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(commonLabels.INDEX_LABEL)
                    stringBuffer.append(indexString)
                    stringBuffer.append(this.soundStrings.SOUND)
                    stringBuffer.append(soundInterface.getClass().getName())
                    this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.INIT)
                    soundInterface.init()
                    progressCanvas.addNormalPortion(100, new StringMaker().append(this.soundStrings.INIT_SOUND).append(indexString).toString())
                }
                i += 1
            }
        }
        this.soundsFactoryInterface.setInitialized(true)
        this.logUtil.putF(this.commonStrings.END, this, this.commonStrings.INIT)
    }

    def stopAll() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.soundStrings.STOP_ALL)
        val soundInterfaceArray : Array[Sound] = this.soundsFactoryInterface.getSoundInterfaceArray()
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        var player : Player = null

        {
            var index : Int = 0
            while (index < soundInterfaceArray.length) {
                if (soundInterfaceArray(index) != null) {
                    player = soundInterfaceArray(index).getPlayerP()
                    if (player != null) {
                        player.stop()
                        progressCanvas.addPortion(100, this.soundStrings.STOPPING_SOUND, index)
                    }
                }
                index += 1
            }
        }
    }

    def closeAll() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.soundStrings.CLOSE_ALL)
        val soundInterfaceArray : Array[Sound] = this.soundsFactoryInterface.getSoundInterfaceArray()
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        var player : Player = null

        {
            var index : Int = 0
            while (index < soundInterfaceArray.length) {
                if (soundInterfaceArray(index) != null) {
                    player = soundInterfaceArray(index).getPlayerP()
                    if (player != null) {
                        player.close()
                        progressCanvas.addPortion(100, this.soundStrings.CLOSING_SOUND, index)
                    }
                }
                index += 1
            }
        }
    }

}


