/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.workflow

import _root_.org.allbinary.data.tables.workflow.WorkFlowEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.control.workflow.NewWorkFlowFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class AddValidationView(param_transformInfoInterface : TransformInfoInterface) extends WorkFlowView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_AddValidationView : LogUtil = LogUtil.getInstance()

    private val abeClientInformation_AddValidationView : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.workFlowInterface = NewWorkFlowFactory.getInstance().getInstance(this.abeClientInformation_AddValidationView, this.getPropertiesHashMap(), this.getPageContext())
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            /*          if(WorkFlowEntityFactory.getInstance().create2().get(             this.workFlowInterface.getName(),              this.getTransformInfoInterface().getStoreName())!=null)          {             if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().VIEW))             {                this.logUtil.putF("WorkFlow already in existance.", this, this.commonStrings.IS_VALID);             }             return Boolean.FALSE;          }                    if(this.workFlowInterface.isValid() == Boolean.FALSE) return Boolean.FALSE;           */
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (WorkFlowEntityFactory.getInstance().create2().get(this.workFlowInterface.getName(), this.getTransformInfoInterface().getStoreName()) != null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_AddValidationView.putF("Workflow already exist", this, "validationInfo()")
                }
                stringBuffer.append("The WorkFlow name you selected is already in use.<br/>  Please select another Name.<br />")
            }
            /*          if(this.workFlowInterface.isValid() == Boolean.FALSE)          {             stringBuffer.append(this.workFlowInterface.validationInfo());          }          */
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
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


