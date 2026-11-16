/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.customer.subscriber

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.modules.User
import _root_.org.allbinary.business.user.subscription.Subscription
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface

class SubscriberUser private (super_1 : HashMap[Object, Object], constructor_ : Unit) extends User(super_1) {

    //Store Subscriber Info in another table or order
    private var subscription : Subscription = null

    def this(userHashMap : HashMap[Object, Object]) = {
        this(userHashMap, ())
        this.subscription = new Subscription()
    }

    def this() = {
        this(null, ())
        this.subscription = new Subscription()
    }

    override def validateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
        super.validateSession(weblisketSession)
        this.updateSession(weblisketSession)
    }

    override def updateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
        weblisketSession.setStoreName(this.getPermissions())
    }

    override def isSessionValid() : _root_.java.lang.Boolean = {
        return this.subscription.isSubscribed()
    }

}


