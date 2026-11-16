/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.advertisement.campaign.internal

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaign
import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaignData
import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaignInterface
import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaigns
import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaignsInterface
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.time.TimeData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class AdvertisementCampaignInternalEntity() extends AbSqlBean(new UserDbInitInfo()) with AdvertisementCampaignInternalEntityInterface {

    val logUtil_AdvertisementCampaignInternalEntity : LogUtil = LogUtil.getInstance()

    val tableName : String = "adCampaignInternal"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    /*      public void insert(BasicArrayList values)      {      try      {      super.insert(values);                if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.putF(this.commonStrings.SUCCESS, this, INSERT);      }      }      catch(Exception e)      {      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.put(this.commonStrings.FAILURE,this,INSERT,e);      }      }      }      */
    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(StoreFrontData.getInstance().NAME, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AdvertisementCampaignInternalEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_AdvertisementCampaignInternalEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    def getCampaignsInStore(storeName : String) : AdvertisementCampaignsInterface = {
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
                    vector.add((new AdvertisementCampaign(hashMap)).asInstanceOf[AdvertisementCampaignInterface])
                }
                index += 1
            }
        }
        return (new AdvertisementCampaigns(vector)).asInstanceOf[AdvertisementCampaignsInterface]
    }

    def get(storeName : String, name : String) : AdvertisementCampaignInterface = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(StoreFrontData.getInstance().NAME, storeName)
        keysAndValues.put(AdvertisementCampaignData.getInstance().NAME, name)
        var hashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
        if (hashMap != null) {
            return (new AdvertisementCampaign(hashMap)).asInstanceOf[AdvertisementCampaignInterface]
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(EntryData.getInstance().ID, updatedValues.get(EntryData.getInstance().ID).asInstanceOf[String], updatedValues)
    }

    final def createTableStatement() : String = {
        var entryData : EntryData = EntryData.getInstance()
        var advertisementCampaignData : AdvertisementCampaignData = AdvertisementCampaignData.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.START)
        //Usually StoreName and id/name of entity
        stringBuffer.append(entryData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(StoreFrontData.getInstance().NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(advertisementCampaignData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(advertisementCampaignData.DESCRIPTION).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(advertisementCampaignData.CONFIG).append(this.sqlTypeStrings.BLOB_NOT_NULL).append(TimeData.getInstance().START).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(TimeData.getInstance().END).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(entryData.TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(entryData.LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(entryData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        var returnStr : String = super.createTable(this.createTableStatement())
        return returnStr
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def insert(values : BasicArrayList) : Unit = {
        super.insert(values)
    }

}


