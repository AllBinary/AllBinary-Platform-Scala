/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.address

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.address.StreetAddressData
import _root_.org.allbinary.data.tables.TableDataFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class StreetAddressesEntity private (super_1 : UserDbInitInfo, constructor_ : Unit) extends AbSqlBean(super_1) with StreetAddressesEntityInterface {

    val logUtil_StreetAddressesEntity : LogUtil = LogUtil.getInstance()

    private var userName : String = null

    def this(userName : String) = {
        this(new UserDbInitInfo(), ())
        this.userName = userName
    }

    def this() = {
        this(new UserDbInitInfo(), ())
    }

    def remove(index : Integer) : Unit = {
        try {
            var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereHashMap.put(UserData.USERNAME, this.userName)
            whereHashMap.put(StreetAddressData.ID, index.toString().asInstanceOf[String])
            super.deleteWhere(whereHashMap)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_StreetAddressesEntity.putF(this.commonStrings.SUCCESS, this, "remove")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.put(this.commonStrings.FAILURE, this, "remove", e)
                }
            }
        }
    }

    def add(address : StreetAddress) : Unit = {
        this.add(address, TableDataFactory.getInstance().INTEGER_MAX_VALUE_STRING)
    }

    private def add(address : StreetAddress, index : String) : Unit = {
        try {
            var values : BasicArrayList = new BasicArrayListD()
            values.add(index)
            values.add(this.userName)
            values.add(StringUtil.getInstance().EMPTY_STRING)
            values.add(address.getName())
            values.add(address.getStreet())
            values.add(address.getCity())
            values.add(address.getState())
            values.add(address.getCode())
            values.add(address.getCountry())
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            values.add(time)
            super.insert(values)
            this.setDefault(getLastId())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_StreetAddressesEntity.putF(this.commonStrings.SUCCESS, this, "add")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.put(this.commonStrings.FAILURE, this, "add", e)
                }
            }
        }
    }

    def update(address : StreetAddress) : Unit = {
        try {
            var addressHashMap : HashMap[Object, Object] = address.toHashMap().asInstanceOf[HashMap[Object, Object]]
            //String time = new String(new Long(calendar.getTimeInMillis()).toString());
            var whereKeyValuePairs : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereKeyValuePairs.put(StreetAddressData.ID, address.getId())
            whereKeyValuePairs.put(UserData.USERNAME, this.userName)
            super.updateWhere(whereKeyValuePairs, addressHashMap)
            this.setDefault(address.getId())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_StreetAddressesEntity.putF(this.commonStrings.SUCCESS, this, "update")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.put(this.commonStrings.FAILURE, this, "add", e)
                }
            }
        }
    }

    def getLastId() : String = {
        return super.getLargestIntegerInColumnWhere(StreetAddressData.ID, UserData.USERNAME, userName)
    }

    //retrieve one users addresses
    def get() : BasicArrayList = {
        try {
            var streetAddressVector : BasicArrayList = new BasicArrayListD()
            var keyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keyAndValue.put(UserData.USERNAME, this.userName)
            var addressList : BasicArrayList = super.getRows(keyAndValue)
            val size : Int = addressList.size()

            {
                var index : Int = 0
                while (index < size) {
                    var addressHashMap : HashMap[Object, Object] = addressList.get(index).asInstanceOf[HashMap[Object, Object]]
                    var streetAddress : StreetAddress = new StreetAddress(addressHashMap)
                    if (streetAddress != null) {
                        streetAddressVector.add(streetAddress)
                    }
                    index += 1
                }
            }
            return streetAddressVector
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def get(index : Integer) : StreetAddress = {
        try {
            //BasicArrayList streetAddressVector = new BasicArrayListD();
            var keyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keyAndValue.put(UserData.USERNAME, this.userName)
            keyAndValue.put(StreetAddressData.ID, index.toString())
            var addressHashMap : HashMap[Object, Object] = super.getRow(keyAndValue).asInstanceOf[HashMap[Object, Object]]
            if (addressHashMap != null) {
                return new StreetAddress(addressHashMap)
            } else {
                return null
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getDefault() : StreetAddress = {
        try {
            var addressHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var updateKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            updateKeyAndValue.put(StreetAddressData.DEFAULT, StreetAddressData.DEFAULT)
            updateKeyAndValue.put(UserData.USERNAME, this.userName)
            addressHashMap = super.getRow(updateKeyAndValue).asInstanceOf[HashMap[Object, Object]]
            if (addressHashMap != null) {
                var streetAddress : StreetAddress = new StreetAddress(addressHashMap)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.putF(this.commonStrings.SUCCESS, this, "getDefault")
                }
                return streetAddress
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.putF("No Default Address Found", this, "getDefault")
                }
                return null
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.put(this.commonStrings.FAILURE, this, "getDefault", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def setDefault(value : String) : Unit = {
        try {
            var updateKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var whereKeyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereKeyAndValue.put(UserData.USERNAME, this.userName)
            //remove old default value if it exist
            var streetAddress : StreetAddress = this.getDefault()
            if (streetAddress != null) {
                updateKeyAndValue.put(StreetAddressData.DEFAULT, StringUtil.getInstance().EMPTY_STRING)
                whereKeyAndValue.put(StreetAddressData.ID, streetAddress.getId())
                super.updateWhere(whereKeyAndValue, updateKeyAndValue)
            }
            //now update new default         
            whereKeyAndValue.put(StreetAddressData.ID, value)
            updateKeyAndValue.put(StreetAddressData.DEFAULT, StreetAddressData.DEFAULT)
            super.updateWhere(whereKeyAndValue, updateKeyAndValue)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_StreetAddressesEntity.putF(this.commonStrings.SUCCESS, this, "setDefault")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StreetAddressesEntity.put(this.commonStrings.FAILURE, this, "setShippingAddress", e)
                }
            }
        }
    }

    def getUserName() : String = {
        return this.userName
    }

    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(this.getTableName()).append(this.sqlStrings.START).append(StreetAddressData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_AUTO_INCREMENT_NOT_NULL).append(UserData.USERNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(StreetAddressData.DEFAULT).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(StreetAddressData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(StreetAddressData.STREET).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(StreetAddressData.CITY).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(StreetAddressData.STATE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(StreetAddressData.CODE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(StreetAddressData.COUNTRY).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(StreetAddressData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    //return super.createTable("CREATE TABLE " +  + tableData);
    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    def drop() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def dropTable() : String = {
        return super.dropTable()
    }

}


