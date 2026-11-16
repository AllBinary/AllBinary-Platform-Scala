/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.admin.store.customer

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.UserFactoryInterface
import _root_.org.allbinary.business.user.UserInterface

class CustomerStoreAdminUserFactory() extends UserFactoryInterface {

    def getInstance() : UserInterface = {
        return new CustomerStoreAdminUser()
    }

    def getInstance(hashMap : HashMap[Object, Object]) : UserInterface = {
        return new CustomerStoreAdminUser(hashMap)
    }

}


