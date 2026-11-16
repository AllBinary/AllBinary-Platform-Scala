/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.views.admin.payment.PaymentProcessorComponent

class PaymentProcessHelper(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    private var paymentProcessorComponent : PaymentProcessorComponent = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        var transformInfoInterface : TransformInfoHttpInterface = TransformInfoHttpFactory.getInstance(propertiesHashMap, pageContext).asInstanceOf[TransformInfoHttpInterface]
        this.paymentProcessorComponent = new PaymentProcessorComponent(transformInfoInterface)
    }

    def process() : String = {
        return this.paymentProcessorComponent.view()
    }

}


