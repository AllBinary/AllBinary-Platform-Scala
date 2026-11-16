/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.CategoryHelperFactory
import _root_.admin.taghelpers.CategoryRequestHelperFactory
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData

class CategoryTag() extends TableTag {

    val logUtil_CategoryTag : LogUtil = LogUtil.getInstance()

    private var xsl : String = null

    //Constructor
    {
        this.setTagHelperFactory(new CategoryHelperFactory())
        this.setTagRequestHelperFactory(new CategoryRequestHelperFactory())
    }

    def setXsl(value : String) : Unit = {
        this.xsl = value
    }

    private def viewCategory() : String = {
        try {
            var anyType : Object = new CategoryRequestHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("viewCategory", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to view a Category"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_CategoryTag.put(this.commonStrings.EXCEPTION, this, "viewCategory()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    private def viewCategories() : String = {
        try {
            var anyType : Object = new CategoryRequestHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("viewCategories", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to view a Categories"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_CategoryTag.put(this.commonStrings.EXCEPTION, this, "viewCategories()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (this.isEnabled()) {
                if (this.getCommand() != null) {
                    this.getPropertiesHashMap().put(TransformInfoData.getInstance().TEMPLATEFILENAME, this.xsl)
                    if (this.getCommand().compareTo(CategoryData.getInstance().VIEW) == 0) {
                        var output : String = this.viewCategory()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            pageContext.getOut().print(output)
                        }
                    } else if (this.getCommand().compareTo(CategoryData.getInstance().VIEW) == 0) {
                        var output : String = this.viewCategories()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            pageContext.getOut().print(output)
                        }
                    } else {
                        return super.doStartTag()
                    }
                }
            }
            return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
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


