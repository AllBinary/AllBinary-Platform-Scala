/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.log

import _root_.java.io.BufferedReader
import _root_.java.io.BufferedWriter
import _root_.java.io.File
import _root_.java.io.FileReader
import _root_.java.io.FileWriter
import _root_.java.io.RandomAccessFile
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.communication.log.LogFormatUtil
import _root_.org.allbinary.logic.string.StringMaker

class FileLog private() {
    import _root_.org.allbinary.log.FileLog.{*}

}

object FileLog {
    private val stringUtil : StringUtil = StringUtil.getInstance()

    // 33MB
    private val logLength : Long = 33000000

    //private static final String logPath = MyFrame.PATH + "/log/";
    private val logPath : String = "g:\\log\\"

    private val extension : String = new String("dat")

    private val fileName : String = new String("log." + FileLog.extension)

    private val backupFileName : String = FileLog.fileName.concat(".bak")

    private val ORG_ALLBINARY : String = "org.allbinary: "

    private var firstTime : Boolean = true

    private var logFile : File = new File(FileLog.logPath, FileLog.fileName)

    private var logFileBak : File = null

    private var fileOut : BufferedWriter = null

    private var backupIndex : Int = 0

    def createLogFile() : Boolean = this.synchronized {
        try {
            FileLog.logFile = new File(logPath, fileName)
            if (!FileLog.firstTime) {
                FileLog.fileOut = new BufferedWriter(new FileWriter(logFile))
            } else {
                FileLog.firstTime = false
                var raFile : RandomAccessFile = new RandomAccessFile(logFile, "rw")
                raFile.seek(raFile.length())
                FileLog.fileOut = new BufferedWriter(new FileWriter(raFile.getFD()))
            }
            var canWrite : Boolean = FileLog.logFile.canWrite()
            return canWrite
        } catch {
            case e : Exception => {
                System.out.println("Error Creating Log: " + e)
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def createLogFileBackup() : Boolean = this.synchronized {
        try {
            val stringMaker : StringMaker = new StringMaker()
            FileLog.logFileBak = new File(logPath, stringMaker.append(backupFileName).append(CommonSeps.getInstance().PERIOD).appendint(backupIndex).toString())

            {
                while (FileLog.logFileBak.isFile()) {
                    FileLog.backupIndex += 1
                    stringMaker.delete(0, stringMaker.length())
                    FileLog.logFileBak = new File(logPath, stringMaker.append(backupFileName).append(CommonSeps.getInstance().PERIOD).appendint(backupIndex).toString())
                }
            }
            //String time= new String(date.toString());
            var line : String = new String()
            //+ time
            var tmpOut : BufferedWriter = new BufferedWriter(new FileWriter(logFileBak))
            var tmpIn : BufferedReader = new BufferedReader(new FileReader(logFile))
            //ready instead of a null readLine so languages without null strings stop at the end of the file and not at an empty line

            {
                while (tmpIn.ready()) {
                    line = tmpIn.readLine()
                    tmpOut.write(line, 0, line.length())
                    tmpOut.newLine()
                }
            }
            tmpOut.flush()
            tmpOut.close()
            tmpIn.close()
            FileLog.logFile.delete()
            return true
        } catch {
            case e : Exception => {
                System.out.println("Error Creating Backup: " + e)
                return false
            }
        }
        throw new IllegalStateException()
    }

    def put(specialMessage : String, anyType : Object, functionName : String) : String = this.synchronized {
        return FileLog.put(specialMessage, anyType, functionName, null)
    }

    def put(param_specialMessage : String, anyType : Object, param_functionName : String, exception : Throwable) : String = this.synchronized {
        var specialMessage : String = param_specialMessage
        var functionName : String = param_functionName
        try {
            if (FileLog.firstTime == true) {
                FileLog.createLogFileBackup()
                if (createLogFile() == false) {
                    return new String("Log File Creation Error")
                }
            }
            var length : Long = FileLog.logFile.length()
            if (length > FileLog.logLength) {
                if (!(createLogFileBackup()) || (createLogFile() == false)) {
                    return new String("Couldn't Create a Backup file")
                }
            }
            var className : String = new String(stringUtil.NULL_STRING)
            if (functionName == null) {
                functionName = new String(FileLog.stringUtil.NULL_STRING)
            }
            if (specialMessage == null) {
                specialMessage = new String(FileLog.stringUtil.NULL_STRING)
            }
            if (anyType.getClass().getName() != null) {
                className = new String(anyType.getClass().getName())
            }
            val message : String = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception)
            FileLog.fileOut.write(message, 0, message.length())
            FileLog.fileOut.newLine()
            FileLog.fileOut.flush()
            return new String(FileLog.ORG_ALLBINARY + message)
        } catch {
            case e : Exception => {
                return new String("Error: " + e)
            }
        }
        throw new IllegalStateException()
    }

    def put(specialMessage : String, className : String, functionName : String) : String = this.synchronized {
        return FileLog.put(specialMessage, className, functionName, null)
    }

    def put(param_specialMessage : String, className : String, param_functionName : String, exception : Exception) : String = this.synchronized {
        var specialMessage : String = param_specialMessage
        var functionName : String = param_functionName
        try {
            if (FileLog.firstTime == true) {
                FileLog.createLogFileBackup()
                if (createLogFile() == false) {
                    return new String("Log File Creation Error")
                }
            }
            var length : Long = FileLog.logFile.length()
            if (length > FileLog.logLength) {
                if (!(createLogFileBackup()) || (createLogFile() == false)) {
                    return new String("Couldn't Create a Backup file")
                }
            }
            if (functionName == null) {
                functionName = new String(FileLog.stringUtil.NULL_STRING)
            }
            if (specialMessage == null) {
                specialMessage = new String(FileLog.stringUtil.NULL_STRING)
            }
            val message : String = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception)
            FileLog.fileOut.write(message, 0, message.length())
            FileLog.fileOut.newLine()
            FileLog.fileOut.flush()
            return new String(FileLog.ORG_ALLBINARY + message)
        } catch {
            case e : Exception => {
                return new String("Error: " + e)
            }
        }
        throw new IllegalStateException()
    }

    def getFilePath() : String = {
        return FileLog.logPath + FileLog.fileName
    }

}


