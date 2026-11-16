/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable


/**  *  * @author User  */
class GameTickDisplayInfoSingleton {
    import _root_.org.allbinary.graphics.displayable.GameTickDisplayInfoSingleton.{*}

    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var lastWidth : Int = this.displayInfoSingleton.getLastWidth()

    private var lastHeight : Int = this.displayInfoSingleton.getLastHeight()

    private var lastHalfWidth : Int = this.displayInfoSingleton.getLastHalfWidth()

    private var lastHalfHeight : Int = this.displayInfoSingleton.getLastHalfHeight()

    def update() : Unit = {
        this.lastWidth = this.displayInfoSingleton.getLastWidth()
        this.lastHeight = this.displayInfoSingleton.getLastHeight()
        this.lastHalfWidth = this.displayInfoSingleton.getLastHalfWidth()
        this.lastHalfHeight = this.displayInfoSingleton.getLastHalfHeight()
    }

    def getLastWidth() : Int = {
        return this.lastWidth
    }

    def getLastHeight() : Int = {
        return this.lastHeight
    }

    def getLastHalfWidth() : Int = {
        return this.lastHalfWidth
    }

    def getLastHalfHeight() : Int = {
        return this.lastHalfHeight
    }

}

object GameTickDisplayInfoSingleton {
    private val instance : GameTickDisplayInfoSingleton = new GameTickDisplayInfoSingleton()

    /**      * @return the instance      */
    def getInstance() : GameTickDisplayInfoSingleton = {
        return GameTickDisplayInfoSingleton.instance
    }

}


