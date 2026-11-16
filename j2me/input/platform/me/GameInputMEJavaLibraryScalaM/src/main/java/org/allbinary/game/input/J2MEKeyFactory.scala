/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input


class J2MEKeyFactory private() {
    import _root_.org.allbinary.game.input.J2MEKeyFactory.{*}

    private val gameKeyFactory : GameKeyFactory = GameKeyFactory.getInstance()

    def init() : Unit = {
        var gameKeyArray : Array[GameKey] = Array[GameKey](this.gameKeyFactory.DOWN, this.gameKeyFactory.FIRE, this.gameKeyFactory.GAME_A, this.gameKeyFactory.GAME_B, this.gameKeyFactory.GAME_C, this.gameKeyFactory.GAME_D, this.gameKeyFactory.KEY_NUM0, this.gameKeyFactory.KEY_NUM1, this.gameKeyFactory.KEY_NUM2, this.gameKeyFactory.KEY_NUM3, this.gameKeyFactory.KEY_NUM4, this.gameKeyFactory.KEY_NUM5, this.gameKeyFactory.KEY_NUM6, this.gameKeyFactory.KEY_NUM7, this.gameKeyFactory.KEY_NUM8, this.gameKeyFactory.KEY_NUM9, this.gameKeyFactory.KEY_POUND, this.gameKeyFactory.KEY_STAR, this.gameKeyFactory.LEFT, this.gameKeyFactory.LEVEL_DOWN, this.gameKeyFactory.LEVEL_UP, this.gameKeyFactory.NONE, this.gameKeyFactory.RIGHT, this.gameKeyFactory.UP)
        var inputFactory : InputFactory = InputFactory.getInstance()

        {
            var index : Int = gameKeyArray.length
            while ({ index -= 1; index } >= 0) {
                inputFactory.add(gameKeyArray(index).getId(), gameKeyArray(index))
            }
        }
    }

    def isSubmission(input : Input) : Boolean = {
        if (input eq this.gameKeyFactory.FIRE) {
            return true
        }
        return false
    }

    def isDelete(input : Input) : Boolean = {
        if (input eq this.gameKeyFactory.GAME_D) {
            return true
        }
        return false
    }

    def isBackSpace(input : Input) : Boolean = {
        return false
    }

    def isUp(input : Input) : Boolean = {
        if (input eq this.gameKeyFactory.UP) {
            return true
        }
        return false
    }

    def isDown(input : Input) : Boolean = {
        if (input eq this.gameKeyFactory.DOWN) {
            return true
        }
        return false
    }

    def isLeft(input : Input) : Boolean = {
        if (input eq this.gameKeyFactory.LEFT) {
            return true
        }
        return false
    }

    def isRight(input : Input) : Boolean = {
        if (input eq this.gameKeyFactory.RIGHT) {
            return true
        }
        return false
    }

    def isEnter(input : Input) : Boolean = {
        if (input eq this.gameKeyFactory.FIRE) {
            return true
        }
        return false
    }

}

object J2MEKeyFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : J2MEKeyFactory = new J2MEKeyFactory()

    def getInstance() : J2MEKeyFactory = {
        return J2MEKeyFactory.instance
    }

}


