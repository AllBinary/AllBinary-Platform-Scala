/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.order

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.java.util.Random
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.HistoryDbInitInfo
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.address.BillingAddressData
import _root_.org.allbinary.business.user.address.ShippingAddressData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.inventory.basket.Basket
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.Order
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentInterface
import _root_.org.allbinary.business.user.commerce.money.tax.TaxFactory
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethods
import _root_.org.allbinary.business.user.commerce.shipping.modules.ShippingInterface
import _root_.org.allbinary.data.generator.OrderHistoryIdGenerator
import _root_.org.allbinary.data.tables.TableDataFactory
import _root_.org.allbinary.data.tables.user.address.billing.BillingAddressesEntity
import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntity
import _root_.org.allbinary.data.tables.user.commerce.money.payment.PaymentEntity
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.control.crypt.SuperCrypt
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class OrderHistoryEntity() extends AbSqlBean(new HistoryDbInitInfo()) with OrderHistoryEntityInterface {

    val logUtil_OrderHistoryEntity : LogUtil = LogUtil.getInstance()

    val tableName : String = "orderhistory"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    def insert(userName : String, order : Order) : Unit = {
        val vector : BasicArrayList = new BasicArrayListD()
        try {
            val paymentInterface : PaymentInterface = new PaymentEntity().getDefault(userName)
            val billingAddress : StreetAddress = new BillingAddressesEntity(userName).getDefault()
            val shippingAddress : StreetAddress = new ShippingAddressesEntity(userName).getDefault()
            val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()
            val storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(order.getStoreName())
            val shippingInterface : ShippingInterface = new ShippingMethods(abeClientInformation, storeFrontInterface).getShippingInterface(order.getShippingMethod())
            val shippingCost : Money = shippingInterface.getCost(order)
            val basketInterface : BasketInterface = order.getBasket()
            val subTotal : Money = basketInterface.getSubTotal()
            val taxRate : _root_.java.lang.Float = TaxFactory.getInstance().getInstance(abeClientInformation, storeFrontInterface).getTaxRate(shippingAddress, storeFrontInterface)
            val tax : Money = new Money()
            val total : Money = new Money()
            total.add(shippingCost.toString())
            total.add(subTotal.toString())
            tax.add(total.toString())
            tax.multiply(taxRate)
            total.add(tax.toString())
            val empty : String = StringUtil.getInstance().EMPTY_STRING
            //vector.add(empty);
            vector.add(new OrderHistoryIdGenerator().getNext())
            val ZERO : String = TableDataFactory.getInstance().ZERO_STRING
            vector.add(order.getId())
            vector.add(userName)
            vector.add(order.getStoreName())
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            vector.add(ZERO)
            vector.add(time)
            vector.add(ZERO)
            vector.add(ZERO)
            vector.add(OrderHistoryData.PREPROCESSING)
            vector.add(order.getPaymentMethod())
            if (paymentInterface != null) {
                vector.add(paymentInterface.getName())
                vector.add(paymentInterface.getType())
                vector.add(paymentInterface.getExpiration())
                var random : Int = new Random().nextInt(SuperCrypt.KEYMAX)
                vector.add(new SuperCrypt(random).encrypt(paymentInterface.getNumber()))
                vector.add(new Integer(random).toString())
            } else {
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(ZERO)
            }
            if (billingAddress != null) {
                vector.add(billingAddress.getName())
                vector.add(billingAddress.getStreet())
                vector.add(billingAddress.getCity())
                vector.add(billingAddress.getState())
                vector.add(billingAddress.getCode())
                vector.add(billingAddress.getCountry())
            } else {
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
            }
            if (shippingAddress != null) {
                vector.add(shippingAddress.getName())
                vector.add(shippingAddress.getStreet())
                vector.add(shippingAddress.getCity())
                vector.add(shippingAddress.getState())
                vector.add(shippingAddress.getCode())
                vector.add(shippingAddress.getCountry())
            } else {
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
                vector.add(empty)
            }
            vector.add(order.getShippingMethod())
            vector.add(subTotal.toString())
            vector.add(shippingCost.toString())
            vector.add(tax.toString())
            vector.add(total.toString())
            vector.add(order.getSpecial())
            vector.add(order.getUserComments())
            vector.add(order.getUserCancelComments())
            vector.add(order.getStoreComments())
            vector.add(order.getStoreCancelComments())
            this.insert(vector)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_OrderHistoryEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderHistoryEntity.put("Command Failed: " + vector, this, INSERT, e)
                }
            }
        }
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_OrderHistoryEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderHistoryEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def setStatus(orderId : String, status : String) : Unit = {
        try {
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            var updateHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            updateHashMap.put(OrderHistoryData.STATUS, status)
            if (status.compareTo(OrderHistoryData.CANCELLED) == 0) {
                updateHashMap.put(OrderHistoryData.CANCELDATE, time)
            } else if (status.compareTo(OrderHistoryData.SHIPPED) == 0) {
                updateHashMap.put(OrderHistoryData.SHIPPEDDATE, time)
            }
            super.updateWhere(OrderData.ID, orderId, updateHashMap)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderHistoryEntity.put(this.commonStrings.FAILURE, this, "setStatus", e)
                }
            }
        }
    }

    def setPaymentMethod(orderId : String, paymentMethod : String) : Unit = {
        try {
            var calendar : Calendar = Calendar.getInstance()
            var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            var updateHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            updateHashMap.put(PaymentData.METHOD, paymentMethod)
            updateHashMap.put(OrderHistoryData.TRANSDATE, time)
            super.updateWhere(OrderData.ID, orderId, updateHashMap)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_OrderHistoryEntity.put(this.commonStrings.FAILURE, this, "setPaymentMethod", e)
                }
            }
        }
    }

    /*     public String getUserOrdersTable(String userName,String fromDate,String toDate)     {     HashMap whereHashMap = StdUtil.getInstance().createHashMap();     whereHashMap.put(UserData.USERNAME,userName);          return super.getTableWhereBetween(whereHashMap,OrderHistoryData.ORDERDATE,fromDate,toDate);     }          public String getCancelledTable()     {     return super.getTableWhere(OrderHistoryData.STATUS,OrderHistoryData.CANCELLED);     }          public String getShippedTable()     {     return super.getTableWhere(OrderHistoryData.STATUS,OrderHistoryData.SHIPPED);     }          public String getPreprocessingTable()     {     return super.getTableWhere(OrderHistoryData.STATUS,OrderHistoryData.PREPROCESSING);     }          public String getProcessingTable()     {     return super.getTableWhere(OrderHistoryData.STATUS,OrderHistoryData.PROCESSING);     }          public String getPartiallyTable()     {     return super.getTableWhere(OrderHistoryData.STATUS,OrderHistoryData.PARTIALLYSHIPPED);     }           */
    def getStoreOrders(storeFrontInterface : StoreFrontInterface) : BasicArrayList = {
        var orderReviewVector : BasicArrayList = new BasicArrayListD()
        var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        whereHashMap.put(StoreFrontData.getInstance().NAME, storeFrontInterface.getName())
        var orderHashMapVector : BasicArrayList = super.getRows(whereHashMap)
        var size : Int = orderHashMapVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var orderReviewHashMap : HashMap[Object, Object] = orderHashMapVector.get(i).asInstanceOf[HashMap[Object, Object]]
                var orderReview : OrderHistory = new OrderHistory(new Basket(), orderReviewHashMap)
                orderReviewVector.add(orderReview)
                i += 1
            }
        }
        return orderReviewVector
    }

    def getOrders(userName : String) : BasicArrayList = {
        var orderReviewVector : BasicArrayList = new BasicArrayListD()
        var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        whereHashMap.put(UserData.USERNAME, userName)
        var orderHashMapVector : BasicArrayList = super.getRows(whereHashMap)
        val size : Int = orderHashMapVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var orderReviewHashMap : HashMap[Object, Object] = orderHashMapVector.get(index).asInstanceOf[HashMap[Object, Object]]
                var orderReview : OrderHistory = new OrderHistory(new Basket(), orderReviewHashMap)
                orderReviewVector.add(orderReview)
                index += 1
            }
        }
        return orderReviewVector
    }

    def getOrders(status : String, fromDate : String, toDate : String) : BasicArrayList = {
        var orderReviewVector : BasicArrayList = new BasicArrayListD()
        var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        whereHashMap.put(OrderHistoryData.STATUS, status)
        var orderHashMapVector : BasicArrayList = super.getRowsWhereBetween(whereHashMap, OrderHistoryData.ORDERDATE, fromDate, toDate)
        val size : Int = orderHashMapVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var orderReviewHashMap : HashMap[Object, Object] = orderHashMapVector.get(index).asInstanceOf[HashMap[Object, Object]]
                var orderReview : OrderHistory = new OrderHistory(new Basket(), orderReviewHashMap)
                orderReviewVector.add(orderReview)
                index += 1
            }
        }
        return orderReviewVector
    }

    def getOrders(fromDate : String, toDate : String) : BasicArrayList = {
        var orderReviewVector : BasicArrayList = new BasicArrayListD()
        var orderHashMapVector : BasicArrayList = super.getRowsWhereBetween(OrderHistoryData.ORDERDATE, fromDate, toDate)
        val size : Int = orderHashMapVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var orderReviewHashMap : HashMap[Object, Object] = orderHashMapVector.get(index).asInstanceOf[HashMap[Object, Object]]
                var orderReview : OrderHistory = new OrderHistory(new Basket(), orderReviewHashMap)
                orderReviewVector.add(orderReview)
                index += 1
            }
        }
        return orderReviewVector
    }

    def getOrder(id : String) : OrderHistory = {
        var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        whereHashMap.put(OrderData.ID, id)
        var orderReviewHashMap : HashMap[Object, Object] = super.getRow(whereHashMap).asInstanceOf[HashMap[Object, Object]]
        if (orderReviewHashMap != null) {
            var orderHistory : OrderHistory = new OrderHistory(new Basket(), orderReviewHashMap)
            return orderHistory
        } else {
            return null
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
        stringBuffer.append(UserData.USERNAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(StoreFrontData.getInstance().NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.SHIPPEDDATE)
        stringBuffer.append(" BIGINT(19) UNSIGNED ,")
        stringBuffer.append(OrderHistoryData.ORDERDATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(OrderHistoryData.TRANSDATE)
        stringBuffer.append(" BIGINT(19) UNSIGNED ,")
        stringBuffer.append(OrderHistoryData.CANCELDATE)
        stringBuffer.append(" BIGINT(19) UNSIGNED ,")
        stringBuffer.append(OrderHistoryData.STATUS)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentData.METHOD)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(PaymentData.NAME)
        stringBuffer.append(" VARCHAR(255) ,")
        stringBuffer.append(PaymentData.TYPE)
        stringBuffer.append(" VARCHAR(255) ,")
        stringBuffer.append(PaymentData.EXPIRATION)
        stringBuffer.append(" VARCHAR(255) ,")
        stringBuffer.append(PaymentData.NUMBER)
        stringBuffer.append(" VARCHAR(255) ,")
        stringBuffer.append(entryData.ENCRYPTION)
        stringBuffer.append(" BIGINT(19) UNSIGNED ,")
        stringBuffer.append(BillingAddressData.NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(BillingAddressData.STREET)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(BillingAddressData.CITY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(BillingAddressData.STATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(BillingAddressData.CODE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(BillingAddressData.COUNTRY)
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
        stringBuffer.append(OrderHistoryData.SUBTOTAL)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.SHIPPINGCOST)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.TAX)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(OrderHistoryData.TOTAL)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(entryData.SPECIAL)
        stringBuffer.append(" VARCHAR(255) ,")
        stringBuffer.append(OrderData.CUSTOMERCOMMENT)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(OrderData.CUSTOMERCANCELCOMMENT)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(OrderData.STORECOMMENT)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(OrderData.STORECANCELCOMMENT)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
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

    /*     public String getTable()     {     return super.getTable();     }      */
    def update(whereHashMap : HashMap[Object, Object], orderHashMap : HashMap[Object, Object]) : Unit = {
        try {
            updateWhere(whereHashMap, orderHashMap)
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

}


