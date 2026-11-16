/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class BasicUserRoles {
    import _root_.org.allbinary.business.user.role.BasicUserRoles.{*}

    val roleVector : BasicArrayList = new BasicArrayListD()

    def getRole(role : String) : BasicUserRole = {
        val roleVector : BasicArrayList = this.getAll()
        val size : Int = roleVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var userRole : BasicUserRole = roleVector.get(index).asInstanceOf[BasicUserRole]
                if (role.compareTo(userRole.toString()) == 0) {
                    return userRole
                }
                index += 1
            }
        }
        throw new Exception("Unable to get role - Unknown Role")
    }

    def getAll() : BasicArrayList = {
        return this.roleVector
    }

}

object BasicUserRoles {
    private val instance : BasicUserRoles = new BasicUserRoles()

    /**      * @return the instance      */
    def getInstance() : BasicUserRoles = {
        return BasicUserRoles.instance
    }

}


