/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.logic.system.security.licensing.ClientInformationFactory
import _root_.org.allbinary.logic.system.security.licensing.LicenseServerInitFileUtil

class SpecialDemoGameMidlet(param_clientInformationFactory : ClientInformationFactory, param_licenseLoadingType : LicenseLoadingType, param_demoSetupFactory : LicensedDemoSetupFactory, param_licenseCheckRunnableFactory : LicenseCheckRunnableFactory) extends DemoGameMidlet(param_clientInformationFactory) {

    //Constructor
    {
        val clientInformationFactory : ClientInformationFactory = param_clientInformationFactory
        val licenseLoadingType : LicenseLoadingType = param_licenseLoadingType
        val demoSetupFactory : LicensedDemoSetupFactory = param_demoSetupFactory
        val licenseCheckRunnableFactory : LicenseCheckRunnableFactory = param_licenseCheckRunnableFactory
    }

    def initView() : Unit = {
    }

    override def preInit() : Unit = {
        new LicenseServerInitFileUtil().init()
    }

}


