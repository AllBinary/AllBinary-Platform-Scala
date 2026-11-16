/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.DataInputStream
import _root_.java.io.DataOutputStream
import _root_.javax.microedition.rms.RecordEnumeration
import _root_.javax.microedition.rms.RecordStore
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.game.configuration.persistance.BasicPersitance
import _root_.org.allbinary.game.configuration.persistance.NullRecordComparator
import _root_.org.allbinary.game.configuration.persistance.NullRecordFilter
import _root_.org.allbinary.game.configuration.persistance.NullRecordStore
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.HashtableUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

//GameInputPersistanceLibrary
class InputPersistance(param_name : String) extends BasicPersitance(param_name) {

    private val tsUtil : TsUtil = TsUtil.getInstance()

    private val hashtableUtil : HashtableUtil = HashtableUtil.getInstance()

    //Constructor
    {
        val name : String = param_name
    }

    def loadAll(abeClientInformation : AbeClientInformationInterface) : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
            val recordEnum : RecordEnumeration = recordStore.enumerateRecords(NullRecordFilter.NULL_RECORD_FILTER, NullRecordComparator.NULL_RECORD_COMPARATOR, true)
            //PreLogUtil.put(METHOD_NAME, this, METHOD_NAME);
            var gameActionInputId : Long = 0L
            var inputId : Long = 0L
            var gameActionInput : Input = null
            var input : Input = null
            var hashtable : ABHashtable[Object, Object] = null
            val gameKeyFactory : GameKeyMappingFactory = GameKeyMappingFactory.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            val inputFactory : InputFactory = InputFactory.getInstance()
            val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
            val stdUtil : StdUtil = StdUtil.getInstance()
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
                        //PreLogUtil.put("bytes in: " + ArrayUtil.getInstance().toString(recordAsBytes), this, METHOD_NAME);
                        byteArrayInputStream = new ByteArrayInputStream(recordAsBytes)
                        inputStream = new DataInputStream(byteArrayInputStream)
                        hashtable = stdUtil.createHashtable()
                        //PreLogUtil.put("inputStream.available(): " + inputStream.available(), this, METHOD_NAME);
                        var value : Int = 0

                        {
                            while (inputStream.available() > 0) {
                                val gameActionInputIdAsString : String = inputStream.readUTF()
                                //PreLogUtil.put("gameActionInputIdAsString: " + gameActionInputIdAsString, this, METHOD_NAME);
                                value = Integer.parseInt(gameActionInputIdAsString)
                                gameActionInputId = value.toLong
                                //PreLogUtil.put("gameActionInputId: " + gameActionInputId, this, METHOD_NAME);
                                inputStream.readUTF()
                                value = Integer.parseInt(inputStream.readUTF())
                                inputId = value.toLong
                                //PreLogUtil.put("inputId: " + inputId, this, METHOD_NAME);
                                gameActionInput = gameKeyFactory.getGameKey(gameActionInputId.toInt)
                                input = inputFactory.getInstanceById(inputId.toInt)
                                if ((input eq inputFactory.NO_INPUT) || (gameActionInput == null)) {
                                    stringBuffer.delete(0, stringBuffer.length())
                                    if (input eq inputFactory.NO_INPUT) {
                                        stringBuffer.append(this.persistanceStrings.ERROR_LOADING_ID)
                                        stringBuffer.appendlong(inputId)
                                        stringBuffer.append(this.persistanceStrings.GAME_ACTION_INPUT)
                                        stringBuffer.appendlong(gameActionInputId)
                                        //this.logUtil.putF(stringBuffer.toString(), this, persistanceStrings.LOAD_ALL);
                                        PreLogUtil.put(stringBuffer.toString(), this, this.persistanceStrings.LOAD_ALL)
                                    }
                                    if (gameActionInput == null) {
                                        stringBuffer.delete(0, stringBuffer.length())
                                        stringBuffer.append(this.persistanceStrings.ERROR_LOADING)
                                        stringBuffer.appendlong(gameActionInputId)
                                        stringBuffer.append(this.persistanceStrings.ID)
                                        stringBuffer.appendlong(inputId)
                                        //this.logUtil.putF(stringBuffer.toString(), this, persistanceStrings.LOAD_ALL);
                                        PreLogUtil.put(stringBuffer.toString(), this, this.persistanceStrings.LOAD_ALL)
                                    }
                                } else {
                                }
                                hashtable.put(input, gameActionInput)
                            }
                        }
                        //this.logUtil.putF("Add mapping for id", this, METHOD_NAME);
                        this.valueList.add(hashtable)
                        this.idList.add(smallIntegerSingletonFactory.getAt(id))
                    } else {
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
            val stringBuffer : StringMaker = new StringMaker()
            PreLogUtil.put(stringBuffer.append(this.persistanceStrings.SAVING).append(StringUtil.getInstance().toString(hashtable)).toString(), this, this.commonStrings.SAVE)
            //this.logUtil.putF("Saving: ").append(hashtable, this, this.commonStrings.SAVE);
            recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
            var byteArrayOutputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            var outputStream : DataOutputStream = new DataOutputStream(byteArrayOutputStream)
            var gameActionInput : Input = null
            var list : BasicArrayList = null
            var input : Input = null
            var savedGameBytes : Array[Byte] = null
            val commonSeps : CommonSeps = CommonSeps.getInstance()
            val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
            val inputObjectArray : Array[Object] = this.hashtableUtil.getKeysAsArray(hashtable)
            val size : Int = inputObjectArray.length

            {
                var index : Int = 0
                while (index < size) {
                    gameActionInput = inputObjectArray(index).asInstanceOf[Input]
                    list = hashtable.get(inputObjectArray(index).asInstanceOf[Object]).asInstanceOf[BasicArrayList]

                    {
                        var index2 : Int = 0
                        while (index2 < list.size()) {
                            val gameActionInputIdAsString : String = smallIntegerSingletonFactory.getAt(gameActionInput.getId()).toString()
                            //stringBuffer.append(gameActionInputIdAsString);
                            outputStream.writeUTF(gameActionInputIdAsString)
                            //stringBuffer.append(commonSeps.EQUALS);
                            outputStream.writeUTF(commonSeps.EQUALS)
                            input = list.objectArray(index2).asInstanceOf[Input]
                            val inputIdAsString : String = smallIntegerSingletonFactory.getAt(input.getId()).toString()
                            //stringBuffer.append(inputIdAsString);
                            outputStream.writeUTF(inputIdAsString)
                            index2 += 1
                        }
                    }
                    index += 1
                }
            }
            //savedGameBytes = byteArrayOutputStream.toString().getBytes();
            savedGameBytes = byteArrayOutputStream.toByteArray()
            //PreLogUtil.put("bytes out: " + ArrayUtil.getInstance().toString(savedGameBytes), this, this.commonStrings.SAVE);
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

}


