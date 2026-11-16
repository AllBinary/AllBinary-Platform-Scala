/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class ColorChangeEvent(param_anyType : Object) extends AllBinaryEventObject(param_anyType) {

    private var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    //Constructor
    {
        val anyType : Object = param_anyType
    }

    def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

}


