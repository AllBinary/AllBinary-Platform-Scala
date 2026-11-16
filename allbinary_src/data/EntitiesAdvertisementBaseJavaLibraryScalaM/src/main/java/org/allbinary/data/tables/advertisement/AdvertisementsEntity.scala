/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.advertisement

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.business.advertisement.AdvertisementData
import _root_.org.allbinary.business.advertisement.AdvertisementInterface
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class AdvertisementsEntity() extends AbSqlBean(new UserDbInitInfo()) with AdvertisementsEntityInterface {

    val logUtil_AdvertisementsEntity : LogUtil = LogUtil.getInstance()

    val tableName : String = "advertisements"

    private val _INDEX : String = "_index"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    /*      public void insert(BasicArrayList values)      {      try      {      super.insert(values);                if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.putF(this.commonStrings.SUCCESS, this, INSERT);      }      }      catch(Exception e)      {      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.put(this.commonStrings.FAILURE,this,INSERT,e);      }      }      }      */
    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(EntryData.getInstance().ID, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AdvertisementsEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_AdvertisementsEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    //AdvertisementsInterface
    def get(storeName : String) : BasicArrayList = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(StoreFrontData.getInstance().NAME, storeName)
        var hashMapVector : BasicArrayList = super.getRows(keysAndValues)
        var vector : BasicArrayList = new BasicArrayListD()
        val size : Int = hashMapVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var hashMap : HashMap[Object, Object] = hashMapVector.get(index).asInstanceOf[HashMap[Object, Object]]
                index += 1
            }
        }
        return vector
    }

    def get(storeName : String, advertismentName : String) : AdvertisementInterface = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(StoreFrontData.getInstance().NAME, storeName)
        keysAndValues.put(AdvertisementData.getInstance().NAME, advertismentName)
        var hashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
        // else 
        return null
    }

    final def createTableStatement() : String = {
        var advertisementData : AdvertisementData = AdvertisementData.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.getTableName()).append(this.sqlStrings.START).append(advertisementData.NAME).append(_INDEX).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(advertisementData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(StoreFrontData.getInstance().NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(advertisementData.DESCRIPTION).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        //AdComponent that uses the AdViewComponent
        stringBuffer.append(DynamicObjectData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(advertisementData.NAME).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        var returnStr : String = super.createTable(this.createTableStatement())
        return returnStr
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        //super.updateWhere(StoreFrontData.NAME,(String) updatedValues.get(StoreFrontData.NAME),updatedValues);      
        super.updateWhere(EntryData.getInstance().ID, updatedValues.get(EntryData.getInstance().ID).asInstanceOf[String], updatedValues)
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def insert(values : BasicArrayList) : Unit = {
        super.insert(values)
    }

}


