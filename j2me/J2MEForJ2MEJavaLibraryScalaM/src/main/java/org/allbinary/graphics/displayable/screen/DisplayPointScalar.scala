/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.org.allbinary.graphics.GPoint

/**  *  * @author User  */
class DisplayPointScalar {
    import _root_.org.allbinary.graphics.displayable.screen.DisplayPointScalar.{*}

    def processX(value : Int) : Int = {
        return value
    }

    def processY(value : Int) : Int = {
        return value
    }

    def process(point : GPoint) : GPoint = {
        return point
    }

}

object DisplayPointScalar {
    private val instance : DisplayPointScalar = new DisplayPointScalar()

    /**      * @return the instance      */
    def getInstance() : DisplayPointScalar = {
        return DisplayPointScalar.instance
    }

}


