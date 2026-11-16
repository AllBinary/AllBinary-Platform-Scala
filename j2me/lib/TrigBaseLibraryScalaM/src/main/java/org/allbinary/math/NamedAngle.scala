/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsProperty
import _root_.jsinterop.annotations.JsConstructor

/**  *  * @author User  */
@JsType
class NamedAngle(param_angle : Short, param_name : String) extends Angle(param_angle) {

    @JsProperty
    var name : String = null

    //protected
    //Constructor
    {
        val angle : Short = param_angle
        val name : String = param_name
        this.name = name
    }

}


