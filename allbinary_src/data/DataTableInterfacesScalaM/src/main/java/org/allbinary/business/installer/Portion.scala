/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.installer

import _root_.java.util.HashMap

class Portion(param_hashMap : HashMap[Object, Object]) {

    // = Integer.valueOf(0);
    private var current : Integer = null

    // = Integer.valueOf(1);
    private var total : Integer = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        this.current = hashMap.get("current").asInstanceOf[Integer]
        this.total = hashMap.get("total").asInstanceOf[Integer]
    }

    def getCurrent() : Integer = {
        return this.current
    }

    def getTotal() : Integer = {
        return this.total
    }

}


