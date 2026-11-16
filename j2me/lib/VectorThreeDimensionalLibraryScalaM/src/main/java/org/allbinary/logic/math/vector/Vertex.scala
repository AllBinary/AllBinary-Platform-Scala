/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.vector

import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonSeps

class Vertex() {

    var x : BasicDecimal = new BasicDecimal(0)

    var y : BasicDecimal = new BasicDecimal(0)

    var z : BasicDecimal = new BasicDecimal(0)

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        var positionStrings : PositionStrings = PositionStrings.getInstance()
        stringBuffer.append(positionStrings.X_LABEL)
        stringBuffer.append(this.x.toString())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(positionStrings.Y_LABEL)
        stringBuffer.append(this.y.toString())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(positionStrings.Z_LABEL)
        stringBuffer.append(this.z.toString())
        return stringBuffer.toString()
    }

}


