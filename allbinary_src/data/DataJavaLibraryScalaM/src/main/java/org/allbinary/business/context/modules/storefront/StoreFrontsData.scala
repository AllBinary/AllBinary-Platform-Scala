/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront


class StoreFrontsData {
    import _root_.org.allbinary.business.context.modules.storefront.StoreFrontsData.{*}

    //StoreFront Commands
    val TYPE : String = "STOREFRONTS_TYPE"

    //Generic Store Types = Not required - Can use your own type
    val RETAIL : String = "STOREFRONTS_RETAIL"

    val SUBSCRIPTION : String = "STOREFRONTS_SUBSCRIPTION"

    val AUCTION : String = "STOREFRONTS_AUCTION"

    val NEWS : String = "STOREFRONTS_NEWS"

    val BLOG : String = "STOREFRONTS_BLOG"

    val FORUM : String = "STOREFRONTS_FORUM"

}

object StoreFrontsData {
    private val instance : StoreFrontsData = new StoreFrontsData()

    def getInstance() : StoreFrontsData = {
        return StoreFrontsData.instance
    }

}


