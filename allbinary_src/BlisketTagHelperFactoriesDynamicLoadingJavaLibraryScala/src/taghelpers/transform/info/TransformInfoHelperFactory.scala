/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.admin.taghelpers.TagHelperFactoryInterface
import _root_.admin.taghelpers.HelperFactory

class TransformInfoHelperFactory() extends TagHelperFactoryInterface {
    import _root_.taghelpers.transform.info.TransformInfoHelperFactory.{*}

    def getInstance(hashMap : HashMap[Object, Object], pageContext : PageContext) : Object = {
        return HelperFactory.getInstance(FACTORYNAME, CLASSNAME, hashMap, pageContext)
    }

}

object TransformInfoHelperFactory {
    private val CLASSNAME : String = "taghelpers.transform.info.TransformInfoHelper"

    private val FACTORYNAME : String = "TransformInfoHelperFactory"

}


