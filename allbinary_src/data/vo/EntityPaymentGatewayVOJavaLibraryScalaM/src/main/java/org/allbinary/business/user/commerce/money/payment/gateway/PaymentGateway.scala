/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.control.crypt.SuperCrypt
import _root_.org.allbinary.logic.string.StringUtil

class PaymentGateway(param_hashMap : HashMap[Object, Object]) extends PaymentGatewayInterface {

    //private String gatewayId;
    private var storeName : String = null

    private var name : String = null

    private var enable : String = null

    private var paymentMethod : String = null

    private var mode : String = null

    private var testProtocol : String = null

    private var testServer : String = null

    private var testPort : String = null

    private var testPath : String = null

    private var serverProtocol : String = null

    private var server : String = null

    private var serverPort : String = null

    private var serverPath : String = null

    private var timeout : String = null

    private var userName : String = null

    private var password : String = null

    private var proxyProtocol : String = null

    private var proxyServer : String = null

    private var proxyPort : String = null

    private var proxyPath : String = null

    private var proxyUserName : String = null

    private var proxyPassword : String = null

    private var proxyTimeout : String = null

    private var special1 : String = null

    private var special2 : String = null

    private var special3 : String = null

    private var special4 : String = null

    private var special5 : String = null

    private var special6 : String = null

    private var special7 : String = null

    private var special8 : String = null

    private var special9 : String = null

    private var lastModified : String = null

    private var timeEntered : String = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        this.getFormData(hashMap)
    }

    def getFormData(hashMap : HashMap[Object, Object]) : Unit = {
        var stringUtil : StringUtil = StringUtil.getInstance()
        val empty : String = stringUtil.EMPTY_STRING
        //if(this.gatewayId==null) this.gatewayId = empty;
        this.storeName = hashMap.get(StoreFrontData.getInstance().NAME.toString()).asInstanceOf[String]
        //if(this.storeName==null) this.storeName = empty;
        this.name = hashMap.get(PaymentGatewayData.NAME.toString()).asInstanceOf[String]
        //if(this.gatewayName==null) this.gatewayName = empty;
        this.enable = stringUtil.getNonNull(hashMap.get(EntryData.getInstance().ENABLE.toString()).asInstanceOf[String])
        this.paymentMethod = stringUtil.getNonNull(hashMap.get(PaymentData.METHOD.toString()).asInstanceOf[String])
        this.mode = stringUtil.getNonNull(hashMap.get(PaymentGatewayData.MODE.toString()).asInstanceOf[String])
        this.testProtocol = stringUtil.getNonNull(hashMap.get(PaymentGatewayData.TESTPROTOCOL.toString()).asInstanceOf[String])
        this.testServer = stringUtil.getNonNull(hashMap.get(PaymentGatewayData.TESTSERVER.toString()).asInstanceOf[String])
        this.testPort = stringUtil.getNonNull(hashMap.get(PaymentGatewayData.TESTPORT.toString()).asInstanceOf[String])
        this.testPath = hashMap.get(PaymentGatewayData.TESTPATH.toString()).asInstanceOf[String]
        if (this.testPath == null) {
            this.testPath = empty
        }
        this.serverProtocol = hashMap.get(PaymentGatewayData.SERVERPROTOCOL.toString()).asInstanceOf[String]
        if (this.serverProtocol == null) {
            this.serverProtocol = empty
        }
        this.server = hashMap.get(PaymentGatewayData.SERVER.toString()).asInstanceOf[String]
        if (this.server == null) {
            this.server = empty
        }
        this.serverPort = hashMap.get(PaymentGatewayData.SERVERPORT.toString()).asInstanceOf[String]
        if (this.serverPort == null) {
            this.serverPort = empty
        }
        this.serverPath = hashMap.get(PaymentGatewayData.SERVERPATH.toString()).asInstanceOf[String]
        if (this.serverPath == null) {
            this.serverPath = empty
        }
        this.userName = hashMap.get(UserData.USERNAME.toString()).asInstanceOf[String]
        if (this.userName == null) {
            this.userName = empty
        }
        this.password = hashMap.get(UserData.PASSWORD.toString()).asInstanceOf[String]
        if (this.password == null) {
            this.password = empty
        }
        this.timeout = hashMap.get(PaymentGatewayData.TIMEOUT.toString()).asInstanceOf[String]
        if (this.timeout == null) {
            this.timeout = empty
        }
        this.proxyProtocol = hashMap.get(PaymentGatewayData.PROXYPROTOCOL.toString()).asInstanceOf[String]
        if (this.proxyProtocol == null) {
            this.proxyProtocol = empty
        }
        this.proxyServer = hashMap.get(PaymentGatewayData.PROXYSERVER.toString()).asInstanceOf[String]
        if (this.proxyServer == null) {
            this.proxyServer = empty
        }
        this.proxyPort = hashMap.get(PaymentGatewayData.PROXYPORT.toString()).asInstanceOf[String]
        if (this.proxyPort == null) {
            this.proxyPort = empty
        }
        this.proxyPath = hashMap.get(PaymentGatewayData.PROXYPATH.toString()).asInstanceOf[String]
        if (this.proxyPath == null) {
            this.proxyPath = empty
        }
        this.proxyUserName = hashMap.get(PaymentGatewayData.PROXYUSERNAME.toString()).asInstanceOf[String]
        if (this.proxyUserName == null) {
            this.proxyUserName = empty
        }
        this.proxyPassword = hashMap.get(PaymentGatewayData.PROXYPASSWORD.toString()).asInstanceOf[String]
        if (this.proxyPassword == null) {
            this.proxyPassword = empty
        }
        this.proxyTimeout = hashMap.get(PaymentGatewayData.PROXYTIMEOUT.toString()).asInstanceOf[String]
        if (this.proxyTimeout == null) {
            this.proxyTimeout = empty
        }
        this.special1 = hashMap.get(PaymentGatewayData.SPECIAL1.toString()).asInstanceOf[String]
        if (this.special1 == null) {
            this.special1 = empty
        }
        this.special2 = hashMap.get(PaymentGatewayData.SPECIAL2.toString()).asInstanceOf[String]
        if (this.special2 == null) {
            this.special2 = empty
        }
        this.special3 = hashMap.get(PaymentGatewayData.SPECIAL3.toString()).asInstanceOf[String]
        if (this.special3 == null) {
            this.special3 = empty
        }
        this.special4 = hashMap.get(PaymentGatewayData.SPECIAL4.toString()).asInstanceOf[String]
        if (this.special4 == null) {
            this.special4 = empty
        }
        this.special5 = hashMap.get(PaymentGatewayData.SPECIAL5.toString()).asInstanceOf[String]
        if (this.special5 == null) {
            this.special5 = empty
        }
        this.special6 = hashMap.get(PaymentGatewayData.SPECIAL6.toString()).asInstanceOf[String]
        if (this.special6 == null) {
            this.special6 = empty
        }
        this.special7 = hashMap.get(PaymentGatewayData.SPECIAL7.toString()).asInstanceOf[String]
        if (this.special7 == null) {
            this.special7 = empty
        }
        this.special8 = hashMap.get(PaymentGatewayData.SPECIAL8.toString()).asInstanceOf[String]
        if (this.special8 == null) {
            this.special8 = empty
        }
        this.special9 = hashMap.get(PaymentGatewayData.SPECIAL9.toString()).asInstanceOf[String]
        if (this.special9 == null) {
            this.special9 = empty
        }
        this.lastModified = hashMap.get(EntryData.getInstance().LASTMODIFIED.toString()).asInstanceOf[String]
        if (this.lastModified == null) {
            this.lastModified = empty
        }
        this.timeEntered = hashMap.get(EntryData.getInstance().TIMECREATED.toString()).asInstanceOf[String]
        if (this.timeEntered == null) {
            this.timeEntered = empty
        }
    }

    /*    public String getGatewayId()    {       return this.gatewayId;    }    */
    def getStoreName() : String = {
        return this.storeName
    }

    def getName() : String = {
        return this.name
    }

    def getEnable() : String = {
        return this.enable
    }

    def getPaymentMethod() : String = {
        return this.paymentMethod
    }

    def getMode() : String = {
        return this.mode
    }

    def getTestProtocol() : String = {
        return this.testProtocol
    }

    def getTestServer() : String = {
        return this.testServer
    }

    def getTestPort() : String = {
        return this.testPort
    }

    def getTestPath() : String = {
        return this.testPath
    }

    def getServerProtocol() : String = {
        return this.serverProtocol
    }

    def getServer() : String = {
        return this.server
    }

    def getServerPort() : String = {
        return this.serverPort
    }

    def getServerPath() : String = {
        return this.serverPath
    }

    def getUserName() : String = {
        return this.userName
    }

    def getPassword() : String = {
        return this.password
    }

    def getProxyProtocol() : String = {
        return this.proxyProtocol
    }

    def getProxyServer() : String = {
        return this.proxyServer
    }

    def getProxyPath() : String = {
        return this.proxyPath
    }

    def getProxyPort() : String = {
        return this.proxyPort
    }

    def getProxyUserName() : String = {
        return this.proxyUserName
    }

    def getProxyPassword() : String = {
        return this.proxyPassword
    }

    def getTimeout() : String = {
        return this.timeout
    }

    def getProxyTimeout() : String = {
        return this.proxyTimeout
    }

    def getSpecial1() : String = {
        return this.special1
    }

    def getSpecial2() : String = {
        return this.special2
    }

    def getSpecial3() : String = {
        return this.special3
    }

    def getSpecial4() : String = {
        return this.special4
    }

    def getSpecial5() : String = {
        return this.special5
    }

    def getSpecial6() : String = {
        return this.special6
    }

    def getSpecial7() : String = {
        return this.special7
    }

    def getSpecial8() : String = {
        return this.special8
    }

    def getSpecial9() : String = {
        return this.special9
    }

    def getLastModified() : String = {
        return this.lastModified
    }

    def getTimeEntered() : String = {
        return this.timeEntered
    }

    /*    public void setGatewayId(String value)    {       this.gatewayId = value;    }    */
    def setEnable(value : String) : Unit = {
        this.enable = value
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    def setName(value : String) : Unit = {
        this.name = value
    }

    def setPaymentMethod(value : String) : Unit = {
        this.paymentMethod = value
    }

    def setMode(value : String) : Unit = {
        this.mode = value
    }

    def setTestProtocol(value : String) : Unit = {
        this.testProtocol = value
    }

    def setTestServer(value : String) : Unit = {
        this.testServer = value
    }

    def setTestPort(value : String) : Unit = {
        this.testPort = value
    }

    def setTestPath(value : String) : Unit = {
        this.testPath = value
    }

    def setServerProtocol(value : String) : Unit = {
        this.serverProtocol = value
    }

    def setServer(value : String) : Unit = {
        this.server = value
    }

    def setServerPort(value : String) : Unit = {
        this.serverPort = value
    }

    def setServerPath(value : String) : Unit = {
        this.serverPath = value
    }

    def setTimeout(value : String) : Unit = {
        this.timeout = value
    }

    def setUserName(value : String) : Unit = {
        this.userName = value
    }

    def setPassword(value : String) : Unit = {
        this.password = value
    }

    def setProxyProtocol(value : String) : Unit = {
        this.proxyProtocol = value
    }

    def setProxyServer(value : String) : Unit = {
        this.proxyServer = value
    }

    def setProxyPort(value : String) : Unit = {
        this.proxyPort = value
    }

    def setProxyPath(value : String) : Unit = {
        this.proxyPath = value
    }

    def setProxyUserName(value : String) : Unit = {
        this.proxyUserName = value
    }

    def setProxyPassword(value : String) : Unit = {
        this.proxyPassword = value
    }

    def setProxyTimeout(value : String) : Unit = {
        this.proxyTimeout = value
    }

    def setSpecial1(value : String) : Unit = {
        this.special1 = value
    }

    def setSpecial2(value : String) : Unit = {
        this.special2 = value
    }

    def setSpecial3(value : String) : Unit = {
        this.special3 = value
    }

    def setSpecial4(value : String) : Unit = {
        this.special4 = value
    }

    def setSpecial5(value : String) : Unit = {
        this.special5 = value
    }

    def setSpecial6(value : String) : Unit = {
        this.special6 = value
    }

    def setSpecial7(value : String) : Unit = {
        this.special7 = value
    }

    def setSpecial8(value : String) : Unit = {
        this.special8 = value
    }

    def setSpecial9(value : String) : Unit = {
        this.special9 = value
    }

    def setLastModified(value : String) : Unit = {
        this.lastModified = value
    }

    def setTimeEntered(value : String) : Unit = {
        this.timeEntered = value
    }

    def toHashMap() : HashMap[Object, Object] = {
        return this.toHashMap(true)
    }

    def toHashMap(isEncrypted : Boolean) : HashMap[Object, Object] = {
        var paymentGatewayHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        paymentGatewayHashMap.put(EntryData.getInstance().ENABLE, this.enable)
        paymentGatewayHashMap.put(StoreFrontData.getInstance().NAME.toString(), this.storeName)
        //   PaymentGatewayData.ID.toString(),this.gatewayId);
        paymentGatewayHashMap.put(PaymentGatewayData.NAME.toString(), this.getName())
        paymentGatewayHashMap.put(PaymentData.METHOD.toString(), this.paymentMethod)
        paymentGatewayHashMap.put(PaymentGatewayData.MODE.toString(), this.mode)
        paymentGatewayHashMap.put(PaymentGatewayData.TESTPROTOCOL.toString(), this.testProtocol)
        paymentGatewayHashMap.put(PaymentGatewayData.TESTSERVER.toString(), this.testServer)
        paymentGatewayHashMap.put(PaymentGatewayData.TESTPORT.toString(), this.testPort)
        paymentGatewayHashMap.put(PaymentGatewayData.TESTPATH.toString(), this.testPath)
        paymentGatewayHashMap.put(PaymentGatewayData.SERVERPROTOCOL.toString(), this.serverProtocol)
        paymentGatewayHashMap.put(PaymentGatewayData.SERVER.toString(), this.server)
        paymentGatewayHashMap.put(PaymentGatewayData.SERVERPORT.toString(), this.serverPort)
        paymentGatewayHashMap.put(PaymentGatewayData.SERVERPATH.toString(), this.serverPath)
        if (isEncrypted) {
            var superCrypt : SuperCrypt = new SuperCrypt(PaymentGatewayData.CRYPTNUM)
            paymentGatewayHashMap.put(UserData.USERNAME.toString(), superCrypt.encrypt(this.userName))
            paymentGatewayHashMap.put(UserData.PASSWORD.toString(), superCrypt.encrypt(this.password))
        } else {
            paymentGatewayHashMap.put(UserData.USERNAME.toString(), this.userName)
            paymentGatewayHashMap.put(UserData.PASSWORD.toString(), this.password)
        }
        paymentGatewayHashMap.put(PaymentGatewayData.TIMEOUT.toString(), this.timeout)
        paymentGatewayHashMap.put(PaymentGatewayData.PROXYPROTOCOL.toString(), this.proxyProtocol)
        paymentGatewayHashMap.put(PaymentGatewayData.PROXYSERVER.toString(), this.proxyServer)
        paymentGatewayHashMap.put(PaymentGatewayData.PROXYPORT.toString(), this.proxyPort)
        paymentGatewayHashMap.put(PaymentGatewayData.PROXYPATH.toString(), this.proxyPath)
        paymentGatewayHashMap.put(PaymentGatewayData.PROXYUSERNAME.toString(), this.proxyUserName)
        paymentGatewayHashMap.put(PaymentGatewayData.PROXYPASSWORD.toString(), this.proxyPassword)
        paymentGatewayHashMap.put(PaymentGatewayData.PROXYTIMEOUT.toString(), this.proxyTimeout)
        if (isEncrypted) {
            var superCrypt : SuperCrypt = new SuperCrypt(PaymentGatewayData.CRYPTNUM)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL1.toString(), superCrypt.encrypt(this.special1))
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL2.toString(), superCrypt.encrypt(this.special2))
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL3.toString(), superCrypt.encrypt(this.special3))
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL4.toString(), superCrypt.encrypt(this.special4))
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL5.toString(), superCrypt.encrypt(this.special5))
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL6.toString(), superCrypt.encrypt(this.special6))
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL7.toString(), superCrypt.encrypt(this.special7))
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL8.toString(), superCrypt.encrypt(this.special8))
        } else {
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL1.toString(), this.special1)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL2.toString(), this.special2)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL3.toString(), this.special3)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL4.toString(), this.special4)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL5.toString(), this.special5)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL6.toString(), this.special6)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL7.toString(), this.special7)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL8.toString(), this.special8)
            paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL9.toString(), this.special9)
        }
        paymentGatewayHashMap.put(EntryData.getInstance().LASTMODIFIED.toString(), this.lastModified)
        // EntryData.getInstance().TIMECREATED.toString(),this.timeEntered);
        return paymentGatewayHashMap
    }

    def toVector() : BasicArrayList = {
        return this.toVector(true)
    }

    def toVector(isEncrypted : Boolean) : BasicArrayList = {
        var updateVector : BasicArrayList = new BasicArrayListD()
        //updateVector.add(this.gatewayId);
        updateVector.add(this.enable)
        updateVector.add(this.storeName)
        updateVector.add(this.getName())
        updateVector.add(this.paymentMethod)
        updateVector.add(this.mode)
        updateVector.add(this.testProtocol)
        updateVector.add(this.testServer)
        updateVector.add(this.testPort)
        updateVector.add(this.testPath)
        updateVector.add(this.serverProtocol)
        updateVector.add(this.server)
        updateVector.add(this.serverPort)
        updateVector.add(this.serverPath)
        if (isEncrypted) {
            var superCrypt : SuperCrypt = new SuperCrypt(PaymentGatewayData.CRYPTNUM)
            updateVector.add(superCrypt.encrypt(this.userName))
            updateVector.add(superCrypt.encrypt(this.password))
        } else {
            updateVector.add(this.userName)
            updateVector.add(this.password)
        }
        updateVector.add(this.timeout)
        updateVector.add(this.proxyProtocol)
        updateVector.add(this.proxyServer)
        updateVector.add(this.proxyPort)
        updateVector.add(this.proxyPath)
        updateVector.add(this.proxyUserName)
        updateVector.add(this.proxyPassword)
        updateVector.add(this.proxyTimeout)
        if (isEncrypted) {
            var superCrypt : SuperCrypt = new SuperCrypt(PaymentGatewayData.CRYPTNUM)
            updateVector.add(superCrypt.encrypt(this.special1))
            updateVector.add(superCrypt.encrypt(this.special2))
            updateVector.add(superCrypt.encrypt(this.special3))
            updateVector.add(superCrypt.encrypt(this.special4))
            updateVector.add(superCrypt.encrypt(this.special5))
            updateVector.add(superCrypt.encrypt(this.special6))
            updateVector.add(superCrypt.encrypt(this.special7))
            updateVector.add(superCrypt.encrypt(this.special8))
            updateVector.add(superCrypt.encrypt(this.special9))
        } else {
            updateVector.add(this.special1)
            updateVector.add(this.special2)
            updateVector.add(this.special3)
            updateVector.add(this.special4)
            updateVector.add(this.special5)
            updateVector.add(this.special6)
            updateVector.add(this.special7)
            updateVector.add(this.special8)
            updateVector.add(this.special9)
        }
        //updateVector.add(this.timeEntered);
        return updateVector
    }

    def getKey() : Object = {
        return (new PaymentGatewayPrimaryKey(this.getStoreName(), this.getName())).asInstanceOf[Object]
    }

}


