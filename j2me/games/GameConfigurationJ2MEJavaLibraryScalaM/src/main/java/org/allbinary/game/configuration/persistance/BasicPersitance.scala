/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.persistance

import _root_.javax.microedition.rms.RecordStore
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.persistance.PlatformRecordIdUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicPersitance(param_recordId : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val persistanceStrings : PersistanceStrings = PersistanceStrings.getInstance()

    private val platformRecordIdUtil : PlatformRecordIdUtil = PlatformRecordIdUtil.getInstance()

    private var recordId : String = null

    val valueList : BasicArrayList = new BasicArrayListD()

    val idList : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val recordId : String = param_recordId
        this.recordId = recordId
    }

    def deleteRecoreStore(abeClientInformation : AbeClientInformationInterface) : Unit = {
        RecordStore.deleteRecordStore(this.getRecordId(abeClientInformation))
    }

    //Load all needs to be called already
    def deleteAll(abeClientInformation : AbeClientInformationInterface) : Unit = {
        var size : Int = this.idList.size()

        {
            var index : Int = 0
            while (index < size) {
                var integer : Integer = this.idList.objectArray(index).asInstanceOf[Integer]
                this.delete(abeClientInformation, integer.intValue())
                index += 1
            }
        }
        this.clear()
    }

    def delete(abeClientInformation : AbeClientInformationInterface, deleteId : Int) : Unit = {
        var recordStore : RecordStore = NullRecordStore.NULL_RECORD_STORE
        try {
            this.logUtil.putF(new StringMaker().append(this.persistanceStrings.DELETING_WITH_ID).appendint(deleteId).toString(), this, this.commonStrings.delete)
            recordStore = RecordStore.openRecordStore(this.getRecordId(abeClientInformation), true)
            recordStore.deleteRecord(deleteId)
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            if (recordStore != null) {
                PreLogUtil.put(this.persistanceStrings.CLOSING_RECORDSTORE, this, this.commonStrings.delete)
                recordStore.closeRecordStore()
            }
        }
    }

    def getRecordId(abeClientInformation : AbeClientInformationInterface) : String = {
        return this.platformRecordIdUtil.getRecordId(abeClientInformation, this.recordId)
    }

    def getList() : BasicArrayList = {
        return this.valueList
    }

    def getIds() : BasicArrayList = {
        return this.idList
    }

    def clear() : Unit = {
        this.valueList.clear()
        this.idList.clear()
    }

}


