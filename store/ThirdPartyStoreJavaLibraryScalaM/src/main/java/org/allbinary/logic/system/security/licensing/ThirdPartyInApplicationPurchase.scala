/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.logic.string.StringUtil

class ThirdPartyInApplicationPurchase extends ThirdPartyInApplicationPurchaseInterface {

    override def isPurchased(lockableFeature : LockableFeature) : Boolean = {
        return false
    }

    override def onCreate(anyType : Object, stateObject : Object) : Unit = {
    }

    override def onDestroy() : Unit = {
    }

    override def onStart() : Unit = {
    }

    override def onActivityResult(requestCode : Int, resultCode : Int, dataObject : Object) : Unit = {
    }

    override def onSaveInstanceState(anyType : Object) : Unit = {
    }

    override def onStop() : Unit = {
    }

    override def requestPurchase(lockableFeature : LockableFeature) : Unit = {
    }

    override def requestReceipts() : Unit = {
    }

    override def add(lockableFeature : LockableFeature) : Unit = {
    }

    override def getUserName() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def isEnabled() : Boolean = {
        return false
    }

    def requestProducts() : Unit = {
    }

}


