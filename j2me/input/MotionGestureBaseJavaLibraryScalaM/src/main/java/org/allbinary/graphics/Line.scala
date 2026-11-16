/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics


class Line(param_p1 : GPoint, param_p2 : GPoint) {

    private var p1 : GPoint = null

    private var p2 : GPoint = null

    private var deltaX : Double = 0.0

    private var deltaY : Double = 0.0

    //Constructor
    {
        val p1 : GPoint = param_p1
        val p2 : GPoint = param_p2
        this.p1 = PointFactory.getInstance().ZERO_ZERO
        this.p2 = this.p1
        this.setP1(p1)
        this.setP2(p2)
    }

    def getGradient() : Double = {
        return this.getDeltaY() / this.getDeltaX()
    }

    private def update() : Unit = {
        this.deltaX = this.getP1().getX().toDouble - this.getP2().getX()
        this.deltaY = this.getP1().getY().toDouble - this.getP2().getY()
    }

    def getDeltaX() : Double = {
        return this.deltaX
    }

    def getDeltaY() : Double = {
        return this.deltaY
    }

    def getP1() : GPoint = {
        return this.p1
    }

    def getP2() : GPoint = {
        return this.p2
    }

    def setP1(p1 : GPoint) : Unit = {
        this.p1 = p1
        this.update()
    }

    def setP2(p2 : GPoint) : Unit = {
        this.p2 = p2
        this.update()
    }

}


