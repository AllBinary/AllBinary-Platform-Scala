/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package bundle.input.automation


trait InputAutomationBundleActivatorListenerInterface {

    //Allows module to start and stop while the gui is running
    def registerAsService() : Unit

    //Add all modules that are already running as a service to the gui
    def useServices() : Unit

}


