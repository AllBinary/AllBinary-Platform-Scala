/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author user  */
class StoreRoleFactory private() {
    import _root_.org.allbinary.business.user.role.StoreRoleFactory.{*}

    private val roles : BasicArrayList = new BasicArrayListD()

    private val subscriberRoles : BasicArrayList = new BasicArrayListD()

    private val wholesaleRoles : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val basicUserRoleFactory : BasicUserRoleFactory = BasicUserRoleFactory.getInstance()
        this.roles.add(basicUserRoleFactory.CUSTOMER)
        this.roles.add(basicUserRoleFactory.SUBSCRIBERCUSTOMER)
        this.roles.add(basicUserRoleFactory.WHOLESALECUSTOMER)
        this.subscriberRoles.add(basicUserRoleFactory.SUBSCRIBERCUSTOMER)
        this.wholesaleRoles.add(basicUserRoleFactory.WHOLESALECUSTOMER)
    }

    /**      * @return the roles      */
    def getRoles() : BasicArrayList = {
        return this.roles
    }

    /**      * @return the subscriberRoles      */
    def getSubscriberRoles() : BasicArrayList = {
        return this.subscriberRoles
    }

    /**      * @return the wholesaleRoles      */
    def getWholesaleRoles() : BasicArrayList = {
        return this.wholesaleRoles
    }

}

object StoreRoleFactory {
    private val instance : StoreRoleFactory = new StoreRoleFactory()

    /**      * @return the instance      */
    def getInstance() : StoreRoleFactory = {
        return StoreRoleFactory.instance
    }

}


