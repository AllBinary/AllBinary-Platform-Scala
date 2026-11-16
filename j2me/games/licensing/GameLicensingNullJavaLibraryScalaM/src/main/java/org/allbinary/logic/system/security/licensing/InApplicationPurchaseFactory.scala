/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.logic.string.StringUtil

class InApplicationPurchaseFactory private() {
    import _root_.org.allbinary.logic.system.security.licensing.InApplicationPurchaseFactory.{*}

    def init(anyType : Object, stateObject : Object) : Unit = {
    }

    def onCreate(anyType : Object, stateObject : Object) : Unit = {
    }

    def onStart() : Unit = {
    }

    def onResult(requestCode : Int, resultCode : Int, data : Object) : Unit = {
    }

    def onSaveState(anyType : Object) : Unit = {
    }

    def onStop() : Unit = {
    }

    def onDestroy() : Unit = {
    }

    def purchase(lockableFeature : LockableFeature) : Unit = {
    }

    def isPurchased(lockableFeature : LockableFeature) : Boolean = {
        return false
    }

    def add(lockableFeature : LockableFeature) : Unit = {
    }

    def getUserName() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def isEnabled() : Boolean = {
        return false
    }

}

object InApplicationPurchaseFactory {
    private val instance : InApplicationPurchaseFactory = new InApplicationPurchaseFactory()

    /**      * @return the instance      */
    def getInstance() : InApplicationPurchaseFactory = {
        return InApplicationPurchaseFactory.instance
    }

}


