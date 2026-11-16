/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement

import _root_.org.allbinary.business.advertisement.image.AdvertisementImageInterface
import _root_.org.allbinary.business.advertisement.product.AdvertisementProductInterface
import _root_.org.allbinary.business.advertisement.thumbnail.AdvertisementThumbnailInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.logic.control.contraints.display.browser.DisplayInBrowserContraintsInterface

/**  *  * @author user  */
class Advertisement() extends AdvertisementInterface {

    private var artist : String = null

    private var artistLink : String = null

    private var title : String = null

    private var dateAdded : String = null

    private var directory : String = null

    private var framedLink : String = null

    private var rank : Int = 0

    private var listPrice : Money = null

    private var ourPrice : Money = null

    private var image : AdvertisementImageInterface = null

    private var product : AdvertisementProductInterface = null

    private var thumbnail : AdvertisementThumbnailInterface = null

    private var displayInBrowserContraintsInterface : DisplayInBrowserContraintsInterface = null

    //Constructor
    {
        this.displayInBrowserContraintsInterface = null
    }

    /**      * @return the artist      */
    def getArtist() : String = {
        return this.artist
    }

    /**      * @param artist the artist to set      */
    def setArtist(artist : String) : Unit = {
        this.artist = artist
    }

    /**      * @return the artistLink      */
    def getArtistLink() : String = {
        return this.artistLink
    }

    /**      * @param artistLink the artistLink to set      */
    def setArtistLink(artistLink : String) : Unit = {
        this.artistLink = artistLink
    }

    /**      * @return the title      */
    def getTitle() : String = {
        return this.title
    }

    /**      * @param title the title to set      */
    def setTitle(title : String) : Unit = {
        this.title = title
    }

    /**      * @return the dateAdded      */
    def getDateAdded() : String = {
        return this.dateAdded
    }

    /**      * @param dateAdded the dateAdded to set      */
    def setDateAdded(dateAdded : String) : Unit = {
        this.dateAdded = dateAdded
    }

    /**      * @return the directory      */
    def getDirectory() : String = {
        return this.directory
    }

    /**      * @param directory the directory to set      */
    def setDirectory(directory : String) : Unit = {
        this.directory = directory
    }

    /**      * @return the framedLink      */
    def getFramedLink() : String = {
        return this.framedLink
    }

    /**      * @param framedLink the framedLink to set      */
    def setFramedLink(framedLink : String) : Unit = {
        this.framedLink = framedLink
    }

    /**      * @return the listPrice      */
    def getListPrice() : Money = {
        return this.listPrice
    }

    /**      * @param listPrice the listPrice to set      */
    def setListPrice(listPrice : Money) : Unit = {
        this.listPrice = listPrice
    }

    /**      * @return the ourPrice      */
    def getOurPrice() : Money = {
        return this.ourPrice
    }

    /**      * @param ourPrice the ourPrice to set      */
    def setOurPrice(ourPrice : Money) : Unit = {
        this.ourPrice = ourPrice
    }

    /**      * @return the rank      */
    def getRank() : Int = {
        return this.rank
    }

    /**      * @param rank the rank to set      */
    def setRank(rank : Int) : Unit = {
        this.rank = rank
    }

    /**      * @return the image      */
    def getImage() : AdvertisementImageInterface = {
        return this.image
    }

    /**      * @param image the image to set      */
    def setImage(image : AdvertisementImageInterface) : Unit = {
        this.image = image
    }

    /**      * @return the product      */
    def getProduct() : AdvertisementProductInterface = {
        return this.product
    }

    /**      * @param product the product to set      */
    def setProduct(product : AdvertisementProductInterface) : Unit = {
        this.product = product
    }

    /**      * @return the thumbnail      */
    def getThumbnail() : AdvertisementThumbnailInterface = {
        return this.thumbnail
    }

    /**      * @param thumbnail the thumbnail to set      */
    def setThumbnail(thumbnail : AdvertisementThumbnailInterface) : Unit = {
        this.thumbnail = thumbnail
    }

    /**      * @return the displayInBrowserContraintsInterface      */
    def getDisplayInBrowserContraintsInterface() : DisplayInBrowserContraintsInterface = {
        return this.displayInBrowserContraintsInterface
    }

}


