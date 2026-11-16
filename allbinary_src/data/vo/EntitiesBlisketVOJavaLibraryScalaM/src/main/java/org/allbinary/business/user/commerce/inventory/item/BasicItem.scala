/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.data.generator.ProductIdGenerator
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonStrings

class BasicItem() extends ItemInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    var itemId : String = null

    var number : String = null

    var inBaskets : String = null

    var weight : String = null

    var enabled : String = null

    var newOrUsed : String = null

    var summary : String = null

    var distributor : String = null

    var idUsedByDistributor : String = null

    var producedBy : String = null

    var productionDate : String = null

    var startProductionDate : String = null

    var description : String = null

    var keywords : String = null

    var category : String = null

    var `type` : String = null

    var smallImage : String = null

    var mediumImage : String = null

    var largeImage : String = null

    var price : Money = null

    var comment : String = null

    var customs : String = null

    private var downloads : String = null

    var groups : String = null

    var options : String = null

    var permissions : String = null

    var specials : String = null

    private var downloadable : Boolean = false

    var timeEntered : String = null

    var lastModified : String = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
        var EMPTY : String = StringUtil.getInstance().EMPTY_STRING
        this.itemId = new ProductIdGenerator().getNext()
        this.number = CommonPhoneStrings.getInstance().ZERO
        this.inBaskets = EMPTY
        this.weight = EMPTY
        this.enabled = EMPTY
        this.newOrUsed = EMPTY
        this.summary = EMPTY
        this.distributor = EMPTY
        this.idUsedByDistributor = EMPTY
        this.producedBy = EMPTY
        this.productionDate = EMPTY
        this.startProductionDate = EMPTY
        this.description = EMPTY
        this.keywords = EMPTY
        this.category = EMPTY
        this.`type` = EMPTY
        this.smallImage = EMPTY
        this.mediumImage = EMPTY
        this.largeImage = EMPTY
        this.timeEntered = EMPTY
        this.lastModified = EMPTY
        this.price = new Money()
        this.comment = EMPTY
        this.customs = EMPTY
        this.setDownloads(EMPTY)
        this.groups = EMPTY
        this.options = EMPTY
        this.permissions = EMPTY
        this.specials = EMPTY
    }

    def this(itemHashMap : HashMap[Object, Object]) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, "Constructor(HashMap)")
        }
        this.itemId = itemHashMap.get(basicItemData.ID).asInstanceOf[String]
        this.number = itemHashMap.get(basicItemData.NUMBER).asInstanceOf[String]
        /*          * String numberString = (String) itemHashMap.get(basicItemData.NUMBER);          * if(!StringValidationUtil.isEmpty(numberString)) { this.number = new          * Long(0).valueOf(numberString); } else { this.number }          */
        this.inBaskets = itemHashMap.get(basicItemData.INBASKETS).asInstanceOf[String]
        this.weight = itemHashMap.get(basicItemData.WEIGHT).asInstanceOf[String]
        this.enabled = itemHashMap.get(EntryData.getInstance().ENABLE).asInstanceOf[String]
        this.newOrUsed = itemHashMap.get(basicItemData.NEWORUSED).asInstanceOf[String]
        this.summary = itemHashMap.get(basicItemData.SUMMARY).asInstanceOf[String]
        this.distributor = itemHashMap.get(basicItemData.DISTRIBUTOR).asInstanceOf[String]
        this.idUsedByDistributor = itemHashMap.get(basicItemData.IDUSEDBYDISTRIBUTOR).asInstanceOf[String]
        this.producedBy = itemHashMap.get(basicItemData.PRODUCEDBY).asInstanceOf[String]
        this.productionDate = itemHashMap.get(basicItemData.PRODUCTIONDATE).asInstanceOf[String]
        this.startProductionDate = itemHashMap.get(basicItemData.STARTPRODUCTIONDATE).asInstanceOf[String]
        this.description = itemHashMap.get(basicItemData.DESCRIPTION).asInstanceOf[String]
        this.keywords = itemHashMap.get(basicItemData.KEYWORDS).asInstanceOf[String]
        this.category = itemHashMap.get(basicItemData.CATEGORY).asInstanceOf[String]
        this.`type` = itemHashMap.get(basicItemData.TYPE).asInstanceOf[String]
        this.smallImage = itemHashMap.get(basicItemData.SMALLIMAGE).asInstanceOf[String]
        this.mediumImage = itemHashMap.get(basicItemData.MEDIUMIMAGE).asInstanceOf[String]
        this.largeImage = itemHashMap.get(basicItemData.LARGEIMAGE).asInstanceOf[String]
        this.timeEntered = itemHashMap.get(EntryData.getInstance().TIMECREATED).asInstanceOf[String]
        this.lastModified = itemHashMap.get(EntryData.getInstance().LASTMODIFIED).asInstanceOf[String]
        this.price = new Money(itemHashMap.get(basicItemData.PRICE).asInstanceOf[String])
        this.comment = itemHashMap.get(basicItemData.COMMENT).asInstanceOf[String]
        this.customs = itemHashMap.get(basicItemData.CUSTOMS).asInstanceOf[String]
        this.setDownloads(itemHashMap.get(basicItemData.DOWNLOADS).asInstanceOf[String])
        this.groups = itemHashMap.get(basicItemData.GROUPS).asInstanceOf[String]
        this.options = itemHashMap.get(basicItemData.OPTIONS).asInstanceOf[String]
        this.permissions = itemHashMap.get(basicItemData.PERMISSIONS).asInstanceOf[String]
        this.specials = itemHashMap.get(basicItemData.SPECIALS).asInstanceOf[String]
    }

    def setId(itemId : String) : Unit = {
        this.itemId = itemId
    }

    def setNumber(number : String) : Unit = {
        this.number = number
    }

    def setInBaskets(value : String) : Unit = {
        this.inBaskets = value
    }

    def setWeight(value : String) : Unit = {
        this.weight = value
    }

    def setNewOrUsed(value : String) : Unit = {
        this.newOrUsed = value
    }

    def setSummary(value : String) : Unit = {
        this.summary = value
    }

    def setDistributor(value : String) : Unit = {
        this.distributor = value
    }

    def setIdUsedByDistributor(value : String) : Unit = {
        this.idUsedByDistributor = value
    }

    def setProducedBy(value : String) : Unit = {
        this.producedBy = value
    }

    def setProductionDate(value : String) : Unit = {
        this.productionDate = value
    }

    def setStartProductionDate(value : String) : Unit = {
        this.startProductionDate = value
    }

    def setDescription(value : String) : Unit = {
        this.description = value
    }

    def setKeywords(value : String) : Unit = {
        this.keywords = value
    }

    def setCategory(value : String) : Unit = {
        this.category = value
    }

    def setType(value : String) : Unit = {
        this.`type` = value
    }

    def setSmallImage(value : String) : Unit = {
        this.smallImage = value
    }

    def setMediumImage(value : String) : Unit = {
        this.mediumImage = value
    }

    def setLargeImage(value : String) : Unit = {
        this.largeImage = value
    }

    def setTimeEntered(value : String) : Unit = {
        this.timeEntered = value
    }

    def setLastModified(value : String) : Unit = {
        this.lastModified = value
    }

    def setPrice(value : Money) : Unit = {
        this.price = value
    }

    def setComment(value : String) : Unit = {
        this.comment = value
    }

    def setCustoms(value : String) : Unit = {
        this.customs = value
    }

    def setDownloads(value : String) : Unit = {
        this.downloads = value
        if (!StringValidationUtil.getInstance().isEmpty(this.downloads)) {
            var downloadInteger : Integer = Integer.valueOf(this.downloads)
            if (downloadInteger.intValue() != 0) {
                this.setDownloadable(true)
            }
        }
    }

    def setGroups(value : String) : Unit = {
        this.groups = value
    }

    def setOptions(value : String) : Unit = {
        this.options = value
    }

    def setPermissions(value : String) : Unit = {
        this.permissions = value
    }

    def setSpecials(value : String) : Unit = {
        this.specials = value
    }

    def setEnabled(value : String) : Unit = {
        this.enabled = value
    }

    def getId() : String = {
        return this.itemId
    }

    def getNumber() : String = {
        return this.number
    }

    def getInBaskets() : String = {
        return this.inBaskets
    }

    def getWeight() : String = {
        return this.weight
    }

    def getNewOrUsed() : String = {
        return this.newOrUsed
    }

    def getSummary() : String = {
        return this.summary
    }

    def getDistributor() : String = {
        return this.distributor
    }

    def getIdUsedByDistributor() : String = {
        return this.idUsedByDistributor
    }

    def getProducedBy() : String = {
        return this.producedBy
    }

    def getProductionDate() : String = {
        return this.productionDate
    }

    def getStartProductionDate() : String = {
        return this.startProductionDate
    }

    def getDescription() : String = {
        return this.description
    }

    def getKeywords() : String = {
        return this.keywords
    }

    def getCategory() : String = {
        return this.category
    }

    def getType() : String = {
        return this.`type`
    }

    def getSmallImage() : String = {
        return this.smallImage
    }

    def getMediumImage() : String = {
        return this.mediumImage
    }

    def getLargeImage() : String = {
        return this.largeImage
    }

    def getTimeEntered() : String = {
        return this.timeEntered
    }

    def getLastModified() : String = {
        return this.lastModified
    }

    def getPrice() : Money = {
        return this.price
    }

    def getComment() : String = {
        return this.comment
    }

    def getCustoms() : String = {
        return this.customs
    }

    def getDownloads() : String = {
        return this.downloads
    }

    def getGroups() : String = {
        return this.groups
    }

    def getOptions() : String = {
        return this.options
    }

    def getPermissions() : String = {
        return this.permissions
    }

    def getSpecials() : String = {
        return this.specials
    }

    def setDownloadable(downloadable : Boolean) : Unit = {
        this.downloadable = downloadable
    }

    def isDownloadable() : Boolean = {
        return this.downloadable
    }

    def getEnabled() : String = {
        return this.enabled
    }

    def getTotal() : Money = {
        // add = total is number * items price
        var itemTotal : Money = new Money(this.price)
        itemTotal.multiply(new Integer(this.number).intValue())
        return itemTotal
    }

    def toHashMap() : HashMap[Object, Object] = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, "toHashMap")
        }
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(basicItemData.ID, this.itemId)
        hashMap.put(basicItemData.NUMBER, this.number)
        hashMap.put(basicItemData.INBASKETS, this.inBaskets)
        hashMap.put(basicItemData.WEIGHT, this.weight)
        hashMap.put(EntryData.getInstance().ENABLE, this.enabled)
        hashMap.put(basicItemData.NEWORUSED, this.newOrUsed)
        hashMap.put(basicItemData.SUMMARY, this.summary)
        hashMap.put(basicItemData.DISTRIBUTOR, this.distributor)
        hashMap.put(basicItemData.IDUSEDBYDISTRIBUTOR, this.idUsedByDistributor)
        hashMap.put(basicItemData.PRODUCEDBY, this.producedBy)
        hashMap.put(basicItemData.PRODUCTIONDATE, this.productionDate)
        hashMap.put(basicItemData.STARTPRODUCTIONDATE, this.startProductionDate)
        hashMap.put(basicItemData.DESCRIPTION, this.description)
        hashMap.put(basicItemData.KEYWORDS, this.keywords)
        hashMap.put(basicItemData.CATEGORY, this.category)
        hashMap.put(basicItemData.TYPE, this.`type`)
        // hashMap.put(basicItemData.IMAGE,EMPTY);
        hashMap.put(basicItemData.SMALLIMAGE, this.smallImage)
        hashMap.put(basicItemData.MEDIUMIMAGE, this.mediumImage)
        hashMap.put(basicItemData.LARGEIMAGE, this.largeImage)
        // update time
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new _root_.java.lang.Long(calendar.getTimeInMillis()).toString()
        hashMap.put(EntryData.getInstance().LASTMODIFIED, time)
        // if(this.price.isValid())
        hashMap.put(basicItemData.PRICE, this.price.toString())
        hashMap.put(basicItemData.COMMENT, this.comment)
        hashMap.put(basicItemData.CUSTOMS, this.customs)
        hashMap.put(basicItemData.DOWNLOADS, this.getDownloads())
        hashMap.put(basicItemData.GROUPS, this.groups)
        hashMap.put(basicItemData.OPTIONS, this.options)
        hashMap.put(basicItemData.PERMISSIONS, this.permissions)
        hashMap.put(basicItemData.SPECIALS, this.specials)
        return hashMap
    }

    def toVector() : BasicArrayList = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, "toVector")
        }
        var values : BasicArrayList = new BasicArrayListD()
        values.add(this.itemId)
        values.add(this.number)
        values.add(this.inBaskets)
        values.add(this.weight)
        values.add(this.enabled)
        values.add(this.newOrUsed)
        values.add(this.summary)
        values.add(this.distributor)
        values.add(this.idUsedByDistributor)
        values.add(this.producedBy)
        values.add(this.productionDate)
        values.add(this.startProductionDate)
        values.add(this.description)
        values.add(this.keywords)
        values.add(this.category)
        values.add(this.`type`)
        values.add(this.getSmallImage())
        values.add(this.getMediumImage())
        values.add(this.getLargeImage())
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new _root_.java.lang.Long(calendar.getTimeInMillis()).toString()
        values.add(time)
        values.add(time)
        values.add(this.price.toString())
        values.add(this.comment)
        values.add(this.customs)
        values.add(this.getDownloads())
        values.add(this.groups)
        values.add(this.options)
        values.add(this.permissions)
        values.add(this.specials)
        return values
    }

    def getKey() : Object = {
        return this.getId().asInstanceOf[Object]
    }

}


