/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.org.allbinary.logic.string.StringMaker
import _root_.java.sql.ResultSet
import _root_.java.sql.ResultSetMetaData
import _root_.java.util.Calendar
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.logic.io.AbFileOutputStream
import _root_.org.allbinary.logic.io.BufferedLineReader
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.java.io.OutputStream
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringUtil

class AbSqlTableUtil {
    import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var EXTENSION : String = ".adb"

    private val END : String = "')\n"

    private val SAVING_BACKUP_PATH : String = "Saving Backup: Path: "

    private val FILE_LABEL : String = " File: "

    private val METHOD_RESTORE_TABLE : String = "restoreTable()"

    private val METHOD_BACKUP_TABLE : String = "backupTable()"

    private val METHOD_BACKUP_FILE : String = "backupFile()"

    private val METHOD_GET_OUTPUT_STREAM : String = "getOutputStream()"

    private val TABLE_CREATION_SUCCESS : String = "Table Creation Successful: "

    private val DROPPED_SUCCESS : String = " Dropped Successfully"

    private val SAVING : String = "Saving: "

    private val APPENDING : String = "Appending: "

    private val TABLE_LABEL : String = "Table: "

    private val BACKUP_SUCCESS : String = " Backup Success"

    private val ERROR_CREATING : String = "Error Creating: "

    private val TOTAL_LABEL : String = " Total: "

    private val SECTION_LABEL : String = " Section: "

    private val DASH : String = " - "

    private val PORTION_RESTORED : String = " Portion Restored"

    private val specialCharArray : Array[Char] = Array[Char]('\n', '\f', '\r')

    private val NEW_LINE : String = "\\n"

    val stringUtil : StringUtil = StringUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    val sqlStrings : SqlStrings = SqlStrings.getInstance()

    private def getOutputStream(backupPath : String, tableName : String) : OutputStream = this.synchronized {
        try {
            var fileName : String = tableName + this.EXTENSION
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil.putF(this.SAVING + tableName, this, this.METHOD_GET_OUTPUT_STREAM)
            }
            var backupFilePath : AbPath = new AbPath(backupPath, fileName)
            var backupFile : AbFile = AbFile.createAbFile(backupFilePath)
            if (backupFile.exists()) {
                this.backupFile(backupFilePath, backupPath, tableName)
                backupFile.delete()
            }
            backupFile.createNewFile()
            var outputStream : OutputStream = new AbFileOutputStream(backupFile)
            return outputStream
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put("Create File", this, this.METHOD_GET_OUTPUT_STREAM, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    private def backupFile(path : AbPath, backupPath : String, tableName : String) : Boolean = this.synchronized {
        try {
            var calendar : Calendar = Calendar.getInstance()
            var timeLong : _root_.java.lang.Long = new _root_.java.lang.Long(calendar.getTimeInMillis())
            var time : String = timeLong.toString()
            val stringBuffer : StringMaker = new StringMaker()
            var fileName : String = tableName + this.EXTENSION
            stringBuffer.append(backupPath)
            stringBuffer.append(AbPathData.getInstance().SEPARATOR)
            stringBuffer.append(time)
            var backupAbPath : AbPath = new AbPath(stringBuffer.toString())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(this.SAVING_BACKUP_PATH)
                stringBuffer.append(backupAbPath.toFileSystemString())
                stringBuffer.append(this.FILE_LABEL)
                stringBuffer.append(fileName)
                this.logUtil.putF(stringBuffer.toString(), this, this.METHOD_BACKUP_FILE)
            }
            Directory.create(backupAbPath)
            var backupFileBak : AbFile = AbFile.createAbFile(backupAbPath.toFileSystemString())
            backupFileBak.createNewFile()
            FileUtil.getInstance().copy(path, backupAbPath)
            return true
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.METHOD_BACKUP_FILE, e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def convertNewLines(value : String) : String = {
        //Replace replace = new Replace(CommonSeps.getInstance().NEW_LINE,"\\n");
        var stringBuffer : StringMaker = new StringMaker()
        var index : Int = 0
        var lastIndex : Int = 0

        {
            scala.util.boundary { (break_N78540 : scala.util.boundary.Label[Unit]) ?=>
                while (index < value.length()) {
                    index = value.indexOf(specialCharArray(0), lastIndex)
                    if (index != -1) {
                        var nextLine : String = value.substring(lastIndex, index - 1)
                        stringBuffer.append(nextLine)
                        stringBuffer.append(this.NEW_LINE)
                        lastIndex = index + 1
                    } else {
                        scala.util.boundary.break()(using break_N78540)
                    }
                }
            }
        }
        //add the last line since if it did not end with a new line
        if (lastIndex < value.length()) {
            stringBuffer.append(value.substring(lastIndex, value.length()))
        }
        return stringBuffer.toString()
    }

    //This is not good for large data
    def backupTable(abSqlTable : AbSqlTable) : String = this.synchronized {
        val tableName : String = abSqlTable.getTableName()
        try {
            var count : Int = 0
            var sqlStatement : String = this.sqlStrings.SELECT_ALL_FROM + tableName
            var path : String = String.valueOf(_root_.org.allbinary.globals.URLGLOBALS.getMainPath()) + PATH_GLOBALS.getInstance().BACKUP_PATH
            if (!Directory.create(new AbPath(path))) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil.putF(ERROR_CREATING + path, this, this.METHOD_BACKUP_TABLE)
                }
            }
            var rset : ResultSet = abSqlTable.executeSQLStatement(sqlStatement)
            var rsmd : ResultSetMetaData = rset.getMetaData()
            var colNum : Int = rsmd.getColumnCount()
            val QUERY_START : String = new _root_.java.lang.StringBuilder().append(this.sqlStrings.INSERT_INTO).append(tableName).append(this.sqlStrings.VALUES).toString()
            var stringBuffer : StringMaker = new StringMaker()
            //createFile(path, tableName, returnBuffer.toString());
            var outputStream : OutputStream = this.getOutputStream(path, tableName)

            {
                while (rset.next()) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(QUERY_START)

                    {
                        var i : Int = 1
                        while (i < colNum) {
                            //get rid of new lines
                            var value : String = rset.getString(i)
                            stringBuffer.append(this.convertNewLines(value))
                            stringBuffer.append(this.sqlStrings.SINGLE_QUOTE_COMMA_SEP)
                            i += 1
                        }
                    }
                    stringBuffer.append(rset.getString(colNum))
                    stringBuffer.append(this.END)
                    var sqlStatementLine : String = stringBuffer.toString()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil.putF(this.APPENDING + sqlStatementLine, this, this.METHOD_BACKUP_TABLE)
                    }
                    outputStream.write(sqlStatementLine.getBytes())
                }
            }
            StreamUtil.getInstance().close(outputStream)
            return (this.TABLE_LABEL + tableName) + this.BACKUP_SUCCESS
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put("Backup Table Failed\nSQL Statement", this, this.METHOD_BACKUP_TABLE, e)
                }
                return (this.TABLE_LABEL + tableName) + " Backup Failed"
            }
        }
        throw new IllegalStateException()
    }

    def restoreTable(abSqlTable : AbSqlTable, portion : Portion) : String = this.synchronized {
        val tableName : String = abSqlTable.getTableName()
        try {
            var path : String = String.valueOf(_root_.org.allbinary.globals.URLGLOBALS.getMainPath()) + PATH_GLOBALS.getInstance().BACKUP_PATH
            var current : Int = portion.getCurrent().intValue()
            if (current == 0) {
                if (Directory.create(new AbPath(path))) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil.putF(this.ERROR_CREATING + path, this, this.METHOD_RESTORE_TABLE)
                    }
                }
            }
            var backupFile : AbFile = AbFile.createAbFile(path, tableName + this.EXTENSION)
            var bufferedLineReader : BufferedLineReader = new BufferedLineReader(backupFile)
            var size : Long = bufferedLineReader.getSize()
            //Add one to round up so files will not be missed
            var section : Long = (size / portion.getTotal().intValue()) + 1
            var start : Long = section * current
            var end : Long = start + section
            if (end > size) {
                end = size
            }
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.TOTAL_LABEL)
            stringBuffer.append(size)
            stringBuffer.append(this.SECTION_LABEL)
            stringBuffer.append(start)
            stringBuffer.append(this.DASH)
            stringBuffer.append(end)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil.putF(stringBuffer.toString(), this, this.METHOD_RESTORE_TABLE)
            }
            //If the readahead is less than 2 lines then this will only work some of the time
            bufferedLineReader.readUpToLines(start)
            var line : String = this.stringUtil.EMPTY_STRING
            //ready instead of a null readLine so languages without null strings stop at the end of the file and not at an empty line

            {
                while ((bufferedLineReader.getCurrent() < end) && bufferedLineReader.ready()) {
                    line = bufferedLineReader.readLine()
                    if (line.length() > 1) {
                        abSqlTable.executeSQLStatement(line)
                    }
                }
            }
            stringBuffer.append(this.commonSeps.SPACE)
            stringBuffer.append(this.TABLE_LABEL)
            stringBuffer.append(tableName)
            stringBuffer.append(this.PORTION_RESTORED)
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put("Restore Table Failed\nSQL Statement", this, this.METHOD_RESTORE_TABLE, e)
                }
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(this.TABLE_LABEL)
                stringBuffer.append(tableName)
                stringBuffer.append(" Restoration Failed")
                return stringBuffer.toString()
            }
        }
        throw new IllegalStateException()
    }

}

object AbSqlTableUtil {
    private val instance : AbSqlTableUtil = new AbSqlTableUtil()

    /**      * @return the instance      */
    def getInstance() : AbSqlTableUtil = {
        return AbSqlTableUtil.instance
    }

}


