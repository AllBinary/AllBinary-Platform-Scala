/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.directory.SubDirectory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class WeblisketFinder private() {
    import _root_.org.allbinary.business.init.WeblisketFinder.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val subDirectory : SubDirectory = SubDirectory.getInstance()

    //searches for all paths that contain the path provided
    def findAll(path : String) : BasicArrayList = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "findAll")
            return this.subDirectory.search(WeblisketFinder.KEY, AbFile.createAbFile(path))
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "findAll", e)
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "findAll", e)
                }
                //return new BasicArrayListD();
                return null
            }
        }
        throw new IllegalStateException()
    }

    //Retrieves the intallation path
    def getInstallationPath(file : AbFile) : String = {
        try {
            var filePath : String = file.getPath()
            var end : Int = filePath.indexOf(KEY)
            if (end < 0) {
                return null
            }
            return filePath.substring(0, end)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getInstallationPath", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object WeblisketFinder {
    private val instance : WeblisketFinder = new WeblisketFinder()

    /**      * @return the instance      */
    def getInstance() : WeblisketFinder = {
        return WeblisketFinder.instance
    }

    private val KEY : String = "installerdata.dat"

    def main(args : Array[String]) : Unit = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        val vector : BasicArrayList = WeblisketFinder.getInstance().findAll(stringUtil.EMPTY_STRING)
        System.out.println(vector.size())
    }

}


