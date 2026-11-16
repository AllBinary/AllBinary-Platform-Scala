/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.actions.script.condition.processors.output

import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.w3c.dom.Node

class ProfileActionScriptOutputFactory private() {
    import _root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ProfileActionScriptOutputFactory.{*}

}

object ProfileActionScriptOutputFactory {
    def getInstance(node : Node) : ProfileActionScriptOutputInterface = {
        var profileActionScriptOutputInterface : ProfileActionScriptOutputInterface = null
        if (DomSearchHelper.getNodeNoThrow(ImageActionScriptOutputData.NAME, node.getChildNodes()) != null) {
            profileActionScriptOutputInterface = new ImageActionScriptOutput(node)
        } else {
            throw new Exception("No Such ActionScript Output")
        }
        return profileActionScriptOutputInterface
    }

}


