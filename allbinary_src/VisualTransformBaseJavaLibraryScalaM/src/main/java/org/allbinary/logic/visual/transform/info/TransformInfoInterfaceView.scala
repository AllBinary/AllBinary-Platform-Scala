/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class TransformInfoInterfaceView(param_transformInfoInterface : TransformInfoInterface) extends DomNodeInterface {

    private var transformInfoInterface : TransformInfoInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.transformInfoInterface = transformInfoInterface
    }

    def toXmlNode(document : Document) : Node = {
        return ModDomHelper.createNameValueNodes(document, TransformInfoData.getInstance().NAME, this.transformInfoInterface.toHashMap())
    }

}


