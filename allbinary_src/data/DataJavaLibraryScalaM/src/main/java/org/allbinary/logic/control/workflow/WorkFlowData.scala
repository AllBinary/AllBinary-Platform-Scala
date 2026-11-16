/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow


class WorkFlowData private() {
    import _root_.org.allbinary.logic.control.workflow.WorkFlowData.{*}

    var WORKFLOWS : String = "WORKFLOWS"

    var WORKFLOW : String = "WORKFLOW"

    var NAME : String = "WORKFLOW_NAME"

    var DATA : String = "WORKFLOW_DATA"

}

object WorkFlowData {
    private val instance : WorkFlowData = new WorkFlowData()

    def getInstance() : WorkFlowData = {
        return WorkFlowData.instance
    }

}


