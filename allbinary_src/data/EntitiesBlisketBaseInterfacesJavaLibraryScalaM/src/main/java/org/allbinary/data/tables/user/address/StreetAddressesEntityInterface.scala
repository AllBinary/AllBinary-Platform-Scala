/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.address

import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait StreetAddressesEntityInterface extends BasicDataTableInterface {

    def remove(index : Integer) : Unit

    def add(address : StreetAddress) : Unit

    //public void add(StreetAddress address,String index);
    def update(address : StreetAddress) : Unit

    def getLastId() : String

    def getDefault() : StreetAddress

    def setDefault(value : String) : Unit

}


