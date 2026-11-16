/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.event

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class RawKeyEventHandler() {
    import _root_.org.allbinary.game.input.event.RawKeyEventHandler.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    var eventListenerInterfaceList : BasicArrayList = null

    //Constructor
    {
        this.eventListenerInterfaceList = new BasicArrayListD()
    }

    def removeAllListeners() : Unit = {
        this.eventListenerInterfaceList = new BasicArrayListD()
    }

    def addListeners(vector : BasicArrayList) : Unit = {
        var eventListenerInterface : RawKeyEventListener = null
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                eventListenerInterface = vector.get(index).asInstanceOf[RawKeyEventListener]
                this.addListener(eventListenerInterface)
                index += 1
            }
        }
    }

    def addListenerSingleThreaded(eventListenerInterface : RawKeyEventListener) : Unit = {
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //this.logUtil.putF(CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface)
        }
    }

    def addListener(eventListenerInterface : RawKeyEventListener) : Unit = {
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //this.logUtil.putF(CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface)
        }
    }

    def removeListenerSingleThreaded(eventListenerInterface : RawKeyEventListener) : Unit = {
        //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
        this.eventListenerInterfaceList.remove(eventListenerInterface)
    }

    def removeListener(eventListenerInterface : RawKeyEventListener) : Unit = {
        this.eventListenerInterfaceList.remove(eventListenerInterface)
    }

    def fireEvent(keyCode : Int, deviceId : Int, repeated : Boolean) : Unit = {
        var eventListenerInterface : RawKeyEventListener = null
        var index : Int = 0

        {
            while (index < this.eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = this.eventListenerInterfaceList.get(index).asInstanceOf[RawKeyEventListener]
                    this.process(keyCode, deviceId, repeated, eventListenerInterface)
                } catch {
                    case e : Exception => {
                        val commonStrings : CommonStrings = CommonStrings.getInstance()
                        this.logUtil.put(commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
                index += 1
            }
        }
    }

    def process(keyCode : Int, deviceId : Int, repeated : Boolean, eventListenerInterface : RawKeyEventListener) : Unit = {
        eventListenerInterface.onEventRaw(keyCode, deviceId, repeated)
    }

    def getEventListenerInterfaceListP() : BasicArrayList = {
        return this.eventListenerInterfaceList
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(RawKeyEventHandler.TOTAL_LISTENERS)
        stringBuffer.appendint(this.eventListenerInterfaceList.size())
        var eventListenerInterface : RawKeyEventListener = null
        var index : Int = 0

        {
            while (index < this.eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = this.eventListenerInterfaceList.get(index).asInstanceOf[RawKeyEventListener]
                    stringBuffer.append(RawKeyEventHandler.LISTENER_LABEL)
                    stringBuffer.append(eventListenerInterface.toString())
                } catch {
                    case e : Exception => {
                        val commonStrings : CommonStrings = CommonStrings.getInstance()
                        this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.TOSTRING, e)
                    }
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}

object RawKeyEventHandler {
    private val instance : RawKeyEventHandler = new RawKeyEventHandler()

    /**      * @return the instance      */
    def getInstance() : RawKeyEventHandler = {
        return RawKeyEventHandler.instance
    }

    private val TOTAL_LISTENERS : String = "Total Listeners: "

    private val LISTENER_LABEL : String = " Listener: "

}


