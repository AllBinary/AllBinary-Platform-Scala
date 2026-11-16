/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math


class ScaleFactorFactory {
    import _root_.org.allbinary.logic.math.ScaleFactorFactory.{*}

    var DEFAULT_SCALE_FACTOR : Int = 10

    var DEFAULT_SCALE_VALUE : Int = 1024

}

object ScaleFactorFactory {
    private val instance : ScaleFactorFactory = new ScaleFactorFactory()

    def getInstance() : ScaleFactorFactory = {
        return ScaleFactorFactory.instance
    }

}


