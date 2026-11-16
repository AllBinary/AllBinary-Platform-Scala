/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.business.user.role.UserRoleB
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.logic.string.StringValidationUtil

class CreateUserFactory private() {
    import _root_.org.allbinary.business.user.CreateUserFactory.{*}

}

object CreateUserFactory {
    def getInstance(hashMap : HashMap[Object, Object]) : UserInterface = {
        if (hashMap != null) {
            var roleString : String = hashMap.get(UserRoleData.NAME.toString()).asInstanceOf[String]
            if (!StringValidationUtil.getInstance().isEmpty(roleString)) {
                var role : UserRole = UserRoleB.getRole(roleString)
                return role.getUserFactory().getInstance(hashMap)
            } else {
                throw new Exception("No Role Specified")
            }
        } else {
            throw new Exception("Null HashMap")
        }
        throw new IllegalStateException()
    }

}


