/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.osgi.framework

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class NullServiceReference {

    def getProperty(key : String) : Object = {
        return NullUtil.getInstance().NULL_OBJECT
    }

    def getPropertyKeys() : Array[String] = {
        return StringUtil.getInstance().getArrayInstance()
    }

    def compareTo(o : Object) : Int = {
        throw new RuntimeException()
    }

}


