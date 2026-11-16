/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.NullUtil

class AndroidAPI1KeyFactory() extends AndroidKeyFactory {
    import _root_.org.allbinary.game.input.AndroidAPI1KeyFactory.{*}

}

object AndroidAPI1KeyFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : AndroidAPI1KeyFactory = {
        if (AndroidAPI1KeyFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            AndroidAPI1KeyFactory.instance = new AndroidAPI1KeyFactory()
        }
        return AndroidAPI1KeyFactory.instance.asInstanceOf[AndroidAPI1KeyFactory]
    }

}


