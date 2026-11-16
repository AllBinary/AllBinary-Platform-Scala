/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.html.select.HtmlSelect
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps

class StoreFrontsHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends BasicTable {
    import _root_.admin.taghelpers.StoreFrontsHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private StoreFrontInterface storeFrontInterface;
    private var portion : Portion = null

    private val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.portion = new Portion(hashMap)
    }

    override def drop() : String = {
        try {
            var success : String = StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance().dropTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, this.commonStrings.DROP)
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to drop storefronts table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.DROP, e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def create() : String = {
        try {
            var success : String = StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance().createTable()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "create()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to create new storefronts table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "create()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def restore() : String = {
        try {
            val success : String = "Restore Successful"
            val result : String = AbSqlTableUtil.getInstance().restoreTable(StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance(), this.portion)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "restore()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to restore backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "restore()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def backup() : String = {
        try {
            val success : String = "Restore Successful"
            val result : String = AbSqlTableUtil.getInstance().backupTable(StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "backup()")
            }
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to make backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "backup()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def generateSelect() : String = {
        try {
            var success : String = CommonSeps.getInstance().SPACE
            var storeNamesVector : BasicArrayList = StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance().getStoreFrontNames()
            var storeSelect : HtmlSelect = new HtmlSelect(StringUtil.getInstance().EMPTY_STRING, this.commonPhoneStrings.ONE, StoreFrontData.getInstance().SELECTSTORENAME, StringUtil.getInstance().EMPTY_STRING)
            storeSelect.addAttribute(StoreFrontsHelper.CLASS, StoreFrontsHelper.TEXT)
            val size : Int = storeNamesVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var storeName : String = storeNamesVector.get(index).asInstanceOf[String]
                    storeSelect.addOption(storeName)
                    index += 1
                }
            }
            success += storeSelect
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "generateSelect()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to generate storefronts select"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "generateSelect()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}

object StoreFrontsHelper {
    private val CLASS : String = "class"

    private val TEXT : String = "text"

}


