/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.basket

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketData
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemView
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class BasketView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_BasketView : LogUtil = LogUtil.getInstance()

    //private HashMap propertiesHashMap;
    private var request : HttpServletRequest = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        //this.propertiesHashMap = hashMap;
        this.request = this.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var inventoryEntity : InventoryEntity = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
            var basketInterface : BasketInterface = this.getWeblisketSession().getOrder().getBasket()
            var basketNode : Node = document.createElement(BasketData.BASKET)
            var itemsAndNumberInBasket : HashMap[Object, Object] = basketInterface.getItems().asInstanceOf[HashMap[Object, Object]]
            var numberOfResults : Int = 1
            var items : Set[Object] = itemsAndNumberInBasket.keySet().asInstanceOf[Set[Object]]
            val productArray : Array[Object] = items.toArray()
            val size : Int = productArray.length

            {
                var index : Int = 0
                while (index < size) {
                    var product : String = new String(productArray(index).asInstanceOf[String])
                    var itemInterface : ItemInterface = inventoryEntity.getItem(product)
                    if (itemInterface != null) {
                        var basicItemView : BasicItemView = new BasicItemView(itemInterface, new BasicArrayListD())
                        var node : Node = basicItemView.toXmlNode(document)
                        var numberInBasket : String = basketInterface.getNumberOf(product).toString()
                        node.appendChild(ModDomHelper.createNameValueNodes(document, BasketData.ITEMTOTALINBASKET, numberInBasket))
                        //add = total is number * items price
                        var itemPrice : Money = itemInterface.getPrice()
                        var itemTotal : Money = new Money(itemPrice)
                        itemTotal.multiply(basketInterface.getNumberOf(product).intValue())
                        node.appendChild(ModDomHelper.createNameValueNodes(document, BasketData.ITEMTOTAL, itemTotal.toString()))
                        basketNode.appendChild(node)
                    } else {
                        this.logUtil_BasketView.putF("Product Failed: " + product, this, "toXmlNode")
                    }
                    numberOfResults += 1
                    index += 1
                }
            }
            var totalNumberNode : Node = document.createElement(SearchData.TOTAL_NUMBER_ITEMS)
            var totalNumberTextNode : Node = document.createTextNode(basketInterface.getNumberOfItems().toString())
            totalNumberNode.appendChild(totalNumberTextNode)
            var totalWeightNode : Node = document.createElement(BasketData.TOTALWEIGHT)
            var totalWeightTextNode : Node = document.createTextNode(basketInterface.getTotalWeight().toString())
            totalWeightNode.appendChild(totalWeightTextNode)
            var subTotalNode : Node = document.createElement(BasketData.SUBTOTAL)
            var subTotalTextNode : Node = document.createTextNode(basketInterface.getSubTotal().toString())
            subTotalNode.appendChild(subTotalTextNode)
            basketNode.appendChild(totalNumberNode)
            basketNode.appendChild(totalWeightNode)
            basketNode.appendChild(subTotalNode)
            return basketNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_BasketView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
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
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_BasketView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


