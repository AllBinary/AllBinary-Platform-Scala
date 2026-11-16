/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.admin.taghelpers.TagHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.workflow.StoreTagWorkFlowFactory
import _root_.org.allbinary.logic.control.workflow.StoreWorkFlowInterface
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class StoreTagWorkFlowHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    //implements StoreWorkFlowInterface
    val logUtil : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var storeWorkFlowInterface : StoreWorkFlowInterface = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        /*       StoreFrontInterface storeFrontInterface =          StoreFrontFactory.getInstance(             new WeblisketSession(hashMap, pageContext).getStoreName());              viewName = storeFrontInterface.getName() + " " + viewName + " " + CustomizerTransformInfoData.NAME ;       hashMap.put(TransformInfoData.NAME, viewName);       */
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
            this.logUtil.putF("Properties: " + hashMap.toString(), this, "StoreTagWorkFlowHelper()")
        }
        this.storeWorkFlowInterface = StoreTagWorkFlowFactory.getInstance().getInstance(this.abeClientInformation, hashMap, pageContext)
    }

    def process() : Integer = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                this.logUtil.putF("Process", this, this.commonStrings.PROCESS)
            }
            return this.storeWorkFlowInterface.process()
        } catch {
            case e : Exception => {
                var error : String = "Failed to process workflow: "
                //else error += "Unknown";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


