package sample

import android.os.Handler
import android.os.Looper

inline fun uiThread(crossinline f: () -> Unit) {
    Handler(Looper.getMainLooper()).post { f() }
}