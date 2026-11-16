/* Generated Code Do Not Modify */
package org.osgi.framework

import _root_.java.util.Dictionary

trait BundleContext {

    def getBundles() : Array[Bundle]

    def installBundle(location : String) : Bundle

    def registerService(clazz : String, service : Object, properties : Dictionary[Object, Object]) : ServiceRegistration

    def getService(reference : ServiceReference) : Object

    def getServiceReferences(clazz : String, filter : String) : Array[ServiceReference]

    def getServiceReference(clazz : String) : ServiceReference

}


