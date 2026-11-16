/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role

import _root_.java.io.Serializable
import _root_.org.allbinary.business.user.UserFactoryInterface

class UserRole(param_aBasicUserRole : BasicUserRole, param_aUserFactoryInterface : UserFactoryInterface) extends Serializable {

    private var basicUserRole : BasicUserRole = null

    private var userFactoryInterface : UserFactoryInterface = null

    //Constructor
    {
        val aBasicUserRole : BasicUserRole = param_aBasicUserRole
        val aUserFactoryInterface : UserFactoryInterface = param_aUserFactoryInterface
        this.basicUserRole = aBasicUserRole
        this.userFactoryInterface = aUserFactoryInterface
    }

    override def toString() : String = {
        return this.basicUserRole.toString()
    }

    def getBasicUserRole() : BasicUserRole = {
        return this.basicUserRole
    }

    def getUserFactory() : UserFactoryInterface = {
        return this.userFactoryInterface
    }

    def getSessionTimeout() : Long = {
        return this.basicUserRole.getSessionTimeout()
    }

    def getSessionInactivityTimeout() : Long = {
        return this.basicUserRole.getSessionInactivityTimeout()
    }

}


