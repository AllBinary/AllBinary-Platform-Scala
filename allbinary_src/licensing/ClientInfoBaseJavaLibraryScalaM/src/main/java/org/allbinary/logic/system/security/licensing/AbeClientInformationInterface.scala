/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList

trait AbeClientInformationInterface {

    def init() : Unit

    def getOperatingSystemInterface() : GenericOperatingSystem

    def getName() : String

    def getSpecialName() : String

    def getVersion() : String

    def getLicenseId() : String

    def getLicenseServers() : BasicArrayList

    def getLicenseServer(index : Int) : String

    def getNumberOfLicenseServers() : Int

    def toHashtable() : ABHashtable[Object, Object]

    def isSameId(alicenseId : String) : Boolean

    def isLargerOrDifferentServerList(vector : BasicArrayList) : Boolean

    def isHardSale() : Boolean

    def toShortString() : String

}


