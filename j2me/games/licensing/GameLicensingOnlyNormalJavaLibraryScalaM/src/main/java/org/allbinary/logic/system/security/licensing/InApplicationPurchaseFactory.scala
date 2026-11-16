/*  * To change this license header, choose License Headers in Project Properties.  * To change this template file, choose Tools | Templates  * and open the template in the editor.  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author user  */
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
        return true
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


