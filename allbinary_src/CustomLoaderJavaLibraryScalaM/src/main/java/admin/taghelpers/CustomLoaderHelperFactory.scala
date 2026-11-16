/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class CustomLoaderHelperFactory() extends TagHelperFactoryInterface {
    import _root_.admin.taghelpers.CustomLoaderHelperFactory.{*}

    def getInstance(hashMap : HashMap[Object, Object], pageContext : PageContext) : Object = {
        val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()
        return HelperFactory.getInstance(abeClientInformation, FACTORYNAME, CLASSNAME, hashMap, pageContext)
    }

    def getInstance(abeClientInformation : AbeClientInformationInterface) : Object = {
        return HelperFactory.getInstance(abeClientInformation, FACTORYNAME, CustomLoaderHelperFactory.CLASSNAME)
    }

}

object CustomLoaderHelperFactory {
    private val CLASSNAME : String = "admin.taghelpers.CustomLoaderHelper"

    private val FACTORYNAME : String = "CustomLoaderHelperFactory"

}


