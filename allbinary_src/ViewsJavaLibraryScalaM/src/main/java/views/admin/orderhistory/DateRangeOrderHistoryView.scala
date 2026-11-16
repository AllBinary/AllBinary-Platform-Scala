/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.orderhistory

import _root_.java.util.Calendar
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityFactory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.time.TimeUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class DateRangeOrderHistoryView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with ValidationComponentInterface with DomNodeInterface {

    val logUtil_DateRangeOrderHistoryView : LogUtil = LogUtil.getInstance()

    //private final String VIEWORDERSINLAST30DAYS = "View Orders In Last 30 Days";
    private val VIEWALLORDERS : String = "View All"

    private val VIEWORDERSINLASTHOUR : String = "Last Hour"

    private val VIEWORDERSINLASTDAY : String = "Last Day"

    private val VIEWORDERSINLASTWEEK : String = "Last Week"

    private val VIEWORDERSINLAST30DAYS : String = "30 Days"

    //private PageContext pageContext;
    private var request : HttpServletRequest = null

    private var shipped : String = null

    private var partiallyShipped : String = null

    private var processing : String = null

    private var preprocessing : String = null

    private var cancelled : String = null

    private var dateType : String = null

    //long string
    private var toDate : String = null

    private var fromDate : String = null

    private var fromYear : String = null

    private var fromMonth : String = null

    private var fromDay : String = null

    private var fromHour : String = null

    private var toYear : String = null

    private var toMonth : String = null

    private var toDay : String = null

    private var toHour : String = null

    private var command : String = null

    private val ON : String = "on"

    private var MAXLEN : Int = 15

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.request = this.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.dateType = this.request.getParameter(OrderHistoryData.DATETYPE)
        this.preprocessing = this.request.getParameter(OrderHistoryData.PREPROCESSINGNAME)
        this.shipped = this.request.getParameter(OrderHistoryData.SHIPPEDNAME)
        this.partiallyShipped = this.request.getParameter(OrderHistoryData.PARTIALLYSHIPPEDNAME)
        this.processing = this.request.getParameter(OrderHistoryData.PROCESSINGNAME)
        this.cancelled = this.request.getParameter(OrderHistoryData.CANCELLEDNAME)
        this.fromYear = this.request.getParameter(OrderHistoryData.FROMYEAR)
        this.fromMonth = this.request.getParameter(OrderHistoryData.FROMMONTH)
        this.fromDay = this.request.getParameter(OrderHistoryData.FROMDAY)
        this.fromHour = this.request.getParameter(OrderHistoryData.FROMHOUR)
        this.toYear = this.request.getParameter(OrderHistoryData.TOYEAR)
        this.toMonth = this.request.getParameter(OrderHistoryData.TOMONTH)
        this.toDay = this.request.getParameter(OrderHistoryData.TODAY)
        this.toHour = this.request.getParameter(OrderHistoryData.TOHOUR)
        this.command = this.request.getParameter(GLOBALS2.ADMINCOMMAND)
    }

    def addDomNodeInterfaces() : Unit = {
        this.addDomNodeInterface(this.asInstanceOf[DomNodeInterface])
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_DateRangeOrderHistoryView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def toXmlNode(document : Document) : Node = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Attempt to View orders in (fromDate=")
                stringBuffer.append(this.fromDate)
                stringBuffer.append(",toDate=")
                stringBuffer.append(this.toDate)
                stringBuffer.append(") and status")
                this.logUtil_DateRangeOrderHistoryView.putF(stringBuffer.toString(), this, "view")
            }
            var node : Node = document.createElement(OrderData.ORDERS)
            /*             BasicArrayList orderHistoryVector = OrderHistoryEntityFactory.getInstance().getOrders(fromDate, toDate);                           iter = orderHistoryVector;             while(iter.hasNext())             {                OrderHistory orderHistory = (OrderHistory) iter.next();                node.appendChild(orderHistory.toXmlNode(document));             }              */
            if ((this.preprocessing != null) && (this.preprocessing.compareTo(this.ON) == 0)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_DateRangeOrderHistoryView.putF("Adding Preprocessing Orders", this, "toXmlNode")
                }
                var orderHistoryVector : BasicArrayList = OrderHistoryEntityFactory.getInstance().getOrders(OrderHistoryData.PREPROCESSING, fromDate, toDate)
                val size : Int = orderHistoryVector.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        var orderHistory : OrderHistory = orderHistoryVector.get(index).asInstanceOf[OrderHistory]
                        node.appendChild(orderHistory.toXmlNode(document))
                        index += 1
                    }
                }
            }
            if ((this.shipped != null) && (this.shipped.compareTo(this.ON) == 0)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_DateRangeOrderHistoryView.putF("Adding Shipped Orders", this, "toXmlNode")
                }
                var orderHistoryVector : BasicArrayList = OrderHistoryEntityFactory.getInstance().getOrders(OrderHistoryData.SHIPPED, fromDate, toDate)
                val size : Int = orderHistoryVector.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        var orderHistory : OrderHistory = orderHistoryVector.get(index).asInstanceOf[OrderHistory]
                        node.appendChild(orderHistory.toXmlNode(document))
                        index += 1
                    }
                }
            }
            if ((this.partiallyShipped != null) && (this.partiallyShipped.compareTo(this.ON) == 0)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_DateRangeOrderHistoryView.putF("Adding Partially Shipped Orders", this, "toDomNode")
                }
                var orderHistoryVector : BasicArrayList = OrderHistoryEntityFactory.getInstance().getOrders(OrderHistoryData.PARTIALLYSHIPPED, fromDate, toDate)
                val size : Int = orderHistoryVector.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        var orderHistory : OrderHistory = orderHistoryVector.get(index).asInstanceOf[OrderHistory]
                        node.appendChild(orderHistory.toXmlNode(document))
                        index += 1
                    }
                }
            }
            if ((this.processing != null) && (this.processing.compareTo(this.ON) == 0)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_DateRangeOrderHistoryView.putF("Adding Processing Orders", this, "toXmlNode")
                }
                var orderHistoryVector : BasicArrayList = OrderHistoryEntityFactory.getInstance().getOrders(OrderHistoryData.PROCESSING, fromDate, toDate)
                val size : Int = orderHistoryVector.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        var orderHistory : OrderHistory = orderHistoryVector.get(index).asInstanceOf[OrderHistory]
                        node.appendChild(orderHistory.toXmlNode(document))
                        index += 1
                    }
                }
            }
            if ((this.cancelled != null) && (this.cancelled.compareTo(this.ON) == 0)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_DateRangeOrderHistoryView.putF("Adding Cancelled Orders", this, "view")
                }
                var orderHistoryVector : BasicArrayList = OrderHistoryEntityFactory.getInstance().getOrders(OrderHistoryData.CANCELLED, fromDate, toDate)
                val size : Int = orderHistoryVector.size()

                {
                    var index : Int = 0
                    while (index < size) {
                        var orderHistory : OrderHistory = orderHistoryVector.get(index).asInstanceOf[OrderHistory]
                        node.appendChild(orderHistory.toXmlNode(document))
                        index += 1
                    }
                }
            }
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.PREPROCESSINGNAME, OrderHistoryData.PREPROCESSING))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.PROCESSINGNAME, OrderHistoryData.PROCESSING))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.CANCELLEDNAME, OrderHistoryData.CANCELLED))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.PARTIALLYSHIPPEDNAME, OrderHistoryData.PARTIALLYSHIPPED))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.SHIPPEDNAME, OrderHistoryData.SHIPPED))
            node.appendChild(ModDomHelper.createNameValueNodes(document, GLOBALS2.VIEWNAME, GLOBALS2.VIEW))
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_DateRangeOrderHistoryView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var isValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if ((this.dateType == null) || ((this.dateType.compareTo(OrderHistoryData.TYPELONG) != 0) && (this.dateType.compareTo(OrderHistoryData.TYPECAESAR) != 0))) {
                isValid = _root_.java.lang.Boolean.FALSE
            }
            if (this.dateType != null) {
                if (this.dateType.compareTo(OrderHistoryData.TYPELONG) == 0) {
                    var calendar : Calendar = Calendar.getInstance()
                    var currentTime : Long = calendar.getTimeInMillis()
                    //set date delta OrderHistoryData.DATEDELTA
                    var rangeDate : String = StringUtil.getInstance().EMPTY_STRING
                    if (this.command.compareTo(this.VIEWORDERSINLASTHOUR) == 0) {
                        var oneHour : Long = ((60).toLong * 60) * 1000
                        rangeDate = new _root_.java.lang.Long(oneHour).toString()
                    } else if (this.command.compareTo(this.VIEWORDERSINLASTDAY) == 0) {
                        var oneDay : Long = (((24).toLong * 60) * 60) * 1000
                        rangeDate = new _root_.java.lang.Long(oneDay).toString()
                    } else if (this.command.compareTo(this.VIEWORDERSINLASTWEEK) == 0) {
                        var oneWeek : Long = ((((7).toLong * 24) * 60) * 60) * 1000
                        rangeDate = new _root_.java.lang.Long(oneWeek).toString()
                    } else if (this.command.compareTo(this.VIEWORDERSINLAST30DAYS) == 0) {
                        var thirtyDays : Long = ((((30).toLong * 24) * 60) * 60) * 1000
                        rangeDate = new _root_.java.lang.Long(thirtyDays).toString()
                    } else if (this.command.compareTo(this.VIEWALLORDERS) == 0) {
                        rangeDate = new _root_.java.lang.Long(currentTime).toString()
                    }
                    var rangeDateLong : Long = new _root_.java.lang.Long(rangeDate).longValue()
                    this.fromDate = new _root_.java.lang.Long(currentTime - rangeDateLong).toString()
                    var time : String = new String(new _root_.java.lang.Long(currentTime).toString())
                    this.toDate = time
                } else if (this.dateType.compareTo(OrderHistoryData.TYPECAESAR) == 0) {
                    var calendar : Calendar = Calendar.getInstance()
                    TimeUtil.getInstance().setCalendar(calendar, this.fromYear, this.fromMonth, this.fromDay, this.fromHour)
                    this.fromDate = new _root_.java.lang.Long(calendar.getTimeInMillis()).toString()
                    TimeUtil.getInstance().setCalendar(calendar, this.toYear, this.toMonth, this.toDay, this.toHour)
                    this.toDate = new _root_.java.lang.Long(calendar.getTimeInMillis()).toString()
                }
                if (StringValidationUtil.getInstance().isEmpty(this.toDate) || (this.toDate.length() > this.MAXLEN)) {
                    isValid = _root_.java.lang.Boolean.FALSE
                }
                if (StringValidationUtil.getInstance().isEmpty(this.fromDate) || (this.fromDate.length() > this.MAXLEN)) {
                    isValid = _root_.java.lang.Boolean.FALSE
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Attempt to View orders in (fromDate=")
                stringBuffer.append(this.fromDate)
                stringBuffer.append(",toDate=")
                stringBuffer.append(this.toDate)
                stringBuffer.append(")")
                this.logUtil_DateRangeOrderHistoryView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
            }
            return isValid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_DateRangeOrderHistoryView.put("Exception in validation", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def validationInfo() : String = {
        try {
            var result : StringMaker = new StringMaker()
            if ((this.dateType == null) || ((this.dateType.compareTo(OrderHistoryData.TYPELONG) != 0) && (this.dateType.compareTo(OrderHistoryData.TYPECAESAR) != 0))) {
                result.append("DATETYPE not recognized")
            }
            if (StringValidationUtil.getInstance().isEmpty(this.toDate) || (this.toDate.length() > this.MAXLEN)) {
                result.append("Invalid To Date")
            }
            if (StringValidationUtil.getInstance().isEmpty(this.fromDate) || (this.fromDate.length() > this.MAXLEN)) {
                result.append("Invalid From Date")
            }
            //"Date Range Invalid"
            return result.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_DateRangeOrderHistoryView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Getting Validation Info"
            }
        }
        throw new IllegalStateException()
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


