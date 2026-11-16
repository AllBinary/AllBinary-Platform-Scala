/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.campaign


class AdvertisementCampaignData private() {
    import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaignData.{*}

    val NAME : String = "ADVERTISEMENTCAMPAIGN_NAME"

    val DESCRIPTION : String = "ADVERTISEMENTCAMPAIGN_DESCRIPTION"

    val CONFIG : String = "ADVERTISEMENTCAMPAIGN_CONFIG"

}

object AdvertisementCampaignData {
    private val instance : AdvertisementCampaignData = new AdvertisementCampaignData()

    def getInstance() : AdvertisementCampaignData = {
        return AdvertisementCampaignData.instance
    }

}


