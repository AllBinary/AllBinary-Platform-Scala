/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.search

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class ImageComparisonSearchResultsEvent(param_anyType : Object, param_imageComparisonSearch : ImageComparisonSearch) extends AllBinaryEventObject(param_anyType) {

    private var imageComparisonSearch : ImageComparisonSearch = null

    //Constructor
    {
        val anyType : Object = param_anyType
        val imageComparisonSearch : ImageComparisonSearch = param_imageComparisonSearch
        this.setImageComparisonSearch(imageComparisonSearch)
    }

    def getImageComparisonSearch() : ImageComparisonSearch = {
        return this.imageComparisonSearch
    }

    private def setImageComparisonSearch(imageComparisonSearch : ImageComparisonSearch) : Unit = {
        this.imageComparisonSearch = imageComparisonSearch
    }

}


