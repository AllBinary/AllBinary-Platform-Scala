/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.globals

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class UrlGlobalsView() extends DomNodeInterface {

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(UrlGlobalsData.WEBAPPPATH, _root_.org.allbinary.globals.URLGLOBALS.getWebappPath())
        var node : Node = ModDomHelper.createNameValueNodes(document, UrlGlobalsData.NAME, hashMap)
        return node
    }

}


