/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor

@JsType
class Angle(param_angle : Short) {

    //private Integer value;
    private var value : Short = 0

    //protected 
    //Constructor
    {
        val angle : Short = param_angle
        //this.value = SmallIntegerSingletonFactory.getInstance(angle);
        this.value = angle
    }

    @JsMethod
    def getValue() : Short = {
        return this.value
    }

}


