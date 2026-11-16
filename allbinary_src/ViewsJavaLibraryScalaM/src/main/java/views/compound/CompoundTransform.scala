/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.compound

import _root_.java.io.InputStream
import _root_.javax.xml.transform.URIResolver
import _root_.org.allbinary.data.tree.dom.BasicUriResolver
import _root_.org.allbinary.data.tree.dom.StoreUriResolver
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.AbTransformer
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.compound.objectConfig.CompoundContextTransformInfoObjectConfig

class CompoundTransform(param_transformInfoInterface : TransformInfoInterface) extends AbTransformer(param_transformInfoInterface) {

    val logUtil_CompoundTransform : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.setURIResolver((new StoreUriResolver(this.getTransformInfoInterface(), this.getURIResolver().asInstanceOf[BasicUriResolver])).asInstanceOf[URIResolver])
        var objectConfig : CompoundContextTransformInfoObjectConfig = new CompoundContextTransformInfoObjectConfig(this.abeClientInformation, this.getTransformInfoInterface(), this.getTransformInfoInterface().getObjectConfigInterface().toXmlDoc())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_CompoundTransform.putF("\nObjectConfig: \n" + objectConfig.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
        var templateInputStream : InputStream = objectConfig.createInputStream()
        this.setInputStream(templateInputStream)
    }

}


