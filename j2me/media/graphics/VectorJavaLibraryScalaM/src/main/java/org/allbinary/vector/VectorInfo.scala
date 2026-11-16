/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.vector


class VectorInfo(param_width : Int, param_height : Int, param_points : Array[Array[Int]], param_totalFrames : Int) {

    private var width : Int = 0

    private var height : Int = 0

    private var points : Array[Array[Int]] = null

    private var totalFrames : Int = 0

    //Constructor
    {
        val width : Int = param_width
        val height : Int = param_height
        val points : Array[Array[Int]] = param_points
        val totalFrames : Int = param_totalFrames
        this.width = width
        this.height = height
        this.points = points
        this.totalFrames = totalFrames
    }

    def getWidth() : Int = {
        return this.width
    }

    private def setWidth(width : Int) : Unit = {
        this.width = width
    }

    def getHeight() : Int = {
        return this.height
    }

    private def setHeight(height : Int) : Unit = {
        this.height = height
    }

    def getPoints() : Array[Array[Int]] = {
        return this.points
    }

    private def setPoints(points : Array[Array[Int]]) : Unit = {
        this.points = points
    }

    def getTotalFrames() : Int = {
        return this.totalFrames
    }

    private def setTotalFrames(totalFrames : Int) : Unit = {
        this.totalFrames = totalFrames
    }

}


