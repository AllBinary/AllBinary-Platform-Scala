/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.resources

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

/**  *  * @author User  */
class KeyValueFactory {
    import _root_.org.allbinary.resources.KeyValueFactory.{*}

    val MAP : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def get(key : String) : String = {
        //containsKey instead of a null get so languages without null strings return the key for a missing value
        if (!this.MAP.containsKey(key.asInstanceOf[Object])) {
            return key
        }
        return this.MAP.get(key.asInstanceOf[Object]).asInstanceOf[String]
    }

}

object KeyValueFactory {
    private val instance : KeyValueFactory = new KeyValueFactory()

    /**      * @return the instance      */
    def getInstance() : KeyValueFactory = {
        return KeyValueFactory.instance
    }

}


