/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.inventory

import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemView
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.StoreTransformer
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformStoreDocumentFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpSearch
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class InventorySearchProductUtil {
    import _root_.views.generic.inventory.InventorySearchProductUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val ITEM_NOT_FOUND : String = "Item Not Found."

    def getProduct(abeClientInformation : AbeClientInformationInterface, searchRequest : SearchRequest, product : String) : String = {
        try {
            var inventoryEntityInterface : InventoryEntity = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
            var itemInterface : ItemInterface = inventoryEntityInterface.getItem(product)
            if (itemInterface != null) {
                var viewDocumentInterface : TransformDocumentInterface = TransformStoreDocumentFactory.getInstance(searchRequest)
                viewDocumentInterface.getBaseNode().appendChild(new BasicItemView(itemInterface, new BasicArrayListD()).toXmlNode(viewDocumentInterface.getDoc()))
                var success : String = XmlDocumentHelper.toString(viewDocumentInterface.getDoc())
                var outputStr : String = new StoreTransformer(abeClientInformation, (new TransformInfoHttpSearch(searchRequest)).asInstanceOf[TransformInfoInterface]).translate(success)
                return outputStr
            } else {
                return this.ITEM_NOT_FOUND
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.FAILURE, this, "getProduct", e)
                }
                throw new Exception("Failed to getProduct")
            }
        }
        throw new IllegalStateException()
    }

}

object InventorySearchProductUtil {
    private val instance : InventorySearchProductUtil = new InventorySearchProductUtil()

    def getInstance() : InventorySearchProductUtil = {
        return InventorySearchProductUtil.instance
    }

}


