/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.org.allbinary.util.BasicArrayList

class BasicArrayListPool(param_cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface) extends AbstractArrayListPool(param_cacheableInterfaceFactoryInterface) {

    //Constructor
    {
        val cacheableInterfaceFactoryInterface : CacheableInterfaceFactoryInterface = param_cacheableInterfaceFactoryInterface
    }

    override def clear() : Unit = {
        this.buffers.clear()
    }

    override def remove(key : Object) : CacheableInterface = {
        var size : Int = this.buffers.size()
        if (size > 0) {
            return this.buffers.removeAt(size - 1).asInstanceOf[CacheableInterface]
        } else {
            return this.cacheableInterfaceFactoryInterface.getInstance(key)
        }
        throw new IllegalStateException()
    }

    def addAll(usedList : BasicArrayList) : Unit = {

        {
            var index : Int = usedList.size()
            while ({ index -= 1; index } >= 0) {
                var anyType : CacheableInterface = usedList.objectArray(index).asInstanceOf[CacheableInterface]
                this.add(anyType)
            }
        }
        usedList.clear()
    }

    def releaseUsedBackToPool(usedList : BasicArrayList) : Unit = {

        {
            var index : Int = usedList.size()
            while ({ index -= 1; index } >= 0) {
                var list : BasicArrayListCacheable = usedList.objectArray(index).asInstanceOf[BasicArrayListCacheable]
                if (list.size() == 0) {
                    usedList.removeAt(index)
                    this.add(list)
                }
            }
        }
    }

}


