/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class LockableFeatureFactory {
    import _root_.org.allbinary.logic.system.security.licensing.LockableFeatureFactory.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    /**      * @return the list      */
    def getList() : BasicArrayList = {
        return this.list
    }

}

object LockableFeatureFactory {
    private val instance : LockableFeatureFactory = new LockableFeatureFactory()

    /**      * @return the instance      */
    def getInstance() : LockableFeatureFactory = {
        return LockableFeatureFactory.instance
    }

}


