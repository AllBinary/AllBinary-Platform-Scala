/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.admin.taghelpers.TagHelperFactoryInterface
import _root_.admin.taghelpers.HelperFactory

class TransformInfoRequestHelperFactory() extends TagHelperFactoryInterface {
    import _root_.taghelpers.transform.info.TransformInfoRequestHelperFactory.{*}

    def getInstance(hashMap : HashMap[Object, Object], pageContext : PageContext) : Object = {
        return HelperFactory.getInstance(FACTORYNAME, CLASSNAME, hashMap, pageContext)
    }

}

object TransformInfoRequestHelperFactory {
    private val CLASSNAME : String = "taghelpers.transform.info.TransformInfoRequestHelper"

    private val FACTORYNAME : String = "TransformInfoRequestHelperFactory"

}


