/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.rms.RecordEnumeration
import _root_.javax.microedition.rms.RecordStore
import _root_.org.allbinary.game.configuration.persistance.BasicPersitance
import _root_.org.allbinary.game.configuration.persistance.NullRecordComparator
import _root_.org.allbinary.game.configuration.persistance.NullRecordFilter
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.HashtableUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

//GameInputNoPersistanceLibrary
class InputPersistance(param_name : String) extends BasicPersitance(param_name) {

    private val hashtableUtil : HashtableUtil = HashtableUtil.getInstance()

    //Constructor
    {
        val name : String = param_name
    }

    def loadAll(abeClientInformation : AbeClientInformationInterface) : Unit = {
        val recordStore : RecordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
        val recordEnum : RecordEnumeration = recordStore.enumerateRecords(NullRecordFilter.NULL_RECORD_FILTER, NullRecordComparator.NULL_RECORD_COMPARATOR, true)
        //DataInputStream inputStream;
        var hashtable : ABHashtable[Object, Object] = null
        //GameKeyMappingFactory gameKeyFactory = GameKeyMappingFactory.getInstance();            
        val stringBuffer : StringMaker = new StringMaker()
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        var id : Int = 0

        {
            while (recordEnum.hasNextElement()) {
                id = recordEnum.nextRecordId()
                stringBuffer.delete(0, stringBuffer.length())
                this.logUtil.putF(stringBuffer.append(this.persistanceStrings.LOADING_ID).appendint(id).toString(), this, this.persistanceStrings.LOAD_ALL)
                //inputStream = new DataInputStream(byteArrayInputStream);
                hashtable = StdUtil.getInstance().createHashtable()
                /*             while (inputStream.available() > 0)             {                 gameActionInputId = Integer.parseInt(inputStream.readUTF());                 inputStream.readUTF();                 inputId = Integer.parseInt(inputStream.readUTF());                 gameActionInput = gameKeyFactory.getInstance((int) gameActionInputId);                 input = inputFactory.getInstance((int) inputId);                  if (input == null || gameActionInput == null)                 {                     stringBuffer.delete(0, stringBuffer.length());                      if (input == null)                     {                         stringBuffer.append(ERROR_LOADING_ID);                         stringBuffer.append(inputId);                         stringBuffer.append(GAME_ACTION_INPUT);                         stringBuffer.append(gameActionInputId);                                                  //this.logUtil.putF(stringBuffer.toString(), this, persistanceStrings.LOAD_ALL);                         PreLogUtil.put(stringBuffer.toString(), this, METHOD_NAME);                     }                     if (gameActionInput == null)                     {                         stringBuffer.delete(0, stringBuffer.length());                                                  stringBuffer.append(ERROR_LOADING);                         stringBuffer.append(gameActionInputId);                         stringBuffer.append(ID);                         stringBuffer.append(inputId);                                                  //this.logUtil.putF(stringBuffer.toString(), this, persistanceStrings.LOAD_ALL);                         PreLogUtil.put(stringBuffer.toString(), this, METHOD_NAME);                     }                 }                 else                 {                     //this.logUtil.putF("Load Mapping from: "                       //     ).append(input.toString()).append(" to: "                         //   ).append(gameActionInput.toString(), this, persistanceStrings.LOAD_ALL);                 }                  hashtable.put(input, gameActionInput);             }             */
                this.valueList.add(hashtable)
                this.idList.add(smallIntegerSingletonFactory.getAt(id))
            }
        }
        recordStore.closeRecordStore()
    }

    def save(abeClientInformation : AbeClientInformationInterface, hashtable : ABHashtable[Object, Object]) : Unit = {
        PreLogUtil.put(new StringMaker().append(this.persistanceStrings.NOT_SAVING).append(StringUtil.getInstance().toString(hashtable)).toString(), this, this.commonStrings.SAVE)
        //this.logUtil.putF("Saving: ").append(hashtable, this, this.commonStrings.SAVE);
        val recordStore : RecordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
        //      byteArrayOutputStream);
        var gameActionInput : Input = null
        var list : BasicArrayList = null
        var input : Input = null
        //final SmallIntegerSingletonFactory smallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance();
        val inputObjectArray : Array[Object] = this.hashtableUtil.getKeysAsArray(hashtable)
        val size : Int = inputObjectArray.length

        {
            var index : Int = 0
            while (index < size) {
                gameActionInput = inputObjectArray(index).asInstanceOf[Input]
                list = hashtable.get(inputObjectArray(index)).asInstanceOf[BasicArrayList]

                {
                    var index2 : Int = 0
                    while (index2 < list.size()) {
                        //outputStream.writeUTF(commonSeps.EQUALS);
                        input = list.get(index2).asInstanceOf[Input]
                        index2 += 1
                    }
                }
                index += 1
            }
        }
        //recordStore.addRecord(savedGameBytes, 0, savedGameBytes.length);
        recordStore.closeRecordStore()
    }

}


