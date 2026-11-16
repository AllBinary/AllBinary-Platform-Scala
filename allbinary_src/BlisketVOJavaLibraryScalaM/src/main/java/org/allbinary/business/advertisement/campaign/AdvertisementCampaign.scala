/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.campaign

import _root_.java.util.HashMap
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.business.advertisement.AdvertisementsInterface
import _root_.org.allbinary.business.advertisement.search.AdvertisementSearchInterface

class AdvertisementCampaign(param_hashMap : HashMap[Object, Object]) extends AdvertisementCampaignInterface {

    private var hashMap : HashMap[Object, Object] = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        this.hashMap = hashMap
    }

    def getComponent() : Object = {
        //return (Object) this.hashMap.get(AdvertisementCampaignData.NAME);
        return null
    }

    def getName() : String = {
        return this.hashMap.get(AdvertisementCampaignData.getInstance().NAME).asInstanceOf[String]
    }

    def setComponentName(name : String) : Unit = {
        this.hashMap.put(DynamicObjectData.NAME, name)
    }

    def setName(name : String) : Unit = {
        this.hashMap.put(AdvertisementCampaignData.getInstance().NAME, name)
    }

    //Will Retrieve the appropriate advertisment from the selected campaigns/advertisementPrograms
    def search(advertisementSearchInterface : AdvertisementSearchInterface) : AdvertisementsInterface = {
        return null
    }

}


