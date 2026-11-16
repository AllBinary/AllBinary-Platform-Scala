/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.org.allbinary.logic.string.StringUtil

class ImageCacheable(param_name : String, param_anyType : Object) {

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    //private Object object;
    //Constructor
    {
        val name : String = param_name
        val anyType : Object = param_anyType
    }

    def getKey() : Object = {
        return this.name
    }

    override def toString() : String = {
        return this.name
    }

}


