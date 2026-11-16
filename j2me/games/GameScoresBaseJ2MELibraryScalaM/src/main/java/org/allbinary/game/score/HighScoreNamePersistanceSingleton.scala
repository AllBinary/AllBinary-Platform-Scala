/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.DataInputStream
import _root_.java.io.DataOutputStream
import _root_.javax.microedition.rms.RecordEnumeration
import _root_.javax.microedition.rms.RecordStore
import _root_.javax.microedition.rms.RecordStoreException
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.configuration.persistance.NullRecordComparator
import _root_.org.allbinary.game.configuration.persistance.NullRecordFilter
import _root_.org.allbinary.game.configuration.persistance.NullRecordStore
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.java.exception.ExceptionUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.persistance.PlatformRecordIdUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class HighScoreNamePersistanceSingleton {
    import _root_.org.allbinary.game.score.HighScoreNamePersistanceSingleton.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val platformRecordIdUtil : PlatformRecordIdUtil = PlatformRecordIdUtil.getInstance()

    //_Saved_Name
    private val RECORD_ID : String = "_SN"

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    private var nameBasicArrayList : BasicArrayList = new BasicArrayListD()

    // private BasicArrayList list = new BasicArrayListD();
    def clear() : Unit = {
        this.name = StringUtil.getInstance().EMPTY_STRING
    }

    def deleteAll(abeClientInformation : AbeClientInformationInterface, gameInfo : GameInfo) : Unit = {
        var size : Int = this.nameBasicArrayList.size()

        {
            var index : Int = 0
            while (index < size) {
                val integer : Integer = this.nameBasicArrayList.objectArray(index).asInstanceOf[Integer]
                this.delete(abeClientInformation, gameInfo, integer.intValue())
                index += 1
            }
        }
        this.clear()
    }

    private def getRecordId(abeClientInformation : AbeClientInformationInterface) : String = {
        return this.platformRecordIdUtil.getRecordId(abeClientInformation, this.RECORD_ID)
    }

    def delete(abeClientInformation : AbeClientInformationInterface, gameInfo : GameInfo, deleteId : Int) : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            this.logUtil.putF(new StringMaker().append("Deleting: ").appendint(deleteId).toString(), this, this.commonStrings.delete)
            recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
            recordStore.deleteRecord(deleteId)
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            if (recordStore != null) {
                PreLogUtil.put("Closing RecordStore", this, this.commonStrings.delete)
                recordStore.closeRecordStore()
            }
        }
    }

    def getIds() : BasicArrayList = {
        return this.nameBasicArrayList
    }

    def load(abeClientInformation : AbeClientInformationInterface, gameInfo : GameInfo) : String = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            // If not loaded try loading
            if (this.name eq StringUtil.getInstance().EMPTY_STRING) {
                val LOADING_ID : String = "Loading id: "
                recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
                val recordEnum : RecordEnumeration = recordStore.enumerateRecords(NullRecordFilter.NULL_RECORD_FILTER, NullRecordComparator.NULL_RECORD_COMPARATOR, true)
                val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
                var recordAsBytes : Array[Byte] = null
                var byteArrayInputStream : ByteArrayInputStream = null
                var inputStream : DataInputStream = null

                {
                    while (recordEnum.hasNextElement()) {
                        val id : Int = recordEnum.nextRecordId()
                        this.logUtil.putF(new StringMaker().append(LOADING_ID).appendint(id).toString(), this, this.commonStrings.LOAD)
                        recordAsBytes = this.tsUtil.getRecord(recordStore, id)
                        byteArrayInputStream = new ByteArrayInputStream(recordAsBytes)
                        inputStream = new DataInputStream(byteArrayInputStream)
                        //PreLogUtil.put("inputStream.available(): " + inputStream.available(), this, LOAD);

                        {
                            while (inputStream.available() > 0) {
                                this.name = inputStream.readUTF()
                            }
                        }
                        this.nameBasicArrayList.add(smallIntegerSingletonFactory.getAt(id))
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.save(abeClientInformation, gameInfo, this.name)
                this.logUtil.putF(new StringMaker().append(this.commonStrings.EXCEPTION_LABEL).append(ExceptionUtil.getInstance().getStackTrace(e)).toString(), this, this.commonStrings.LOAD)
            }
        } finally {
            try {
                if (recordStore != null) {
                    PreLogUtil.put("Closing RecordStore", this, this.commonStrings.LOAD)
                    recordStore.closeRecordStore()
                }
            } catch {
                case e : RecordStoreException => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.LOAD, e)
                }
            }
        }
        return this.name
    }

    def save(abeClientInformation : AbeClientInformationInterface, gameInfo : GameInfo, name : String) : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            this.logUtil.putF(new StringMaker().append("Saving: ").append(name).toString(), this, this.commonStrings.SAVE)
            recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
            val byteArrayOutputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            val outputStream : DataOutputStream = new DataOutputStream(byteArrayOutputStream)
            outputStream.writeUTF(name)
            //final byte[] savedGameBytes = byteArrayOutputStream.toString().getBytes();
            val savedGameBytes : Array[Byte] = byteArrayOutputStream.toByteArray()
            recordStore.addRecord(savedGameBytes, 0, savedGameBytes.length)
            this.name = name
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.SAVE, e)
            }
        } finally {
            try {
                if (recordStore != null) {
                    PreLogUtil.put("Closing RecordStore", this, this.commonStrings.SAVE)
                    recordStore.closeRecordStore()
                }
            } catch {
                case e : RecordStoreException => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.SAVE, e)
                }
            }
        }
    }

}

object HighScoreNamePersistanceSingleton {
    private var SINGLETON : HighScoreNamePersistanceSingleton = new HighScoreNamePersistanceSingleton()

    def getInstance() : HighScoreNamePersistanceSingleton = {
        return HighScoreNamePersistanceSingleton.SINGLETON
    }

}


