/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.user

import _root_.org.allbinary.business.user.UserDomNode
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class UserView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_UserView : LogUtil = LogUtil.getInstance()

    var user : UserInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def addDomNodeInterfaces() : Unit = {
        this.addDomNodeInterface((new UserDomNode(this.user)).asInstanceOf[DomNodeInterface])
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_UserView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


