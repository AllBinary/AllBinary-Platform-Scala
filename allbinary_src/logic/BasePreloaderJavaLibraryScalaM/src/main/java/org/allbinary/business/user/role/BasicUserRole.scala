/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role

import _root_.java.io.Serializable

class BasicUserRole(param_aRole : String, param_aDisplayValue : String, param_a_int_RoleId : Int, param_aSessionTimeout : Long, param_aSessionInactivityTimeout : Long) extends Serializable {

    private var m_int_RoleId : Int = 0

    private var role : String = null

    private var displayValue : String = null

    private var sessionTimeout : Long = 0L

    private var sessionInactivityTimeout : Long = 0L

    //Constructor
    {
        val aRole : String = param_aRole
        val aDisplayValue : String = param_aDisplayValue
        val a_int_RoleId : Int = param_a_int_RoleId
        val aSessionTimeout : Long = param_aSessionTimeout
        val aSessionInactivityTimeout : Long = param_aSessionInactivityTimeout
        this.m_int_RoleId = a_int_RoleId
        this.role = aRole
        this.displayValue = aDisplayValue
        this.sessionTimeout = aSessionTimeout
        this.sessionInactivityTimeout = aSessionInactivityTimeout
        BasicUserRoles.getInstance().roleVector.add(this)
    }

    def this(aRole : String, a_int_RoleId : Int, aSessionTimeout : Long, aSessionInactivityTimeout : Long) = {
        this(aRole, aRole, a_int_RoleId, aSessionTimeout, aSessionInactivityTimeout)
    }

    private def getRoleId() : Int = {
        return this.m_int_RoleId
    }

    def getRole() : String = {
        return this.role
    }

    def getSessionTimeout() : Long = {
        return this.sessionTimeout
    }

    def getSessionInactivityTimeout() : Long = {
        return this.sessionInactivityTimeout
    }

    def equals(basicUserRole : BasicUserRole) : Boolean = {
        if (this.getRoleId() == basicUserRole.getRoleId()) {
            return true
        }
        return false
    }

    override def toString() : String = {
        return this.getRole()
    }

}


