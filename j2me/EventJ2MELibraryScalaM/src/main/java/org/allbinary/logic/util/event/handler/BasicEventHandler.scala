/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event.handler

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

@JsType
class BasicEventHandler() extends BasicEventHandlerInterface {

    @JsProperty
    val logUtil : LogUtil = LogUtil.getInstance()

    @JsProperty
    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val eventStrings : EventStrings = EventStrings.getInstance()

    @JsProperty
    var eventListenerInterfaceList : BasicArrayList = null

    // private Condition condition = reentrantLock.newCondition();
    //Constructor
    {
        this.eventListenerInterfaceList = new BasicArrayListD()
    }

    @JsMethod
    override def removeAllListeners() : Unit = {
        this.eventListenerInterfaceList = new BasicArrayListD()
    }

    @JsMethod
    override def addListeners(vector : BasicArrayList) : Unit = {
        var eventListenerInterface : EventListenerInterface = null
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                eventListenerInterface = vector.get(index).asInstanceOf[EventListenerInterface]
                this.addListenerInterface(eventListenerInterface)
                index += 1
            }
        }
    }

    @JsMethod
    def removeListeners(vector : BasicArrayList) : Unit = {
        var eventListenerInterface : EventListenerInterface = null
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                eventListenerInterface = vector.get(index).asInstanceOf[EventListenerInterface]
                this.removeListener(eventListenerInterface)
                index += 1
            }
        }
    }

    @JsMethod
    def addListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //this.logUtil.putF(CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface)
        }
    }

    @JsMethod
    override def addListenerInterface(eventListenerInterface : EventListenerInterface) : Unit = {
        // reentrantLock.isHeldByCurrentThread(), this, this.commonStrings.ADD_LISTENER);
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //this.logUtil.putF(CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface)
        }
    }

    @JsMethod
    def removeListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
        this.eventListenerInterfaceList.remove(eventListenerInterface)
    }

    @JsMethod
    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = {
        //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
        this.eventListenerInterfaceList.remove(eventListenerInterface)
    }

    @JsMethod
    override def fireEvent(eventObject : AllBinaryEventObject) : Unit = {
        // while(enumeration.hasMoreElements())
        var eventListenerInterface : EventListenerInterface = null
        var index : Int = 0

        {
            while (index < this.eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = this.eventListenerInterfaceList.get(index).asInstanceOf[EventListenerInterface]
                    this.process(eventObject, eventListenerInterface)
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, this.eventStrings.FIRE_EVENT, e)
                    }
                }
                index += 1
            }
        }
    }

    @JsMethod
    def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        // (BasicEventListenerInterface) eventListenerInterface;
        eventListenerInterface.onEvent(eventObject)
    }

    @JsMethod
    def getEventListenerInterfaceListP() : BasicArrayList = {
        return this.eventListenerInterfaceList
    }

    @JsMethod
    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.eventStrings.TOTAL_LISTENERS)
        stringBuffer.appendint(this.eventListenerInterfaceList.size())
        var eventListenerInterface : EventListenerInterface = null
        var index : Int = 0

        {
            while (index < this.eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = this.eventListenerInterfaceList.get(index).asInstanceOf[EventListenerInterface]
                    stringBuffer.append(this.eventStrings.LISTENER_LABEL)
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


