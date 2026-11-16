/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement


trait AdvertisementsInterface {

    def add(advertisementInterface : AdvertisementInterface) : Unit

    def get(index : Int) : AdvertisementInterface

    def getCurrentPageNum() : Int

    def getErrorDescription() : String

    def getErrorNum() : String

    def getNumberOfPosters() : Int

    def getNumberOfProductsInPage() : Int

    def getStatusCode() : Int

    def getTotalNumberOfProducts() : Int

    def isSearchValid() : Boolean

    //If status code = 0 search is valid, if statuscode is 1 search is invalid.
    def setCurrentPageNum(currentPageNum : Int) : Unit

    def setErrorDescription(errorDescription : String) : Unit

    def setErrorNum(errorNum : String) : Unit

    def setNumberOfProductsInPage(numberOfProductsInPage : Int) : Unit

    def setStatusCode(statusCode : Int) : Unit

    def setTotalNumberOfProducts(totalNumberOfProducts : Int) : Unit

    override def toString() : String

}


