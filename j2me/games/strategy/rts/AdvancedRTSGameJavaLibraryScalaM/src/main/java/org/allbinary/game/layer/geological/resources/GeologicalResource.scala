/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geological.resources


/**  *  * @author user  */
class GeologicalResource(param_initTotal : Int) {

    private var total : Int = 0

    private var initTotal : Int = 0

    //Constructor
    {
        val initTotal : Int = param_initTotal
        this.initTotal = initTotal
        this.init()
    }

    def init() : Unit = {
        this.setTotal(this.initTotal)
    }

    def add(value : Int) : Unit = {
        val max : Int = Integer.MAX_VALUE
        if ((this.getTotal() + value) > max) {
            this.setTotal(max)
        } else {
            this.setTotal(this.getTotal() + value)
        }
    }

    def remove(value : Int) : Unit = {
        if ((this.getTotal() - value) < 0) {
            this.setTotal(0)
        } else {
            this.setTotal(this.getTotal() - value)
        }
    }

    /**      * @return the total      */
    def getTotal() : Int = {
        return this.total
    }

    /**      * @param total the total to set      */
    def setTotal(total : Int) : Unit = {
        this.total = total
    }

}


