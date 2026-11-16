/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.user

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.UserDomNode
import _root_.org.allbinary.business.user.UsersData
import _root_.org.allbinary.business.user.modules.User
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.HttpContextView

class UsersView(param_transformInfoInterface : TransformInfoInterface) extends HttpContextView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_UsersView : LogUtil = LogUtil.getInstance()

    var userVector : BasicArrayList = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var usersNode : Node = document.createElement(UsersData.NAME)
            var size : Int = this.userVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var userInterface : User = this.userVector.get(index).asInstanceOf[User]
                    if (userInterface != null) {
                        var node : Node = new UserDomNode(userInterface).toXmlNode(document)
                        usersNode.appendChild(node)
                    } else {
                        this.logUtil_UsersView.putF("UserHelper", this, "toXmlNode")
                    }
                    index += 1
                }
            }
            return usersNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_UsersView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def addDomNodeInterfaces() : Unit = {
        this.addDomNodeInterface(this.asInstanceOf[DomNodeInterface])
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_UsersView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


