/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform

import _root_.javax.xml.transform.URIResolver
import _root_.org.allbinary.data.tree.dom.BasicUriResolver
import _root_.org.allbinary.data.tree.dom.ContextUriResolver
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

class ContextTransformer(param_abeClientInformation : AbeClientInformationInterface, param_transformInfoInterface : TransformInfoInterface) extends BasicTransformer(param_abeClientInformation, param_transformInfoInterface) {

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.setURIResolver((new ContextUriResolver(this.getURIResolver().asInstanceOf[BasicUriResolver])).asInstanceOf[URIResolver])
    }

}


