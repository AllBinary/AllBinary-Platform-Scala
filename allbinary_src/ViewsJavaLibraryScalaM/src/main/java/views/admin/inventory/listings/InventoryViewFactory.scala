/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory.listings

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonStrings
import _root_.views.generic.inventory.InventorySearch

class InventoryViewFactory private() {
    import _root_.views.admin.inventory.listings.InventoryViewFactory.{*}

}

object InventoryViewFactory {
    def getInstance(searchRequest : SearchRequest) : InventoryViewSearchInterface = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            /*          String className = CLASSNAME;                    Object params[] = new Object[1];          Class classes[] = new Class[1];                             //Add param types          classes[0] = searchRequest.getClass();                    //Add arguments          params[0] = (Object) searchRequest;                    return (InventoryViewSearchInterface) AbeFactory.getInstance().getInstance(className, classes, params);          */
            return new InventorySearch(searchRequest)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, "InventoryViewFactory", "getInstance(SearchRequest)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


