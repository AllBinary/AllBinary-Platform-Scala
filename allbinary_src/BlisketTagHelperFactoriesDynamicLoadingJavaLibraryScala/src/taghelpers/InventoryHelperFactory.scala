/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.admin.taghelpers.HelperFactory

class InventoryHelperFactory private() {
    import _root_.taghelpers.InventoryHelperFactory.{*}

}

object InventoryHelperFactory {
    private val CLASSNAME : String = "taghelpers.InventoryHelper"

    private val FACTORYNAME : String = "taghelpers.InventoryHelperFactory"

    def getInstance(hashMap : HashMap[Object, Object], pageContext : PageContext) : Object = {
        return HelperFactory.getInstance(FACTORYNAME, CLASSNAME, hashMap, pageContext)
    }

}


