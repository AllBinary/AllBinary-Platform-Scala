/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.shipping

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.tax.TaxFactory
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethods
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodsData
import _root_.org.allbinary.business.user.commerce.shipping.modules.ShippingInterface
import _root_.org.allbinary.data.tables.user.address.StreetAddressesEntityInterface
import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntityFactory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class ShippingMethodsView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    //extends allbinary.business.component.user.commerce.inventory.shipping.ShippingMethods
    val logUtil_ShippingMethodsView : LogUtil = LogUtil.getInstance()

    private var shippingMethods : ShippingMethods = null

    private var storeFrontInterface : StoreFrontInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.storeFrontInterface = StoreFrontFactory.getInstance(this.getTransformInfoInterface().getStoreName())
        this.shippingMethods = new ShippingMethods(this.abeClientInformation, this.storeFrontInterface)
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var shippingMethodsNode : Node = document.createElement(ShippingMethodsData.SHIPPINGMETHODSORDERSUMMARIES)
            var order : OrderInterface = this.getWeblisketSession().getOrder()
            var basket : BasketInterface = this.getWeblisketSession().getOrder().getBasket()
            var shippingAddressesEntityInterface : StreetAddressesEntityInterface = ShippingAddressesEntityFactory.getInstance().getInstance(this.getWeblisketSession().getUserName())
            var streetAddress : StreetAddress = shippingAddressesEntityInterface.getDefault()
            var shippingVector : BasicArrayList = this.shippingMethods.get()
            val size : Int = shippingVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var shippingMethodNode : Node = document.createElement(ShippingMethodsData.SHIPPINGMETHODORDERSUMMARY)
                    var shipping : ShippingInterface = shippingVector.get(index).asInstanceOf[ShippingInterface]
                    var shippingView : DomNodeInterface = shipping.asInstanceOf[DomNodeInterface]
                    shippingMethodNode.appendChild(shippingView.toXmlNode(document))
                    var shippingCost : Money = shipping.getCost(order)
                    var subTotal : Money = basket.getSubTotal()
                    var taxRate : _root_.java.lang.Float = TaxFactory.getInstance().getInstance(this.abeClientInformation, storeFrontInterface).getTaxRate(streetAddress, storeFrontInterface)
                    var tax : Money = new Money()
                    var total : Money = new Money()
                    total.add(shippingCost.toString())
                    total.add(subTotal.toString())
                    tax.add(total.toString())
                    tax.multiply(taxRate)
                    total.add(tax.toString())
                    shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, ShippingMethodsData.SHIPPINGCOST, shippingCost.toString()))
                    shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, ShippingMethodsData.TAXRATE, taxRate.toString()))
                    shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, ShippingMethodsData.SUBTOTAL, subTotal.toString()))
                    shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, ShippingMethodsData.TAX, tax.toString()))
                    shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, ShippingMethodsData.TOTAL, total.toString()))
                    shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, EntryData.getInstance().DEFAULT, this.shippingMethods.getDefault().getName()))
                    shippingMethodsNode.appendChild(shippingMethodNode)
                    index += 1
                }
            }
            return shippingMethodsNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_ShippingMethodsView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                throw e
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
                var error : String = "Failed to view ShippingMethods"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_ShippingMethodsView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


