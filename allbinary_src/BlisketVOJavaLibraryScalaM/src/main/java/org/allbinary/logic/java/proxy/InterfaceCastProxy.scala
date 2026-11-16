/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.proxy

import _root_.java.lang.reflect.Method
import _root_.java.lang.reflect.Proxy

class InterfaceCastProxy private(param_anyType : Object) extends _root_.java.lang.reflect.InvocationHandler {
    import _root_.org.allbinary.logic.java.proxy.InterfaceCastProxy.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var anyType : Object = null

    //Constructor
    {
        val anyType : Object = param_anyType
        this.anyType = anyType
    }

    //Invokes on the dynamic class and uses proxy class info for its invocation
    def invoke(proxyObject : Object, proxyMethod : Method, proxyArgs : Array[Object]) : Object = {
        var methodName : String = proxyMethod.getName()
        var realMethod : Method = this.anyType.getClass().getMethod(methodName, proxyMethod.getParameterTypes())
        //the proxy object methods should be not accessible always
        if (!realMethod.isAccessible()) {
            realMethod.setAccessible(true)
        }
        return proxyMethod.invoke(this.anyType, proxyArgs*)
    }

}

object InterfaceCastProxy {
    def newInstance(anyType : Object) : Object = {
        return Proxy.newProxyInstance(anyType.getClass().getClassLoader(), anyType.getClass().getInterfaces(), new InterfaceCastProxy(anyType))
    }

}


