/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.users

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.data.tables.user.UserEntityInterface
import _root_.org.allbinary.logic.StdUtil

class StoreFrontUsersStatistics(param_storeFrontInterface : StoreFrontInterface) extends StoreFrontUsersStatisticsInterface {

    private var totalNumberOfUsers : _root_.java.lang.Long = null

    private var totalUsersByRoleHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        this.totalUsersByRoleHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val userEntityInterface : UserEntityInterface = UserEntityFactory.getInstance()
        //BasicArrayList userVector = userEntityInterface.getUsers(storeFrontInterface);
        val userVector : BasicArrayList = userEntityInterface.getCustomers()
        this.totalNumberOfUsers = new _root_.java.lang.Long(userVector.size())
        val size : Int = userVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var userInterface : UserInterface = userVector.get(index).asInstanceOf[UserInterface]
                var nextUserRole : UserRole = userInterface.getRole()
                var currentNumberOfUsersForRole : _root_.java.lang.Long = this.getNewTotal(nextUserRole)
                this.totalUsersByRoleHashMap.put(nextUserRole, currentNumberOfUsersForRole)
                index += 1
            }
        }
    }

    private def getNewTotal(userRole : UserRole) : _root_.java.lang.Long = {
        var numberOfUsersForRoleLong : _root_.java.lang.Long = this.totalUsersByRoleHashMap.get(userRole).asInstanceOf[_root_.java.lang.Long]
        if (numberOfUsersForRoleLong == null) {
            numberOfUsersForRoleLong = new _root_.java.lang.Long(0)
        }
        return new _root_.java.lang.Long(numberOfUsersForRoleLong.longValue() + 1)
    }

    def getNumberOfUsers() : _root_.java.lang.Long = {
        return this.totalNumberOfUsers
    }

    def getNumberOfUsersByRole(role : String) : _root_.java.lang.Long = {
        var totalForRole : _root_.java.lang.Long = this.totalUsersByRoleHashMap.get(role).asInstanceOf[_root_.java.lang.Long]
        return totalForRole
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(StoreFrontUsersStatisticsData.getInstance().NUMBEROFUSERS, this.getNumberOfUsers().toString())
        var setOfUserRoles : Set[Object] = this.totalUsersByRoleHashMap.keySet().asInstanceOf[Set[Object]]
        var nextUserRole : UserRole = null
        val userRoleArray : Array[Object] = setOfUserRoles.toArray()
        val size : Int = userRoleArray.length

        {
            var index : Int = 0
            while (index < size) {
                nextUserRole = userRoleArray(index).asInstanceOf[UserRole]
                var totalForRole : _root_.java.lang.Long = this.totalUsersByRoleHashMap.get(nextUserRole).asInstanceOf[_root_.java.lang.Long]
                hashMap.put(nextUserRole.toString(), totalForRole.toString())
                index += 1
            }
        }
        return hashMap
    }

    def toVector() : BasicArrayList = {
        return null
    }

    def getKey() : Object = {
        return null
    }

}


