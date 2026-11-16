/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.thumbnail

import _root_.org.allbinary.logic.control.contraints.size.TwoDimensionalConstraintInterface

class AdvertisementThumbnail() extends AdvertisementThumbnailInterface {

    private var imageFileName : String = null

    private var imageUrl : String = null

    private var constraint : TwoDimensionalConstraintInterface = null

    def getFileName() : String = {
        return this.imageFileName
    }

    def getUrl() : String = {
        return this.imageUrl
    }

    def getTwoDimensionalConstraint() : TwoDimensionalConstraintInterface = {
        return this.constraint
    }

}


