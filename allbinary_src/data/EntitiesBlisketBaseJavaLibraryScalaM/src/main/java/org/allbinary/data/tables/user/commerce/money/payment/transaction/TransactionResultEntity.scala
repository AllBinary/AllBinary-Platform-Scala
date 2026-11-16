/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment.transaction

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionKeysFactory
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.TransactionResult
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.TransactionResultInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class TransactionResultEntity() extends AbSqlBean(new UserDbInitInfo()) with TransactionResultEntityInterface {

    val logUtil_TransactionResultEntity : LogUtil = LogUtil.getInstance()

    private val tableName : String = "vresults"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    def remove(userName : String, orderNumber : String) : Unit = {
        try {
            var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereHashMap.put(OrderData.ID, orderNumber.asInstanceOf[String])
            whereHashMap.put(UserData.USERNAME, userName)
            super.deleteWhere(whereHashMap)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_TransactionResultEntity.putF(this.commonStrings.SUCCESS, this, "remove")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_TransactionResultEntity.put(this.commonStrings.FAILURE, this, "remove", e)
                }
            }
        }
    }

    def add(userName : String, orderNumber : String, transactionResultInterface : TransactionResultInterface) : Unit = {
        try {
            var values : BasicArrayList = new BasicArrayListD()
            values.add(orderNumber)
            values.add(userName)
            values.addAllList(transactionResultInterface.getValues())
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new _root_.java.lang.Long(calendar.getTimeInMillis()).toString()
            values.add(time)
            values.add(time)
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_TransactionResultEntity.putF(this.commonStrings.SUCCESS, this, "add")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_TransactionResultEntity.put(this.commonStrings.FAILURE, this, "add", e)
                }
            }
        }
    }

    def getTransactionResultInterface(orderNumber : String) : TransactionResultInterface = {
        try {
            var resultHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var updateKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            updateKeyAndValue.put(OrderData.ID, orderNumber)
            resultHashMap = super.getRow(updateKeyAndValue).asInstanceOf[HashMap[Object, Object]]
            if (resultHashMap != null) {
                var transactionResult : TransactionResult = new TransactionResult(resultHashMap)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_TransactionResultEntity.putF(this.commonStrings.SUCCESS, this, "getTransactionResultInterface")
                }
                return transactionResult.asInstanceOf[TransactionResultInterface]
            } else {
                return null
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_TransactionResultEntity.put(this.commonStrings.FAILURE, this, "getTransactionResultInterface", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    final def createTableStatement() : String = {
        val paymentTransactionKeysFactory : PaymentTransactionKeysFactory = PaymentTransactionKeysFactory.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(OrderData.ID).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(UserData.USERNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        //unknown max size but 0 means transaction was a success
        stringBuffer.append(paymentTransactionKeysFactory.RESULT.toString()).append(this.sqlTypeStrings.MAX_INT_NOT_NULL).append(paymentTransactionKeysFactory.PNREF.toString()).append(this.sqlTypeStrings.TWELVE_CHAR_COLUMN_NOT_NULL)
        //unknown max size of alphanumeric data
        stringBuffer.append(paymentTransactionKeysFactory.RESPMSG.toString()).append(this.sqlTypeStrings.BLOB_NOT_NULL).append(paymentTransactionKeysFactory.AUTHCODE.toString()).append(this.sqlTypeStrings.SIX_CHAR_COLUMN_NOT_NULL).append(paymentTransactionKeysFactory.AVSADDR.toString()).append(this.sqlTypeStrings.ONE_CHAR_COLUMN_NOT_NULL)
        //Norwest only - unknown sizes/type of data
        stringBuffer.append(paymentTransactionKeysFactory.AVSZIP.toString()).append(this.sqlTypeStrings.ONE_CHAR_COLUMN_NOT_NULL).append(paymentTransactionKeysFactory.ORIGRESULT.toString()).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(paymentTransactionKeysFactory.STATUS.toString()).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        //codes available but not yet programmed
        stringBuffer.append(paymentTransactionKeysFactory.FRAUDCODE.toString()).append(this.sqlTypeStrings.TWO_INT_NOT_NULL)
        //msgs available but not yet programmed
        stringBuffer.append(paymentTransactionKeysFactory.FRAUDMSG.toString()).append(this.sqlTypeStrings.MAX_INT_NOT_NULL)
        //unknown size of number
        stringBuffer.append(paymentTransactionKeysFactory.ERRCODE.toString()).append(this.sqlTypeStrings.MAX_INT_NOT_NULL)
        //1-999 where 999 is the most likely fraud
        stringBuffer.append(paymentTransactionKeysFactory.SCORE.toString()).append(this.sqlTypeStrings.THREE_INT_NOT_NULL)
        //reason codes available but not yet programmed
        stringBuffer.append(paymentTransactionKeysFactory.REASON1.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.REASON2.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.REASON3.toString())
        //exceptions available but not yet programmed
        stringBuffer.append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.EXCEPTION1.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.EXCEPTION2.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.EXCEPTION3.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.EXCEPTION4.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.EXCEPTION5.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.EXCEPTION6.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(paymentTransactionKeysFactory.EXCEPTION7.toString()).append(this.sqlTypeStrings.FOUR_INT_NOT_NULL).append(EntryData.getInstance().LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(OrderData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    /*      public String getTable()      {      return super.getTable();      }      **/
    override def dropTable() : String = {
        return super.dropTable()
    }

}


