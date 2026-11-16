/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement

import _root_.org.allbinary.business.advertisement.image.AdvertisementImageInterface
import _root_.org.allbinary.business.advertisement.product.AdvertisementProductInterface
import _root_.org.allbinary.business.advertisement.thumbnail.AdvertisementThumbnailInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.logic.control.contraints.display.browser.DisplayInBrowserContraintsInterface

trait AdvertisementInterface {

    def getArtist() : String

    def getArtistLink() : String

    def getTitle() : String

    def getDateAdded() : String

    def getDirectory() : String

    def getFramedLink() : String

    def getListPrice() : Money

    def getOurPrice() : Money

    def getRank() : Int

    def getImage() : AdvertisementImageInterface

    def getProduct() : AdvertisementProductInterface

    def getThumbnail() : AdvertisementThumbnailInterface

    def getDisplayInBrowserContraintsInterface() : DisplayInBrowserContraintsInterface

    def setArtist(artist : String) : Unit

    def setArtistLink(artistLink : String) : Unit

    def setTitle(title : String) : Unit

    def setDateAdded(dateAdded : String) : Unit

    def setDirectory(directory : String) : Unit

    def setFramedLink(framedLink : String) : Unit

    //void setOurPrice(double ourPrice);
    def setRank(rank : Int) : Unit

    def setImage(AdvertisementImageInterface : AdvertisementImageInterface) : Unit

    def setProduct(AdvertisementProductInterface : AdvertisementProductInterface) : Unit

    def setThumbnail(AdvertisementThumbnailInterface : AdvertisementThumbnailInterface) : Unit

}


