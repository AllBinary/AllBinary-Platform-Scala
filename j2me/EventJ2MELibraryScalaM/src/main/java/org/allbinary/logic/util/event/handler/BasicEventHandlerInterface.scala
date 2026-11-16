/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event.handler

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.util.BasicArrayList
import _root_.jsinterop.annotations.JsMethod

@JsType
trait BasicEventHandlerInterface {

    @JsMethod
    def addListenerInterface(eventListenerInterface : EventListenerInterface) : Unit

    @JsMethod
    def addListeners(basicArrayList : BasicArrayList) : Unit

    @JsMethod
    def fireEvent(eventObject : AllBinaryEventObject) : Unit

    @JsMethod
    def removeAllListeners() : Unit

    @JsMethod
    def removeListener(eventListenerInterface : EventListenerInterface) : Unit

}


