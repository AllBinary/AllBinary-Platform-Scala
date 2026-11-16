/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.search


class AdvertisementSearchData private() {
    import _root_.org.allbinary.business.advertisement.search.AdvertisementSearchData.{*}

    val TITLE : String = "AFFILIATE_TITLE"

    val PRICE : String = "AFFILIATE_PRICE"

    val RELEVANCY : String = "AFFILIATE_RELEVANCY"

    val POPULARITY : String = "AFFILIATE_POPULARITY"

}

object AdvertisementSearchData {
    private val instance : AdvertisementSearchData = new AdvertisementSearchData()

    def getInstance() : AdvertisementSearchData = {
        return AdvertisementSearchData.instance
    }

}


