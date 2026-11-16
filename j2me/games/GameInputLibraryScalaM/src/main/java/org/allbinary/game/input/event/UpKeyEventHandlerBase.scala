/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class UpKeyEventHandlerBase() extends BasicEventHandler {
    import _root_.org.allbinary.game.input.event.UpKeyEventHandlerBase.{*}

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

    def fireEventForInteger(eventObject : Integer) : Unit = {

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    //Add deviceId
                    var playerGameInput : PlayerGameInput = this.list.objectArray(index).asInstanceOf[PlayerGameInput]
                    playerGameInput.onUpKeyEvent(eventObject)
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
        var index : Int = 0
        var eventListenerInterface : EventListenerInterface = null

        {
            while (index < this.eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = this.eventListenerInterfaceList.get(index).asInstanceOf[EventListenerInterface]
                    this.processForInteger(eventObject, eventListenerInterface)
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
                index += 1
            }
        }
    }

    def processForInteger(eventObject : Integer, eventListenerInterface : EventListenerInterface) : Unit = {
        val upKeyEventListenerInterface : UpKeyEventListenerInterface = eventListenerInterface.asInstanceOf[UpKeyEventListenerInterface]
        upKeyEventListenerInterface.onUpKeyEvent(eventObject)
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        stringBuffer.append(UpKeyEventHandlerBase.TOTAL_LISTENERS)
        stringBuffer.appendint(this.list.size())

        {
            var index : Int = 0
            while (index < this.list.size()) {
                try {
                    var eventListenerInterface : EventListenerInterface = this.list.get(index).asInstanceOf[EventListenerInterface]
                    stringBuffer.append(UpKeyEventHandlerBase.LISTENER_LABEL)
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

object UpKeyEventHandlerBase {
    private val TOTAL_LISTENERS : String = " Total PlayerGameInput Listeners: "

    private val LISTENER_LABEL : String = " PlayerGameInput Listener: "

}


