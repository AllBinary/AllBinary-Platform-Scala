/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment.gateway

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayEncryptedMapping
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterfaceFactory
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentType
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentTypeUtil
import _root_.org.allbinary.data.generator.PaymentGatewayIdGenerator
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.control.crypt.SuperCrypt
import _root_.org.allbinary.logic.string.StringMaker

class PaymentGatewayEntity() extends AbSqlBean(new UserDbInitInfo()) with PaymentGatewayEntityInterface {

    val logUtil_PaymentGatewayEntity : LogUtil = LogUtil.getInstance()

    private val tableName : String = "paymentgateways"

    //note that xslt files format output from a paymentgateway for a client when required
    //Constructor
    {
        this.setTableName(this.tableName)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
            this.logUtil_PaymentGatewayEntity.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def add(paymentGatewayInterface : PaymentGatewayInterface) : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_PaymentGatewayEntity.putF(this.commonStrings.START, this, "add")
            }
            var vector : BasicArrayList = new BasicArrayListD()
            vector.add(new PaymentGatewayIdGenerator().getNext())
            //values.add(StringUtil.getInstance());
            vector.addAllList(new PaymentGatewayEncryptedMapping(paymentGatewayInterface).toVector())
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            vector.add(time)
            vector.add(time)
            super.insert(vector)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_PaymentGatewayEntity.putF(this.commonStrings.END, this, "add")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentGatewayEntity.put(this.commonStrings.FAILURE, this, "add", e)
                }
            }
        }
    }

    def update(paymentGatewayInterface : PaymentGatewayInterface) : Unit = {
        try {
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            paymentGatewayInterface.setLastModified(time)
            var whereKeyValuePairs : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereKeyValuePairs.put(StoreFrontData.getInstance().NAME.toString(), paymentGatewayInterface.getStoreName())
            whereKeyValuePairs.put(PaymentGatewayData.NAME.toString(), paymentGatewayInterface.getName())
            if (whereKeyValuePairs.get(EntryData.getInstance().TIMECREATED) != null) {
                throw new Exception("Don't update TimeCreated for update")
            }
            var updateHashMap : HashMap[Object, Object] = new PaymentGatewayEncryptedMapping(paymentGatewayInterface).toHashMap().asInstanceOf[HashMap[Object, Object]]
            super.updateWhere(whereKeyValuePairs, updateHashMap)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_PaymentGatewayEntity.putF(this.commonStrings.SUCCESS, this, "update")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentGatewayEntity.put(this.commonStrings.FAILURE, this, "update", e)
                }
            }
        }
    }

    def getPaymentGatewayInterface(storeName : String, paymentType : BasicPaymentType) : PaymentGatewayInterface = {
        try {
            var paymentGatewayHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var whereKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereKeyAndValue.put(StoreFrontData.getInstance().NAME.toString(), storeName)
            whereKeyAndValue.put(PaymentGatewayData.NAME.toString(), paymentType.getName())
            paymentGatewayHashMap = super.getRow(whereKeyAndValue).asInstanceOf[HashMap[Object, Object]]
            if (paymentGatewayHashMap != null) {
                var userName : String = paymentGatewayHashMap.get(UserData.USERNAME.toString()).asInstanceOf[String]
                var password : String = paymentGatewayHashMap.get(UserData.PASSWORD.toString()).asInstanceOf[String]
                var special1 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL1.toString()).asInstanceOf[String]
                var special2 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL2.toString()).asInstanceOf[String]
                var special3 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL3.toString()).asInstanceOf[String]
                var special4 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL4.toString()).asInstanceOf[String]
                var special5 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL5.toString()).asInstanceOf[String]
                var special6 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL6.toString()).asInstanceOf[String]
                var special7 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL7.toString()).asInstanceOf[String]
                var special8 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL8.toString()).asInstanceOf[String]
                var special9 : String = paymentGatewayHashMap.get(PaymentGatewayData.SPECIAL9.toString()).asInstanceOf[String]
                var superCrypt : SuperCrypt = new SuperCrypt(PaymentGatewayData.CRYPTNUM)
                paymentGatewayHashMap.put(UserData.USERNAME.toString(), superCrypt.decrypt(userName))
                paymentGatewayHashMap.put(UserData.PASSWORD.toString(), superCrypt.decrypt(password))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL1.toString(), superCrypt.decrypt(special1))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL2.toString(), superCrypt.decrypt(special2))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL3.toString(), superCrypt.decrypt(special3))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL4.toString(), superCrypt.decrypt(special4))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL5.toString(), superCrypt.decrypt(special5))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL6.toString(), superCrypt.decrypt(special6))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL7.toString(), superCrypt.decrypt(special7))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL8.toString(), superCrypt.decrypt(special8))
                paymentGatewayHashMap.put(PaymentGatewayData.SPECIAL9.toString(), superCrypt.decrypt(special9))
                var paymentGatewayInterface : PaymentGatewayInterface = new PaymentGatewayInterfaceFactory().getInstance(paymentGatewayHashMap)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentGatewayEntity.putF(this.commonStrings.SUCCESS, this, "getPaymentGatewayInterface()")
                }
                return paymentGatewayInterface
            } else {
                return new PaymentGatewayInterfaceFactory().getInstance(paymentType)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentGatewayEntity.put("Command Failed for paymentType: " + paymentType.getName(), this, "getPaymentGatewayInterface", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def findPaymentTypeVectorByStore(storeName : String) : BasicArrayList = {
        try {
            var paymentGatewayNameVector : BasicArrayList = new BasicArrayListD()
            //HashMap whereKeyAndValue = StdUtil.getInstance().createHashMap();
            paymentGatewayNameVector = super.getColumnWhere(PaymentGatewayData.NAME.toString(), StoreFrontData.getInstance().NAME.toString(), storeName)
            if (paymentGatewayNameVector != null) {
                var paymentGatewayVector : BasicArrayList = new BasicArrayListD()
                var size : Int = paymentGatewayNameVector.size()

                {
                    var i : Int = 0
                    while (i < size) {
                        var paymentTypeString : String = paymentGatewayNameVector.get(i).asInstanceOf[String]
                        var paymentType : BasicPaymentType = BasicPaymentTypeUtil.getInstance().get(paymentTypeString)
                        paymentGatewayVector.add(paymentType)
                        i += 1
                    }
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentGatewayEntity.putF(this.commonStrings.SUCCESS, this, "findPaymentTypeVectorByStore()")
                }
                return paymentGatewayVector
            } else {
                return new BasicArrayListD()
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentGatewayEntity.put(this.commonStrings.FAILURE, this, "findPaymentTypeVectorByStore", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def remove(storeName : String, paymentType : BasicPaymentType) : Unit = {
        try {
            var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereHashMap.put(StoreFrontData.getInstance().NAME.toString(), storeName)
            whereHashMap.put(PaymentGatewayData.NAME.toString(), paymentType.getName())
            super.deleteWhere(whereHashMap)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_PaymentGatewayEntity.putF(this.commonStrings.SUCCESS, this, "remove")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentGatewayEntity.put(this.commonStrings.FAILURE, this, "remove", e)
                }
            }
        }
    }

    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.START)
        stringBuffer.append(PaymentGatewayData.ID.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_AUTO_INCREMENT_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().ENABLE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(StoreFrontData.getInstance().NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.NAME.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentData.METHOD)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.MODE.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        //testing or live
        stringBuffer.append(PaymentGatewayData.TESTPROTOCOL.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.TESTSERVER.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.TESTPORT.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.TESTPATH.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SERVERPROTOCOL.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SERVER.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SERVERPORT.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SERVERPATH.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(UserData.USERNAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(UserData.PASSWORD)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.TIMEOUT.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.PROXYPROTOCOL.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.PROXYSERVER.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.PROXYPORT.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.PROXYPATH.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.PROXYUSERNAME.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.PROXYPASSWORD.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.PROXYTIMEOUT.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL1.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL2.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL3.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL4.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL5.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL6.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL7.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL8.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentGatewayData.SPECIAL9.toString())
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().LASTMODIFIED)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().TIMECREATED)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(this.sqlStrings.PRIMARY_KEY)
        stringBuffer.append(PaymentGatewayData.ID.toString())
        stringBuffer.append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    /*     public String getTable()     {     return super.getTable();     }*/
    override def dropTable() : String = {
        return super.dropTable()
    }

}


