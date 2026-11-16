/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait UserEntityInterface extends BasicDataTableInterface {

    def getAdministrators() : BasicArrayList

    def getStoreManagers(storeFrontInterface : StoreFrontInterface) : BasicArrayList

    def getCustomers() : BasicArrayList

    def getUsersWithRole(userRole : UserRole) : BasicArrayList

    def getUsers(storeFrontInterface : StoreFrontInterface) : BasicArrayList

    def getUser(userName : String) : UserInterface

    //public String getUserRole(String userName, String password);
    def login(userName : String, password : String) : String

    def deleteWhere(key : String, value : String) : Unit

    def insert(values : BasicArrayList) : Unit

    def update(userName : String, updatedValues : HashMap[Object, Object]) : Unit

}


