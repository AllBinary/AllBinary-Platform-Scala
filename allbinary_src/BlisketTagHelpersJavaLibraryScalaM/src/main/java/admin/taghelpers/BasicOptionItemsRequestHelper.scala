/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.option.BasicOptionItemData
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.options.BasicOptionItemsEntityFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class BasicOptionItemsRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    private var request : HttpServletRequest = null

    private var id : String = null

    private var optionOneTitle : String = null

    private var defaultOptionItem : String = null

    private var defaultOptionValue : String = null

    private var optionItem : BasicArrayList = null

    private var optionValue : BasicArrayList = null

    private var timeEntered : String = null

    private var lastModified : String = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.getFormData()
    }

    def getFormData() : Unit = {
        this.optionItem = new BasicArrayListD()
        this.optionValue = new BasicArrayListD()
        this.id = this.request.getParameter(basicItemData.ID)
        this.optionOneTitle = this.request.getParameter(BasicOptionItemData.OPTION_ONE_TITLE)
        this.defaultOptionItem = this.request.getParameter(BasicOptionItemData.DEFAULT_OPTION_ITEM)
        this.defaultOptionValue = this.request.getParameter(BasicOptionItemData.DEFAULT_OPTION_VALUE)
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_ONE_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_ONE_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_TWO_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_TWO_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_THREE_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_THREE_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_FOUR_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_FOUR_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_FIVE_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_FIVE_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_SIX_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_SIX_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_SEVEN_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_SEVEN_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_EIGHT_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_EIGHT_VALUE))
        this.optionItem.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_NINE_ITEM))
        this.optionValue.add(this.request.getParameter(BasicOptionItemData.OPTION_ONE_NINE_VALUE))
        this.timeEntered = this.request.getParameter(EntryData.getInstance().TIMECREATED)
        this.lastModified = this.request.getParameter(EntryData.getInstance().LASTMODIFIED)
    }

    private def getHashMap() : HashMap[Object, Object] = {
        val values : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        values.put(basicItemData.ID, id)
        values.put(BasicOptionItemData.OPTION_ONE_ONE_ITEM, this.optionItem.get(0))
        values.put(BasicOptionItemData.OPTION_ONE_ONE_VALUE, this.optionValue.get(0))
        values.put(BasicOptionItemData.OPTION_ONE_TWO_ITEM, this.optionItem.get(1))
        values.put(BasicOptionItemData.OPTION_ONE_TWO_VALUE, this.optionValue.get(1))
        values.put(BasicOptionItemData.OPTION_ONE_THREE_ITEM, this.optionItem.get(2))
        values.put(BasicOptionItemData.OPTION_ONE_THREE_VALUE, this.optionValue.get(2))
        values.put(BasicOptionItemData.OPTION_ONE_FOUR_ITEM, this.optionItem.get(3))
        values.put(BasicOptionItemData.OPTION_ONE_FOUR_VALUE, this.optionValue.get(3))
        values.put(BasicOptionItemData.OPTION_ONE_FIVE_ITEM, this.optionItem.get(4))
        values.put(BasicOptionItemData.OPTION_ONE_FIVE_VALUE, this.optionValue.get(4))
        values.put(BasicOptionItemData.OPTION_ONE_SIX_ITEM, this.optionItem.get(5))
        values.put(BasicOptionItemData.OPTION_ONE_SIX_VALUE, this.optionValue.get(5))
        values.put(BasicOptionItemData.OPTION_ONE_SEVEN_ITEM, this.optionItem.get(6))
        values.put(BasicOptionItemData.OPTION_ONE_SEVEN_VALUE, this.optionValue.get(6))
        values.put(BasicOptionItemData.OPTION_ONE_EIGHT_ITEM, this.optionItem.get(7))
        values.put(BasicOptionItemData.OPTION_ONE_EIGHT_VALUE, this.optionValue.get(7))
        values.put(BasicOptionItemData.OPTION_ONE_NINE_ITEM, this.optionItem.get(8))
        values.put(BasicOptionItemData.OPTION_ONE_NINE_VALUE, this.optionValue.get(8))
        val calendar : Calendar = Calendar.getInstance()
        val time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        values.put(EntryData.getInstance().LASTMODIFIED, time)
        return values
    }

    override def insert() : String = {
        try {
            val calendar : Calendar = Calendar.getInstance()
            val time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
            val values : BasicArrayList = new BasicArrayListD()
            values.add(this.id)
            val size : Int = this.optionValue.size()

            {
                var index : Int = 0
                while (index < size) {
                    values.add(this.optionValue.get(index))
                    values.add(this.optionItem.get(index))
                    index += 1
                }
            }
            values.add(time)
            values.add(time)
            BasicOptionItemsEntityFactory.getInstance().getBasicOptionItemsEntityInstance().insert(values)
            val success : String = ("Successfully inserted " + this.id) + " into items table"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = ("Failed to insert " + this.id) + " into items table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "inserts()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        try {
            BasicOptionItemsEntityFactory.getInstance().getBasicOptionItemsEntityInstance().delete(this.id)
            var success : String = "Successfully deleted"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to delete"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            var success : String = "Update Pricing Successful"
            var values : HashMap[Object, Object] = this.getHashMap().asInstanceOf[HashMap[Object, Object]]
            BasicOptionItemsEntityFactory.getInstance().getBasicOptionItemsEntityInstance().update(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(new StringMaker().append(this.id).append(CommonSeps.getInstance().SPACE).append(success).toString(), this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to update: " + this.id
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


