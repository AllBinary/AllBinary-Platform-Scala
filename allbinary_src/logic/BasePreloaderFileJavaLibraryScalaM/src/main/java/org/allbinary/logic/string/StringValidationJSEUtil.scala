/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string


class StringValidationJSEUtil private() {
    import _root_.org.allbinary.logic.string.StringValidationJSEUtil.{*}

}

object StringValidationJSEUtil {
    def isBlank(string : String) : Boolean = {
        var len : Int = string.length()

        {
            var i : Int = 0
            while (i < len) {
                var c : Char = string.charAt(i)
                if (Character.isWhitespace(c) == false) {
                    return false
                }
                i += 1
            }
        }
        return true
    }

}


