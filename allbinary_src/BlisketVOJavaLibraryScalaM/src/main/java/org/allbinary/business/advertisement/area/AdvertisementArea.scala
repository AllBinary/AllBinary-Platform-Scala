/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.area

import _root_.java.util.HashMap
import _root_.org.allbinary.business.advertisement.campaign.AdvertisementCampaignData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.w3c.dom.Document

class AdvertisementArea(param_hashMap : HashMap[Object, Object]) extends AdvertisementAreaInterface {

    private var name : String = null

    private var storeName : String = null

    private var description : String = null

    private var advertisementAreaConstraintsInterface : AdvertisementAreaConstraintsInterface = null

    //Ad campaign associated with the ad area
    private var campaign : String = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        this.name = hashMap.get(AdvertisementAreaData.getInstance().NAME).asInstanceOf[String]
        this.storeName = hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        this.description = hashMap.get(AdvertisementAreaData.getInstance().DESCRIPTION).asInstanceOf[String]
        var constraintsDomString : String = hashMap.get(AdvertisementAreaData.getInstance().CONSTRAINTS).asInstanceOf[String]
        var document : Document = DomDocumentHelper.create(constraintsDomString)
        this.advertisementAreaConstraintsInterface = new AdvertisementAreaConstraints(document)
        this.campaign = hashMap.get(AdvertisementCampaignData.getInstance().NAME).asInstanceOf[String]
    }

    def getName() : String = {
        return this.name
    }

    def getStoreName() : String = {
        return this.storeName
    }

    def getDescription() : String = {
        return this.description
    }

    def getConstraints() : AdvertisementAreaConstraintsInterface = {
        return this.advertisementAreaConstraintsInterface
    }

    def getCampaign() : String = {
        return this.campaign
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def setStoreName(storeName : String) : Unit = {
        this.storeName = storeName
    }

    def setDescription(description : String) : Unit = {
        this.description = description
    }

    def setConstraints(advertisementConstraintsInterface : AdvertisementAreaConstraintsInterface) : Unit = {
        this.advertisementAreaConstraintsInterface = this.advertisementAreaConstraintsInterface
    }

    def setCampaign(campaign : String) : Unit = {
        this.campaign = campaign
    }

}


