/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item.download

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class DownloadableItemView(param_downloadableItem : DownloadableItem) extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var downloadableItem : DownloadableItem = null

    //Constructor
    {
        val downloadableItem : DownloadableItem = param_downloadableItem
        this.downloadableItem = downloadableItem
    }

    def toXmlNode(document : Document) : Node = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, "toXmlNode")
        }
        /*       try       {        */
        var hashMap : HashMap[Object, Object] = this.downloadableItem.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var totalTime : Long = this.downloadableItem.getValidTime().longValue()
        var calendar : Calendar = Calendar.getInstance()
        var year : Int = calendar.get(Calendar.YEAR)
        var month : Int = calendar.get(Calendar.MONTH)
        var day : Int = calendar.get(Calendar.DAY_OF_MONTH)
        var hour : Int = calendar.get(Calendar.HOUR)
        var minute : Int = calendar.get(Calendar.MINUTE)
        var second : Int = calendar.get(Calendar.SECOND)
        calendar.setTimeInMillis(calendar.getTimeInMillis() + totalTime)
        var yearDelta : Int = calendar.get(Calendar.YEAR)
        var monthDelta : Int = calendar.get(Calendar.MONTH)
        var dayDelta : Int = calendar.get(Calendar.DAY_OF_MONTH)
        var hourDelta : Int = calendar.get(Calendar.HOUR)
        var minuteDelta : Int = calendar.get(Calendar.MINUTE)
        var secondDelta : Int = calendar.get(Calendar.SECOND)
        hashMap.put(DownloadItemData.VALID_TIME_YEARS, Integer.valueOf(yearDelta - year))
        hashMap.put(DownloadItemData.VALID_TIME_MONTHS, Integer.valueOf(monthDelta - month))
        hashMap.put(DownloadItemData.VALID_TIME_DAYS, Integer.valueOf(dayDelta - day))
        hashMap.put(DownloadItemData.VALID_TIME_HOURS, Integer.valueOf(hourDelta - hour))
        hashMap.put(DownloadItemData.VALID_TIME_MINUTES, Integer.valueOf(minuteDelta - minute))
        hashMap.put(DownloadItemData.VALID_TIME_SECONDS, Integer.valueOf(secondDelta - second))
        //hashMap.put(BasicItemData.IMAGE, StringUtil.getInstance());
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var node : Node = document.createElement(DownloadItemData.NAME)
        var stringUtil : StringUtil = StringUtil.getInstance()
        val nameArray : Array[Object] = keySet.toArray()
        val size : Int = nameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var name : String = nameArray(index).asInstanceOf[String]
                var value : String = hashMap.get(name).asInstanceOf[String]
                value = stringUtil.getNonNull(value)
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                index += 1
            }
        }
        return node
    }

    def toXmlDoc() : Document = {
        return null
    }

    def view() : String = {
        return null
    }

}


