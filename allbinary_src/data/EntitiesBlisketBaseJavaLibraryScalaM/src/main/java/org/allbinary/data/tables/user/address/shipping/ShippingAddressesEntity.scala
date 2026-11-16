/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.address.shipping

import _root_.org.allbinary.data.tables.user.address.StreetAddressesEntity

class ShippingAddressesEntity(param_userName : String) extends StreetAddressesEntity(param_userName) {

    private val TABLENAME : String = "shipping"

    //Constructor
    {
        val userName : String = param_userName
        setTableName(this.TABLENAME)
    }

}


