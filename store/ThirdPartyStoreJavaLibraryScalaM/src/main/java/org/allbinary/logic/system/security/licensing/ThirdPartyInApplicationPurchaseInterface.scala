/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing


trait ThirdPartyInApplicationPurchaseInterface {

    def isPurchased(lockableFeature : LockableFeature) : Boolean

    def onCreate(anyType : Object, stateObject : Object) : Unit

    def onDestroy() : Unit

    def onStart() : Unit

    def onActivityResult(requestCode : Int, resultCode : Int, dataObject : Object) : Unit

    def onSaveInstanceState(anyType : Object) : Unit

    def onStop() : Unit

    def requestPurchase(lockableFeature : LockableFeature) : Unit

    def requestReceipts() : Unit

    def add(lockableFeature : LockableFeature) : Unit

    def getUserName() : String

    def isEnabled() : Boolean

}


