/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.modules.configuration.UserConfigurationInterface
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface
import _root_.org.allbinary.logic.control.validate.ValidationInterface

trait UserInterface extends TableMappingInterface with ValidationInterface {

    def setUserName(value : String) : Unit

    def setPrefixName(value : String) : Unit

    def setFirstName(value : String) : Unit

    def setLastName(value : String) : Unit

    def setMiddleName(value : String) : Unit

    def setSuffixName(value : String) : Unit

    def setCompany(value : String) : Unit

    def setPositionAtCompany(value : String) : Unit

    def setMainEmail(value : String) : Unit

    def setSecondaryEmail(value : String) : Unit

    def setHomePhone(value : String) : Unit

    def setCellPhone(value : String) : Unit

    def setWorkPhone(value : String) : Unit

    def setOtherContact(value : String) : Unit

    def setElectronicContact(value : String) : Unit

    def setFax(value : String) : Unit

    def setRole(aRole : UserRole) : Unit

    def setEncryption(value : String) : Unit

    def setSecret(value : String) : Unit

    def setPassword(value : String) : Unit

    def setPermissions(value : String) : Unit

    def enable() : Unit

    def setEnable(enable : String) : Unit

    def getUserName() : String

    def getPrefixName() : String

    def getFirstName() : String

    def getLastName() : String

    def getMiddleName() : String

    def getSuffixName() : String

    def getCompany() : String

    def getPositionAtCompany() : String

    def getMainEmail() : String

    def getSecondaryEmail() : String

    def getHomePhone() : String

    def getCellPhone() : String

    def getWorkPhone() : String

    def getOtherContact() : String

    def getElectronicContact() : String

    def getFax() : String

    def getRole() : UserRole

    def getEncryption() : String

    def getSecret() : String

    def getPassword() : String

    def getPermissions() : String

    def getUserConfigurationInterface() : UserConfigurationInterface

    def setUserConfigurationInterface(userConfigurationInterface : UserConfigurationInterface) : Unit

    def toPasswordHashMap() : HashMap[Object, Object]

    // RequestParams requestParams);
    def validateSession(weblisketSession : WeblisketSessionInterface) : Unit

    def updateSession(weblisketSession : WeblisketSessionInterface) : Unit

    def isSessionValid() : _root_.java.lang.Boolean

}


