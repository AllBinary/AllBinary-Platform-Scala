/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.org.allbinary.business.error.ErrorData
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicErrorNodeUtil private() {
    import _root_.org.allbinary.data.tree.dom.BasicErrorNodeUtil.{*}

}

object BasicErrorNodeUtil {
    def get(document : Document, errorText : String) : Node = {
        try {
            //String error = "Error Processing Order.  Please contact us if error persists.<p/>";
            var node : Node = document.createElement(ErrorData.getInstance().NAME)
            node.appendChild(ModDomHelper.createNameValueNodes(document, ErrorData.getInstance().TEXT, errorText))
            return node
        } catch {
            case e : Exception => {
                /*          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().XMLLOGGINGERROR))          {             this.logUtil.put("Error Node Creation Failure","BasicErrorNodeUtil","get()",e);          }           */
                throw new Exception("Error Node Creation Failure")
            }
        }
        throw new IllegalStateException()
    }

}


