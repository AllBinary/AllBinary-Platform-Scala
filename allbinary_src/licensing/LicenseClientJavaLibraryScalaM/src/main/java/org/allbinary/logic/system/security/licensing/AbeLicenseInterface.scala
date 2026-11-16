/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.util.BasicArrayList

//import org.allbinary.logic.system.security.licensing*;
trait AbeLicenseInterface {

    def hasKey() : Boolean

    def getKey(keyName : String) : String

    //public void setKey(String keyValue);
    def getLicenseId() : String

    def getServers() : BasicArrayList

    def getSpecial() : String

    def getLicenseType() : LicenseType

    def isValid() : Boolean

    override def toString() : String

}


