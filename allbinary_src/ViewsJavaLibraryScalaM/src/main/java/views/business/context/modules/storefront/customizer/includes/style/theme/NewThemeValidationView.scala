/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.includes.style.theme

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.customizer.includes.style.css.template.retail.CssStyleValidation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.customizer.CustomizerUtil
import _root_.views.business.context.modules.storefront.customizer.includes.style.css.CssCustomizerView

class NewThemeValidationView(param_transformInfoInterface : TransformInfoInterface) extends CssCustomizerView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_NewThemeValidationView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.styleValidationInterface = new CssStyleValidation()
    }

    override def toXmlDoc() : Document = {
        return null
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            //Insert XML into the view specified by the Object Config for this view
            CustomizerUtil.getInstance().insert(this.getTransformInfoInterface(), this.styleValidationInterface.asInstanceOf[DomNodeInterface])
            //return isValid;
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_NewThemeValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.styleValidationInterface.validationInfo())
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_NewThemeValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Getting Validation Info"
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    override def view() : String = {
        return views.ValidationOnlyTempUtil.getInstance().view(this)
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


