/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.BasicErrorNodeUtil
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class EmailsNotUsed() extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    var emailInfoVector : BasicArrayList = null

    //Constructor
    {
        this.emailInfoVector = new BasicArrayListD()
    }

    def toXmlNode(document : Document) : Node = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
                this.logUtil.putF(this.commonStrings.START, this, "toXmlNode")
            }
            var node : Node = document.createElement(EmailData.NAME)
            val size : Int = this.emailInfoVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var email : Email = this.emailInfoVector.get(index).asInstanceOf[Email]
                    var emailNode : Node = email.toXmlNode(document)
                    if (emailNode != null) {
                        node.appendChild(emailNode)
                    }
                    index += 1
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
                this.logUtil.putF(this.commonStrings.END, this, "toXmlNode()")
            }
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "toXmlNode()", e)
                }
                var error : String = "Error Processing Order.  Please contact us if error persists.<p/>"
                return BasicErrorNodeUtil.get(document, error)
            }
        }
        throw new IllegalStateException()
    }

}


