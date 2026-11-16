/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas
import _root_.android.view.KeyEvent

class AndroidNumberKeyToJ2MECanvasNumberKey private() {
    import _root_.org.allbinary.game.input.AndroidNumberKeyToJ2MECanvasNumberKey.{*}

}

object AndroidNumberKeyToJ2MECanvasNumberKey {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val androidtoJavaMicroEditionKeyMap : Array[Int] = new Array[Int](17)

    def init() : Unit = {
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_0) = Canvas.KEY_NUM0
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_1) = Canvas.KEY_NUM1
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_2) = Canvas.KEY_NUM2
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_3) = Canvas.KEY_NUM3
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_4) = Canvas.KEY_NUM4
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_5) = Canvas.KEY_NUM5
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_6) = Canvas.KEY_NUM6
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_7) = Canvas.KEY_NUM7
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_8) = Canvas.KEY_NUM8
        AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(KeyEvent.KEYCODE_9) = Canvas.KEY_NUM9
    }

    //since Canvas number keys are used instead of
    def getKey(key : Int) : Int = {
        // KeyEvent.KEYCODE_SOFT_LEFT + " key: " + key, "AndroidToJ2MEKey", // "getKey");
        if (key < AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap.length) {
            var value : Int = AndroidNumberKeyToJ2MECanvasNumberKey.androidtoJavaMicroEditionKeyMap(key)
            if (value != 0) {
                return value
            }
        }
        // hashtable.put(androidToJ2MEKey, key);
        return key
    }

}


