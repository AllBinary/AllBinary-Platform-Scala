/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.taghelpers.StoreTagWorkFlowHelperFactory

//and hidden field removal
class StoreWorkFlowTag() extends HelperTag(new StoreTagWorkFlowHelperFactory()) {

    val logUtil_StoreWorkFlowTag : LogUtil = LogUtil.getInstance()

    private var viewName : String = null

    private var viewFile : String = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_StoreWorkFlowTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def setName(value : String) : Unit = {
        this.viewName = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().NAME, this.viewName)
    }

    /*    public void setObjectFile(String value)    {       this.viewFile = value;       this.getPropertiesHashMap().put(TransformInfoData.OBJECTFILENAME, this.viewFile);    }    */
    private def process() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_StoreWorkFlowTag.putF(this.commonStrings.START, this, this.commonStrings.PROCESS)
            }
            var helperClass : Class[?] = this.getHelper().getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(commonStrings.PROCESS, null)
            var result : Integer = method.invoke(this.getHelper(), null).asInstanceOf[Integer]
            return result.intValue()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StoreWorkFlowTag.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_StoreWorkFlowTag.putF(this.commonStrings.START, this, tagStrings.DO_START_TAG)
            }
            this.setHelper()
            return this.process()
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


