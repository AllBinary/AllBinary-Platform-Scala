/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AnalogControllerConfigurationEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.android.input.motion.event.AnalogControllerConfigurationEventHandler.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addListener(analogControllerConfigurationEventListenerInterface : AnalogControllerConfigurationEventListenerInterface) : Unit = {
        if (!this.list.contains(analogControllerConfigurationEventListenerInterface)) {
            this.list.add(analogControllerConfigurationEventListenerInterface)
        }
    }

    override def removeAllListeners() : Unit = {
        this.list.clear()
        super.removeAllListeners()
    }

    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = {
        this.list.remove(eventListenerInterface)
        super.removeListener(eventListenerInterface)
    }

    override def fireEvent(eventObject : AllBinaryEventObject) : Unit = {

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    //Add deviceId
                    var playerGameInput : AnalogControllerConfigurationEventListenerInterface = this.list.objectArray(index).asInstanceOf[AnalogControllerConfigurationEventListenerInterface]
                    playerGameInput.onAnalogControllerConfigurationEvent(eventObject.asInstanceOf[AnalogControllerConfigurationEvent])
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
        val analogControllerConfigurationEventListenerInterface : AnalogControllerConfigurationEventListenerInterface = (eventListenerInterface.asInstanceOf[AnalogControllerConfigurationEventListenerInterface])
        analogControllerConfigurationEventListenerInterface.onAnalogControllerConfigurationEvent(eventObject.asInstanceOf[AnalogControllerConfigurationEvent])
    }

}

object AnalogControllerConfigurationEventHandler {
    private val instance : AnalogControllerConfigurationEventHandler = new AnalogControllerConfigurationEventHandler()

    def getInstance() : AnalogControllerConfigurationEventHandler = {
        return AnalogControllerConfigurationEventHandler.instance
    }

}


