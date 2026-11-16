/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.java.util.Random
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.commerce.money.payment.Payment
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentInterface
import _root_.org.allbinary.data.generator.PaymentIdGenerator
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.control.crypt.SuperCrypt
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class PaymentEntity() extends AbSqlBean(new UserDbInitInfo()) with PaymentEntityInterface {

    val logUtil_PaymentEntity : LogUtil = LogUtil.getInstance()

    private val tableName : String = "payment"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    def getLastId(userName : String) : String = {
        return super.getLargestIntegerInColumnWhere(PaymentData.ID, UserData.USERNAME, userName)
    }

    def setDefault(userName : String, index : Integer) : Unit = {
        try {
            var updateKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var whereKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereKeyAndValue.put(UserData.USERNAME, userName)
            //remove old default value if it exist
            var paymentInterface : PaymentInterface = this.getDefault(userName)
            if (paymentInterface != null) {
                updateKeyAndValue.put(EntryData.getInstance().DEFAULT, StringUtil.getInstance().EMPTY_STRING)
                whereKeyAndValue.put(PaymentData.ID, paymentInterface.getId())
                super.updateWhere(whereKeyAndValue, updateKeyAndValue)
            }
            updateKeyAndValue.put(EntryData.getInstance().DEFAULT, EntryData.getInstance().DEFAULT)
            whereKeyAndValue.put(PaymentData.ID, index.toString())
            super.updateWhere(whereKeyAndValue, updateKeyAndValue)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_PaymentEntity.putF(this.commonStrings.SUCCESS, this, "setDefault")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentEntity.put(this.commonStrings.FAILURE, this, "setDefault", e)
                }
            }
        }
    }

    def get(userName : String) : BasicArrayList = {
        try {
            var paymentVector : BasicArrayList = new BasicArrayListD()
            var keyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keyAndValue.put(UserData.USERNAME, userName)
            var paymentList : BasicArrayList = super.getRows(keyAndValue)
            val size : Int = paymentList.size()

            {
                var index : Int = 0
                while (index < size) {
                    var paymentHashMap : HashMap[Object, Object] = paymentList.get(index).asInstanceOf[HashMap[Object, Object]]
                    var payment : Payment = new Payment(paymentHashMap)
                    if (payment != null) {
                        paymentVector.add(payment)
                    }
                    index += 1
                }
            }
            return paymentVector
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getDefault(userName : String) : PaymentInterface = {
        try {
            var paymentHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var updateKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            updateKeyAndValue.put(EntryData.getInstance().DEFAULT, EntryData.getInstance().DEFAULT)
            updateKeyAndValue.put(UserData.USERNAME, userName)
            paymentHashMap = super.getRow(updateKeyAndValue).asInstanceOf[HashMap[Object, Object]]
            if (paymentHashMap != null) {
                var payment : Payment = new Payment(paymentHashMap)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentEntity.putF(this.commonStrings.SUCCESS, this, "getDefault")
                }
                return payment.asInstanceOf[PaymentInterface]
            } else {
                return null
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentEntity.put(this.commonStrings.FAILURE, this, "getDefault", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def remove(userName : String, index : Integer) : Unit = {
        try {
            var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereHashMap.put(UserData.USERNAME, userName)
            whereHashMap.put(PaymentData.ID, index.toString().asInstanceOf[String])
            super.deleteWhere(whereHashMap)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_PaymentEntity.putF(this.commonStrings.SUCCESS, this, "remove")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentEntity.put(this.commonStrings.FAILURE, this, "remove", e)
                }
            }
        }
    }

    def add(userName : String, paymentInterface : PaymentInterface) : Unit = {
        try {
            var vector : BasicArrayList = new BasicArrayListD()
            //vector.add("auto_increment");
            vector.add(new PaymentIdGenerator().getNext())
            vector.add(userName)
            vector.add(StringUtil.getInstance().EMPTY_STRING)
            vector.add(paymentInterface.getName())
            vector.add(paymentInterface.getType())
            vector.add(paymentInterface.getExpiration())
            var random : Int = new Random().nextInt(SuperCrypt.KEYMAX)
            vector.add(new SuperCrypt(random).encrypt(paymentInterface.getNumber()))
            vector.add(new Integer(random).toString())
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            vector.add(time)
            super.insert(vector)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_PaymentEntity.putF(this.commonStrings.SUCCESS, this, "add")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentEntity.put(this.commonStrings.FAILURE, this, "add", e)
                }
            }
        }
    }

    final def createTableStatement() : String = {
        var entryData : EntryData = EntryData.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(PaymentData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_AUTO_INCREMENT_NOT_NULL).append(UserData.USERNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(entryData.DEFAULT).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(PaymentData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(PaymentData.TYPE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(PaymentData.EXPIRATION).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(PaymentData.NUMBER).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(entryData.ENCRYPTION).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(entryData.TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(PaymentData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    def drop() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def insert(values : BasicArrayList) : Unit = {
        super.insert(values)
    }

    //Needed for polyglot do not remove
    override def dropTable() : String = {
        return super.dropTable()
    }

}


