/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.hardware.components.linux


class CpuInfo private(param_name : String) {
    import _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.{PROCESSOR as _, VENDORID as _, CPUFAMILY as _, MODEL as _, MODELNAME as _, STEPPING as _, CPUMHZ as _, CACHESIZE as _, FDIVBUG as _, HLTBUG as _, F00FBUG as _, COMABUG as _, FPU as _, FPUEXCEPTION as _, CPUIDLEVEL as _, WP as _, FLAGS as _, BOGOMIPS as _, *}
    def PROCESSOR : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.PROCESSOR
    def VENDORID : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.VENDORID
    def CPUFAMILY : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.CPUFAMILY
    def MODEL : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.MODEL
    def MODELNAME : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.MODELNAME
    def STEPPING : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.STEPPING
    def CPUMHZ : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.CPUMHZ
    def CACHESIZE : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.CACHESIZE
    def FDIVBUG : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.FDIVBUG
    def HLTBUG : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.HLTBUG
    def F00FBUG : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.F00FBUG
    def COMABUG : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.COMABUG
    def FPU : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.FPU
    def FPUEXCEPTION : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.FPUEXCEPTION
    def CPUIDLEVEL : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.CPUIDLEVEL
    def WP : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.WP
    def FLAGS : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.FLAGS
    def BOGOMIPS : CpuInfo = _root_.org.allbinary.logic.system.hardware.components.linux.CpuInfo.BOGOMIPS

    private var name : String = null

    //Constructor
    {
        val name : String = param_name
        this.name = name
    }

    override def toString() : String = {
        return this.name
    }

}

object CpuInfo {
    val PROCESSOR : CpuInfo = new CpuInfo("processor")

    val VENDORID : CpuInfo = new CpuInfo("vendor_id")

    val CPUFAMILY : CpuInfo = new CpuInfo("cpu family")

    val MODEL : CpuInfo = new CpuInfo("model")

    val MODELNAME : CpuInfo = new CpuInfo("model name")

    val STEPPING : CpuInfo = new CpuInfo("stepping")

    val CPUMHZ : CpuInfo = new CpuInfo("cpu MHz")

    val CACHESIZE : CpuInfo = new CpuInfo("cache size")

    val FDIVBUG : CpuInfo = new CpuInfo("fdiv_bug")

    val HLTBUG : CpuInfo = new CpuInfo("hlt_bug")

    val F00FBUG : CpuInfo = new CpuInfo("f00f_bug")

    val COMABUG : CpuInfo = new CpuInfo("coma_bug")

    val FPU : CpuInfo = new CpuInfo("fpu")

    val FPUEXCEPTION : CpuInfo = new CpuInfo("fpu_exception")

    val CPUIDLEVEL : CpuInfo = new CpuInfo("cache size")

    val WP : CpuInfo = new CpuInfo("yes")

    val FLAGS : CpuInfo = new CpuInfo("flags")

    val BOGOMIPS : CpuInfo = new CpuInfo("bogomips")

}


