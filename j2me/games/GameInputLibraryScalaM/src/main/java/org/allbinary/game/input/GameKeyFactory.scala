/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.string.CommonPhoneStrings

class GameKeyFactory {
    import _root_.org.allbinary.game.input.GameKeyFactory.{*}

    val NONE : GameKey = new GameKey(InputFactory.getInstance().MAX - 1, "None")

    val UP : GameKey = new GameKey(Canvas.UP, CommonPhoneStrings.getInstance().UP)

    val DOWN : GameKey = new GameKey(Canvas.DOWN, CommonPhoneStrings.getInstance().DOWN)

    val LEFT : GameKey = new GameKey(Canvas.LEFT, CommonPhoneStrings.getInstance().LEFT)

    val RIGHT : GameKey = new GameKey(Canvas.RIGHT, CommonPhoneStrings.getInstance().RIGHT)

    val KEY_POUND : GameKey = new GameKey(Canvas.KEY_POUND, "POUND")

    val KEY_STAR : GameKey = new GameKey(Canvas.KEY_STAR, "STAR")

    val KEY_NUM0 : GameKey = new GameKey(Canvas.KEY_NUM0, CommonPhoneStrings.getInstance().ZERO)

    val KEY_NUM1 : GameKey = new GameKey(Canvas.KEY_NUM1, CommonPhoneStrings.getInstance().ONE)

    val KEY_NUM2 : GameKey = new GameKey(Canvas.KEY_NUM2, CommonPhoneStrings.getInstance().TWO)

    val KEY_NUM3 : GameKey = new GameKey(Canvas.KEY_NUM3, CommonPhoneStrings.getInstance().THREE)

    val KEY_NUM4 : GameKey = new GameKey(Canvas.KEY_NUM4, CommonPhoneStrings.getInstance().FOUR)

    val KEY_NUM5 : GameKey = new GameKey(Canvas.KEY_NUM5, CommonPhoneStrings.getInstance().FIVE)

    val KEY_NUM6 : GameKey = new GameKey(Canvas.KEY_NUM6, CommonPhoneStrings.getInstance().SIX)

    val KEY_NUM7 : GameKey = new GameKey(Canvas.KEY_NUM7, CommonPhoneStrings.getInstance().SEVEN)

    val KEY_NUM8 : GameKey = new GameKey(Canvas.KEY_NUM8, CommonPhoneStrings.getInstance().EIGHT)

    val KEY_NUM9 : GameKey = new GameKey(Canvas.KEY_NUM9, CommonPhoneStrings.getInstance().NINE)

    val GAME_A : GameKey = new GameKey(Canvas.GAME_A, "Game A")

    val GAME_B : GameKey = new GameKey(Canvas.GAME_B, "Game B")

    val GAME_C : GameKey = new GameKey(Canvas.GAME_C, "Game C")

    val GAME_D : GameKey = new GameKey(Canvas.GAME_D, "Game D")

    val FIRE : GameKey = new GameKey(Canvas.FIRE, CommonPhoneStrings.getInstance().FIRE)

    /*     public GameKey KEYBOARD_Y = GameKey.NONE;     public GameKey KEYBOARD_U = GameKey.NONE;     public GameKey KEYBOARD_I = GameKey.NONE;      public GameKey KEYBOARD_H = GameKey.NONE;     public GameKey KEYBOARD_J = GameKey.NONE;     public GameKey KEYBOARD_K = GameKey.NONE;      public GameKey KEYBOARD_N = GameKey.NONE;     public GameKey KEYBOARD_M = GameKey.NONE;     public GameKey KEYBOARD_LESS = GameKey.NONE;      public GameKey KEYBOARD_SPACE = GameKey.NONE;     public GameKey KEYBOARD_INSERT = GameKey.NONE;     public GameKey KEYBOARD_DELETE = GameKey.NONE;      public GameKey QUICK_STAR = GameKey.KEYBOARD_SPACE;     public GameKey QUICK_POUND = GameKey.KEYBOARD_DELETE;      // KeyEvent.VK_F3     public GameKey LEVEL_DOWN = GameKey.NONE;     public GameKey LEVEL_UP = GameKey.NONE;      */
    var LEVEL_DOWN : GameKey = new GameKey(Canvas.KEY_NUM9 + 1, "Cheat Level Up")

    var LEVEL_UP : GameKey = new GameKey(Canvas.KEY_NUM9 + 2, "Cheat Level Down")

}

object GameKeyFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameKeyFactory = {
        if (GameKeyFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GameKeyFactory.instance = new GameKeyFactory()
        }
        return GameKeyFactory.instance.asInstanceOf[GameKeyFactory]
    }

}


