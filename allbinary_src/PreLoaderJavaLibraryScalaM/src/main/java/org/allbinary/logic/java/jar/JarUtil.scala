/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.jar

import _root_.java.io.IOException
import _root_.java.net.URL
import _root_.java.net.URLConnection
import _root_.java.util.jar.JarEntry
import _root_.java.util.jar.JarInputStream

/**  *  * @author USER  */
class JarUtil(param_jarURL : URL) {
    import _root_.org.allbinary.logic.java.jar.JarUtil.{*}

    private var jarURL : URL = null

    /** Creates a new instance of JarUtil */
    //Constructor
    {
        val jarURL : URL = param_jarURL
        this.jarURL = jarURL
    }

    def show() : Unit = {
        var cache : Array[Byte] = new Array[Byte](1024)
        try {
            var conn : URLConnection = this.jarURL.openConnection()
            var jis : JarInputStream = new JarInputStream(conn.getInputStream())

            {
                scala.util.boundary { (break_N68675 : scala.util.boundary.Label[Unit]) ?=>
                    while (true) {
                        var entry : JarEntry = jis.getNextJarEntry()
                        if (entry != null) {
                            if (!entry.isDirectory()) {
                                var offset : Int = 0
                                var i : Int = 0

                                {
                                    while (({ i = jis.read(cache, offset, cache.length - offset); i }) != -1) {
                                        offset += i
                                        if (offset >= cache.length) {
                                            var newcache : Array[Byte] = new Array[Byte](cache.length + 1024)
                                            System.arraycopy(cache, 0, newcache, 0, cache.length)
                                            cache = newcache
                                        }
                                    }
                                }
                                var tmp : Array[Byte] = new Array[Byte](offset)
                                System.arraycopy(cache, 0, tmp, 0, offset)
                                System.out.println(entry.getName())
                            }
                        } else {
                            scala.util.boundary.break()(using break_N68675)
                        }
                    }
                }
            }
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case ex : IOException => {
                System.err.println(ex)
                ex.printStackTrace()
            }
        }
    }

}

object JarUtil {
    /**     * @param args the command line arguments     */
    def main(args : Array[String]) : Unit = {
        new JarUtil(new URL("file:///G:/mnt/bc/mydev/working/j2me/MiniSpaceWars/MiniSpaceWars/dist/MiniSpaceWars.jar")).show()
    }

}


