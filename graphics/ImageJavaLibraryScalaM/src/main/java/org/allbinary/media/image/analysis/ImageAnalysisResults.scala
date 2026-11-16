/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.analysis


class ImageAnalysisResults() {

    private var imageColorRangeResults : ImageColorRangeResults = null

    private var imageColorResults : ImageColorResults = null

    private var averageAmbientLevel : Float = 0.0f

    //Constructor
    {
        this.imageColorRangeResults = new ImageColorRangeResults()
        this.imageColorResults = new ImageColorResults()
    }

    def getImageColorRangeResults() : ImageColorRangeResults = {
        return this.imageColorRangeResults
    }

    def setImageColorRangeResults(imageColorRangeResults : ImageColorRangeResults) : Unit = {
        this.imageColorRangeResults = imageColorRangeResults
    }

    def getAverageAmbientLevel() : Float = {
        return this.averageAmbientLevel
    }

    def setAverageAmbientLevel(averageAmbientLevel : Float) : Unit = {
        this.averageAmbientLevel = averageAmbientLevel
    }

    def getImageColorResults() : ImageColorResults = {
        return this.imageColorResults
    }

    def setImageColorResults(imageColorResults : ImageColorResults) : Unit = {
        this.imageColorResults = imageColorResults
    }

}


