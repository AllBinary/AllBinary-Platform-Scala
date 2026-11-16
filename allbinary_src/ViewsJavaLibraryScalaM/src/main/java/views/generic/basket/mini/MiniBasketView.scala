/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.basket.mini

import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketData
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class MiniBasketView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_MiniBasketView : LogUtil = LogUtil.getInstance()

    //   private HttpServletRequest request;
    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var basketInterface : BasketInterface = this.getWeblisketSession().getOrder().getBasket()
            var basketNode : Node = document.createElement(BasketData.BASKET)
            //Set items = itemsAndNumberInBasket.keySet();
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
                    this.logUtil_MiniBasketView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
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
                    this.logUtil_MiniBasketView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


