/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.installer

import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbIOSystem
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList

class InitializeCloud() {
    import _root_.org.allbinary.business.installer.InitializeCloud.{CLOUD as _, CLOUD_UPDATE as _, *}
    def CLOUD : String = _root_.org.allbinary.business.installer.InitializeCloud.CLOUD
    def CLOUD_UPDATE : String = _root_.org.allbinary.business.installer.InitializeCloud.CLOUD_UPDATE

    val logUtil : LogUtil = LogUtil.getInstance()

    def initialize(cloud : String, overwriteNewer : Boolean, overwriteAll : Boolean, current : Int, total : Int) : Boolean = {
        try {
            if (AbIOSystem.getInstance().isType("com.vobject.appengine.java.io")) {
                //Copy all installer files into cloud
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(URLGLOBALS.getWebappPath())
                stringBuffer.append(cloud)
                stringBuffer.append(PATH_GLOBALS.getInstance().DATA_PATH)
                val path : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(URLGLOBALS.getWebappPath())
                //stringBuffer.append(PATH_GLOBALS.getInstance().DATA_PATH);
                val realPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
                //Using cloud file search currently causes problems when trying to output new file
                val file : AbFile = AbFile.createAbFileFromAbPath(path)
                val fileBasicArrayList : BasicArrayList = Directory.getInstance().search(file, true)
                val size : Int = fileBasicArrayList.size()
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append("Searched: ")
                stringBuffer.append(path.toFileSystemString())
                stringBuffer.append(" BasicArrayList: ")
                stringBuffer.appendint(size)
                //Add one to round up so files will not be missed
                val portion : Int = (size / total) + 1
                val start : Int = portion * current
                var end : Int = start + portion
                if (end > size) {
                    end = size
                }
                stringBuffer.append(" Section: ")
                stringBuffer.appendint(start)
                stringBuffer.append(" - ")
                stringBuffer.appendint(end)
                this.logUtil.putF(stringBuffer.toString(), this, "initialize()")
                var nextFile : AbFile = null

                {
                    var index : Int = start
                    while (index < end) {
                        nextFile = fileBasicArrayList.get(index).asInstanceOf[AbFile]
                        if (nextFile.isDirectory()) {
                        } else {
                            FileUtil.getInstance().copyToCloud(nextFile, path, realPath, cloud, overwriteNewer, overwriteAll)
                        }
                        index += 1
                    }
                }
                this.logUtil.putF("Copied Files To Cloud", this, "initialize()")
            }
            return true
        } catch {
            case e : Exception => {
                this.logUtil.put("Unable to copy installer files into cloud", this, "initialize()", e)
                return false
            }
        }
        throw new IllegalStateException()
    }

}

object InitializeCloud {
    val CLOUD : String = "cloud/"

    val CLOUD_UPDATE : String = "cloudupdate/"

}


