/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db


trait DatabaseConnectionInfoInterface {

    def getUrl() : String

    def getJdbcDriver() : String

    def getName() : String

    def getUserName() : String

    def getPassword() : String

    def getHost() : String

    def getSchema() : String

    def getServer() : String

    def getPort() : String

    def setJdbcDriver(value : String) : Unit

    def setName(value : String) : Unit

    def setUserName(value : String) : Unit

    def setPassword(value : String) : Unit

    def setSchema(value : String) : Unit

    def setServer(value : String) : Unit

    def setPort(value : String) : Unit

    def getUserNameKey() : String

    def getPasswordKey() : String

}


