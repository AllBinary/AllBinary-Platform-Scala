/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.workflow

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.control.workflow.DbWorkFlowFactory
import _root_.org.allbinary.logic.control.workflow.WorkFlowData
import _root_.org.allbinary.logic.control.workflow.WorkFlowInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class WorkFlowEntity() extends AbSqlBean(new UserDbInitInfo()) with WorkFlowEntityInterface {

    val logUtil_WorkFlowEntity : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    val tableName : String = "workflows"

    private val METHOD_GET : String = "get()"

    private val METHOD_UPDATE : String = "update"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_WorkFlowEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_WorkFlowEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def delete(name : String, storeName : String) : Unit = {
        try {
            val keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keysAndValues.put(WorkFlowData.getInstance().NAME, name)
            keysAndValues.put(StoreFrontData.getInstance().NAME, storeName)
            super.deleteWhere(keysAndValues)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_WorkFlowEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_WorkFlowEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    def get(name : String, storeName : String) : WorkFlowInterface = {
        try {
            val keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keysAndValues.put(WorkFlowData.getInstance().NAME, name)
            keysAndValues.put(StoreFrontData.getInstance().NAME, storeName)
            val hashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
            return DbWorkFlowFactory.getInstance().getInstance(this.abeClientInformation, hashMap).asInstanceOf[WorkFlowInterface]
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_WorkFlowEntity.put(this.commonStrings.FAILURE, this, METHOD_GET, e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_WorkFlowEntity.put(this.commonStrings.FAILURE, this, METHOD_GET, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def get(storeName : String) : BasicArrayList = {
        try {
            var workFlowsVector : BasicArrayList = new BasicArrayListD()
            var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keysAndValues.put(StoreFrontData.getInstance().NAME, storeName)
            var hashMapVector : BasicArrayList = super.getRows(keysAndValues)
            var size : Int = hashMapVector.size()

            {
                var i : Int = 0
                while (i < size) {
                    var workFlowHashMap : HashMap[Object, Object] = hashMapVector.get(i).asInstanceOf[HashMap[Object, Object]]
                    if (workFlowHashMap != null) {
                        workFlowsVector.add(DbWorkFlowFactory.getInstance().getInstance(abeClientInformation, workFlowHashMap))
                    }
                    i += 1
                }
            }
            return workFlowsVector
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_WorkFlowEntity.put(this.commonStrings.FAILURE, this, this.METHOD_GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        try {
            var wherekeysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            wherekeysAndValues.put(WorkFlowData.getInstance().NAME, updatedValues.get(WorkFlowData.getInstance().NAME).asInstanceOf[String])
            wherekeysAndValues.put(StoreFrontData.getInstance().NAME, updatedValues.get(StoreFrontData.getInstance().NAME).asInstanceOf[String])
            super.updateWhere(wherekeysAndValues, updatedValues)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_WorkFlowEntity.put(this.commonStrings.FAILURE, this, METHOD_UPDATE, e)
                }
            }
        }
    }

    final def createTableStatement() : String = {
        val workFlowData : WorkFlowData = WorkFlowData.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(workFlowData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(StoreFrontData.getInstance().NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DynamicObjectData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(workFlowData.DATA).append(this.sqlTypeStrings.BLOB_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(workFlowData.NAME).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

}


