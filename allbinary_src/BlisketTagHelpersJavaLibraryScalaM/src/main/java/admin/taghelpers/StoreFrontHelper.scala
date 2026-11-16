/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFront
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.string.CommonSeps

class StoreFrontHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    private var storeFrontInterface : StoreFrontInterface = null

    private var currentLocation : String = null

    private var currentHomeLocation : String = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        var storeName : String = hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        if (storeName != null) {
            this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
            this.currentLocation = new Replace(CommonSeps.getInstance().SPACE, "%20").all(this.storeFrontInterface.getCurrentHostName() + this.storeFrontInterface.getCurrentHostNamePath())
            this.currentHomeLocation = new Replace(CommonSeps.getInstance().SPACE, "%20").all(this.storeFrontInterface.getCurrentHomeHostName() + this.storeFrontInterface.getCurrentHomeHostNamePath())
        } else {
            val stringUtil : StringUtil = StringUtil.getInstance()
            this.storeFrontInterface = new StoreFront()
            this.currentLocation = stringUtil.EMPTY_STRING
            this.currentHomeLocation = stringUtil.EMPTY_STRING
        }
    }

    def getCurrentLocation() : String = {
        return this.currentLocation
    }

    def getCurrentHomeLocation() : String = {
        return this.currentHomeLocation
    }

}


