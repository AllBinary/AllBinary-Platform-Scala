/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.data

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.string.tokens.Tokenizer
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class CamelCaseUtil {
    import _root_.org.allbinary.data.CamelCaseUtil.{*}

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    //private final String FORMAT = "[\\W_]+";
    def getAsCamelCase(string : String, stringBuilder : StringMaker) : String = {
        //        }
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        stringBuilder.delete(0, stringBuilder.length())
        val list : BasicArrayList = new BasicArrayListD()
        val tokenizer : Tokenizer = new Tokenizer(this.commonSeps.UNDERSCORE)
        tokenizer.getTokensFromString(string, list)
        //final int size = words.length;
        val size : Int = list.size()
        var word : String = null

        {
            var i : Int = 0
            while (i < size) {
                //word = words[i];
                word = list.get(i).asInstanceOf[String]
                //{
                word = (if (stringValidationUtil.isEmpty(word)) word else new StringMaker().appendchar(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).toString())
                //}
                stringBuilder.append(word)
                i += 1
            }
        }
        return stringBuilder.toString()
    }

}

object CamelCaseUtil {
    private val instance : CamelCaseUtil = new CamelCaseUtil()

    /**      * @return the instance      */
    def getInstance() : CamelCaseUtil = {
        return CamelCaseUtil.instance
    }

}


