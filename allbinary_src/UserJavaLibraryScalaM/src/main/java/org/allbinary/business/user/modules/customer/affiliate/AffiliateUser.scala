/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.customer.affiliate

import _root_.java.util.HashMap
import _root_.org.allbinary.business.advertisement.affiliate.sales.AffiliateSales
import _root_.org.allbinary.business.user.modules.User
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface

class AffiliateUser private (super_1 : HashMap[Object, Object], constructor_ : Unit) extends User(super_1) {

    //Store Subscriber Info in another table or order
    private var affiliateSales : AffiliateSales = null

    def this(userHashMap : HashMap[Object, Object]) = {
        this(userHashMap, ())
        this.affiliateSales = new AffiliateSales()
    }

    def this() = {
        this(null, ())
        this.affiliateSales = new AffiliateSales()
    }

    override def validateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
        super.validateSession(weblisketSession)
        this.updateSession(weblisketSession)
    }

    override def updateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
        weblisketSession.setStoreName(this.getPermissions())
    }

    override def isSessionValid() : _root_.java.lang.Boolean = {
        return this.affiliateSales.isValid()
    }

}


