/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps

class PCKeyFactory {
    import _root_.org.allbinary.game.input.PCKeyFactory.{*}

    val UNKNOWN : PCGameKey = new PCGameKey(254, "UNKNOWN")

    val ENTER : PCGameKey = new PCGameKey(13, "Enter")

    val _A : PCGameKey = new PCGameKey(65, "A")

    val _B : PCGameKey = new PCGameKey(66, "B")

    val _C : PCGameKey = new PCGameKey(67, "C")

    val _D : PCGameKey = new PCGameKey(68, "D")

    val _E : PCGameKey = new PCGameKey(69, "E")

    val _F : PCGameKey = new PCGameKey(70, "F")

    val _G : PCGameKey = new PCGameKey(71, "G")

    val _H : PCGameKey = new PCGameKey(72, "H")

    val _I : PCGameKey = new PCGameKey(73, "I")

    val _J : PCGameKey = new PCGameKey(74, "J")

    val _K : PCGameKey = new PCGameKey(75, "K")

    val _L : PCGameKey = new PCGameKey(76, "L")

    val _M : PCGameKey = new PCGameKey(77, "M")

    val _N : PCGameKey = new PCGameKey(78, "N")

    val _O : PCGameKey = new PCGameKey(79, "O")

    val _P : PCGameKey = new PCGameKey(80, "P")

    val _Q : PCGameKey = new PCGameKey(81, "Q")

    val _R : PCGameKey = new PCGameKey(82, "R")

    val _S : PCGameKey = new PCGameKey(83, "S")

    val _T : PCGameKey = new PCGameKey(84, "T")

    val _U : PCGameKey = new PCGameKey(85, "U")

    val _V : PCGameKey = new PCGameKey(86, "V")

    val _W : PCGameKey = new PCGameKey(87, "W")

    val _X : PCGameKey = new PCGameKey(88, "X")

    val _Y : PCGameKey = new PCGameKey(89, "Y")

    val _Z : PCGameKey = new PCGameKey(90, "Z")

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

    val ZERO : PCGameKey = new PCGameKey(48, CommonPhoneStrings.getInstance().ZERO)

    val ONE : PCGameKey = new PCGameKey(49, CommonPhoneStrings.getInstance().ONE)

    val TWO : PCGameKey = new PCGameKey(50, CommonPhoneStrings.getInstance().TWO)

    val THREE : PCGameKey = new PCGameKey(51, CommonPhoneStrings.getInstance().THREE)

    val FOUR : PCGameKey = new PCGameKey(52, CommonPhoneStrings.getInstance().FOUR)

    val FIVE : PCGameKey = new PCGameKey(53, CommonPhoneStrings.getInstance().FIVE)

    val SIX : PCGameKey = new PCGameKey(54, CommonPhoneStrings.getInstance().SIX)

    val SEVEN : PCGameKey = new PCGameKey(55, CommonPhoneStrings.getInstance().SEVEN)

    val EIGHT : PCGameKey = new PCGameKey(56, CommonPhoneStrings.getInstance().EIGHT)

    val NINE : PCGameKey = new PCGameKey(57, CommonPhoneStrings.getInstance().NINE)

    val DPAD_UP : PCGameKey = new PCGameKey(38, CommonPhoneStrings.getInstance().UP)

    val DPAD_DOWN : PCGameKey = new PCGameKey(40, CommonPhoneStrings.getInstance().DOWN)

    val DPAD_LEFT : PCGameKey = new PCGameKey(37, CommonPhoneStrings.getInstance().LEFT)

    val DPAD_RIGHT : PCGameKey = new PCGameKey(39, CommonPhoneStrings.getInstance().RIGHT)

    val DPAD_UP2 : PCGameKey = this.DPAD_UP

    val DPAD_DOWN2 : PCGameKey = this.DPAD_DOWN

    val DPAD_LEFT2 : PCGameKey = this.DPAD_LEFT

    val DPAD_RIGHT2 : PCGameKey = this.DPAD_RIGHT

    //public final PCGameKey COMMA = new PCGameKey(188, "COMMA");
    val COMMA : PCGameKey = new PCGameKey(44, "COMMA")

    val SPACE : PCGameKey = new PCGameKey(32, "SPACE")

    val DEL : PCGameKey = new PCGameKey(46, "DEL")

    //      CommonPhoneStrings.getInstance().POUND);
    val STAR : PCGameKey = new PCGameKey(42, CommonPhoneStrings.getInstance().STAR)

    val QUESTION : PCGameKey = new PCGameKey(47, "?")

    //public final PCGameKey PERIOD = new PCGameKey(190,CommonSeps.getInstance().PERIOD);
    val PERIOD : PCGameKey = new PCGameKey(46, CommonSeps.getInstance().PERIOD)

    val ESCAPE : PCGameKey = new PCGameKey(27, "Esc")

    val BACK_SPACE : PCGameKey = new PCGameKey(8, "Backspace")

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


