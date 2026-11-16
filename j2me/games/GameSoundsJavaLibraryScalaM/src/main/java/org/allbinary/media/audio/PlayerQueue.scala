/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class PlayerQueue(param_max : Int) {
    import _root_.org.allbinary.media.audio.PlayerQueue.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val list : BasicArrayList = new BasicArrayListD()

    private var max : Int = 0

    //Constructor
    {
        val max : Int = param_max
        this.max = max
    }

    def add(sound : Sound) : Unit = {
        try {
            if (!this.list.contains(sound)) {
                //this.logUtil.putF(new StringMaker().append("Adding: ").append(sound.getResource()).toString(), this, this.commonStrings.ADD);
                this.list.add(sound)
            }
        } catch {
            case e : Exception => {
                PreLogUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD)
            }
        }
    }

    def process() : Boolean = {
        var sound : Sound = NoSound.getInstance()
        try {
            var played : Boolean = false
            if (this.list.size() > 0) {
                sound = this.list.removeAt(0).asInstanceOf[Sound]
                //Should be possible, but it still happens?
                if (sound != null) {
                    //SoundThreadPool.getInstance().runTask(sound);
                    sound.getPlayerP().start()
                }

                {
                    while (this.list.size() > this.max) {
                        this.list.removeAt(0)
                    }
                }
                played = true
            }
            return played
        } catch {
            case e : Exception => {
                var resource : String = StringUtil.getInstance().EMPTY_STRING
                if (sound != null) {
                    resource = sound.getResource()
                }
                /*             try             {                 final String message = CommonStrings.getInstance();                               GameNotificationEvent gameNotificationEvent =                      new GameNotificationEvent(                             this, message,                             SmallIntegerSingletonFactory.getInstance(1),                             BasicColor.RED,                             Boolean.FALSE);                  GameNotificationEventHandler.getInstance().fireEvent(                         gameNotificationEvent);                                 }             catch(Exception e2)             {                              }             */
                PreLogUtil.put(new StringMaker().append(this.commonStrings.EXCEPTION_LABEL).append(resource).toString(), this, this.commonStrings.PROCESS)
                return false
            }
        }
        throw new IllegalStateException()
    }

    def clear() : Unit = {
        this.list.clear()
    }

    override def toString() : String = {
        return new StringMaker().append(PlayerQueue.TOTAL).appendint(this.list.size()).toString()
    }

}

object PlayerQueue {
    private val TOTAL : String = "Sounds In Queue: "

}


