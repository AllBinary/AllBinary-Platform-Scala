/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string.tokens

import _root_.java.util.HashSet
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class UniqueTokens() {

    private val specialCharacters : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        this.specialCharacters.add("!")
        this.specialCharacters.add("@")
        this.specialCharacters.add(CommonPhoneStrings.getInstance().POUND)
        this.specialCharacters.add("$")
        this.specialCharacters.add("%")
        this.specialCharacters.add("^")
        this.specialCharacters.add(CommonSeps.getInstance().AMPERSAND)
        this.specialCharacters.add(CommonPhoneStrings.getInstance().STAR)
        this.specialCharacters.add("(")
        this.specialCharacters.add(")")
        this.specialCharacters.add("-")
        this.specialCharacters.add("_")
        this.specialCharacters.add("+")
        this.specialCharacters.add("=")
        this.specialCharacters.add("\\")
        this.specialCharacters.add("|")
        this.specialCharacters.add(AbPathData.getInstance().EXTENSION_SEP)
        this.specialCharacters.add(",")
        this.specialCharacters.add("<")
        this.specialCharacters.add(">")
        this.specialCharacters.add("?")
        this.specialCharacters.add("/")
        this.specialCharacters.add("~")
        this.specialCharacters.add("`")
    }

    def getWhithoutDashesAndSkipNumberOnlyTokens(stringVector : BasicArrayList) : HashSet[Object] = {
        try {
            var hashSet : HashSet[Object] = new HashSet[Object]()
            var index : Int = 0
            var commonSeps : CommonSeps = CommonSeps.getInstance()

            {
                while (index < stringVector.size()) {
                    var keywords : String = stringVector.get(index).asInstanceOf[String]
                    var tokenizer : Tokenizer = new Tokenizer(commonSeps.COMMA)
                    var keywordVector : BasicArrayList = tokenizer.getTokensFromString(keywords, new BasicArrayListD())

                    {
                        var forIndex : Int = 0
                        while (forIndex < keywordVector.size()) {
                            var cleanString : String = keywordVector.get(forIndex).asInstanceOf[String]
                            cleanString = cleanString.trim()
                            if (cleanString.indexOf('-') != -1) {
                                cleanString = new Replace("-", commonSeps.SPACE).all(cleanString)
                            }
                            hashSet.add(cleanString)
                            if (cleanString.indexOf(' ') != -1) {
                                var spaceTokenizer : Tokenizer = new Tokenizer(commonSeps.SPACE)
                                var subKeywordVector : BasicArrayList = spaceTokenizer.getTokensFromString(cleanString, new BasicArrayListD())

                                {
                                    var spaceIndex : Int = 0
                                    while (spaceIndex < subKeywordVector.size()) {
                                        var subCleanString : String = subKeywordVector.get(spaceIndex).asInstanceOf[String]
                                        if (!isSpecialCharacter(subCleanString) && !numberOnly(subCleanString)) {
                                            hashSet.add(subCleanString)
                                        }
                                        spaceIndex += 1
                                    }
                                }
                            }
                            forIndex += 1
                        }
                    }
                    index += 1
                }
            }
            return hashSet
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    private def numberOnly(subCleaningString : String) : Boolean = {
        try {
            Integer.parseInt(subCleaningString)
            return true
        } catch {
            case e : NumberFormatException => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def isSpecialCharacter(subCleaningString : String) : Boolean = {

        {
            var index : Int = 0
            while (index < this.specialCharacters.size()) {
                if (subCleaningString.compareTo(this.specialCharacters.get(index).asInstanceOf[String]) == 0) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

}


