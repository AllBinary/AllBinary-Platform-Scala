/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.magnetic.field

import _root_.org.allbinary.input.AllBinarySensorListener
import _root_.org.allbinary.logic.math.Orientation

class NoMagneticFieldSensor extends AllBinaryMagneticFieldSensor with AllBinarySensorListener {

    def getOrientation() : Orientation = {
        return Orientation.NONE
    }

    override def onSensorChange() : Unit = {
    }

}


