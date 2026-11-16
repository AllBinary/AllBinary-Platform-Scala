/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.paint.Paintable

class TouchButtonsPaintableFactory {
    import _root_.org.allbinary.input.motion.button.TouchButtonsPaintableFactory.{*}

}

object TouchButtonsPaintableFactory {
    def getInstance(basicColor : BasicColor) : Paintable = {
        return new TouchButtonsPaintable(basicColor)
    }

}


