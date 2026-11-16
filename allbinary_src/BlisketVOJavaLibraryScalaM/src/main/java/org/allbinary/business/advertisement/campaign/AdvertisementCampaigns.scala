/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.campaign

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.advertisement.AdvertisementInterface
import _root_.org.allbinary.business.advertisement.AdvertisementsInterface
import _root_.org.allbinary.business.advertisement.search.AdvertisementSearchInterface

class AdvertisementCampaigns(param_vector : BasicArrayList) extends AdvertisementCampaignsInterface {

    private var advertisementsVector : BasicArrayList = null

    //Constructor
    {
        val vector : BasicArrayList = param_vector
        this.advertisementsVector = this.advertisementsVector
    }

    def add(advertisementInterface : AdvertisementInterface) : Unit = {
        this.advertisementsVector.add(advertisementInterface)
    }

    def get(index : Int) : AdvertisementInterface = {
        return this.advertisementsVector.get(index).asInstanceOf[AdvertisementInterface]
    }

    def size() : Int = {
        return this.advertisementsVector.size()
    }

    def isEnabled() : Boolean = {
        return true
    }

    def search(advertisementSearchInterface : AdvertisementSearchInterface) : AdvertisementsInterface = {
        return null
    }

}


