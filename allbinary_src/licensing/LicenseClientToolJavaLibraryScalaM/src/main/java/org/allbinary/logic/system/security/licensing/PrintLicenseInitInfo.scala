/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.business.init.LicenseInitInfo
import _root_.org.allbinary.business.init.LicenseInitInfoUtil
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.util.BasicArrayList

class PrintLicenseInitInfo(param_options : Array[String]) {
    import _root_.org.allbinary.logic.system.security.licensing.PrintLicenseInitInfo.{PATH as _, *}
    def PATH : String = _root_.org.allbinary.logic.system.security.licensing.PrintLicenseInitInfo.PATH

    //private static BufferedReader stdinput = new BufferedReader(new InputStreamReader(System.in));
    //Constructor
    {
        val options : Array[String] = param_options
        //Globals.init(this.getClass().getClassLoader(), "G:\\mnt\\bc\\mydev\\licenseserver\\testing\\");
        LicenseInitInfoUtil.getInstance().setFilePath(PrintLicenseInitInfo.PATH + PATH_GLOBALS.getInstance().INIT_PATH)
    }

    def getLicenseInitInfo() : LicenseInitInfo = {
        val licenseInitInfoUtil : LicenseInitInfoUtil = LicenseInitInfoUtil.getInstance()
        if (FileFactory.getInstance().isFile(licenseInitInfoUtil.getFilePath())) {
            return licenseInitInfoUtil.read()
        } else {
            System.out.println("No Licence File at: " + licenseInitInfoUtil.getFilePath())
            return new LicenseInitInfo()
        }
        throw new IllegalStateException()
    }

    def printInitInfo() : Unit = {
        try {
            val licenseInitInfo : LicenseInitInfo = this.getLicenseInitInfo()
            System.out.println("License ID: " + licenseInitInfo.getLicenseId())
            val list : BasicArrayList = licenseInitInfo.getServerList()
            val size : Int = list.size()

            {
                var index : Int = 0
                while (index < size) {
                    System.out.println("Lic Serv: " + list.get(index))
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                System.out.print("Error: " + e)
                e.printStackTrace()
            }
        }
    }

}

object PrintLicenseInitInfo {
    val PATH : String = "G:\\mnt\\bc\\mydev\\work\\allbinary_src\\licensing\\data\\"

    def main(args : Array[String]) : Unit = {
        val initInfo : PrintLicenseInitInfo = new PrintLicenseInitInfo(args)
        initInfo.printInitInfo()
    }

}


