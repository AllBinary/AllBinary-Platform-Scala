/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.area


class AdvertisementAreaData private() {
    import _root_.org.allbinary.business.advertisement.area.AdvertisementAreaData.{*}

    val NAME : String = "ADVERTISEMENT_NAME"

    val DESCRIPTION : String = "ADVERTISEMENT_DESCRIPTION"

    val CONSTRAINTS : String = "ADVERTISEMENT_CONSTRAINTS"

}

object AdvertisementAreaData {
    private val instance : AdvertisementAreaData = new AdvertisementAreaData()

    def getInstance() : AdvertisementAreaData = {
        return AdvertisementAreaData.instance
    }

}


