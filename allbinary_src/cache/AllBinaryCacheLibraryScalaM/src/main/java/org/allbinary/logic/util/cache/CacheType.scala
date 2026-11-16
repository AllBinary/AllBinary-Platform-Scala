/*  * AllBinary Open License Version 1  * Copyright (c) 2007 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.org.allbinary.logic.string.StringMaker

class CacheType(param_vendor : String, param_type : String) {

    private var vendor : String = null

    private var `type` : String = null

    //Constructor
    {
        val vendor : String = param_vendor
        val `type` : String = param_type
        this.vendor = vendor
        this.`type` = `type`
    }

    def getVendor() : String = {
        return this.vendor
    }

    def getType() : String = {
        return this.`type`
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("CacheType: Vendor: ")
        stringBuffer.append(this.getVendor())
        stringBuffer.append(" Type: ")
        stringBuffer.append(this.getType())
        return stringBuffer.toString()
    }

}


