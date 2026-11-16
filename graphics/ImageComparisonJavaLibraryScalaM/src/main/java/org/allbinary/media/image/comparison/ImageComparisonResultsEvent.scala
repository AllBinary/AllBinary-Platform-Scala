/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class ImageComparisonResultsEvent(param_anyType : Object, param_imageComparisonInfo : ImageComparisonResult) extends AllBinaryEventObject(param_anyType) {

    private var imageComparisonResult : ImageComparisonResult = null

    //Constructor
    {
        val anyType : Object = param_anyType
        val imageComparisonInfo : ImageComparisonResult = param_imageComparisonInfo
        this.setImageComparisonResult(imageComparisonInfo)
    }

    def getImageComparisonResult() : ImageComparisonResult = {
        return this.imageComparisonResult
    }

    def setImageComparisonResult(imageComparisonResult : ImageComparisonResult) : Unit = {
        this.imageComparisonResult = imageComparisonResult
    }

}


