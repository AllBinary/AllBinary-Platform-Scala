/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.media.image.comparison.ImageComparisonResult

class MotionRectangles(param_name : String, param_imageComparisonResult : ImageComparisonResult) {

    private var name : String = null

    private var rectangleVector : BasicArrayList = null

    private var imageComparisonResult : ImageComparisonResult = null

    val MAX_PIXEL_DISTANCE_THRESHOLD : Int = 2

    //GenerateImageWithBoundingBoxesAroundMovingArtifacts
    //Constructor
    {
        val name : String = param_name
        val imageComparisonResult : ImageComparisonResult = param_imageComparisonResult
        this.name = name
        this.setImageComparisonResult(imageComparisonResult)
        this.setVector(new BasicArrayListD())
    }

    def getVector() : BasicArrayList = {
        return this.rectangleVector
    }

    def setVector(rectangleVector : BasicArrayList) : Unit = {
        this.rectangleVector = rectangleVector
    }

    def getName() : String = {
        return this.name
    }

    def getImageComparisonResult() : ImageComparisonResult = {
        return this.imageComparisonResult
    }

    def setImageComparisonResult(imageComparisonResult : ImageComparisonResult) : Unit = {
        this.imageComparisonResult = imageComparisonResult
    }

}


