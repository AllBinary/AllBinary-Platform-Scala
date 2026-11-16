/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.logic.util.cache.BaseCircularPool
import _root_.org.allbinary.util.CircularIndexUtil

class AllBinaryLayerCircularPool() extends BaseCircularPool {

    def initAllBinaryLayerCircularPool(allbinaryLayerFactoryInterface : AllBinaryLayerFactoryInterface, total : Int) : Unit = {
        this.circularIndexUtil = CircularIndexUtil.createInstance(total)
        this.OBJECT_ARRAY = new Array[Object](total)

        {
            var localIndex : Int = 0
            while (localIndex < total) {
                this.OBJECT_ARRAY(localIndex) = allbinaryLayerFactoryInterface.getInstance()
                localIndex += 1
            }
        }
    }

}


