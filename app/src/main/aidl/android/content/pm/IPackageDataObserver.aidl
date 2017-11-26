// IPackageDataObserver.aidl
package android.content.pm;

oneway interface IPackageDataObserver {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
   void onRemoveCompleted(in String packageName,boolean succeeded);
}
