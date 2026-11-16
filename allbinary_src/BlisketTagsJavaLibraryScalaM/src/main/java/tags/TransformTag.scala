/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.TagHelperFactoryInterface
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.taghelpers.ViewHelperFactory
import _root_.tags.transform.info.TransformInfoTag

class TransformTag private (super_1 : ViewHelperFactory, constructor_ : Unit) extends TransformInfoTag(super_1) {

    val logUtil_TransformTag : LogUtil = LogUtil.getInstance()

    def this(tagHelperFactoryInterface : TagHelperFactoryInterface) = {
        this(tagHelperFactoryInterface, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_TransformTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    //view object that implements the view interface
    def this() = {
        this(new ViewHelperFactory(), ())
        //this.helperObject = null;
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_TransformTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def view() : String = {
        try {
            var result : String = this.getHelper().getClass().getMethod("view", null).invoke(this.getHelper(), null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGERROR)) {
                    this.logUtil_TransformTag.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_TransformTag.putF("Creating with: \n" + this.getPropertiesHashMap().toString(), this, tagStrings.DO_START_TAG)
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("ViewTag Start For: ")
                stringBuffer.append(this.getName())
                stringBuffer.append("\nViewFile: ")
                stringBuffer.append(this.getObjectFile())
                this.logUtil_TransformTag.putF(stringBuffer.toString(), this, tagStrings.DO_START_TAG)
            }
            this.setHelper()
            pageContext.getOut().print(this.view())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_TransformTag.putF("Tag End", this, tagStrings.DO_START_TAG)
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


