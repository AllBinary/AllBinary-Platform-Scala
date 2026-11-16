/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.javax.microedition.media.Player
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings

class Sound(param_resource : String) extends SoundInterface with Runnable {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var resource : String = null

    var player : Player = NoPlayer.NO_PLAYER

    //Constructor
    {
        val resource : String = param_resource
        this.resource = resource
    }

    override def getResource() : String = {
        return this.resource
    }

    override def getPlayerP() : Player = {
        return this.player
    }

    def setPlayerP(player : Player) : Unit = {
        this.player = player
    }

    override def init() : Unit = {
    }

    def getDuration() : Int = {
        return -1
    }

    override def run() : Unit = {
        try {
            this.player.start()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN)
            }
        }
    }

}


