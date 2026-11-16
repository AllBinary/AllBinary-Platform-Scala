/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.org.allbinary.debug.DebugFactory
import _root_.org.allbinary.debug.NoDebug
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class LicenseInitInfo() {

    private var id : String = StringUtil.getInstance().EMPTY_STRING

    private var serverVector : BasicArrayList = new BasicArrayListD()

    def getLicenseId() : String = {
        return this.id
    }

    def getServer(index : Int) : String = {
        return this.serverVector.objectArray(index).asInstanceOf[String]
    }

    def getNumberOfServers() : Int = {
        return this.serverVector.size()
    }

    def setLicenseId(value : String) : Unit = {
        this.id = value
    }

    def clearServers() : Unit = {
        this.serverVector = new BasicArrayListD()
    }

    def setServer(value : String, index : Int) : Unit = {
        this.serverVector.addAt(index, value)
    }

    def addServer(value : String) : Unit = {
        this.serverVector.add(value)
    }

    def getServerList() : BasicArrayList = {
        return this.serverVector
    }

    def setServerList(servers : BasicArrayList) : Unit = {
        if (DebugFactory.getInstance() eq NoDebug.getInstance()) {
            this.serverVector = servers
        }
    }

}


