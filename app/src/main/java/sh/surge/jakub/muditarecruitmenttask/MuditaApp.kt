package sh.surge.jakub.muditarecruitmenttask

import android.app.Application
import timber.log.Timber

class MuditaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement) =
                element.className + " " + element.lineNumber + " ***:"
        })
    }
}