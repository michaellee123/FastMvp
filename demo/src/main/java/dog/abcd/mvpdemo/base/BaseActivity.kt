package dog.abcd.mvpdemo.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import dog.abcd.fastmvp.IDisposableHandler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : AppCompatActivity(), IBaseView , IDisposableHandler {

    val TAG = javaClass.simpleName

    override var compositeDisposable: CompositeDisposable? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (forcePortrait()) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT//竖屏
        }
        setContentView(layoutId())
    }

    open fun forcePortrait(): Boolean {
        return true
    }

    override fun getContext(): Context? {
        return this
    }

    override fun getLifecycleOwner(): LifecycleOwner? {
        return this
    }

    override fun getBundle(): Bundle? {
        return intent.extras
    }

    override fun finishActivity() {
        finish()
    }

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        resources
        super.onConfigurationChanged(newConfig)
    }

    override fun getResources(): Resources {
        val res: Resources = super.getResources()
        if (res.displayMetrics.scaledDensity != res.displayMetrics.density) {
            res.displayMetrics.scaledDensity = res.displayMetrics.density
        }
        return res
    }

}