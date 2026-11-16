/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.admin.store.payment

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.modules.User
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface

class PaymentStoreAdminUser private (super_1 : HashMap[Object, Object], constructor_ : Unit) extends User(super_1) {

    def this(userHashMap : HashMap[Object, Object]) = {
        this(userHashMap, ())
    }

    def this() = {
        this(null, ())
    }

    override def validateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
        super.validateSession(weblisketSession)
        this.updateSession(weblisketSession)
    }

    override def updateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
        weblisketSession.setStoreName(this.getPermissions())
    }

}


