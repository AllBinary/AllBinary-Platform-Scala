/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.generic.inventory

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.taghelpers.InventoryHelperFactory
import _root_.tags.StoreValidationTransformTag

class InventoryTag() extends StoreValidationTransformTag() {

    val logUtil_InventoryTag : LogUtil = LogUtil.getInstance()

    private def search() : Unit = {
        try {
            var anyType : Object = new InventoryHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("search", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            pageContext.getOut().print(result)
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to search Inventory by keyword"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_InventoryTag.put(this.commonStrings.EXCEPTION, this, "search()", e)
                }
                try {
                    pageContext.getOut().print(error + "<br>")
                    pageContext.getOut().print(("Exception: " + e) + "<br>")
                } catch {
                    case e2 : Exception => {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LICENSINGERROR)) {
                            this.logUtil_InventoryTag.put("Exception in Exception Handling", this, "search()", e)
                        }
                    }
                }
            }
        }
    }

    private def viewSummary() : Unit = {
        try {
            var anyType : Object = new InventoryHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("viewSummary", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            pageContext.getOut().print(result)
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to View Summary"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_InventoryTag.put(this.commonStrings.EXCEPTION, this, "viewSummary()", e)
                }
                try {
                    pageContext.getOut().print(error + "<br>")
                    pageContext.getOut().print(("Exception: " + e) + "<br>")
                } catch {
                    case e2 : Exception => {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LICENSINGERROR)) {
                            this.logUtil_InventoryTag.put("Exception in Exception Handling", this, "viewSummary())", e)
                        }
                    }
                }
            }
        }
    }

    override def doStartTag() : Int = {
        try {
            if (this.getCommand() != null) {
                //this.propertiesHashMap.put(BasicItemData.ID, this.id);
                if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.SEARCH) == 0) {
                    this.setName("Basic Search Inventory View")
                    this.setObjectFile("views.generic.inventory.AutoSearchValidationInventoryView")
                    this.search()
                    return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.VIEWSUMMARY) == 0) {
                    this.setName("Basic Inventory View")
                    this.setObjectFile("views.generic.inventory.AutoValidationInventoryView")
                    this.viewSummary()
                    return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
                } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.VIEW) == 0) {
                    this.setName("Basic Inventory View")
                    this.setObjectFile("views.generic.inventory.AutoValidationInventoryView")
                    return super.doStartTag()
                } else {
                    throw new Exception("No Such View Command: " + this.getCommand())
                }
            }
            throw new Exception("Command Null")
        } catch {
            case e : LicensingException => {
                AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


