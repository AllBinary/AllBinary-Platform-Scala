/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.order

import _root_.java.util.HashMap
import _root_.java.util.ListIterator
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.HistoryDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.address.ShippingAddressData
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketReview
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.Item
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.generator.OrderItemIdGenerator
import _root_.org.allbinary.data.tables.TableDataFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class OrderItemsEntity() extends AbSqlBean(new HistoryDbInitInfo()) with OrderItemsEntityInterface {

    val logUtil_OrderItemsEntity : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    val tableName : String = "orderitems"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    def insert(userName : String, order : OrderInterface) : Unit = {
        var vector : BasicArrayList = new BasicArrayListD()
        try {
            var basket : BasketInterface = order.getBasket()
            var items : Set[Object] = basket.getIds().asInstanceOf[Set[Object]]
            //HashMap numberOfEachItem = StdUtil.getInstance().createHashMap();
            val ZERO_STRING : String = TableDataFactory.getInstance().ZERO_STRING
            val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
            var inventoryEntity : InventoryEntity = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
            var itemsArray : Array[Object] = items.toArray()
            var itemsSize : Int = itemsArray.length

            {
                var i : Int = 0
                while (i < itemsSize) {
                    var item : String = itemsArray(i).asInstanceOf[String]
                    var itemInterface : ItemInterface = inventoryEntity.getItem(item)
                    //String time = new String(new Long(calendar.getTimeInMillis()).toString());
                    vector = new BasicArrayListD()
                    //vector.add("auto_increment");
                    vector.add(new OrderItemIdGenerator().getNext())
                    vector.add(order.getId())
                    vector.add(TableDataFactory.getInstance().INTEGER_MAX_VALUE_STRING)
                    vector.add(userName)
                    vector.add(order.getStoreName())
                    vector.add(itemInterface.getId())
                    vector.add(basket.getNumberOf(item).toString())
                    vector.add(itemInterface.getNewOrUsed())
                    vector.add(itemInterface.getSummary())
                    vector.add(itemInterface.getDistributor())
                    vector.add(itemInterface.getIdUsedByDistributor())
                    vector.add(itemInterface.getProducedBy())
                    vector.add(itemInterface.getProductionDate())
                    vector.add(itemInterface.getStartProductionDate())
                    vector.add(itemInterface.getDescription())
                    vector.add(itemInterface.getKeywords())
                    vector.add(itemInterface.getCategory())
                    vector.add(itemInterface.getType())
                    vector.add(itemInterface.getSmallImage())
                    vector.add(itemInterface.getMediumImage())
                    vector.add(itemInterface.getLargeImage())
                    vector.add(itemInterface.getWeight())
                    vector.add(itemInterface.getPrice().toString())
                    vector.add(itemInterface.getComment())
                    vector.add(itemInterface.getCustoms())
                    vector.add(itemInterface.getDownloads())
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(EMPTY_STRING)
                    vector.add(ZERO_STRING)
                    vector.add(ZERO_STRING)
                    vector.add(ZERO_STRING)
                    vector.add(ZERO_STRING)
                    this.insert(vector)
                    i += 1
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_OrderItemsEntity.putF("Command Success Added: " + items.size(), this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderItemsEntity.put("Command Failed: " + vector.toString(), this, INSERT, e)
                }
            }
        }
    }

    /*      public String getOrderTable(String orderId)      {      return super.getTableWhere(OrderData.ID,orderId);      }      */
    def setStatus(orderId : String, groupId : String, status : String) : Unit = {
        try {
            var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var updateHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            whereHashMap.put(OrderData.ID, orderId)
            whereHashMap.put(ShippingMethodData.GROUP, groupId)
            updateHashMap.put(OrderHistoryData.STATUS, status)
            super.updateWhere(whereHashMap, updateHashMap)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderItemsEntity.put(this.commonStrings.FAILURE, this, "setStatus", e)
                }
            }
        }
    }

    def isEverythingShipped(orderId : String) : Boolean = {
        try {
            val itemStatusVector : BasicArrayList = super.getColumnWhere(OrderHistoryData.STATUS, OrderData.ID, orderId)
            val size : Int = itemStatusVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var status : String = itemStatusVector.get(index).asInstanceOf[String]
                    if (status.compareTo(OrderHistoryData.SHIPPED) != 0) {
                        return false
                    }
                    index += 1
                }
            }
            return true
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderItemsEntity.put(this.commonStrings.FAILURE, this, "isEverythingShipped", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def getBasketReview(orderId : String) : BasketReview = {
        try {
            var basketReview : BasketReview = new BasketReview()
            var keyValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            keyValues.put(OrderData.ID, orderId)
            var items : BasicArrayList = super.getRows(keyValues)
            var entryData : EntryData = EntryData.getInstance()
            if ((items != null) && (items.size() > 0)) {
                val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
                var itemsArray : Array[Object] = items.toArray()
                var itemsSize : Int = itemsArray.length

                {
                    var i : Int = 0
                    while (i < itemsSize) {
                        var itemHashMap : HashMap[Object, Object] = itemsArray(i).asInstanceOf[HashMap[Object, Object]]
                        //add missing entries that exist in basic inventory for item construction
                        itemHashMap.put(basicItemData.INBASKETS, EMPTY_STRING)
                        itemHashMap.put(entryData.ENABLE, EMPTY_STRING)
                        itemHashMap.put(entryData.TIMECREATED, EMPTY_STRING)
                        itemHashMap.put(entryData.LASTMODIFIED, EMPTY_STRING)
                        itemHashMap.put(basicItemData.GROUPS, EMPTY_STRING)
                        itemHashMap.put(basicItemData.OPTIONS, EMPTY_STRING)
                        itemHashMap.put(basicItemData.PERMISSIONS, EMPTY_STRING)
                        itemHashMap.put(basicItemData.SPECIALS, EMPTY_STRING)
                        var item : Item = new Item(itemHashMap)
                        basketReview.addItem(item)
                        i += 1
                    }
                }
                return basketReview
            } else {
                return null
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderItemsEntity.put(this.commonStrings.FAILURE, this, "getBasketReview", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    final def createTableStatement() : String = {
        var entryData : EntryData = EntryData.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("CREATE TABLE ")
        stringBuffer.append(this.tableName)
        stringBuffer.append(" (")
        stringBuffer.append(entryData.ID)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(OrderData.ID)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(ShippingMethodData.GROUP)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(UserData.USERNAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(StoreFrontData.getInstance().NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.ID)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.NUMBER)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.NEWORUSED)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.SUMMARY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.DISTRIBUTOR)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.IDUSEDBYDISTRIBUTOR)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.PRODUCEDBY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.PRODUCTIONDATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.STARTPRODUCTIONDATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.DESCRIPTION)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(basicItemData.KEYWORDS)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.CATEGORY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.TYPE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.SMALLIMAGE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.MEDIUMIMAGE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.LARGEIMAGE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.WEIGHT)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.PRICE)
        //stringBuffer.append(" DECIMAL (11,2) NOT NULL,");
        stringBuffer.append(" VARCHAR(20) NOT NULL,")
        stringBuffer.append(basicItemData.COMMENT)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(basicItemData.CUSTOMS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.DOWNLOADS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(ShippingMethodData.COST)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.TAX)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(ShippingAddressData.NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(ShippingAddressData.STREET)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(ShippingAddressData.CITY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(ShippingAddressData.STATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(ShippingAddressData.CODE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(ShippingAddressData.COUNTRY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(ShippingMethodData.NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(entryData.SPECIAL)
        stringBuffer.append(" VARCHAR(255) ,")
        stringBuffer.append(OrderHistoryData.STATUS)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.CANCELINFO)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.CANCELTYPE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.SHIPPEDDATE)
        stringBuffer.append(" BIGINT(19) UNSIGNED ,")
        stringBuffer.append(OrderHistoryData.ORDERDATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(OrderHistoryData.TRANSDATE)
        stringBuffer.append(" BIGINT(19) UNSIGNED ,")
        stringBuffer.append(OrderHistoryData.CANCELDATE)
        stringBuffer.append(" BIGINT(19) UNSIGNED ,")
        stringBuffer.append("PRIMARY KEY(")
        stringBuffer.append(entryData.ID)
        stringBuffer.append(") )")
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def insert(values : BasicArrayList) : Unit = {
        super.insert(values)
    }

}


