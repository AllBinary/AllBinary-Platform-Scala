/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.workflow

import _root_.org.allbinary.data.tables.workflow.WorkFlowEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.control.workflow.WorkFlowData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class EditValidationView(param_transformInfoInterface : TransformInfoInterface) extends WorkFlowView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_EditValidationView : LogUtil = LogUtil.getInstance()

    private var workFlowName : String = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
        this.workFlowName = httpTransformInfoInterface.getPageContext().getRequest().getParameter(WorkFlowData.getInstance().NAME)
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (this.workFlowName == null) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (WorkFlowEntityFactory.getInstance().create2().get(this.workFlowName, this.getTransformInfoInterface().getStoreName()) == null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("WorkFlow does not exist.", this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditValidationView.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (this.workFlowName == null) {
                stringBuffer.append("WorkFlow name is invalid<br />")
            }
            if (WorkFlowEntityFactory.getInstance().create2().get(this.workFlowName, this.getTransformInfoInterface().getStoreName()) == null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_EditValidationView.putF("WorkFlow does not exist.", this, "validationInfo()")
                }
                stringBuffer.append("WorkFlow does not exist<br />")
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
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


