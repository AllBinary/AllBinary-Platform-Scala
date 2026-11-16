/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.generator

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class IdGeneratorEntity() extends AbSqlBean(new UserDbInitInfo()) with IdGeneratorEntityInterface {

    val logUtil_IdGeneratorEntity : LogUtil = LogUtil.getInstance()

    private val tableName : String = "idgenerator"

    private var tableData : String = null

    val NAME : String = "NAME"

    val VALUE : String = "VALUE"

    //Constructor
    {
        this.tableData = new StringMaker().append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(VALUE).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(NAME).append(this.sqlStrings.END).toString()
        super.setTableName(this.tableName)
    }

    def get(name : String) : _root_.java.lang.Long = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(this.NAME, name)
        var hashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
        if ((hashMap.get(this.NAME).asInstanceOf[String]).compareTo(name) != 0) {
            throw new Exception("results do not match")
        }
        var value : String = hashMap.get(this.VALUE).asInstanceOf[String]
        return _root_.java.lang.Long.parseLong(value)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            //values.add(time);
            super.insert(values)
            this.logUtil_IdGeneratorEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
        } catch {
            case e : Exception => {
                this.logUtil_IdGeneratorEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
            }
        }
    }

    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(this.NAME, value)
            this.logUtil_IdGeneratorEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
        } catch {
            case e : Exception => {
                this.logUtil_IdGeneratorEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
            }
        }
    }

    def update(name : String, value : _root_.java.lang.Long) : Unit = {
        val map : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        map.put(this.NAME, name)
        map.put(this.VALUE, value.toString())
        this.update(map)
    }

    def update(hashMap : HashMap[Object, Object]) : Unit = {
        //hashMap.put(EntryData.getInstance().LASTMODIFIED, time);
        super.updateWhere(this.NAME, hashMap.get(this.NAME).asInstanceOf[String], hashMap)
    }

    def createTable() : String = {
        var returnStr : String = super.createTable(tableData)
        return returnStr
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def deleteWhere(key : String, value : String) : Unit = {
        super.deleteWhere(key, value)
    }

}


