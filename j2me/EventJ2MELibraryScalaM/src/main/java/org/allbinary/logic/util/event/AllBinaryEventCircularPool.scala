/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event

import _root_.org.allbinary.logic.util.cache.BaseCircularPool
import _root_.org.allbinary.util.CircularIndexUtil

class AllBinaryEventCircularPool(param_max : Int) extends BaseCircularPool {

    //Constructor
    {
        val max : Int = param_max
        this.OBJECT_ARRAY = new Array[Object](max)
        this.circularIndexUtil = CircularIndexUtil.createInstance(max)
    }

    def initAllBinaryEventCircularPool(allBinaryEventObjectFactoryInterface : AllBinaryEventObjectFactoryInterface) : Unit = {
        this.circularIndexUtil.setIndex(0)
        var size : Int = this.circularIndexUtil.getSize()

        {
            var index : Int = 0
            while (index < size) {
                this.OBJECT_ARRAY(index) = allBinaryEventObjectFactoryInterface.getInstance()
                index += 1
            }
        }
    }

}


