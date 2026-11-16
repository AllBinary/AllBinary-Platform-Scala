/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.android.view.KeyEvent
import _root_.org.allbinary.android.ActivityFractureUtil
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil

class AndroidKeyFactory extends ActivityFractureUtil {

    val logUtil : LogUtil = LogUtil.getInstance()

    val UNKNOWN : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_UNKNOWN, "UNKNOWN")

    /*      * API 9 Game Input   */
    var KEYCODE_BUTTON_L1 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_R1 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_THUMBR : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_THUMBL : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_START : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_MODE : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_B : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_A : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_X : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_Y : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_L2 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_R2 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_SELECT : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_C : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_Z : AndroidGameKey = this.UNKNOWN

    /*       * API 12 Game Input   */
    var KEYCODE_BUTTON_1 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_10 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_11 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_12 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_13 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_14 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_15 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_16 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_2 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_3 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_4 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_5 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_6 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_7 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_8 : AndroidGameKey = this.UNKNOWN

    var KEYCODE_BUTTON_9 : AndroidGameKey = this.UNKNOWN

    val SOFT_LEFT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SOFT_LEFT, "SOFT_LEFT")

    val SOFT_RIGHT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SOFT_RIGHT, "SOFT_RIGHT")

    val HOME : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_HOME, "HOME")

    val BACK : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_BACK, "BACK")

    val CALL : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_CALL, "CALL")

    val ENDCALL : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_ENDCALL, "ENDCALL")

    val ZERO : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_0, CommonPhoneStrings.getInstance().ZERO)

    val ONE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_1, CommonPhoneStrings.getInstance().ONE)

    val TWO : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_2, CommonPhoneStrings.getInstance().TWO)

    val THREE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_3, CommonPhoneStrings.getInstance().THREE)

    val FOUR : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_4, CommonPhoneStrings.getInstance().FOUR)

    val FIVE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_5, CommonPhoneStrings.getInstance().FIVE)

    val SIX : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_6, CommonPhoneStrings.getInstance().SIX)

    val SEVEN : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_7, CommonPhoneStrings.getInstance().SEVEN)

    val EIGHT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_8, CommonPhoneStrings.getInstance().EIGHT)

    val NINE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_9, CommonPhoneStrings.getInstance().NINE)

    val STAR : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_STAR, CommonPhoneStrings.getInstance().STAR)

    val POUND : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_POUND, CommonPhoneStrings.getInstance().POUND)

    val DPAD_UP : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_UP, "UP")

    val DPAD_DOWN : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_DOWN, "DOWN")

    val DPAD_LEFT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_LEFT, "LEFT")

    val DPAD_RIGHT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_RIGHT, "RIGHT")

    val DPAD_CENTER : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_DPAD_CENTER, "CENTER")

    val VOLUME_UP : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_VOLUME_UP, "VOLUME_UP")

    val VOLUME_DOWN : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_VOLUME_DOWN, "VOLUME_DOWN")

    val POWER : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_POWER, "POWER")

    val CAMERA : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_CAMERA, "CAMERA")

    val CLEAR : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_CLEAR, "CLEAR")

    val A : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_A, "A")

    val B : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_B, "B")

    val C : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_C, "C")

    val D : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_D, "D")

    val E : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_E, "E")

    val F : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_F, "F")

    val G : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_G, "G")

    val H : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_H, "H")

    val I : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_I, "I")

    val J : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_J, "J")

    val K : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_K, "K")

    val L : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_L, "L")

    val M : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_M, "M")

    val N : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_N, "N")

    val O : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_O, "O")

    val P : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_P, "P")

    val Q : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_Q, "Q")

    val R : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_R, "R")

    val S : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_S, "S")

    val T : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_T, "T")

    val U : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_U, "U")

    val V : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_V, "V")

    val W : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_W, "W")

    val X : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_X, "X")

    val Y : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_Y, "Y")

    val Z : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_Z, "Z")

    val COMMA : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_COMMA, "COMMA")

    val PERIOD : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_PERIOD, AbPathData.getInstance().EXTENSION_SEP)

    val ALT_LEFT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_ALT_LEFT, "ALT_LEFT")

    val ALT_RIGHT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_ALT_RIGHT, "ALT_RIGHT")

    val SHIFT_LEFT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SHIFT_LEFT, "SHIFT_LEFT")

    val SHIFT_RIGHT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SHIFT_RIGHT, "SHIFT_RIGHT")

    val TAB : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_TAB, "TAB")

    val SPACE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SPACE, "SPACE")

    val SYM : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SYM, "SYM")

    val EXPLORER : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_EXPLORER, "EXPLORER")

    val ENVELOPE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_ENVELOPE, "ENVELOPE")

    val ENTER : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_ENTER, "ENTER")

    val DEL : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_DEL, "DEL")

    val GRAVE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_GRAVE, "GRAVE")

    val MINUS : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_MINUS, "MINUS")

    val EQUALS : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_EQUALS, "EQUALS")

    val LEFT_BRACKET : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_LEFT_BRACKET, "LEFT_BRACKET")

    val RIGHT_BRACKET : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_RIGHT_BRACKET, "RIGHT_BRACKET")

    val BACKSLASH : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_BACKSLASH, "BACKSLASH")

    val SEMICOLON : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SEMICOLON, "SEMICOLON")

    val APOSTROPHE : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_APOSTROPHE, "APOSTROPHE")

    val SLASH : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SLASH, "SLASH")

    val AT : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_AT, "AT")

    val NUM : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_NUM, "NUM")

    val HEADSETHOOK : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_HEADSETHOOK, "HEADSETHOOK")

    val FOCUS : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_FOCUS, "FOCUS")

    val PLUS : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_PLUS, "PLUS")

    val MENU : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_MENU, "MENU")

    val NOTIFICATION : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_NOTIFICATION, "NOTIFICATION")

    val SEARCH : AndroidGameKey = new AndroidGameKey(KeyEvent.KEYCODE_SEARCH, "SEARCH")

    def init() : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF("Start/End", this, commonStrings.INIT)
    }

    def isSubmission(input : Input) : Boolean = {
        if (input eq this.ENTER) {
            return true
        } else if (input eq this.DPAD_CENTER) {
            return true
        }
        return false
    }

    def isDelete(input : Input) : Boolean = {
        return false
    }

    //In android delete is backspace
    def isBackSpace(input : Input) : Boolean = {
        if (input eq this.DEL) {
            return true
        }
        return false
    }

    def isLeft(input : Input) : Boolean = {
        if (input eq this.DPAD_LEFT) {
            return true
        }
        return false
    }

    def isRight(input : Input) : Boolean = {
        if (input eq this.DPAD_RIGHT) {
            return true
        }
        return false
    }

    def isUp(input : Input) : Boolean = {
        if (input eq this.DPAD_UP) {
            return true
        }
        return false
    }

    def isDown(input : Input) : Boolean = {
        if (input eq this.DPAD_DOWN) {
            return true
        }
        return false
    }

    def isEnter(input : Input) : Boolean = {
        if (input eq this.DPAD_CENTER) {
            return true
        } else if (input eq this.ENTER) {
            return true
        } else if (input eq this.CALL) {
            return true
        }
        return false
    }

}


