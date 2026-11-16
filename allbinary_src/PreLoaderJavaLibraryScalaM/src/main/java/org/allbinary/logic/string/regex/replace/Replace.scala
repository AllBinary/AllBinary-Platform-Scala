/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string.regex.replace

import _root_.java.util.HashMap
import _root_.org.allbinary.J2SEUtil
import _root_.org.allbinary.globals.AppUrlGlobals
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes

class Replace private () {
    import _root_.org.allbinary.logic.string.regex.replace.Replace.{*}

    private val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonStrings commonStrings = CommonStrings.getInstance();
    private val j2seUtil : J2SEUtil = J2SEUtil.getInstance()

    private val REPLACERS_ : String = "Replacers: "

    private val ALL : String = "all"

    private val FOUND_KEY : String = "found key total: "

    private var hashMap : HashMap[Object, Object] = null

    def this(key : String, value : String) = {
        this()
        this.hashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.hashMap.put(Array[String](key), Array[String](value))
    }

    def this(keys : Array[String], values : Array[String]) = {
        this()
        this.hashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.hashMap.put(keys, values)
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.hashMap = hashMap
    }

    def all(replace : String) : String = {
        return this.upTo(replace, Integer.MIN_VALUE)
    }

    def upTo(param_replace : String, total : Int) : String = {
        var replace : String = param_replace
        //      }
        val newStringBuffer : StringMaker = new StringMaker()
        var totalNumberOfReplaces : Int = 0
        var keys : Array[String] = null
        var values : Array[String] = null
        val keyArray : Array[Object] = this.j2seUtil.getHashMapAsArray(this.hashMap)
        val size : Int = keyArray.length

        {
            var index2 : Int = 0
            while (index2 < size) {
                keys = keyArray(index2).asInstanceOf[Array[String]]
                values = this.hashMap.get(keys).asInstanceOf[Array[String]]
                //replace.replace(key, value);
                var foundTotal : Long = 0
                var index : Int = 0
                var nextKey : String = null
                var end : Int = 0
                var nextSecondKey : String = null
                var begin2 : Int = 0

                {
                    scala.util.boundary { (break_N73103 : scala.util.boundary.Label[Unit]) ?=>
                        while (index < replace.length()) {
                            val begin : Int = replace.indexOf(keys(0), index)
                            if (begin != -1) {
                                foundTotal += 1
                                if ((foundTotal % 100) == 0L) {
                                    System.out.println(this.FOUND_KEY + foundTotal)
                                }
                                nextKey = keys(0)
                                end = begin + nextKey.length()
                                //System.out.println(replace.substring(end, replace.length()));
                                newStringBuffer.delete(0, newStringBuffer.length())
                                newStringBuffer.append(replace.substring(0, begin))
                                newStringBuffer.append(values(0))
                                index = newStringBuffer.length()
                                newStringBuffer.append(replace.substring(end, replace.length()))
                                replace = newStringBuffer.toString()
                                if (keys.length > 1) {
                                    nextSecondKey = keys(1)
                                    begin2 = replace.indexOf(nextSecondKey, index)
                                    if (begin2 != -1) {
                                        val end2 : Int = begin2 + nextSecondKey.length()
                                        newStringBuffer.delete(0, newStringBuffer.length())
                                        newStringBuffer.append(replace.substring(0, begin2))
                                        newStringBuffer.append(values(1))
                                        index = newStringBuffer.length()
                                        newStringBuffer.append(replace.substring(end2, replace.length()))
                                        replace = newStringBuffer.toString()
                                    }
                                }
                                totalNumberOfReplaces += 1
                                if ((total != Integer.MIN_VALUE) && (totalNumberOfReplaces >= total)) {
                                    scala.util.boundary.break()(using break_N73103)
                                }
                            } else {
                                scala.util.boundary.break()(using break_N73103)
                            }
                        }
                    }
                }
                index2 += 1
            }
        }
        //}
        if (totalNumberOfReplaces > 0) {
            if (LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().REPLACE)) {
                this.logUtil.putF("Total Number Of Replaces: " + totalNumberOfReplaces, this, this.ALL)
            }
        }
        return replace
    }

    def line(param_replace : String) : String = {
        var replace : String = param_replace
        //      }
        val newStringBuffer : StringMaker = new StringMaker()
        var totalNumberOfReplaces : Int = 0
        var key : String = null
        var value : String = null
        val keyArray : Array[Object] = this.j2seUtil.getHashMapAsArray(this.hashMap)
        val size : Int = keyArray.length

        {
            var index2 : Int = 0
            while (index2 < size) {
                key = keyArray(index2).asInstanceOf[String]
                value = this.hashMap.get(key).asInstanceOf[String]
                //replace.replace(key, value);
                var index : Int = 0

                {
                    scala.util.boundary { (break_N75030 : scala.util.boundary.Label[Unit]) ?=>
                        while (index < replace.length()) {
                            newStringBuffer.delete(0, newStringBuffer.length())
                            val begin : Int = replace.indexOf(key, index)
                            if (begin != -1) {
                                System.out.println(this.FOUND_KEY)
                                val end : Int = replace.indexOf('\n', begin + key.length()) + 1
                                if (end >= 0) {
                                    //System.out.println(replace.substring(end, replace.length()));
                                    newStringBuffer.append(replace.substring(0, begin))
                                    index = newStringBuffer.length()
                                    newStringBuffer.append(replace.substring(end, replace.length()))
                                    replace = newStringBuffer.toString()
                                    totalNumberOfReplaces += 1
                                }
                            } else {
                                scala.util.boundary.break()(using break_N75030)
                            }
                        }
                    }
                }
                index2 += 1
            }
        }
        //}
        if (LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().REPLACE)) {
            this.logUtil.putF("Total Number Of Replaces: " + totalNumberOfReplaces, this, this.ALL)
        }
        return replace
    }

}

object Replace {
    def main(args : Array[String]) : Unit = {
        try {
            val stringUtil : StringUtil = StringUtil.getInstance()
            var appUrlGlobals : AppUrlGlobals = new AppUrlGlobals()
            appUrlGlobals.setWebappPath("G:/mnt/bc/mydev/work/allbinary_src/ToolsJavaLibrary/tools")
            URLGLOBALS.init(appUrlGlobals)
            var testString : String = "\"super gun\" big tank \"goodgunriflegun"
            var replace : Replace = new Replace("gun", "abcdefghijklmnopqrstuxwxyzabcdefghijklmnopqrstuxwxyz")
            System.out.println("Old String: " + testString)
            testString = replace.all(testString)
            System.out.println("New String: " + testString)
            var replaceCat : Replace = new Replace("abcdefghijklmnopqrstuxwxyzabcdefghijklmnopqrstuxwxyz", stringUtil.EMPTY_STRING)
            testString = replaceCat.all(testString)
            System.out.println("New String: " + testString)
        } catch {
            case e : Exception => {
            }
        }
    }

}


