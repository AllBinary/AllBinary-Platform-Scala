/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.UserFactoryInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringValidationUtil

/**  *  * @author user  */
class UserRoleB(param_aBasicUserRole : BasicUserRole, param_aUserFactoryInterface : UserFactoryInterface) extends UserRole(param_aBasicUserRole, param_aUserFactoryInterface) {
    import _root_.org.allbinary.business.user.role.UserRoleB.{*}

    //Constructor
    {
        val aBasicUserRole : BasicUserRole = param_aBasicUserRole
        val aUserFactoryInterface : UserFactoryInterface = param_aUserFactoryInterface
        UserRoleB.roleVector.add(this)
    }

}

object UserRoleB {
    var roleVector : BasicArrayList = new BasicArrayListD()

    def getRole(role : String) : UserRole = this.synchronized {
        UserRoleFactory.getInstance()
        if (!StringValidationUtil.getInstance().isEmpty(role)) {
            val roleVector : BasicArrayList = UserRoleB.getAll()
            val size : Int = roleVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var userRole : UserRole = roleVector.get(index).asInstanceOf[UserRole]
                    if (role.compareTo(userRole.toString()) == 0) {
                        return userRole
                    }
                    index += 1
                }
            }
        }
        throw new Exception("Unable to get role - Unknown Role = " + role)
    }

    def getAll() : BasicArrayList = {
        UserRoleFactory.getInstance()
        return UserRoleB.roleVector
    }

}


