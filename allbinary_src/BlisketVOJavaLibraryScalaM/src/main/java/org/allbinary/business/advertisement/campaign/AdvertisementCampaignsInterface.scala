/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.campaign

import _root_.org.allbinary.business.advertisement.AdvertisementInterface

trait AdvertisementCampaignsInterface {

    def add(advertisementInterface : AdvertisementInterface) : Unit

    def get(index : Int) : AdvertisementInterface

    def size() : Int

    def isEnabled() : Boolean

}


