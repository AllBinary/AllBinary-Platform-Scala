/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.midlet

import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ClientInformationFactory
import _root_.org.allbinary.thread.PrimaryThreadPool
import _root_.org.allbinary.thread.ThreadPool

//J2MEForJ2ME
class ProgressMidlet(param_clientInformationFactory : ClientInformationFactory) extends AllBinaryMidlet {

    var abeClientInformation : AbeClientInformationInterface = null

    //Constructor
    {
        val clientInformationFactory : ClientInformationFactory = param_clientInformationFactory
        this.preInit()
        this.abeClientInformation = clientInformationFactory.getInstance()
    }

    def preInit() : Unit = {
    }

    def exitProgress(isProgress : Boolean) : Unit = {
        val processor : Processor = MidletExitProcessorFactory.getInstance().getExitInstance(this)
        try {
            var primaryThreadPool : ThreadPool = PrimaryThreadPool.getInstance()
            var runnable : Runnable = new ExitRunnable(this, processor, isProgress)
            primaryThreadPool.runTask(runnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "exit", e)
                try {
                    processor.process()
                } catch {
                    case e2 : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, "exit", e)
                    }
                }
            }
        }
    }

}


