/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.address.billing

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.address.BillingAddressData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.address.StreetAddressData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class BillingAddressesView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_BillingAddressesView : LogUtil = LogUtil.getInstance()

    private var request : HttpServletRequest = null

    var streetAddresses : BasicArrayList = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
        this.request = httpTransformInfoInterface.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
    }

    def getRequest() : HttpServletRequest = {
        return this.request
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var billingAddressesNode : Node = document.createElement(BillingAddressData.MULTIPLE)
            var size : Int = this.streetAddresses.size()

            {
                var index : Int = 0
                while (index < size) {
                    var streetAddress : StreetAddress = this.streetAddresses.get(index).asInstanceOf[StreetAddress]
                    billingAddressesNode.appendChild(streetAddress.toXmlNode(document))
                    index += 1
                }
            }
            billingAddressesNode.appendChild(ModDomHelper.createNameValueNodes(document, StreetAddressData.NUMBEROFADDRESSES, new Integer(streetAddresses.size()).toString()))
            return billingAddressesNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_BillingAddressesView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                //throw e;
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
                    this.logUtil_BillingAddressesView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


