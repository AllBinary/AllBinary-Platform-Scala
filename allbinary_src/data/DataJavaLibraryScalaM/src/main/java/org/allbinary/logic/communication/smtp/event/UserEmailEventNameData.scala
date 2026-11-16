/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.event

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.logic.StdUtil

class UserEmailEventNameData(param_eventHandlerName : String) {
    import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.{INSTALLER as _, EXCEPTION as _, LOGGEDEXCEPTION as _, ERROR as _, OUTOFMEMORY as _, ADMINGENERATINGSTATICPAGES as _, STOREERROROCCURRED as _, STOREOUTOFMEMORY as _, STORECREATED as _, STOREOPENED as _, STORECLOSED as _, STOREGENERATINGSTATICPAGES as _, PRODUCTISOUT as _, PRODUCTISAVAILABLE as _, PRODUCTISOLD as _, PRODUCTISONSALE as _, PRODUCTSALEISOVER as _, ORDERPREPROCESSING as _, ORDERPROCESSING as _, ORDERCANCELLED as _, ORDERPARTIALLYSHIPPED as _, ORDERSHIPPED as _, QUOTEREQUEST as _, NEWPASSWORD as _, *}
    def INSTALLER : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.INSTALLER
    def EXCEPTION : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.EXCEPTION
    def LOGGEDEXCEPTION : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.LOGGEDEXCEPTION
    def ERROR : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.ERROR
    def OUTOFMEMORY : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.OUTOFMEMORY
    def ADMINGENERATINGSTATICPAGES : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.ADMINGENERATINGSTATICPAGES
    def STOREERROROCCURRED : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.STOREERROROCCURRED
    def STOREOUTOFMEMORY : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.STOREOUTOFMEMORY
    def STORECREATED : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.STORECREATED
    def STOREOPENED : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.STOREOPENED
    def STORECLOSED : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.STORECLOSED
    def STOREGENERATINGSTATICPAGES : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.STOREGENERATINGSTATICPAGES
    def PRODUCTISOUT : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.PRODUCTISOUT
    def PRODUCTISAVAILABLE : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.PRODUCTISAVAILABLE
    def PRODUCTISOLD : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.PRODUCTISOLD
    def PRODUCTISONSALE : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.PRODUCTISONSALE
    def PRODUCTSALEISOVER : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.PRODUCTSALEISOVER
    def ORDERPREPROCESSING : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.ORDERPREPROCESSING
    def ORDERPROCESSING : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.ORDERPROCESSING
    def ORDERCANCELLED : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.ORDERCANCELLED
    def ORDERPARTIALLYSHIPPED : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.ORDERPARTIALLYSHIPPED
    def ORDERSHIPPED : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.ORDERSHIPPED
    def QUOTEREQUEST : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.QUOTEREQUEST
    def NEWPASSWORD : UserEmailEventNameData = _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData.NEWPASSWORD

    private var eventNameId : Int = 0

    private var eventHandlerName : String = null

    //Constructor
    {
        val eventHandlerName : String = param_eventHandlerName
        this.eventHandlerName = eventHandlerName
        this.initNextId()
        UserEmailEventNameData.userNameEvenNameHashMap.put(this.eventHandlerName, this)
    }

    private def initNextId() : Unit = this.synchronized {
        this.eventNameId = UserEmailEventNameData.nextId
        UserEmailEventNameData.nextId += 1
    }

    def isEvent(userEmailEventNameString : String) : Boolean = {
        return UserEmailEventNameData.userNameEvenNameHashMap.containsKey(userEmailEventNameString)
    }

    override def toString() : String = {
        return this.eventHandlerName
    }

}

object UserEmailEventNameData {
    private var userNameEvenNameHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    private var nextId : Int = 0

    val INSTALLER : UserEmailEventNameData = new UserEmailEventNameData("Installer")

    //Program wide
    val EXCEPTION : UserEmailEventNameData = new UserEmailEventNameData("Exception")

    val LOGGEDEXCEPTION : UserEmailEventNameData = new UserEmailEventNameData("Logged Exception")

    val ERROR : UserEmailEventNameData = new UserEmailEventNameData("Error")

    val OUTOFMEMORY : UserEmailEventNameData = new UserEmailEventNameData("Out Of Memory Error")

    //Admin Section
    val ADMINGENERATINGSTATICPAGES : UserEmailEventNameData = new UserEmailEventNameData("Admin Generating Static Pages")

    //Store Admin Section
    val STOREERROROCCURRED : UserEmailEventNameData = new UserEmailEventNameData("Store Error Occurred")

    val STOREOUTOFMEMORY : UserEmailEventNameData = new UserEmailEventNameData("Store Out Of Memory Error")

    val STORECREATED : UserEmailEventNameData = new UserEmailEventNameData("Store Created")

    val STOREOPENED : UserEmailEventNameData = new UserEmailEventNameData("Store Opened")

    val STORECLOSED : UserEmailEventNameData = new UserEmailEventNameData("Store Closed")

    val STOREGENERATINGSTATICPAGES : UserEmailEventNameData = new UserEmailEventNameData("Store Generating Static Pages")

    //Inventory
    val PRODUCTISOUT : UserEmailEventNameData = new UserEmailEventNameData("Product Is Out")

    val PRODUCTISAVAILABLE : UserEmailEventNameData = new UserEmailEventNameData("Product Is Available")

    val PRODUCTISOLD : UserEmailEventNameData = new UserEmailEventNameData("Product Is Old")

    val PRODUCTISONSALE : UserEmailEventNameData = new UserEmailEventNameData("Product Is On Sale")

    val PRODUCTSALEISOVER : UserEmailEventNameData = new UserEmailEventNameData("Product Sale Is Over")

    //Orders
    val ORDERPREPROCESSING : UserEmailEventNameData = new UserEmailEventNameData(OrderHistoryData.PREPROCESSING)

    val ORDERPROCESSING : UserEmailEventNameData = new UserEmailEventNameData(OrderHistoryData.PROCESSING)

    val ORDERCANCELLED : UserEmailEventNameData = new UserEmailEventNameData(OrderHistoryData.CANCELLED)

    val ORDERPARTIALLYSHIPPED : UserEmailEventNameData = new UserEmailEventNameData(OrderHistoryData.PARTIALLYSHIPPED)

    val ORDERSHIPPED : UserEmailEventNameData = new UserEmailEventNameData(OrderHistoryData.SHIPPED)

    //Misc
    val QUOTEREQUEST : UserEmailEventNameData = new UserEmailEventNameData("Quote Request")

    val NEWPASSWORD : UserEmailEventNameData = new UserEmailEventNameData("New Password")

    def getInstance(userEmailEventNameString : String) : UserEmailEventNameData = this.synchronized {
        var userEmailEventNameData : UserEmailEventNameData = UserEmailEventNameData.userNameEvenNameHashMap.get(userEmailEventNameString).asInstanceOf[UserEmailEventNameData]
        if (userEmailEventNameData == null) {
            throw new Exception()
        } else {
            return userEmailEventNameData
        }
        throw new IllegalStateException()
    }

}


