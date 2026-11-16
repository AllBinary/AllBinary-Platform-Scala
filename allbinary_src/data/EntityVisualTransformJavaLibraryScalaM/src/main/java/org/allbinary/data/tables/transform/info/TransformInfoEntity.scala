/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.transform.info

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.control.crypt.Encoder
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoFactoryInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigAndManipulatorFactoryBase
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.generator.TransformInfoObjectConfigGeneratorFactoryInterface

class TransformInfoEntity(param_transformInfoObjectConfigGeneratorFactoryInterface : TransformInfoObjectConfigGeneratorFactoryInterface, param_transformInfoObjectConfigAndManipulatorFactoryInterface : TransformInfoObjectConfigAndManipulatorFactoryBase, param_transformInfoFactoryInterface : TransformInfoFactoryInterface) extends AbSqlBean(new UserDbInitInfo()) with TransformInfoEntityInterface {

    val logUtil_TransformInfoEntity : LogUtil = LogUtil.getInstance()

    val tableName : String = "transforminfo"

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var transformInfoFactoryInterface : TransformInfoFactoryInterface = null

    private var transformInfoObjectConfigAndManipulatorFactoryInterface : TransformInfoObjectConfigAndManipulatorFactoryBase = null

    private var transformInfoObjectConfigGeneratorFactoryInterface : TransformInfoObjectConfigGeneratorFactoryInterface = null

    //Constructor
    {
        val transformInfoObjectConfigGeneratorFactoryInterface : TransformInfoObjectConfigGeneratorFactoryInterface = param_transformInfoObjectConfigGeneratorFactoryInterface
        val transformInfoObjectConfigAndManipulatorFactoryInterface : TransformInfoObjectConfigAndManipulatorFactoryBase = param_transformInfoObjectConfigAndManipulatorFactoryInterface
        val transformInfoFactoryInterface : TransformInfoFactoryInterface = param_transformInfoFactoryInterface
        this.setTableName(this.tableName)
        this.transformInfoObjectConfigGeneratorFactoryInterface = transformInfoObjectConfigGeneratorFactoryInterface
        this.transformInfoObjectConfigAndManipulatorFactoryInterface = transformInfoObjectConfigAndManipulatorFactoryInterface
        this.transformInfoFactoryInterface = transformInfoFactoryInterface
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_TransformInfoEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_TransformInfoEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(TransformInfoData.getInstance().NAME, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_TransformInfoEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_TransformInfoEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    def get(name : String, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : TransformInfoInterface = {
        var transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(transformInfoData.NAME, name)
        var hashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
        if (hashMap != null) {
            //TWB - Encoder for GAE for XML using JIQL
            var anyType : Object = hashMap.get(transformInfoData.OBJECTCONFIG)
            if (anyType != null) {
                var string : String = anyType.asInstanceOf[String]
                hashMap.put(transformInfoData.OBJECTCONFIG, new String(Encoder.decode(string)))
            }
            var objectData : Object = hashMap.get(transformInfoData.DATA)
            if (objectData != null) {
                var string : String = objectData.asInstanceOf[String]
                hashMap.put(transformInfoData.DATA, new String(Encoder.decode(string)))
            }
            //TWB - End - Encoder for GAE for XML using JIQL
            return this.transformInfoFactoryInterface.getInstance(hashMap, propertiesHashMap, pageContext)
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def getObjectConfigs(storeName : String) : BasicArrayList = {
        var objectConfigVector : BasicArrayList = new BasicArrayListD()
        var objectConfigColumnVector : BasicArrayList = this.getColumnWhere(TransformInfoData.getInstance().OBJECTCONFIG, StoreFrontData.getInstance().NAME, storeName)
        var size : Int = objectConfigColumnVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var objectConfigString : String = objectConfigColumnVector.get(i).asInstanceOf[String]
                //TWB - Encoder for GAE for XML using JIQL
                objectConfigString = new String(Encoder.decode(objectConfigString))
                objectConfigVector.add(this.transformInfoObjectConfigAndManipulatorFactoryInterface.getInstance(this.abeClientInformation, this.asInstanceOf[TransformInfoInterface], DomDocumentHelper.create(objectConfigString)))
                i += 1
            }
        }
        return objectConfigVector
    }

    def getNames(storeName : String) : BasicArrayList = {
        var viewNameVector : BasicArrayList = new BasicArrayListD()
        var columnVector : BasicArrayList = this.getColumnWhere(TransformInfoData.getInstance().NAME, StoreFrontData.getInstance().NAME, storeName)
        var size : Int = columnVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var viewNameString : String = columnVector.get(i).asInstanceOf[String]
                viewNameVector.add(viewNameString)
                i += 1
            }
        }
        return viewNameVector
    }

    final def createTableStatement() : String = {
        var transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.START)
        stringBuffer.append(transformInfoData.NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        //transformInfoData.GROUP
        stringBuffer.append(StoreFrontData.getInstance().NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(transformInfoData.OBJECTFILENAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(transformInfoData.OBJECT)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(transformInfoData.OBJECTCONFIGFILENAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(transformInfoData.OBJECTCONFIG)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(transformInfoData.TEMPLATEFILENAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(transformInfoData.TEMPLATE)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(transformInfoData.DATAFILENAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(transformInfoData.DATA)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().LASTMODIFIED)
        stringBuffer.append(EntryData.getInstance().TIMECREATED)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(this.sqlStrings.PRIMARY_KEY)
        stringBuffer.append(transformInfoData.NAME)
        stringBuffer.append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(TransformInfoData.getInstance().NAME, updatedValues.get(TransformInfoData.getInstance().NAME).asInstanceOf[String], updatedValues)
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

}


