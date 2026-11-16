/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request.session

import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.role.UserRole

/**  *  * @author user  */
trait WeblisketSessionInterface {

    def clear() : Unit

    def getAttempts() : Integer

    def getAuthentication() : String

    //BasketInterface getBasket() throws Exception;
    def getCreationTime() : Long

    def getId() : String

    def getLastAccessedTime() : Long

    def getOrder() : OrderInterface

    def getPassword() : String

    def getPaymentMethod() : String

    def getRole() : UserRole

    def getStoreName() : String

    def getTimeout() : String

    def getUserName() : String

    def getWebAppPath() : String

    def removeBasket() : Unit

    def setAttempts(value : Integer) : Unit

    def setAuthenticated() : Unit

    def setAuthenticated(value : Boolean) : Unit

    def setPassword(password : String) : Unit

    def setPaymentMethod(value : String) : Unit

    def setRole(aRole : UserRole) : Unit

    def setStoreName(value : String) : Unit

    def setTimeout(value : String) : Unit

    def setUserName(userName : String) : Unit

}


