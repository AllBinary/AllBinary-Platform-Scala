/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AbstractArrayListPool(param_cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface) extends PoolInterface {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var buffers : BasicArrayList = new BasicArrayListD()

    //protected int pos = -1;
    var cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface = null

    //Constructor
    {
        val cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface = param_cacheableInterfaceFactoryInterface
        this.cacheableInterfaceFactoryInterface = cacheableInterfaceFactoryInterface
    }

    override def clear() : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def remove(key : Object) : CacheableInterface = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def add(cacheableInterface : CacheableInterface) : Unit = {
        //buffers.set(++pos, cacheableInterface);
        this.buffers.add(cacheableInterface)
    }

    override def addArray(cacheableInterfaces : Array[CacheableInterface]) : Unit = {

        {
            var index : Int = 0
            while (index < cacheableInterfaces.length) {
                //buffers.set(++pos, cacheableInterfaces[index]);
                this.buffers.add(cacheableInterfaces(index))
                index += 1
            }
        }
    }

}


