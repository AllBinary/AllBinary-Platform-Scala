/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.advertisement.areas

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.advertisement.area.AdvertisementArea
import _root_.org.allbinary.business.advertisement.area.AdvertisementAreaData
import _root_.org.allbinary.business.advertisement.area.AdvertisementAreaInterface
import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaignData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class AdvertisementAreasEntity() extends AbSqlBean(new UserDbInitInfo()) with AdvertisementAreasEntityInterface {

    val logUtil_AdvertisementAreasEntity : LogUtil = LogUtil.getInstance()

    val tableName : String = "advertisements"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    /*      public void insert(BasicArrayList values)      {      try      {      super.insert(values);                if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.putF(this.commonStrings.SUCCESS, this, INSERT);      }      }      catch(Exception e)      {      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.put(this.commonStrings.FAILURE,this,INSERT,e);      }      }      }      */
    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(EntryData.getInstance().ID, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AdvertisementAreasEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_AdvertisementAreasEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    //AdvertisementAreaInterface
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
                if (hashMap != null) {
                    vector.add((new AdvertisementArea(hashMap)).asInstanceOf[AdvertisementAreaInterface])
                }
                index += 1
            }
        }
        //(AdvertisementAreaInterface) new AdvertisementArea(vector);
        return vector
    }

    def get(storeName : String, advertisementAreaName : String) : AdvertisementAreaInterface = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(StoreFrontData.getInstance().NAME, storeName)
        keysAndValues.put(AdvertisementAreaData.getInstance().NAME, advertisementAreaName)
        var hashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
        if (hashMap != null) {
            return (new AdvertisementArea(hashMap)).asInstanceOf[AdvertisementAreaInterface]
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    final def createTableStatement() : String = {
        var advertisementAreaData : AdvertisementAreaData = AdvertisementAreaData.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.START)
        //Usually StoreName and id/name of entity
        stringBuffer.append(advertisementAreaData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(StoreFrontData.getInstance().NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(advertisementAreaData.DESCRIPTION).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(advertisementAreaData.CONSTRAINTS).append(this.sqlTypeStrings.BLOB_NOT_NULL).append(AdvertisementCampaignData.getInstance().NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(advertisementAreaData.NAME).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        var returnStr : String = super.createTable(this.createTableStatement())
        return returnStr
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(AdvertisementAreaData.getInstance().NAME, updatedValues.get(AdvertisementAreaData.getInstance().NAME).asInstanceOf[String], updatedValues)
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def insert(values : BasicArrayList) : Unit = {
        super.insert(values)
    }

}


