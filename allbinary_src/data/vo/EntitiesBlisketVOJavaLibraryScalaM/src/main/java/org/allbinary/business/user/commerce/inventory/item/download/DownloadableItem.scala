/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item.download

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.data.generator.ProductIdGenerator
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.time.TimeUtil

class DownloadableItem private () {

    private var id : String = null

    private var basicItemId : String = null

    private var enabled : String = null

    private var system : String = null

    private var platform : String = null

    private var specialName : String = null

    private var version : String = null

    private var changes : String = null

    private var licenseFile : String = null

    private var file : String = null

    private var size : _root_.java.lang.Long = null

    private var validTime : _root_.java.lang.Long = null

    private var retries : String = null

    //private final String lastModified;
    def this(id : String) = {
        this()
        val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
        this.id = new ProductIdGenerator().getNext()
        this.basicItemId = id
        this.enabled = EntryData.getInstance().YES
        this.system = "Java"
        this.platform = "Android"
        this.specialName = EMPTY_STRING
        this.version = EMPTY_STRING
        this.changes = EMPTY_STRING
        this.licenseFile = EMPTY_STRING
        this.file = EMPTY_STRING
        this.size = _root_.java.lang.Long.valueOf(0)
        this.validTime = _root_.java.lang.Long.valueOf(0)
        this.retries = EMPTY_STRING
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.id = hashMap.get(DownloadItemData.ID).asInstanceOf[String]
        this.basicItemId = hashMap.get(BasicItemData.getInstance().ID).asInstanceOf[String]
        this.enabled = hashMap.get(EntryData.getInstance().ENABLE).asInstanceOf[String]
        this.system = hashMap.get(DownloadItemData.SYSTEM).asInstanceOf[String]
        this.platform = hashMap.get(DownloadItemData.PLATFORM).asInstanceOf[String]
        this.specialName = hashMap.get(DownloadItemData.SPECIAL_NAME).asInstanceOf[String]
        this.version = hashMap.get(DownloadItemData.VERSION).asInstanceOf[String]
        this.changes = hashMap.get(DownloadItemData.CHANGES).asInstanceOf[String]
        this.licenseFile = hashMap.get(DownloadItemData.LICENSE_FILE).asInstanceOf[String]
        this.file = hashMap.get(DownloadItemData.FILE).asInstanceOf[String]
        var value : String = hashMap.get(DownloadItemData.SIZE).asInstanceOf[String]
        if (!StringValidationUtil.getInstance().isEmpty(value)) {
            this.size = _root_.java.lang.Long.valueOf(value)
        } else {
            this.size = new _root_.java.lang.Long(0)
        }
        var validTime : String = hashMap.get(DownloadItemData.VALID_TIME).asInstanceOf[String]
        if (!StringValidationUtil.getInstance().isEmpty(validTime)) {
            this.validTime = _root_.java.lang.Long.valueOf(validTime)
        } else {
            var totalYears : String = hashMap.get(DownloadItemData.VALID_TIME_YEARS).asInstanceOf[String]
            var totalMonths : String = hashMap.get(DownloadItemData.VALID_TIME_MONTHS).asInstanceOf[String]
            var totalDays : String = hashMap.get(DownloadItemData.VALID_TIME_DAYS).asInstanceOf[String]
            var totalHours : String = hashMap.get(DownloadItemData.VALID_TIME_HOURS).asInstanceOf[String]
            var totalMinutes : String = hashMap.get(DownloadItemData.VALID_TIME_MINUTES).asInstanceOf[String]
            var totalSeconds : String = hashMap.get(DownloadItemData.VALID_TIME_SECONDS).asInstanceOf[String]
            var totalTime : Long = TimeUtil.getInstance().getTotalTime(totalYears, totalMonths, totalDays, totalHours, totalMinutes, totalSeconds)
            this.validTime = new _root_.java.lang.Long(totalTime)
        }
        this.retries = hashMap.get(DownloadItemData.RETRIES).asInstanceOf[String]
    }

    def toVector() : BasicArrayList = {
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new _root_.java.lang.Long(calendar.getTimeInMillis()).toString()
        var values : BasicArrayList = new BasicArrayListD()
        values.add(getId())
        values.add(this.basicItemId)
        values.add(this.enabled)
        values.add(this.getSpecialName())
        values.add(this.getVersion())
        values.add(this.getChanges())
        values.add(this.getSystem())
        values.add(this.getPlatform())
        values.add(this.getLicenseFile())
        values.add(this.getFile())
        values.add(this.getSize().toString())
        values.add(this.getValidTime().toString())
        values.add(this.getRetries())
        values.add(time)
        values.add(time)
        return values
    }

    def toHashMap() : HashMap[Object, Object] = {
        var values : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        values.put(DownloadItemData.ID, this.getId())
        values.put(BasicItemData.getInstance().ID, this.basicItemId)
        values.put(EntryData.getInstance().ENABLE, this.enabled)
        values.put(DownloadItemData.SYSTEM, this.getSystem())
        values.put(DownloadItemData.PLATFORM, this.getPlatform())
        values.put(DownloadItemData.SPECIAL_NAME, this.getSpecialName())
        values.put(DownloadItemData.VERSION, this.getVersion())
        values.put(DownloadItemData.CHANGES, this.getChanges())
        values.put(DownloadItemData.LICENSE_FILE, this.getLicenseFile())
        values.put(DownloadItemData.FILE, this.getFile())
        values.put(DownloadItemData.SIZE, this.getSize().toString())
        values.put(DownloadItemData.VALID_TIME, this.getValidTime().toString())
        values.put(DownloadItemData.RETRIES, this.getRetries())
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        values.put(EntryData.getInstance().LASTMODIFIED, time)
        return values
    }

    def getId() : String = {
        return this.id
    }

    /**      * @return the system      */
    def getSystem() : String = {
        return this.system
    }

    /**      * @return the platform      */
    def getPlatform() : String = {
        return this.platform
    }

    /**      * @return the specialName      */
    def getSpecialName() : String = {
        return this.specialName
    }

    /**      * @return the version      */
    def getVersion() : String = {
        return this.version
    }

    /**      * @return the changes      */
    def getChanges() : String = {
        return this.changes
    }

    /**      * @return the licenseFile      */
    def getLicenseFile() : String = {
        return this.licenseFile
    }

    /**      * @return the file      */
    def getFile() : String = {
        return this.file
    }

    /**      * @return the size      */
    def getSize() : _root_.java.lang.Long = {
        return this.size
    }

    /**      * @return the validTime      */
    def getValidTime() : _root_.java.lang.Long = {
        return this.validTime
    }

    /**      * @return the retries      */
    def getRetries() : String = {
        return this.retries
    }

}


