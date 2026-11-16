/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package workflows.template.data

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.logic.control.workflow.StoreWorkFlowInterface

class BasicStoreWorkFlow(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends BasicWorkFlow(param_propertiesHashMap, param_pageContext) with StoreWorkFlowInterface {

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
    }

    override def getStoreName() : String = {
        return this.getPropertiesHashMap().get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
    }

}


