/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package dynamic


class NativeLibraryHelper(param_library : String) {

    private var library : String = null

    //Constructor
    {
        val library : String = param_library
        this.library = library
    }

    //Runtime.getRuntime().load("c:\\winnt\\system32\\DirectXWindowsInputRobot.dll");
    def load() : Unit = {
        System.loadLibrary(this.library)
    }

}


