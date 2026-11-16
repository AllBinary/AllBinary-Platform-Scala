/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker

class InitInfoEntity() extends InitSql(new UserDbInitInfo()) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val NAME : String = "InitInfoEntity"

    private val NOTHING : String = "NOTHING"

    //private final String tableName  = "licenseServerInitdata";
    private val tableName : String = "initdata"

    private var tableData : String = null

    private val NOT_IN_DB : String = "Not In DB"

    private val METHOD_GET : String = "get()"

    private val METHOD_IS : String = "is()"

    private val METHOD_ADD : String = "add()"

    private val CREATED_SUCCESS : String = " Created Successfully"

    private val FAILED_TO_CREATE : String = "Failed to create "

    //Constructor
    {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.START)
        stringBuffer.append(this.NOTHING)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(InitInfo.getInstance().TESTING)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(InitInfo.getInstance().TESTHTMLPATH)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(InitInfo.getInstance().MAINPATH)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(this.sqlStrings.PRIMARY_KEY)
        stringBuffer.append(this.NOTHING)
        stringBuffer.append(this.sqlStrings.END)
        this.tableData = stringBuffer.toString()
        this.setTable(this.tableName)
    }

    def get() : Boolean = {
        try {
            var keyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keyAndValue.put(this.NOTHING, this.NOTHING)
            var hashMap : HashMap[Object, Object] = getRow(keyAndValue).asInstanceOf[HashMap[Object, Object]]
            if (hashMap != null) {
                InitInfo.getInstance().set(hashMap)
                return true
            } else {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
                    PreLogUtil.put(this.NOT_IN_DB, NAME, this.METHOD_GET)
                }
                return false
            }
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, this.NAME, this.METHOD_GET, e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def is() : Boolean = {
        try {
            var keyAndValue : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keyAndValue.put(this.NOTHING, this.NOTHING)
            var hashMap : HashMap[Object, Object] = getRow(keyAndValue).asInstanceOf[HashMap[Object, Object]]
            if (hashMap != null) {
                return true
            } else {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADER)) {
                    PreLogUtil.put(this.NOT_IN_DB, this.NAME, this.METHOD_IS)
                }
                return false
            }
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, this.NAME, this.METHOD_IS, e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def update() : Unit = {
        updateWhere(NOTHING, NOTHING, InitInfo.getInstance().toHashMap())
    }

    def add() : Unit = {
        try {
            var values : BasicArrayList = new BasicArrayListD()
            values.add(this.NOTHING)
            values.add(InitInfo.getInstance().getTesting())
            values.add(InitInfo.getInstance().getTestHtmlPath())
            values.add(InitInfo.getInstance().getMainPath())
            insert(values)
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, this.NAME, this.METHOD_ADD, e)
                }
            }
        }
    }

    def createTable() : String = {
        if (super.createTable(this.tableData)) {
            return this.tableName + this.CREATED_SUCCESS
        } else {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.FAILED_TO_CREATE)
            stringBuffer.append(this.tableData)
            stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
            return stringBuffer.toString()
        }
        throw new IllegalStateException()
    }

}


