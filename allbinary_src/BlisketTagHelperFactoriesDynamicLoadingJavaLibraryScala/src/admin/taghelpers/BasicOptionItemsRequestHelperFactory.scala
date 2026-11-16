/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class BasicOptionItemsRequestHelperFactory() extends TagHelperFactoryInterface {
    import _root_.admin.taghelpers.BasicOptionItemsRequestHelperFactory.{*}

    def getInstance(hashMap : HashMap[Object, Object], pageContext : PageContext) : Object = {
        return HelperFactory.getInstance(FACTORYNAME, CLASSNAME, hashMap, pageContext)
    }

}

object BasicOptionItemsRequestHelperFactory {
    private val CLASSNAME : String = "admin.taghelpers.BasicOptionItemsRequestHelper"

    private val FACTORYNAME : String = "BasicOptionItemsRequestHelperFactory"

}


