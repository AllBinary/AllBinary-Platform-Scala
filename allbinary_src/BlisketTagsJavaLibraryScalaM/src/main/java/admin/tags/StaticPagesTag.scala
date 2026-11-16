/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.StaticPagesHelperFactory
import _root_.admin.taghelpers.StaticPagesRequestHelperFactory
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchData
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData

class StaticPagesTag() extends TableTag {

    val logUtil_StaticPagesTag : LogUtil = LogUtil.getInstance()

    private var xslFile : String = null

    //Constructor
    {
        this.setTagHelperFactory(new StaticPagesHelperFactory())
        this.setTagRequestHelperFactory(new StaticPagesRequestHelperFactory())
    }

    def setXsl(value : String) : Unit = {
        this.xslFile = value
    }

    def generateStaticPages() : String = {
        try {
            //this.logUtil.putF(this.commonStrings.START, this, "generateStaticPages()");
            var anyType : Object = new StaticPagesRequestHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("generateStaticPages", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to generate staticpages table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StaticPagesTag.put(this.commonStrings.EXCEPTION, this, "generateStaticPages()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def makePublic() : String = {
        try {
            var anyType : Object = new StaticPagesRequestHelperFactory().getInstance(this.getPropertiesHashMap(), this.pageContext)
            var helperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("makePublic", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to makePublic"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StaticPagesTag.put(this.commonStrings.EXCEPTION, this, "makePublic()", e)
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
                    //this.logUtil.putF(CommonLabels.getInstance().START + this.getCommand(), this, tagStrings.DO_START_TAG);
                    if (this.getCommand().compareTo(SearchData.GENERATESTATICPAGES) == 0) {
                        this.getPropertiesHashMap().put(TransformInfoData.getInstance().TEMPLATEFILENAME, this.xslFile)
                        val output : String = this.generateStaticPages()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output)
                        }
                    } else if (this.getCommand().compareTo(SearchData.MAKEPUBLIC) == 0) {
                        val output : String = this.makePublic()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output)
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


