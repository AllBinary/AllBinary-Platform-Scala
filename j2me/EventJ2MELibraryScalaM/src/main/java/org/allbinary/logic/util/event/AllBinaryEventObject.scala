/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.NullUtil
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

@JsType
class AllBinaryEventObject(param_anyType : Object) {
    import _root_.org.allbinary.logic.util.event.AllBinaryEventObject.{NULL_EVENT as _, *}
    def NULL_EVENT : AllBinaryEventObject = _root_.org.allbinary.logic.util.event.AllBinaryEventObject.NULL_EVENT

    private var source : Object = null

    //Constructor
    {
        val anyType : Object = param_anyType
        this.source = anyType
    }

    @JsMethod
    def getSource() : Object = {
        return this.source
    }

    @JsMethod
    def setSource(source : Object) : Unit = {
        this.source = source
    }

}

object AllBinaryEventObject {
    @JsProperty
    val NULL_EVENT : AllBinaryEventObject = new AllBinaryEventObject(NullUtil.getInstance().NULL_OBJECT)

}


