/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.backup

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntity
import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntityFactory
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.file.zip.ZipFileUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BlisketBackupFactory {
    import _root_.org.allbinary.business.backup.BlisketBackupFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val directory : Directory = Directory.getInstance()

    private def getFileBasicArrayList(pathString : String) : BasicArrayList = {
        var path : AbPath = new AbPath(pathString, this.stringUtil.EMPTY_STRING)
        var file : AbFile = AbFile.createAbFileFromAbPath(path)
        return this.directory.search(file, true)
    }

    def backup() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "backup()")
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getWebappPath())
            stringBuffer.append(PATH_GLOBALS.getInstance().BACKUP_PATH)
            var backupPath : String = stringBuffer.toString()
            var path : AbPath = new AbPath(backupPath, this.stringUtil.EMPTY_STRING)
            var fileBasicArrayList : BasicArrayList = this.getFileBasicArrayList(backupPath)
            this.backup(fileBasicArrayList, path.toFileSystemString() + "backup.zip")
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "backup()", e)
            }
        }
    }

    def backupViews() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "backupViews()")
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getWebappPath())
            stringBuffer.append(PATH_GLOBALS.getInstance().BACKUP_PATH)
            val backupPath : String = stringBuffer.toString()
            val path : AbPath = new AbPath(backupPath, this.stringUtil.EMPTY_STRING)
            val fileBasicArrayList : BasicArrayList = new BasicArrayListD()
            //Backup other customizable generated files
            val storeFrontsEntity : StoreFrontsEntity = StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance()
            val storeFrontNamesBasicArrayList : BasicArrayList = storeFrontsEntity.getStoreFrontNames()
            val size : Int = storeFrontNamesBasicArrayList.size()
            var nextStore : String = null
            var viewsPath : String = null

            {
                var index : Int = 0
                while (index < size) {
                    nextStore = storeFrontNamesBasicArrayList.get(index).asInstanceOf[String]
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(URLGLOBALS.getWebappPath())
                    stringBuffer.append(PATH_GLOBALS.getInstance().VIEWS_PATH)
                    stringBuffer.append(nextStore)
                    viewsPath = stringBuffer.toString()
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("Backup Store Views: ")
                    stringBuffer.append(nextStore)
                    stringBuffer.append(" from: ")
                    stringBuffer.append(viewsPath)
                    PreLogUtil.put(stringBuffer.toString(), this, "backupViews()")
                    //Views
                    fileBasicArrayList.addAllList(this.getFileBasicArrayList(viewsPath))
                    index += 1
                }
            }
            this.backup(fileBasicArrayList, path.toFileSystemString() + "backupViews.zip")
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "backupViews()", e)
            }
        }
    }

    def backupResources() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "backupResources()")
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getWebappPath())
            stringBuffer.append(PATH_GLOBALS.getInstance().BACKUP_PATH)
            val backupPath : String = stringBuffer.toString()
            val path : AbPath = new AbPath(backupPath, this.stringUtil.EMPTY_STRING)
            val fileBasicArrayList : BasicArrayList = new BasicArrayListD()
            //Backup other customizable generated files
            val storeFrontsEntity : StoreFrontsEntity = StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance()
            val storeFrontNamesBasicArrayList : BasicArrayList = storeFrontsEntity.getStoreFrontNames()
            val size : Int = storeFrontNamesBasicArrayList.size()
            var nextStore : String = null
            var storeFrontInterface : StoreFrontInterface = null
            var resourcesPath : String = null

            {
                var index : Int = 0
                while (index < size) {
                    nextStore = storeFrontNamesBasicArrayList.get(index).asInstanceOf[String]
                    storeFrontInterface = storeFrontsEntity.getStoreFrontInterface(nextStore)
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(URLGLOBALS.getWebappPath())
                    stringBuffer.append(storeFrontInterface.getCurrentHostNamePath())
                    stringBuffer.append(storeFrontInterface.getCategoryPath())
                    resourcesPath = stringBuffer.toString()
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("Backup Store Resrouces: ")
                    stringBuffer.append(nextStore)
                    stringBuffer.append(" from: ")
                    stringBuffer.append(resourcesPath)
                    PreLogUtil.put(stringBuffer.toString(), this, "backupResources()")
                    //Views
                    fileBasicArrayList.addAllList(this.getFileBasicArrayList(resourcesPath))
                    index += 1
                }
            }
            this.backup(fileBasicArrayList, path.toFileSystemString() + "backupResources.zip")
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "backupResources()", e)
            }
        }
    }

    def backupJsps() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "backupJsps()")
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getWebappPath())
            stringBuffer.append(PATH_GLOBALS.getInstance().BACKUP_PATH)
            val backupPath : String = stringBuffer.toString()
            val path : AbPath = new AbPath(backupPath, this.stringUtil.EMPTY_STRING)
            val fileBasicArrayList : BasicArrayList = new BasicArrayListD()
            //Backup other customizable generated files
            val storeFrontsEntity : StoreFrontsEntity = StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance()
            val storeFrontNamesBasicArrayList : BasicArrayList = storeFrontsEntity.getStoreFrontNames()
            val size : Int = storeFrontNamesBasicArrayList.size()
            var nextStore : String = null

            {
                var index : Int = 0
                while (index < size) {
                    nextStore = storeFrontNamesBasicArrayList.get(index).asInstanceOf[String]
                    PreLogUtil.put("Backup Store Jsps: " + nextStore, this, "backupJsps()")
                    //Store jsps - while they can be generated from the views I still back them up
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(URLGLOBALS.getWebappPath())
                    stringBuffer.append(nextStore)
                    fileBasicArrayList.addAllList(this.getFileBasicArrayList(stringBuffer.toString()))
                    index += 1
                }
            }
            this.backup(fileBasicArrayList, path.toFileSystemString() + "backupJsps.zip")
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "backupJsps()", e)
            }
        }
    }

    def backup(fileBasicArrayList : BasicArrayList, zipFile : String) : Unit = {
        try {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append("ZipFile: ")
            stringBuffer.append(zipFile)
            stringBuffer.append(" BasicArrayList: ")
            stringBuffer.appendint(fileBasicArrayList.size())
            //  "Creating Backup Zip File: " + stringBuffer.toString(), this, "backup()");
            PreLogUtil.put("Creating Backup Zip File: " + stringBuffer.toString(), this, "backup()")
            ZipFileUtil.getInstance().create(zipFile, fileBasicArrayList)
            this.logUtil.putF("Created Backup Zip File", this, "backup()")
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "backup()", e)
            }
        }
    }

}

object BlisketBackupFactory {
    private val instance : BlisketBackupFactory = new BlisketBackupFactory()

    def getInstance() : BlisketBackupFactory = {
        return BlisketBackupFactory.instance
    }

}


