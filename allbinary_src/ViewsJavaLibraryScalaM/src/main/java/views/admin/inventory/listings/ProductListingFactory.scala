/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory.listings

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.string.CommonStrings

class ProductListingFactory private() {
    import _root_.views.admin.inventory.listings.ProductListingFactory.{*}

}

object ProductListingFactory {
    def getInstance(searchRequest : SearchRequest) : ProductListingInterface = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            //return (ProductListingInterface) InterfaceCastProxy.newInstance(object);
            return (new _root_.views.admin.inventory.listings.ProductListing(searchRequest)).asInstanceOf[ProductListingInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, "ProductListingFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


