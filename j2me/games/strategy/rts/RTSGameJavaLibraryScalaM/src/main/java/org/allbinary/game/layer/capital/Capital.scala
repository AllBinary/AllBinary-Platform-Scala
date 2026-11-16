/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.capital


class Capital() {

    private var value : Int = 0

    def getTotalMoney() : Int = {
        return this.value
    }

    def removeMoney(points : Int) : Unit = {
        this.value -= points
    }

    def addMoney(points : Int) : Unit = {
        this.value += points
    }

}


