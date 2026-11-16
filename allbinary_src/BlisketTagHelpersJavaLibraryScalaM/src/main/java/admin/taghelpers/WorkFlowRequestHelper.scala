/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tables.workflow.WorkFlowEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.workflow.NewWorkFlowFactory
import _root_.org.allbinary.logic.control.workflow.WorkFlowData
import _root_.org.allbinary.logic.control.workflow.WorkFlowInterface
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class WorkFlowRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var workFlowInterface : WorkFlowInterface = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.workFlowInterface = NewWorkFlowFactory.getInstance().getInstance(this.abeClientInformation, hashMap, pageContext)
    }

    override def delete() : String = {
        try {
            val stringUtil : StringUtil = StringUtil.getInstance()
            WorkFlowEntityFactory.getInstance().create2().delete(this.workFlowInterface.getName(), stringUtil.EMPTY_STRING)
            //this.workFlowInterface.getStoreName());
            var success : String = ((("Successfully Removed the workflow with " + WorkFlowData.getInstance().NAME) + "= ") + this.workFlowInterface.getName()) + " from "
            //this.workFlowInterface.getStoreName());
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success
        } catch {
            case e : Exception => {
                try {
                    var error : String = ((("Failed to remove workflow with " + WorkFlowData.getInstance().NAME) + "= ") + this.workFlowInterface.getName()) + " from "
                    //this.workFlowInterface.getStoreName();
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                    }
                    throw new Exception(e)
                } catch {
                    case e2 : Exception => {
                        var error : String = "Failed to get data from workflowinterface to set error string"
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                            this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e2)
                        }
                        return error
                    }
                }
            }
        }
        throw new IllegalStateException()
    }

    override def insert() : String = {
        try {
            //WorkFlowEntityFactory.getInstance().create2().insert(values);
            var success : String = "New User Successfully added to the Users Table"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "add()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add User"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "add()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            //WorkFlowEntityFactory.getInstance().create2().update(values);
            var success : String = "Updated WorkFlow Successfully"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to update WorkFlow"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


