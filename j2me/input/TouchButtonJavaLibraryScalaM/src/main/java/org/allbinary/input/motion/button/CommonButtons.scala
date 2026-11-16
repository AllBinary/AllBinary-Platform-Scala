/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton

class CommonButtons private() {
    import _root_.org.allbinary.input.motion.button.CommonButtons.{*}

    var STANDARD_BUTTON_SIZE : Int = 0

    var NORMAL_BUTTON : Rectangle = null

    var LARGE_BUTTON : Rectangle = null

    //Constructor
    {
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        var commonButtonSize : Int = 128

        {
            scala.util.boundary { (break_N67514 : scala.util.boundary.Label[Unit]) ?=>
                while (commonButtonSize > 64) {
                    var totalColumns : Int = displayInfo.getLastWidth() / commonButtonSize
                    var totalRows : Int = displayInfo.getLastHeight() / commonButtonSize
                    var max : Int = totalColumns
                    if (totalRows > max) {
                        max = totalRows
                    }
                    //PreLogUtil.put("width:" + displayInfo.getLastWidth() + " h:"  + displayInfo.getLastHeight()  + "max:" + max, this, "CommonButtons");
                    if (max > 9) {
                        scala.util.boundary.break()(using break_N67514)
                    }
                    commonButtonSize = commonButtonSize >> 1
                }
            }
        }
        this.STANDARD_BUTTON_SIZE = commonButtonSize
        this.NORMAL_BUTTON = new Rectangle(PointFactory.getInstance().ZERO_ZERO, this.STANDARD_BUTTON_SIZE, this.STANDARD_BUTTON_SIZE)
        this.LARGE_BUTTON = new Rectangle(PointFactory.getInstance().ZERO_ZERO, this.STANDARD_BUTTON_SIZE << 1, this.STANDARD_BUTTON_SIZE << 1)
    }

}

object CommonButtons {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : CommonButtons = new CommonButtons()

    def getInstance() : CommonButtons = {
        return CommonButtons.instance
    }

}


