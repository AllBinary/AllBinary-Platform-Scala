/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

@JsType
class PointFactory private() {
    import _root_.org.allbinary.graphics.PointFactory.{*}

    @JsProperty
    var ZERO_ZERO : GPoint = this.createXYZ(0, 0, 0)

    //private static final Hashtable hashtable = StdUtil.getInstance().createHashtable();
    @JsMethod
    def init() : Unit = {
    }

    //TWB - to be depricated
    @JsMethod
    def createXY(x : Int, y : Int) : GPoint = {
        return new GPoint(x, y, 0)
    }

    //The rest are mainly static or part of each game level as well
    @JsMethod
    def createXYZ(x : Int, y : Int, z : Int) : GPoint = {
        return new GPoint(x, y, z)
    }

}

object PointFactory {
    private val instance : PointFactory = new PointFactory()

    @JsMethod
    def getInstance() : PointFactory = {
        return PointFactory.instance
    }

}


