/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement.product

import _root_.org.allbinary.logic.control.contraints.size.TwoDimensionalConstraintInterface

class AdvertisementProduct() extends AdvertisementProductInterface {

    private var `type` : String = null

    private var link : String = null

    private var number : Int = 0

    private var constraint : TwoDimensionalConstraintInterface = null

    def getType() : String = {
        return this.`type`
    }

    def getLink() : String = {
        return this.link
    }

    def getNumber() : Int = {
        return this.number
    }

    def getTwoDimensionalConstraint() : TwoDimensionalConstraintInterface = {
        return this.constraint
    }

}


