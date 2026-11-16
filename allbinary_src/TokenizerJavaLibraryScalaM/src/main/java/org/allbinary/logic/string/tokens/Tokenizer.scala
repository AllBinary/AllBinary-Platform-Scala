/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string.tokens

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class Tokenizer(param_sep : String) {

    private var sep : String = null

    private var endSep : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val sep : String = param_sep
        if (TsUtil.getInstance().compareTo(sep, StringUtil.getInstance().EMPTY_STRING) == 0) {
            throw new Exception("Sep provided is not valid")
        }
        this.sep = sep
    }

    def setSep(sep : String) : Unit = {
        this.sep = sep
    }

    def setEndSep(endSep : String) : Unit = {
        this.endSep = endSep
    }

    def getInsideSep(string : String) : BasicArrayList = {
        val tokenList : BasicArrayList = new BasicArrayListD()
        var index : Int = 0
        var size : Int = string.length()

        {
            scala.util.boundary { (break_N70310 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    index = string.indexOf(this.sep, index)
                    if (index != -1) {
                        //found possible beginning of token
                        var end : Int = string.indexOf(this.endSep, index + this.sep.length())
                        if (end != -1) {
                            tokenList.add(string.substring(index + this.sep.length(), end - (this.endSep.length() - 1)))
                            index = end + this.endSep.length()
                        } else {
                        }
                    } else {
                        //The end of the string was found
                        scala.util.boundary.break()(using break_N70310)
                    }
                }
            }
        }
        return tokenList
    }

    //BasicArrayList tokenVector = new BasicArrayListD();
    def getTokensFromString(string : String, tokenVector : BasicArrayList) : BasicArrayList = {
        var index : Int = 0
        var end : Int = 0

        {
            scala.util.boundary { (break_N70854 : scala.util.boundary.Label[Unit]) ?=>
                while (index < string.length()) {
                    end = string.indexOf(this.sep, index)
                    // found next token
                    if (end != -1) {
                        tokenVector.add(string.substring(index, end))
                        index = end + this.sep.length()
                    } else {
                        tokenVector.add(string.substring(index, string.length()))
                        scala.util.boundary.break()(using break_N70854)
                    }
                }
            }
        }
        return tokenVector
    }

    //and added to a hashmap
    def getTokens(stringVector : BasicArrayList) : ABHashtable[Object, Object] = {
        var tokenHashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        var string : String = StringUtil.getInstance().EMPTY_STRING
        var end : Int = 0
        var size : Int = stringVector.size()

        {
            var index : Int = 0
            while (index < size) {
                string = stringVector.objectArray(index).asInstanceOf[String]
                end = string.indexOf(this.sep)
                //found next token
                if (end >= 0) {
                    tokenHashtable.put(string.substring(0, end), string.substring(end + 1, string.length()))
                }
                index += 1
            }
        }
        return tokenHashtable
    }

}


