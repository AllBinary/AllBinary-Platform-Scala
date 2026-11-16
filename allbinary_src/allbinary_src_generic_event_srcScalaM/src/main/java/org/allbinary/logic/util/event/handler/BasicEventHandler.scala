/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event.handler

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicEventHandler() extends BasicEventHandlerInterface {
    import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler.{PERFORMANCE_MESSAGE as _, *}
    def PERFORMANCE_MESSAGE : String = _root_.org.allbinary.logic.util.event.handler.BasicEventHandler.PERFORMANCE_MESSAGE

    val logUtil : LogUtil = LogUtil.getInstance()

    private var eventListenerInterfaceList : BasicArrayList = null

    // private Condition condition = reentrantLock.newCondition();
    //Constructor
    {
        this.eventListenerInterfaceList = new BasicArrayListD()
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val LISTENER : String = " Listener: "
        stringBuffer.append("Total Listeners: ")
        stringBuffer.appendint(this.eventListenerInterfaceList.size())
        var eventListenerInterface : EventListenerInterface = null
        var index : Int = 0

        {
            while (index < this.eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = this.eventListenerInterfaceList.objectArray(index).asInstanceOf[EventListenerInterface]
                    stringBuffer.append(LISTENER)
                    stringBuffer.append(StringUtil.getInstance().toString(eventListenerInterface))
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

    def removeAllListeners() : Unit = this.synchronized {
        this.eventListenerInterfaceList = new BasicArrayListD()
    }

    /*     public synchronized void addListeners(BasicArrayList vector)     {         int size = vector.size();         for (int index = 0; index < size; index++)         {             EventListenerInterface eventListenerInterface =                 (EventListenerInterface) vector.get(index);             this.addListener(eventListenerInterface);         }     }     */
    def addListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface)
        }
    }

    def addListenerInterface(eventListenerInterface : EventListenerInterface) : Unit = this.synchronized {
        // reentrantLock.isHeldByCurrentThread(), this, this.commonStrings.ADD_LISTENER);
        if (!this.eventListenerInterfaceList.contains(eventListenerInterface)) {
            //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
            this.eventListenerInterfaceList.add(eventListenerInterface)
        }
    }

    def removeListenerSingleThreaded(eventListenerInterface : EventListenerInterface) : Unit = {
        //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
        this.eventListenerInterfaceList.remove(eventListenerInterface)
    }

    def removeListener(eventListenerInterface : EventListenerInterface) : Unit = this.synchronized {
        //      CommonLabels.getInstance().START + eventListenerInterface, this, this.commonStrings.ADD_LISTENER);
        this.eventListenerInterfaceList.remove(eventListenerInterface)
    }

    def fireEvent(eventObject : AllBinaryEventObject) : Unit = this.synchronized {
        /*          * reentrantLock.lock(); try {          *          * while(this.reentrantLock.getHoldCount() > 1) {          * this.condition.await(); }          *          * //if(this instance of DestroyedEventHandler) //LogUtil.put(new          * Log("Start: Locks Held: " + reentrantLock.getHoldCount() + " Held By          * Current Thread: " + reentrantLock.isHeldByCurrentThread(), this,          * EventStrings.getInstance().FIRE_EVENT)); //this.logUtil.putF(this.commonStrings.START, this, EventStrings.getInstance().FIRE_EVENT);          *          * iter = this.eventListenerInterfaceVector; while          * (iter.hasNext()) { EventListenerInterface eventListenerInterface =          * (EventListenerInterface) iter .next();          *          * this.process(eventObject, eventListenerInterface); }          *          * this.condition.signal(); } catch(Exception e) { LogUtil.put(new          * Log(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)); } finally {          * reentrantLock.unlock(); }          */
        var index : Int = 0
        var eventListenerInterface : EventListenerInterface = null

        {
            while (index < this.eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = this.eventListenerInterfaceList.objectArray(index).asInstanceOf[EventListenerInterface]
                    this.process(eventObject, eventListenerInterface)
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

    def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        // (BasicEventListenerInterface) eventListenerInterface;
        eventListenerInterface.onEvent(eventObject)
    }

    def getEventListenerInterfaceListP() : BasicArrayList = {
        return this.eventListenerInterfaceList
    }

}

object BasicEventHandler {
    val PERFORMANCE_MESSAGE : String = "Use Custom onEvent Methods for needed optimization"

}


