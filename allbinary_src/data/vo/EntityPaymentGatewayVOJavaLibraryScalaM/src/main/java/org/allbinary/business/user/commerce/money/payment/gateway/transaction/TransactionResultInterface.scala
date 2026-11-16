/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.transaction

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

trait TransactionResultInterface {

    override def toString() : String

    def getValues() : BasicArrayList

    def getResult() : String

    def getPnRef() : String

    def getRespMsg() : String

    def getAvsAddr() : String

    def getAvsZip() : String

    def getOrigResult() : String

    def getStatus() : String

    def getFraudCode() : String

    def getFraudMsg() : String

    def getErrCode() : String

    def getScore() : String

    def getReason1() : String

    def getReason2() : String

    def getReason3() : String

    def getException1() : String

    def getException2() : String

    def getException3() : String

    def getException4() : String

    def getException5() : String

    def getException6() : String

    def getException7() : String

}


