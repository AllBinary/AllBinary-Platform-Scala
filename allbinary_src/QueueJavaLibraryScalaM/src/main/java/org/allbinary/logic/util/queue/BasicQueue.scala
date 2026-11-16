/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.queue

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicQueue() {

    val queueVector : BasicArrayList = new BasicArrayListD()

    def offer(anyType : Object) : Boolean = this.synchronized {
        this.queueVector.add(anyType)
        return true
    }

    def remove(anyType : Object) : Unit = this.synchronized {
        this.queueVector.remove(anyType)
    }

    def removeLast() : Object = this.synchronized {
        var anyType : Object = this.queueVector.get(this.queueVector.size() - 1)
        this.queueVector.remove(anyType)
        return anyType
    }

}


