/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps

class PCKeyFactory {
    import _root_.org.allbinary.game.input.PCKeyFactory.{*}

    private val keyEventWrapper : ABKeyEventWrapper = ABKeyEventWrapper.getInstance()

    val UNKNOWN : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_UNDEFINED, "UNKNOWN")

    val ENTER : PCGameKey = new PCGameKey(5, "Enter")

    val _A : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_A, "A")

    val _B : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_B, "B")

    val _C : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_C, "C")

    val _D : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_D, "D")

    val _E : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_E, "E")

    val _F : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_F, "F")

    val _G : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_G, "G")

    val _H : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_H, "H")

    val _I : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_I, "I")

    val _J : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_J, "J")

    val _K : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_K, "K")

    val _L : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_L, "L")

    val _M : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_M, "M")

    val _N : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_N, "N")

    val _O : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_O, "O")

    val _P : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_P, "P")

    val _Q : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_Q, "Q")

    val _R : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_R, "R")

    val _S : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_S, "S")

    val _T : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_T, "T")

    val _U : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_U, "U")

    val _V : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_V, "V")

    val _W : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_W, "W")

    val _X : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_X, "X")

    val _Y : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_Y, "Y")

    val _Z : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_Z, "Z")

    val a : PCGameKey = new PCGameKey(97, "a")

    val b : PCGameKey = new PCGameKey(98, "b")

    val c : PCGameKey = new PCGameKey(99, "c")

    val d : PCGameKey = new PCGameKey(100, "d")

    val e : PCGameKey = new PCGameKey(101, "e")

    val f : PCGameKey = new PCGameKey(102, "f")

    val g : PCGameKey = new PCGameKey(103, "g")

    val h : PCGameKey = new PCGameKey(104, "h")

    val i : PCGameKey = new PCGameKey(105, "i")

    val j : PCGameKey = new PCGameKey(106, "j")

    val k : PCGameKey = new PCGameKey(107, "k")

    val l : PCGameKey = new PCGameKey(108, "l")

    val m : PCGameKey = new PCGameKey(109, "m")

    val n : PCGameKey = new PCGameKey(110, "n")

    val o : PCGameKey = new PCGameKey(111, "o")

    val p : PCGameKey = new PCGameKey(112, "p")

    val q : PCGameKey = new PCGameKey(113, "q")

    val r : PCGameKey = new PCGameKey(114, "r")

    val s : PCGameKey = new PCGameKey(115, "s")

    val t : PCGameKey = new PCGameKey(116, "t")

    val u : PCGameKey = new PCGameKey(117, "u")

    val v : PCGameKey = new PCGameKey(118, "v")

    val w : PCGameKey = new PCGameKey(119, "w")

    val x : PCGameKey = new PCGameKey(120, PositionStrings.getInstance().X)

    val y : PCGameKey = new PCGameKey(121, PositionStrings.getInstance().Y)

    val z : PCGameKey = new PCGameKey(122, "z")

    val ZERO : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_0, CommonPhoneStrings.getInstance().ZERO)

    val ONE : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_1, CommonPhoneStrings.getInstance().ONE)

    val TWO : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_2, CommonPhoneStrings.getInstance().TWO)

    val THREE : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_3, CommonPhoneStrings.getInstance().THREE)

    val FOUR : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_4, CommonPhoneStrings.getInstance().FOUR)

    val FIVE : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_5, CommonPhoneStrings.getInstance().FIVE)

    val SIX : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_6, CommonPhoneStrings.getInstance().SIX)

    val SEVEN : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_7, CommonPhoneStrings.getInstance().SEVEN)

    val EIGHT : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_8, CommonPhoneStrings.getInstance().EIGHT)

    val NINE : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_9, CommonPhoneStrings.getInstance().NINE)

    val DPAD_UP : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_UP, CommonPhoneStrings.getInstance().UP)

    val DPAD_DOWN : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_DOWN, CommonPhoneStrings.getInstance().DOWN)

    val DPAD_LEFT : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_LEFT, CommonPhoneStrings.getInstance().LEFT)

    val DPAD_RIGHT : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_RIGHT, CommonPhoneStrings.getInstance().RIGHT)

    val DPAD_UP2 : PCGameKey = this.DPAD_UP

    val DPAD_DOWN2 : PCGameKey = this.DPAD_DOWN

    val DPAD_LEFT2 : PCGameKey = this.DPAD_LEFT

    val DPAD_RIGHT2 : PCGameKey = this.DPAD_RIGHT

    //      "CENTER");
    val COMMA : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_COMMA, "COMMA")

    val SPACE : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_SPACE, "SPACE")

    val DEL : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_DELETE, "DEL")

    //      CommonPhoneStrings.getInstance().POUND);
    val STAR : PCGameKey = new PCGameKey(42, CommonPhoneStrings.getInstance().STAR)

    val QUESTION : PCGameKey = new PCGameKey(47, "?")

    val PERIOD : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_PERIOD, CommonSeps.getInstance().PERIOD)

    val ESCAPE : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_ESCAPE, "Esc")

    val BACK_SPACE : PCGameKey = new PCGameKey(this.keyEventWrapper.VK_BACK_SPACE, "Backspace")

    //      AbPathData.EXTENSION_SEP);
    def isSubmission(input : Input) : Boolean = {
        if (input eq this.ENTER) {
            return true
        }
        return false
    }

    def isDelete(input : Input) : Boolean = {
        if (input eq this.DEL) {
            return true
        }
        return false
    }

    def isBackSpace(input : Input) : Boolean = {
        if (input eq this.BACK_SPACE) {
            return true
        }
        return false
    }

    def isUp(input : Input) : Boolean = {
        if ((input eq this.DPAD_UP) || (input eq this.DPAD_UP2)) {
            return true
        }
        return false
    }

    def isDown(input : Input) : Boolean = {
        if ((input eq this.DPAD_DOWN) || (input eq this.DPAD_DOWN2)) {
            return true
        }
        return false
    }

    def isLeft(input : Input) : Boolean = {
        if ((input eq this.DPAD_LEFT) || (input eq this.DPAD_LEFT2)) {
            return true
        }
        return false
    }

    def isRight(input : Input) : Boolean = {
        if ((input eq this.DPAD_RIGHT) || (input eq this.DPAD_RIGHT2)) {
            return true
        }
        return false
    }

    def isEnter(input : Input) : Boolean = {
        if (input eq this.ENTER) {
            return true
        }
        return false
    }

}

object PCKeyFactory {
    private val SINGLETON : PCKeyFactory = new PCKeyFactory()

    def getInstance() : PCKeyFactory = {
        return PCKeyFactory.SINGLETON
    }

}


