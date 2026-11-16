/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GameInputProcessorComposite(param_name : String, param_gameInputProcessorInterface : GameInputProcessorInterface) extends PlayerGameInput(new BasicArrayListD(), new BasicArrayListD(), -1) {

    private var name : String = null

    private var gameInputProcessorInterface : GameInputProcessorInterface = null

    private val NAME_LABEL : String = " GameInputProcessorInterface: "

    //Constructor
    {
        val name : String = param_name
        val gameInputProcessorInterface : GameInputProcessorInterface = param_gameInputProcessorInterface
        this.name = name
        this.gameInputProcessorInterface = gameInputProcessorInterface
    }

    override def update() : Unit = this.synchronized {
        try {
            var list : BasicArrayList = this.getGameKeyEventList()
            this.gameInputProcessorInterface.onInput(list)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.UPDATE, e)
            }
        }
    }

    override def toString() : String = {
        return new StringMaker().append(super.toString()).append(this.NAME_LABEL).append(this.name).toString()
    }

}


