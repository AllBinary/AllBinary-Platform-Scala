/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.nio.channels.FileChannel
import _root_.java.nio.channels.FileLock
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbFileOutputStream
import _root_.org.allbinary.logic.io.StreamUtil

class FileLockUtil private() {
    import _root_.org.allbinary.logic.io.file.FileLockUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getAll(vector : BasicArrayList, isReturnOnFailure : Boolean) : BasicArrayList = {
        var fileLockVector : BasicArrayList = new BasicArrayListD()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var file : AbFile = vector.get(index).asInstanceOf[AbFile]
                var fileLock : FileLock = this.getLock(file)
                if (fileLock != null) {
                    this.logUtil.putF("File Lock Obtained: " + file.getAbsolutePath(), this, "getAll")
                    fileLockVector.add(fileLock)
                } else if (isReturnOnFailure) {
                    this.logUtil.putF("Total Locks Obtained: " + fileLockVector.size(), this, "getAll")
                    return fileLockVector
                }
                index += 1
            }
        }
        this.logUtil.putF("Total Locks Obtained: " + fileLockVector.size(), this, "getAll")
        return fileLockVector
    }

    def getAllPossible(vector : BasicArrayList) : BasicArrayList = {
        return this.getAll(vector, false)
    }

    def getAllOrNone(vector : BasicArrayList) : BasicArrayList = {
        var fileLockVector : BasicArrayList = this.getAll(vector, true)
        if (vector.size() != fileLockVector.size()) {
            return new BasicArrayListD()
        } else {
            return fileLockVector
        }
        throw new IllegalStateException()
    }

    def getLock(file : AbFile) : FileLock = {
        try {
            return this.getLock(AbFileOutputStream.createFromAbFileAppend(file, true))
        } catch {
            case e : Exception => {
                this.logUtil.put("Exception returns null", this, "getLock", e)
                return null
            }
        } finally {
        }
        throw new IllegalStateException()
    }

    def getLock(fileOutputStream : AbFileOutputStream) : FileLock = {
        try {
            var fileLock : FileLock = this.getLock(fileOutputStream.getChannel())
            return fileLock
        } catch {
            case e : Exception => {
                this.logUtil.put("Exception returns null", this, "getLock", e)
                return null
            }
        } finally {
            this.logUtil.putF("Finally - Closing FileOutputStream", this, "getLock")
            StreamUtil.getInstance().close(fileOutputStream)
        }
        throw new IllegalStateException()
    }

    def getLock(fileChannel : FileChannel) : FileLock = {
        try {
            var fileLock : FileLock = fileChannel.tryLock()
            //fileLock.release();
            return fileLock
        } catch {
            case e : Exception => {
                this.logUtil.put("Exception returns null", this, "getLock", e)
                return null
            }
        } finally {
            this.logUtil.putF("Finally - Closing FileChannel", this, "getLock")
            fileChannel.close()
        }
        throw new IllegalStateException()
    }

}

object FileLockUtil {
    private val instance : FileLockUtil = new FileLockUtil()

    def getInstance() : FileLockUtil = {
        return FileLockUtil.instance
    }

}


