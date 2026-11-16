/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.area


trait AdvertisementAreaInterface {

    def getName() : String

    def getStoreName() : String

    def getDescription() : String

    def getConstraints() : AdvertisementAreaConstraintsInterface

    def getCampaign() : String

    def setName(name : String) : Unit

    def setStoreName(storeName : String) : Unit

    def setDescription(description : String) : Unit

    def setConstraints(advertisementConstraintsInterface : AdvertisementAreaConstraintsInterface) : Unit

    def setCampaign(campaign : String) : Unit

}


