/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItemInterface
import _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptNodeInterface
import _root_.org.allbinary.input.automation.actions.script.condition.processors.ProfileActionScriptProcessorInterface

trait ProfileActionScriptConditionInterface extends ProfileActionScriptNodeInterface with CustomTreeNodeInterface with ProfileActionScriptItemInterface {

    def addProcessor(profileActionProcessorInterface : ProfileActionScriptProcessorInterface) : Unit

    def removeProcessor(profileActionProcessorInterface : ProfileActionScriptProcessorInterface) : Unit

    def shouldProcess(frame : _root_.java.lang.Long) : Boolean

}


