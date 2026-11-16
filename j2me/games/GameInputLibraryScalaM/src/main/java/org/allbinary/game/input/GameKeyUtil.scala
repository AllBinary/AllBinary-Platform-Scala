/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas

/**  *  * @author user  */
class GameKeyUtil {
    import _root_.org.allbinary.game.input.GameKeyUtil.{*}

    /*     public static boolean isNonDirectionKey(int key)     {         if (key == Canvas.KEY_NUM0 ||             key == Canvas.KEY_NUM1 ||             key == Canvas.KEY_NUM2 ||             key == Canvas.KEY_NUM3 ||             key == Canvas.KEY_NUM4 ||             key == Canvas.KEY_NUM5 ||             key == Canvas.KEY_NUM6 ||             key == Canvas.KEY_NUM7 ||             key == Canvas.KEY_NUM8 ||             key == Canvas.KEY_NUM9 ||             key == Canvas.KEY_POUND ||             key == Canvas.KEY_STAR ||             key == Canvas.FIRE)         {             return true;         }         else         {             return false;         }     }     */
    def isDirectionKey(key : Int) : Boolean = {
        if ((((key == Canvas.UP) || (key == Canvas.DOWN)) || (key == Canvas.LEFT)) || (key == Canvas.RIGHT)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}

object GameKeyUtil {
    private val instance : GameKeyUtil = new GameKeyUtil()

    def getInstance() : GameKeyUtil = {
        return GameKeyUtil.instance
    }

}


