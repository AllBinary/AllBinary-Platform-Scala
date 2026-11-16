/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.includes.style.css.template.retail

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.customizer.includes.style.css.template.retail.EditCssStyleValidation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.customizer.CustomizerUtil
import _root_.views.business.context.modules.storefront.customizer.includes.style.css.CssCustomizerView

class EditCssValidationView(param_transformInfoInterface : TransformInfoInterface) extends CssCustomizerView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_EditCssValidationView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var document : Document = CustomizerUtil.getInstance().getViewDataForComponentsInObjectConfig(this.getTransformInfoInterface())
            this.styleValidationInterface = new EditCssStyleValidation(document)
            var isValid : _root_.java.lang.Boolean = this.styleValidationInterface.isValid()
            return isValid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditCssValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
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
                    this.logUtil_EditCssValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
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

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


