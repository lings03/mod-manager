package top.laoxin.modmanager.observer

import android.os.FileObserver

class FlashModsObserver(val path: String) : FileObserver(path, ALL_EVENTS) {
    companion object {
        var flashObserver: FlashObserverInterface? = null
    }

    override fun onEvent(event: Int, path: String?) {

        when (event) {
            FileObserver.CREATE -> {
                flashObserver?.onFlash()
            }

            FileObserver.DELETE -> {
                flashObserver?.onFlash()
            }

            FileObserver.MOVED_FROM -> {
                flashObserver?.onFlash()
            }

            FileObserver.MOVED_TO -> {
                flashObserver?.onFlash()
            }
            // Add more cases if you want to handle more events
            else -> return
        }
    }

}