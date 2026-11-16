/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.apache.xmlrpc

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.NullUtil

/**  *  * @author User  */
class NullXmlRpcHandler extends XmlRpcHandler {
    import _root_.org.apache.xmlrpc.NullXmlRpcHandler.{NULL_XML_RPC_HANDLER as _, *}
    def NULL_XML_RPC_HANDLER : NullXmlRpcHandler = _root_.org.apache.xmlrpc.NullXmlRpcHandler.NULL_XML_RPC_HANDLER

    override def execute(method : String, params : BasicArrayList) : Object = {
        return NullUtil.getInstance().NULL_OBJECT
    }

}

object NullXmlRpcHandler {
    val NULL_XML_RPC_HANDLER : NullXmlRpcHandler = new NullXmlRpcHandler()

}


