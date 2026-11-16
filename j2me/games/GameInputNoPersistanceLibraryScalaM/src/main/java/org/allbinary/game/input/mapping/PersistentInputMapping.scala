/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping

import _root_.java.util.Enumeration
import _root_.org.allbinary.game.configuration.persistance.GamePersistanceStrings
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputPersistance
import _root_.org.allbinary.game.input.mapping.event.InputMappingEvent
import _root_.org.allbinary.game.input.mapping.event.InputMappingEventListenerInterface
import _root_.org.allbinary.game.input.mapping.event.NullInputMappingEventListener
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.EnumerationUtil
import _root_.org.allbinary.util.ABHashtable

//GameInputNoPersistanceLibrary
class PersistentInputMapping(param_name : String) {
    import _root_.org.allbinary.game.input.mapping.PersistentInputMapping.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    private val inputMapping : InputToGameKeyMapping = new InputToGameKeyMapping()

    private var inputMappingEventListenerInterface : InputMappingEventListenerInterface = NullInputMappingEventListener.NULL_INPUT_MAPPING_EVENT_LISTENER

    private var inputPersistance : InputPersistance = null

    private var inputMappingEvent : InputMappingEvent = new InputMappingEvent(this)

    //Constructor
    {
        val name : String = param_name
        this.inputPersistance = new InputPersistance(name)
    }

    def getTotalMapped() : Int = {
        return this.getInputMapping().getHashtable().size()
    }

    def isDefaultNew() : Boolean = {
        return false
    }

    def getDefault() : InputToGameKeyMapping = {
        return InputToGameKeyMapping.getNullInstance()
    }

    def setDefault(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.getInputMapping().removeAll()
        this.getInputMapping().addMapping(this.getDefault())
        //this.save(inputToGameKeyMapping);
        this.save(abeClientInformation)
    }

    def update(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.inputPersistance.deleteAll(abeClientInformation)
        this.save(abeClientInformation)
    }

    def save(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.inputPersistance.save(abeClientInformation, this.getInputMapping().getHashtable())
        //inputMappingEvent.setInputToGameKeyMapping(inputToGameKeyMapping);
        this.inputMappingEvent.setInputToGameKeyMapping(this.getInputMapping())
        if (this.getInputMappingEventListenerInterface() != null) {
            this.getInputMappingEventListenerInterface().onInputMappingEvent(this.inputMappingEvent)
        }
    }

    def init(abeClientInformation : AbeClientInformationInterface) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.INIT)
        //This could happen if file is not deleted between versions and something changed
        try {
            this.inputPersistance.loadAll(abeClientInformation)
        } catch {
            case e : Exception => {
                //this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e);
                PreLogUtil.putOE(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
                //inputPersistance.deleteAll(abeClientInformation);
                this.inputPersistance.deleteRecoreStore(abeClientInformation)
                this.setDefault(abeClientInformation)
                //this.setDefault((InputToGameKeyMapping) this);
                this.inputPersistance.loadAll(abeClientInformation)
            }
        }
        val list : BasicArrayList = this.inputPersistance.getList()
        var totalMappedTo : Int = 0
        //TWB - Use selected profile/id for future imp
        val size : Int = list.size()
        var hashtable : ABHashtable[Object, Object] = null
        var enumeration : Enumeration[? <: Object] = null
        var mappedToInput : Input = null
        var gameActionInput : Input = null

        {
            var index : Int = 0
            while (index < size) {
                hashtable = list.objectArray(index).asInstanceOf[ABHashtable[Object, Object]]
                enumeration = hashtable.keys().asInstanceOf[Enumeration[? <: Object]]

                {
                    while (this.enumerationUtil.hasMoreElements(enumeration)) {
                        mappedToInput = this.enumerationUtil.nextElement(enumeration).asInstanceOf[Input]
                        gameActionInput = hashtable.get(mappedToInput).asInstanceOf[Input]
                        //MotionGestureInput mappedToKey
                        totalMappedTo += 1
                        this.getInputMapping().add(gameActionInput, mappedToInput)
                    }
                }
                index += 1
            }
        }
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("End - Total Loaded Keys Mapped: ")
        stringBuffer.appendint(this.getTotalMapped())
        stringBuffer.append(" to: ")
        stringBuffer.appendint(totalMappedTo)
        this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.INIT)
    }

    def setInputMappingEventListenerInterface(inputMappingEventListenerInterface : InputMappingEventListenerInterface) : Unit = {
        this.inputMappingEventListenerInterface = inputMappingEventListenerInterface
    }

    private def getInputMappingEventListenerInterface() : InputMappingEventListenerInterface = {
        return this.inputMappingEventListenerInterface
    }

    def getInputMapping() : InputToGameKeyMapping = {
        return this.inputMapping
    }

    //TWB - Hack Method for Platform Independence - Maybe a better place for this
    def isDelete(input : Input) : Boolean = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def isSystemInput(input : Input) : Boolean = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

}

object PersistentInputMapping {
    var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : PersistentInputMapping = {
        if (PersistentInputMapping.instance eq NullUtil.getInstance().NULL_OBJECT) {
            PersistentInputMapping.instance = new PersistentInputMapping(GamePersistanceStrings.getInstance().SAVED_INPUT_CONFIGURATION_RECORD_ID)
        }
        return PersistentInputMapping.instance.asInstanceOf[PersistentInputMapping]
    }

}


