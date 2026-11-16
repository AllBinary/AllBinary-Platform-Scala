/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class UpGameKeyEventHandlerBase() extends BasicEventHandler {
    import _root_.org.allbinary.game.input.event.UpGameKeyEventHandlerBase.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addListener(playerGameInput : PlayerGameInput) : Unit = {
        if (!this.list.contains(playerGameInput)) {
            this.list.add(playerGameInput)
        }
    }

    override def removeAllListeners() : Unit = {
        this.list.clear()
        super.removeAllListeners()
    }

    override def removeListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        this.list.remove(eventListenerInterface)
        super.removeListenerSingleThreaded(eventListenerInterface)
    }

    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = this.synchronized {
        this.list.remove(eventListenerInterface)
        super.removeListener(eventListenerInterface)
    }

    override def fireEvent(eventObject : AllBinaryEventObject) : Unit = {

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    //Add deviceId
                    var playerGameInput : PlayerGameInput = this.list.objectArray(index).asInstanceOf[PlayerGameInput]
                    playerGameInput.onUpGameKeyEvent(eventObject.asInstanceOf[GameKeyEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
        super.fireEvent(eventObject)
    }

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val upGameKeyEventListenerInterface : UpGameKeyEventListenerInterface = eventListenerInterface.asInstanceOf[UpGameKeyEventListenerInterface]
        upGameKeyEventListenerInterface.onUpGameKeyEvent(eventObject.asInstanceOf[GameKeyEvent])
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val size : Int = this.list.size()
        stringBuffer.append(super.toString())
        stringBuffer.append(UpGameKeyEventHandlerBase.TOTAL_LISTENERS)
        stringBuffer.appendint(size)

        {
            var index : Int = 0
            while (index < size) {
                try {
                    var eventListenerInterface : EventListenerInterface = this.list.get(index).asInstanceOf[EventListenerInterface]
                    stringBuffer.append(UpGameKeyEventHandlerBase.LISTENER_LABEL)
                    stringBuffer.append(eventListenerInterface.toString())
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.TOSTRING, e)
                    }
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}

object UpGameKeyEventHandlerBase {
    private val TOTAL_LISTENERS : String = " Total PlayerGameInput Listeners: "

    private val LISTENER_LABEL : String = " PlayerGameInput Listener: "

}


