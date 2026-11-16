/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface

//import org.allbinary.business.user.commerce.money.payment.gateway.*;
trait PaymentGatewayInterface extends TableMappingInterface {

    //public String getGatewayId();
    def getEnable() : String

    def getStoreName() : String

    def getName() : String

    def getPaymentMethod() : String

    def getMode() : String

    def getTestProtocol() : String

    def getTestServer() : String

    def getTestPort() : String

    def getTestPath() : String

    def getServerProtocol() : String

    def getServer() : String

    def getServerPort() : String

    def getServerPath() : String

    def getUserName() : String

    def getPassword() : String

    def getProxyProtocol() : String

    def getProxyServer() : String

    def getProxyPath() : String

    def getProxyPort() : String

    def getProxyUserName() : String

    def getProxyPassword() : String

    def getTimeout() : String

    def getProxyTimeout() : String

    def getSpecial1() : String

    def getSpecial2() : String

    def getSpecial3() : String

    def getSpecial4() : String

    def getSpecial5() : String

    def getSpecial6() : String

    def getSpecial7() : String

    def getSpecial8() : String

    def getSpecial9() : String

    def getLastModified() : String

    def getTimeEntered() : String

    //public void setGatewayId(String value);
    def setEnable(value : String) : Unit

    def setStoreName(value : String) : Unit

    def setName(value : String) : Unit

    def setPaymentMethod(value : String) : Unit

    def setMode(value : String) : Unit

    def setTestProtocol(value : String) : Unit

    def setTestServer(value : String) : Unit

    def setTestPort(value : String) : Unit

    def setTestPath(value : String) : Unit

    def setServerProtocol(value : String) : Unit

    def setServer(value : String) : Unit

    def setServerPort(value : String) : Unit

    def setServerPath(value : String) : Unit

    def setUserName(value : String) : Unit

    def setPassword(value : String) : Unit

    def setProxyProtocol(value : String) : Unit

    def setProxyServer(value : String) : Unit

    def setProxyPath(value : String) : Unit

    def setProxyPort(value : String) : Unit

    def setProxyUserName(value : String) : Unit

    def setProxyPassword(value : String) : Unit

    def setTimeout(value : String) : Unit

    def setProxyTimeout(value : String) : Unit

    def setSpecial1(value : String) : Unit

    def setSpecial2(value : String) : Unit

    def setSpecial3(value : String) : Unit

    def setSpecial4(value : String) : Unit

    def setSpecial5(value : String) : Unit

    def setSpecial6(value : String) : Unit

    def setSpecial7(value : String) : Unit

    def setSpecial8(value : String) : Unit

    def setSpecial9(value : String) : Unit

    def setLastModified(value : String) : Unit

    def setTimeEntered(value : String) : Unit

    def toHashMap(isEncrypted : Boolean) : HashMap[Object, Object]

    def toVector(isEncrypted : Boolean) : BasicArrayList

}


