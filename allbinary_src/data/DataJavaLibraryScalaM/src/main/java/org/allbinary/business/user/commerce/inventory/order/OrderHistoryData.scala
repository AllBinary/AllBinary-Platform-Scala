/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order


class OrderHistoryData {
    import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.{DATEDELTA as _, DATETYPE as _, TYPELONG as _, TYPECAESAR as _, TODATE as _, FROMHOUR as _, FROMDAY as _, FROMMONTH as _, FROMYEAR as _, TOHOUR as _, TODAY as _, TOMONTH as _, TOYEAR as _, ORDERHISTORY as _, SHIPPEDDATE as _, ORDERDATE as _, TRANSDATE as _, CANCELDATE as _, SHIPPEDDATEFORMATTED as _, ORDERDATEFORMATTED as _, TRANSDATEFORMATTED as _, CANCELDATEFORMATTED as _, SUBTOTAL as _, SHIPPINGCOST as _, TAX as _, TOTAL as _, CANCELINFO as _, CANCELTYPE as _, STATUS as _, PREPROCESSINGNAME as _, PROCESSINGNAME as _, CANCELLEDNAME as _, PARTIALLYSHIPPEDNAME as _, SHIPPEDNAME as _, PREPROCESSING as _, PROCESSING as _, CANCELLED as _, PARTIALLYSHIPPED as _, SHIPPED as _, SETSTATUS as _, *}
    def DATEDELTA : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.DATEDELTA
    def DATETYPE : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.DATETYPE
    def TYPELONG : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TYPELONG
    def TYPECAESAR : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TYPECAESAR
    def TODATE : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TODATE
    def FROMHOUR : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.FROMHOUR
    def FROMDAY : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.FROMDAY
    def FROMMONTH : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.FROMMONTH
    def FROMYEAR : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.FROMYEAR
    def TOHOUR : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TOHOUR
    def TODAY : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TODAY
    def TOMONTH : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TOMONTH
    def TOYEAR : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TOYEAR
    def ORDERHISTORY : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.ORDERHISTORY
    def SHIPPEDDATE : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.SHIPPEDDATE
    def ORDERDATE : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.ORDERDATE
    def TRANSDATE : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TRANSDATE
    def CANCELDATE : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.CANCELDATE
    def SHIPPEDDATEFORMATTED : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.SHIPPEDDATEFORMATTED
    def ORDERDATEFORMATTED : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.ORDERDATEFORMATTED
    def TRANSDATEFORMATTED : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TRANSDATEFORMATTED
    def CANCELDATEFORMATTED : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.CANCELDATEFORMATTED
    def SUBTOTAL : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.SUBTOTAL
    def SHIPPINGCOST : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.SHIPPINGCOST
    def TAX : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TAX
    def TOTAL : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.TOTAL
    def CANCELINFO : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.CANCELINFO
    def CANCELTYPE : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.CANCELTYPE
    def STATUS : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.STATUS
    def PREPROCESSINGNAME : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.PREPROCESSINGNAME
    def PROCESSINGNAME : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.PROCESSINGNAME
    def CANCELLEDNAME : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.CANCELLEDNAME
    def PARTIALLYSHIPPEDNAME : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.PARTIALLYSHIPPEDNAME
    def SHIPPEDNAME : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.SHIPPEDNAME
    def PREPROCESSING : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.PREPROCESSING
    def PROCESSING : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.PROCESSING
    def CANCELLED : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.CANCELLED
    def PARTIALLYSHIPPED : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.PARTIALLYSHIPPED
    def SHIPPED : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.SHIPPED
    def SETSTATUS : String = _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData.SETSTATUS

}

object OrderHistoryData {
    var MAXIDLEN : Int = 19

    val DATEDELTA : String = "DATE_DELTA"

    val DATETYPE : String = "DATE_TYPE"

    val TYPELONG : String = "TYPE_LONG"

    val TYPECAESAR : String = "TYPE_CAESAR"

    val TODATE : String = "TO_DATE"

    val FROMHOUR : String = "FROM_HOUR"

    val FROMDAY : String = "FROM_DAY"

    val FROMMONTH : String = "FROM_MONTH"

    val FROMYEAR : String = "FROM_YEAR"

    val TOHOUR : String = "TO_HOUR"

    val TODAY : String = "TO_DAY"

    val TOMONTH : String = "TO_MONTH"

    val TOYEAR : String = "TO_YEAR"

    val ORDERHISTORY : String = "ORDERHISTORY"

    //Transaction dates
    val SHIPPEDDATE : String = "ORDERHISTORY_SHIPPED_DATE"

    val ORDERDATE : String = "ORDERHISTORY_ORDER_DATE"

    val TRANSDATE : String = "ORDERHISTORY_TRANS_DATE"

    val CANCELDATE : String = "ORDERHISTORY_CANCEL_DATE"

    val SHIPPEDDATEFORMATTED : String = "ORDERHISTORY_SHIPPED_DATE_FORMATTED"

    val ORDERDATEFORMATTED : String = "ORDERHISTORY_ORDER_DATE_FORMATTED"

    val TRANSDATEFORMATTED : String = "ORDERHISTORY_TRANS_DATE_FORMATTED"

    val CANCELDATEFORMATTED : String = "ORDERHISTORY_CANCEL_DATE_FORMATTED"

    val SUBTOTAL : String = "ORDERHISTORY_SUB_TOTAL"

    val SHIPPINGCOST : String = "ORDERHISTORY_SHIPPING_COST"

    val TAX : String = "ORDERHISTORY_TAX"

    val TOTAL : String = "ORDERHISTORY_TOTAL"

    val CANCELINFO : String = "ORDERHISTORY_CANCEL_INFO"

    val CANCELTYPE : String = "ORDERHISTORY_CANCEL_TYPE"

    val STATUS : String = "ORDERHISTORY_STATUS"

    //different order status information
    val PREPROCESSINGNAME : String = "PREPROCESSING"

    val PROCESSINGNAME : String = "PROCESSING"

    val CANCELLEDNAME : String = "CANCELLED"

    val PARTIALLYSHIPPEDNAME : String = "PARTIALLYSHIPPED"

    val SHIPPEDNAME : String = "SHIPPED"

    val PREPROCESSING : String = "Order Preprocessing"

    val PROCESSING : String = "Order Processing"

    val CANCELLED : String = "Order Cancelled"

    val PARTIALLYSHIPPED : String = "Order Partially Shipped"

    val SHIPPED : String = "Order Shipped"

    //Status Command
    val SETSTATUS : String = "Set Status"

}


