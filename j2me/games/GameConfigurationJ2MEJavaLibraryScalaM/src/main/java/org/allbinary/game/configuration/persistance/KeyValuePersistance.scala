/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.persistance

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.DataInputStream
import _root_.java.io.DataOutputStream
import _root_.javax.microedition.rms.RecordEnumeration
import _root_.javax.microedition.rms.RecordStore
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.HashtableUtil

class KeyValuePersistance(param_recordId : String) extends BasicPersitance(param_recordId) {

    private val tsUtil : TsUtil = TsUtil.getInstance()

    //Constructor
    {
        val recordId : String = param_recordId
    }

    def loadAll(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.loadAllSize(abeClientInformation, 1)
    }

    def loadAllSize(abeClientInformation : AbeClientInformationInterface, size : Int) : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
            val recordEnum : RecordEnumeration = recordStore.enumerateRecords(NullRecordFilter.NULL_RECORD_FILTER, NullRecordComparator.NULL_RECORD_COMPARATOR, true)
            var hashtable : ABHashtable[String, String] = null
            var name : String = null
            var value : String = null
            val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            var recordAsBytes : Array[Byte] = null
            var byteArrayInputStream : ByteArrayInputStream = null
            var inputStream : DataInputStream = null

            {
                while (recordEnum.hasNextElement()) {
                    val id : Int = recordEnum.nextRecordId()
                    stringBuffer.delete(0, stringBuffer.length())
                    this.logUtil.putF(stringBuffer.append(this.persistanceStrings.LOADING_ID).appendint(id).toString(), this, this.persistanceStrings.LOAD_ALL)
                    recordAsBytes = this.tsUtil.getRecord(recordStore, id)
                    if (recordAsBytes != null) {
                        byteArrayInputStream = new ByteArrayInputStream(recordAsBytes)
                        inputStream = new DataInputStream(byteArrayInputStream)
                        hashtable = new ABHashtable[String, String]()

                        {
                            var index : Int = 0
                            while (index < size) {
                                name = inputStream.readUTF()
                                inputStream.readUTF()
                                value = inputStream.readUTF()
                                hashtable.put(name, value)
                                index += 1
                            }
                        }
                        this.valueList.add(hashtable)
                        this.idList.add(smallIntegerSingletonFactory.getAt(id))
                    }
                }
            }
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            if (recordStore != null) {
                PreLogUtil.put(this.persistanceStrings.CLOSING_RECORDSTORE, this, this.persistanceStrings.LOAD_ALL)
                recordStore.closeRecordStore()
            }
        }
    }

    def save(abeClientInformation : AbeClientInformationInterface, hashtable : ABHashtable[Object, Object]) : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            this.logUtil.putF(new StringMaker().append(this.persistanceStrings.SAVING).append(StringUtil.getInstance().toString(hashtable)).toString(), this, this.commonStrings.SAVE)
            recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
            val byteArrayOutputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            val outputStream : DataOutputStream = new DataOutputStream(byteArrayOutputStream)
            var value : String = null
            val commonSeps : CommonSeps = CommonSeps.getInstance()
            val objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(hashtable)
            var anyType : Object = null
            val size : Int = objectArray.length

            {
                var index : Int = 0
                while (index < size) {
                    outputStream.writeUTF(objectArray(index).asInstanceOf[String])
                    outputStream.writeUTF(commonSeps.EQUALS)
                    anyType = objectArray(index).asInstanceOf[Object]
                    value = hashtable.get(anyType).asInstanceOf[String]
                    outputStream.writeUTF(value)
                    index += 1
                }
            }
            val tsUtil : TsUtil = TsUtil.getInstance()
            val savedGameBytes : Array[Byte] = tsUtil.getByteArray(byteArrayOutputStream.toString())
            recordStore.addRecord(savedGameBytes, 0, savedGameBytes.length)
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            if (recordStore != null) {
                PreLogUtil.put(this.persistanceStrings.CLOSING_RECORDSTORE, this, this.commonStrings.SAVE)
                recordStore.closeRecordStore()
            }
        }
    }

    def get(index : Int) : ABHashtable[Object, Object] = {
        val hashtable : ABHashtable[Object, Object] = this.valueList.objectArray(index).asInstanceOf[ABHashtable[Object, Object]]
        return hashtable
    }

}


