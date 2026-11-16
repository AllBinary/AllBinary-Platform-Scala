/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.advertisement.sales

import _root_.java.util.HashMap
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.user.group.GroupData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList

class AffiliateSalesEntity() extends AbSqlBean(new UserDbInitInfo()) with AffiliateSalesEntityInterface {

    val logUtil_AffiliateSalesEntity : LogUtil = LogUtil.getInstance()

    val tableName : String = "affiliate"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    /*      public void insert(BasicArrayList values)      {      try      {      super.insert(values);                if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.putF(this.commonStrings.SUCCESS, this, INSERT);      }      }      catch(Exception e)      {      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))      {      this.logUtil.put(this.commonStrings.FAILURE,this,INSERT,e);      }      }      }      */
    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(StoreFrontData.getInstance().NAME, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AffiliateSalesEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_AffiliateSalesEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    /*      public AffiliatesInterface get(String name)      {      HashMap keysAndValues = StdUtil.getInstance().createHashMap();      keysAndValues.put(StoreFrontData.NAME, name);      BasicArrayList hashMapVector = super.getRows(keysAndValues);             BasicArrayList affiliateVector = new BasicArrayListD();      iter = hashMapVector;      while(iter.hasNext())      {      HashMap hashMap = (HashMap) iter.next();      if(hashMap!=null)      affiliateVector.add((AffiliateInterface) new Affiliate(hashMap));      }       return (AffiliatesInterface) new Affiliates(affiliateVector);      }       public AffiliateInterface get(String name, String affiliateName)      {      HashMap keysAndValues = StdUtil.getInstance().createHashMap();      keysAndValues.put(StoreFrontData.NAME, name);      keysAndValues.put(AffiliateData.NAME, name);      HashMap hashMap = super.getRow(keysAndValues);             if(hashMap!=null)       return (AffiliateInterface) new Affiliate(hashMap);      else       return null;      }      */
    final def createTableStatement() : String = {
        var entryData : EntryData = EntryData.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.START)
        //Usually StoreName and id/name of entity
        stringBuffer.append(entryData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(StoreFrontData.getInstance().NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(GroupData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DynamicObjectData.NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(entryData.TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(entryData.LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(entryData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        var returnStr : String = super.createTable(this.createTableStatement())
        return returnStr
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
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


