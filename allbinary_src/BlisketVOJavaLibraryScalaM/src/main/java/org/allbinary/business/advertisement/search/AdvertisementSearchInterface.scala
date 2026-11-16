/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.search

import _root_.java.util.HashMap
import _root_.org.allbinary.business.advertisement.search.category.AdvertisementCategoryInterface
import _root_.org.allbinary.business.advertisement.search.website.AdvertisementWebsiteInterface
import _root_.org.allbinary.logic.control.contraints.price.PriceConstraintInterface
import _root_.org.allbinary.logic.control.contraints.size.TwoDimensionalConstraintInterface

trait AdvertisementSearchInterface {

    def getWebSite() : AdvertisementWebsiteInterface

    def getCategory() : AdvertisementCategoryInterface

    def getSizeConstraints() : TwoDimensionalConstraintInterface

    def getPricingConstraints() : PriceConstraintInterface

    def getPageNumber() : Int

    def getProductsPerPage() : Int

    def getSearchParams() : HashMap[Object, Object]

    //public String getSortOrder();
    def setCategory(advertisementCategoryInterface : AdvertisementCategoryInterface) : Unit

    def setSizeConstraints(twoDimensionConstraintsInterface : TwoDimensionalConstraintInterface) : Unit

    def setPricingConstraints(priceConstraintInterface : PriceConstraintInterface) : Unit

    def setPageNumber(pageNumber : Int) : Unit

    def setProductsPerPage(productsPerPage : Int) : Unit

    def setSearchParams(columnAndKeywordHashMap : HashMap[Object, Object]) : Unit

}


