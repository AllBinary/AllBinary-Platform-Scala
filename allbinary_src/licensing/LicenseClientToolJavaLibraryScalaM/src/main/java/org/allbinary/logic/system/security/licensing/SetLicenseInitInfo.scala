/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.java.io.BufferedReader
import _root_.java.io.InputStreamReader
import _root_.org.allbinary.business.init.LicenseInitInfo
import _root_.org.allbinary.business.init.LicenseInitInfoUtil
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.java.io.File
import _root_.java.io.FileReader
import _root_.java.io.LineNumberReader
import _root_.org.allbinary.util.BasicArrayList

class SetLicenseInitInfo(param_options : Array[String]) {
    import _root_.org.allbinary.logic.system.security.licensing.SetLicenseInitInfo.{*}

    private var vector : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val options : Array[String] = param_options
        //Globals.init(this.getClass().getClassLoader(), "G:\\mnt\\bc\\mydev\\licenseserver\\testing\\");
        LicenseInitInfoUtil.getInstance().setFilePath(PrintLicenseInitInfo.PATH + PATH_GLOBALS.getInstance().INIT_PATH)

        {
            var index : Int = 1
            while (index < options.length) {
                this.vector.add(options(index))
                index += 1
            }
        }
    }

    def getLicenseInitInfo() : LicenseInitInfo = {
        var licenseInitInfoUtil : LicenseInitInfoUtil = LicenseInitInfoUtil.getInstance()
        if (FileFactory.getInstance().isFile(licenseInitInfoUtil.INITFILENAME)) {
            return licenseInitInfoUtil.read()
        } else {
            return new LicenseInitInfo()
        }
        throw new IllegalStateException()
    }

    def createNewLicenseInitInfo(licenceServerVector : BasicArrayList) : Unit = {
        try {
            if (licenceServerVector == null) {
                throw new Exception("null BasicArrayList Passed - Just Make Empty if you want")
            }
            var licenseInitInfo : LicenseInitInfo = this.getLicenseInitInfo()
            System.out.println("License Serv Example: http://www.dartstatistics.com/LicServ/serverssl.php")
            licenseInitInfo.clearServers()
            /*             int index = 0;             while (true)             {                 System.out.println("New Lic Serv: ");                 String licServer = stdinput.readLine();                  if (licServer == null || licServer.length() < 2)                 {                     break;                 }                 licenseInitInfo.addServer(licServer);                  index++;             }             */
            var file : File = new File(PrintLicenseInitInfo.PATH + "licenseservers.txt")
            var reader : FileReader = new FileReader(file)
            var lineNumberReader : LineNumberReader = new LineNumberReader(reader)
            //ready instead of a null readLine so languages without null strings stop at the end of the file and not at an empty line

            {
                while (lineNumberReader.ready()) {
                    licenseInitInfo.addServer(lineNumberReader.readLine())
                }
            }
            LicenseInitInfoUtil.getInstance().write(licenseInitInfo)
            LicenseInitInfoUtil.getInstance().read()
        } catch {
            case e : Exception => {
                System.out.print("Error: " + e)
                e.printStackTrace()
            }
        }
    }

}

object SetLicenseInitInfo {
    private var stdinput : BufferedReader = new BufferedReader(new InputStreamReader(System.in))

    def main(args : Array[String]) : Unit = {
        var initInfo : SetLicenseInitInfo = new SetLicenseInitInfo(args)
        initInfo.createNewLicenseInitInfo(new BasicArrayListD())
    }

}


