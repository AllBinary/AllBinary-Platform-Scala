/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package workflows.template.data

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.javax.servlet.jsp.tagext.TagSupport
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.control.workflow.WorkFlowData
import _root_.org.allbinary.logic.control.workflow.WorkFlowInterface
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.TransformFactory
import _root_.org.allbinary.string.CommonStrings

class BasicWorkFlow(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends WorkFlowInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var validationDomNodeInterface : ValidationComponentInterface = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().WORKFLOW)) {
            this.logUtil.putF("Properties: " + propertiesHashMap.toString(), this, "BasicWorkFlow()")
        }
        this.propertiesHashMap = propertiesHashMap
        this.pageContext = pageContext
        this.validationDomNodeInterface = TransformFactory.getInstance().getInstance(this.abeClientInformation, propertiesHashMap, pageContext).asInstanceOf[ValidationComponentInterface]
    }

    def getName() : String = {
        return this.getPropertiesHashMap().get(WorkFlowData.getInstance().NAME).asInstanceOf[String]
    }

    def getPropertiesHashMap() : HashMap[Object, Object] = {
        return this.propertiesHashMap
    }

    def getPageContext() : PageContext = {
        return this.pageContext
    }

    def process() : Integer = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().WORKFLOW)) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.PROCESS)
        }
        if (this.validationDomNodeInterface.isValid().booleanValue()) {
            this.pageContext.getOut().print(this.validationDomNodeInterface.view())
            return Integer.valueOf(TagSupport.EVAL_BODY_INCLUDE)
        } else {
            //super.doStartTag();
            this.pageContext.getOut().print(this.validationDomNodeInterface.validationInfo())
            return Integer.valueOf(TagSupport.SKIP_BODY)
        }
        throw new IllegalStateException()
    }

}


