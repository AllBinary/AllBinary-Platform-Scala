/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment


trait PaymentInterface {

    def setName(value : String) : Unit

    def setType(value : String) : Unit

    def setExpiration(value : String) : Unit

    def setNumber(value : String) : Unit

    def getId() : String

    def getName() : String

    def getType() : String

    def getExpiration() : String

    def getEncryption() : String

    def getNumber() : String

    def getLastFour() : String

    def isDefault() : Boolean

}


