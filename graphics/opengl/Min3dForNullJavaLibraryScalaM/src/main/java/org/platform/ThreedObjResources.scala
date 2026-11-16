/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.platform

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

/**  *  * @author User  */
class ThreedObjResources {
    import _root_.org.platform.ThreedObjResources.{*}

    val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def get(resourceName : String) : String = {
        val resourceName2 : String = this.hashtable.get(resourceName).asInstanceOf[String]
        if (resourceName2 != null) {
            return resourceName2
        }
        return resourceName
    }

}

object ThreedObjResources {
    private val instance : ThreedObjResources = new ThreedObjResources()

    /**      * @return the instance      */
    def getInstance() : ThreedObjResources = {
        return ThreedObjResources.instance
    }

}


